package com.ainisi.queenmirror.common.commonutils.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.ainisi.queenmirror.common.commonutils.ToastUtils;
import com.ainisi.queenmirror.common.commonwidget.CommonDialog;

import static com.ainisi.queenmirror.common.commonutils.network.NetWorkUtils.HAS_INTERNET;
import static com.ainisi.queenmirror.common.commonutils.network.NetWorkUtils.NO_INTERNET;

/**
 * @author weikailiang
 * @function Created on 2017/7/10.
 */

public class InterNetBroadCastManager extends BroadcastReceiver {
    private CommonDialog dialog;
    private Context context;

    @Override
    public void onReceive(Context context, Intent intent) {

        this.context = context;
        NetworkInfo.State wifiState = null;
        NetworkInfo.State mobileState = null;
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        wifiState = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
        mobileState = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
        if (wifiState != null && mobileState != null
                && NetworkInfo.State.CONNECTED != wifiState
                && NetworkInfo.State.CONNECTED == mobileState) {
            // 手机网络连接成功
            dissMissDialog();
            context.sendBroadcast(new Intent(HAS_INTERNET));
        } else if (wifiState != null && mobileState != null
                && NetworkInfo.State.CONNECTED != wifiState
                && NetworkInfo.State.CONNECTED != mobileState) {
            // 手机没有任何的网络
            showDialog(context);
            context.sendBroadcast(new Intent(NO_INTERNET));
        } else if (wifiState != null && NetworkInfo.State.CONNECTED == wifiState) {
            // 无线网络连接成功
            dissMissDialog();
            context.sendBroadcast(new Intent(HAS_INTERNET));
        }
    }

    private void showDialog(final Context context) {
        if (dialog == null) {
            dialog = new CommonDialog(context, "网络提示", "您的网络不可用,请点‘确定’设置网络", "确定", "取消", new CommonDialog.DialogClickListener() {
                @Override
                public void onDialogClick() {
                    // 跳转到系统的网络设置界面
                    Intent intent = null;
                    // 先判断当前系统版本
                    if (android.os.Build.VERSION.SDK_INT > 10) {  // 3.0以上
                        intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                    } else {
                        intent = new Intent();
                        intent.setClassName("com.android.settings", "com.android.settings.WirelessSettings");
                    }
                    context.startActivity(intent);
                }
            });
        }
        dialog.show();
    }

    private void dissMissDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            Toast.makeText(context,"您的网络又回来啦(:",Toast.LENGTH_SHORT).show();

           // ToastUtils.showShotToast("您的网络又回来啦(:");
        }
    }

}
