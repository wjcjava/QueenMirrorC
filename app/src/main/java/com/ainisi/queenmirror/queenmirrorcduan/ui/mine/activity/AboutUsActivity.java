package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.api.UrlConstants;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.OSSSTSModel;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSS;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.internal.OSSAsyncTask;
import com.alibaba.sdk.android.oss.model.GetObjectRequest;
import com.alibaba.sdk.android.oss.model.GetObjectResult;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.google.zxing.WriterException;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.StringCallback;

import org.json.JSONObject;

import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;


/**
 * 关于我们
 *
 * @author jiangchao
 *         created at 2018/5/11 下午1:38
 */
public class AboutUsActivity extends BaseNewActivity implements HttpCallBack{


    private static final String TAG = "AboutUsActivity";
    @Bind(R.id.iv_test)
    ImageView ivTest;
    @Bind(R.id.btn_upload)
    Button btnUpload;
    @Bind(R.id.btn_download)
    Button btnDownload;
    private OSS oss;

    private String securityToken;
    private String securityAppKey;

    private String securityAccessKeySecret;

    private String securityExpiration;

    OSSAsyncTask task;
    public static final String ENDPOINT = "http://oss-cn-hangzhou.aliyuncs.com";
    //public static final String BUCKET = "nvtest";
    public static final String BUCKET = "jayceework";

    File file, file2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        file = new File(Environment.getExternalStorageDirectory(), "2.jpg");
        file2 = new File(Environment.getExternalStorageDirectory(), "2.jpg");
        if (!file.exists() || !file2.exists()) {
            Toast.makeText(AboutUsActivity.this, "文件不存在，请修改文件路径", Toast.LENGTH_SHORT).show();
            return;
        }

        getOSSToken();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_about_us;
    }

    @OnClick({R.id.btn_upload, R.id.btn_download})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_upload:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    String[] mPermissionList = new String[]{
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                    };
                    ActivityCompat.requestPermissions(this, mPermissionList,100);
                } else {
                    uploadPicByAliyunOSS(securityAppKey, securityAccessKeySecret, securityToken);
                }
                break;
            case R.id.btn_download:
                downloadPicFromAliyunOSS(securityAppKey, securityAccessKeySecret, securityToken);
                break;
            default:
                break;

        }
    }


    private void getOSSToken() {
        HashMap<String, String> params = new HashMap<>();
        HttpUtils.doPost(ACTION.OSSGETTOKEN, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            case ACTION.OSSGETTOKEN:

                OSSSTSModel ossstsModel = GsonUtil.toObj(res,OSSSTSModel.class);

                if(ossstsModel.isSuccess()){
                    securityToken = ossstsModel.getBody().getSecurityToken();
                    securityAppKey = ossstsModel.getBody().getAccessKeyId();
                    securityAccessKeySecret = ossstsModel.getBody().getAccessKeySecret();
                    securityExpiration = ossstsModel.getBody().getExpiration();
                }
                break;
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }

    private String picturePath = Environment.getExternalStorageDirectory() + File.separator + "2.jpg";
    public static final String JAYCEE_ACCESSKEYID = "LTAIpiY45EMpLtDe";
    public static final String JAYCEE_ACCESSKEYSECRET = "8HeLX9vyker1oM0JP1LoeyyMTYhCgq";

    private void uploadPicByAliyunOSS(String securityAppKey, String securityAppSecret, String securityToken) {
        // 在移动端建议使用STS方式初始化OSSClient。
        // 更多信息可查看sample 中 sts 使用方式(https://github.com/aliyun/aliyun-oss-android-sdk/tree/master/app/src/main/java/com/alibaba/sdk/android/oss/app)

        //    public static final String JAYCEE_ACCESSKEYID = "LTAIpiY45EMpLtDe";
//    public static final String JAYCEE_ACCESSKEYSECRET = "8HeLX9vyker1oM0JP1LoeyyMTYhCgq";

        OSSCredentialProvider credentialProvider = new OSSStsTokenCredentialProvider(JAYCEE_ACCESSKEYID, JAYCEE_ACCESSKEYSECRET, "");
        //该配置类如果不设置，会有默认配置，具体可看该类
        ClientConfiguration conf = new ClientConfiguration();
        // 连接超时，默认15秒
        conf.setConnectionTimeout(15 * 1000);
        // socket超时，默认15秒
        conf.setSocketTimeout(15 * 1000);
        // 最大并发请求数，默认5个
        conf.setMaxConcurrentRequest(5);
        // 失败后最大重试次数，默认2次
        conf.setMaxErrorRetry(2);
//开启可以在控制台看到日志，并且会支持写入手机sd卡中的一份日志文件位置在SDCard_path\OSSLog\logs.csv  默认不开启
//日志会记录oss操作行为中的请求数据，返回数据，异常信息
//例如requestId,response header等
//android_version：5.1  android版本
//mobile_model：XT1085  android手机型号
//network_state：connected  网络状况
//network_type：WIFI 网络连接类型
//具体的操作行为信息:
//[2017-09-05 16:54:52] - Encounter local execpiton: //java.lang.IllegalArgumentException: The bucket name is invalid.
//A bucket name must:
//1) be comprised of lower-case characters, numbers or dash(-);
//2) start with lower case or numbers;
//3) be between 3-63 characters long.
//------>end of log
        OSSLog.enableLog();
        oss = new OSSClient(getApplicationContext(),ENDPOINT, credentialProvider, conf);
        // Construct an upload request
        PutObjectRequest put = new PutObjectRequest(BUCKET, "photo", picturePath);

// You can set progress callback during asynchronous upload
        put.setProgressCallback(new OSSProgressCallback<PutObjectRequest>() {
            @Override
            public void onProgress(PutObjectRequest request, long currentSize, long totalSize) {
//                Logger.i(TAG, "currentSize: " + currentSize + " totalSize: " + totalSize);
            }
        });


        task = oss.asyncPutObject(put, new OSSCompletedCallback<PutObjectRequest, PutObjectResult>() {
            @Override
            public void onSuccess(PutObjectRequest request, PutObjectResult result) {

//                Log.i(TAG, "UploadSuccess\n" + result.getServerCallbackReturnBody() + "\n" +
//                        result.getETag() + "\n" + result.getRequestId() + "\n" +
//                        result.getClientCRC() + "\n" + result.getResponseHeader().toString());
                Log.i(TAG, "上传成功---" + result.toString());
            }

            @Override
            public void onFailure(PutObjectRequest request, ClientException clientExcepion, ServiceException serviceException) {
                // Request exception
                L.e("?????????????   "+serviceException.getErrorCode()+"  "+serviceException.getRawMessage());
                if (clientExcepion != null) {
                    // Local exception, such as a network exception
                    clientExcepion.printStackTrace();
                }
                if (serviceException != null) {
                    // Service exception
//                    Log.i(TAG, "ErrorCode---" + serviceException.getErrorCode());
//                    Log.i(TAG, "RequestId---" + serviceException.getRequestId());
//                    Log.i(TAG, "HostId---" + serviceException.getHostId());
//                    Log.i(TAG, "RawMessage---" + serviceException.getRawMessage());
                }
            }
        });
    }


    private void downloadPicFromAliyunOSS(String securityAppKey, String securityAppSecret, String securityToken) {
        // 在移动端建议使用STS方式初始化OSSClient。
// 更多信息可查看sample 中 sts 使用方式(https://github.com/aliyun/aliyun-oss-android-sdk/tree/master/app/src/main/java/com/alibaba/sdk/android/oss/app)
        OSSCredentialProvider credentialProvider = new OSSStsTokenCredentialProvider(JAYCEE_ACCESSKEYID, JAYCEE_ACCESSKEYSECRET, "");
        //该配置类如果不设置，会有默认配置，具体可看该类
        ClientConfiguration conf = new ClientConfiguration();
        // 连接超时，默认15秒
        conf.setConnectionTimeout(15 * 1000);
        // socket超时，默认15秒
        conf.setSocketTimeout(15 * 1000);
        // 最大并发请求数，默认5个
        conf.setMaxConcurrentRequest(5);
        // 失败后最大重试次数，默认2次
        conf.setMaxErrorRetry(2);
//开启可以在控制台看到日志，并且会支持写入手机sd卡中的一份日志文件位置在SDCard_path\OSSLog\logs.csv  默认不开启
//日志会记录oss操作行为中的请求数据，返回数据，异常信息
//例如requestId,response header等
//android_version：5.1  android版本
//mobile_model：XT1085  android手机型号
//network_state：connected  网络状况
//network_type：WIFI 网络连接类型
//具体的操作行为信息:
//[2017-09-05 16:54:52] - Encounter local execpiton: //java.lang.IllegalArgumentException: The bucket name is invalid.
//A bucket name must:
//1) be comprised of lower-case characters, numbers or dash(-);
//2) start with lower case or numbers;
//3) be between 3-63 characters long.
//------>end of log
        OSSLog.enableLog();
        oss = new OSSClient(getApplicationContext(), ENDPOINT, credentialProvider, conf);

        GetObjectRequest get = new GetObjectRequest(BUCKET, "photo");
//设置下载进度回调
        get.setProgressListener(new OSSProgressCallback<GetObjectRequest>() {
            @Override
            public void onProgress(GetObjectRequest request, long currentSize, long totalSize) {
//                Logger.i(TAG, "getobj_progress: " + currentSize + "  total_size: " + totalSize);
            }
        });
        task = oss.asyncGetObject(get, new OSSCompletedCallback<GetObjectRequest, GetObjectResult>() {
            @Override
            public void onSuccess(GetObjectRequest request, GetObjectResult result) {
                Log.i(TAG, "下载成功---" + result.toString());
                // 请求成功
                InputStream inputStream = result.getObjectContent();
                //需要根据对应的View大小来自适应缩放
                final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                //ivTest.setImageBitmap(bitmap);
                ivTest.post(new Runnable() {
                    @Override
                    public void run() {
                        ivTest.setImageBitmap(bitmap);
                    }
                });
            }

            @Override
            public void onFailure(GetObjectRequest request, ClientException clientExcepion, ServiceException serviceException) {
                // 请求异常
                if (clientExcepion != null) {
                    // 本地异常如网络异常等
                    clientExcepion.printStackTrace();
                }
                if (serviceException != null) {
                    // 服务异常
                    Log.e("ErrorCode", serviceException.getErrorCode());
                    Log.e("RequestId", serviceException.getRequestId());
                    Log.e("HostId", serviceException.getHostId());
                    Log.e("RawMessage", serviceException.getRawMessage());
                }
            }
        });
    }

    /**
     * 处理权限申请回调
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        if (requestCode ==100) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                uploadPicByAliyunOSS(securityAppKey, securityAccessKeySecret, securityToken);
            } else {
                // Permission Denied
                Toast.makeText(AboutUsActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
