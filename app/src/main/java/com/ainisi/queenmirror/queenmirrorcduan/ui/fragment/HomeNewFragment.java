package com.ainisi.queenmirror.queenmirrorcduan.ui.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HomeListViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HomepageGridViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.EstheticsActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.HomeAdvertisingActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.HomeFightaloneActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.MessageActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SearchActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.ClassificationBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeAdvertisingBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeHeadlinesBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeIndustryBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.ScrollRecyclerView;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GDLocationUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GlideImageLoader;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollListview;
import com.ainisi.queenmirror.queenmirrorcduan.utils.ScrollInterceptScrollView;
import com.amap.api.location.AMapLocation;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.cache.CacheMode;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

public class HomeNewFragment extends BaseFragment implements HttpCallBack {

    @Bind(R.id.banner)
    Banner banner;
    @Bind(R.id.banner_middle)
    Banner banner_middle;
    @Bind(R.id.tv_home_esthetics)
    TextView tv_home_esthetics;
    @Bind(R.id.tv_home_nailart)
    TextView tv_home_nailart;
    @Bind(R.id.tv_home_haircustom)
    TextView tv_home_haircustom;
    @Bind(R.id.tv_home_beauty)
    TextView tv_home_beauty;
    @Bind(R.id.tv_home_permanent)
    TextView tv_home_permanent;
    @Bind(R.id.mv_home_marqueeView)
    MarqueeView mv_home_marqueeView;
    @Bind(R.id.rv_home_new_every)
    ScrollRecyclerView rv_home_new_every;
    @Bind(R.id.nl_home_list_view)
    NoScrollListview nl_home_list_view;
    @Bind(R.id.gv_home_gridView)
    NoScrollGridView gv_home_gridView;
    @Bind(R.id.iv_surface)
    ImageView iv_surface;
    @Bind(R.id.line_surface)
    LinearLayout line_surface;
    @Bind(R.id.iv_uspension_surface)
    ImageView iv_uspension_surface;
    @Bind(R.id.layout_stick_header_main)
    LinearLayout layout_stick_header_main;
    @Bind(R.id.sc_home_scroll)
    ScrollInterceptScrollView sc_home_scroll;
    @Bind(R.id.tv_home_bustling)
    TextView  mLocation;
    private String city;
    private HomeIndustryBean homeIndustryBean;
    private HomeHeadlinesBean homeHeadlinesBean;
    private HomeAdvertisingBean homeAdvertisingBean;

    List<String> contntList = new ArrayList<>();
    List<SortBean> sortlist = new ArrayList<>();
    int hight;
    boolean type = false;
    ClassificationBean classificationBean;
    private LocationManager lm;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_home_new_fragment;
    }

    @Override
    public void initPresenter() {
    }

    /**
     * 获取首页顶部Banner图
     */
    private void getBannerData() {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("tabType", "2");
        hashMap.put("tabFather", "0");
        HttpUtils.doPost(ACTION.INDUSTRY, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);//首页的行业分类
        HttpUtils.doPost(ACTION.HEADLINES, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);//头条
        HttpUtils.doPost(ACTION.ADVERTISING, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);//Banner
    }

    /**
     * 获取首页底部商家列表
     */
    private void getShopData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("enableFlag", "0");
        params.put("pageNumber", "1");
        params.put("contentByTitle", "");
        params.put("categoryId", "0");
        HttpUtils.doPost(ACTION.CLASSIFICATION, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


    @SuppressLint("NewApi")
    @Override
    protected void initView() {
        /**
         * 获取首页部分数据
         */
        getBannerData();

        getShopData();
        lm = (LocationManager) getActivity().getSystemService(getActivity().LOCATION_SERVICE);
        boolean ok = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if (ok) {//开了定位服务
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                // 没有权限，申请权限。
                initDialog();


            } else {
                // 有权限了，去放肆吧。
//                        Toast.makeText(getActivity(), "有权限", Toast.LENGTH_SHORT).show();
                // 定位工具初始化
                GDLocationUtil.init(getActivity());
                initLocation();
            }
        } else {
            Toast.makeText(getActivity(), "系统检测到未开启GPS定位服务", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivityForResult(intent, 1315);
        }

        for (int i = 0; i < 10; i++) {
            SortBean sortBean = new SortBean();
            sortlist.add(sortBean);
        }
        MyAdapter sortAdapter = new MyAdapter(R.layout.re_full_recommend, sortlist);
        rv_home_new_every.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rv_home_new_every.setAdapter(sortAdapter);
        sortAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), FullActivity.class));
            }
        });

        sc_home_scroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                hight = i1;
                if (i1 >= 3315) {
                    layout_stick_header_main.setVisibility(View.VISIBLE);
                } else {
                    layout_stick_header_main.setVisibility(View.GONE);
                }
            }
        });

    }

    private void initDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("手机未开通定位权限");
        builder.setMessage("建议开通");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               dialog.dismiss();
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent localIntent = new Intent();
                localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                if (Build.VERSION.SDK_INT >= 9) {
                    localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    localIntent.setData(Uri.fromParts("package", getActivity().getPackageName(), null));
                } else if (Build.VERSION.SDK_INT <= 8) {
                    localIntent.setAction(Intent.ACTION_VIEW);
                    localIntent.setClassName("com.android.settings","com.android.settings.InstalledAppDetails");
                    localIntent.putExtra("com.android.settings.ApplicationPkgName", getActivity().getPackageName());
                }
                startActivity(localIntent);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @OnClick({R.id.li_home_esthetics, R.id.li_home_nailart, R.id.li_home_haircustom, R.id.li_home_beauty, R.id.li_home_permanent, R.id.linear_home_freetrial,
            R.id.line_surface, R.id.line_uspension_surface, R.id.iv_home_search, R.id.img_information})
    public void onClick(View view) {
        switch (view.getId()) {
            /**
             * 行业分类
             */
            case R.id.li_home_esthetics:
                startActivity(new Intent(getActivity(), EstheticsActivity.class));
                break;
            case R.id.li_home_nailart:
                startActivity(new Intent(getActivity(), EstheticsActivity.class));
                break;
            case R.id.li_home_haircustom:
                startActivity(new Intent(getActivity(), EstheticsActivity.class));
                break;
            case R.id.li_home_beauty:
                startActivity(new Intent(getActivity(), EstheticsActivity.class));
                break;
            case R.id.li_home_permanent:
                startActivity(new Intent(getActivity(), EstheticsActivity.class));
                break;
            /**
             * 拼团
             */
            case R.id.linear_home_freetrial:
                startActivity(new Intent(getActivity(), HomeFightaloneActivity.class));
                break;
            /**
             * 展示形式改变
             */
            case R.id.line_surface:
            case R.id.line_uspension_surface:
                if (type) {
                    iv_surface.setImageResource(R.drawable.icon_home_recycler);
                    iv_uspension_surface.setImageResource(R.drawable.icon_home_recycler);
                    type = false;
                    nl_home_list_view.setVisibility(View.GONE);
                    gv_home_gridView.setVisibility(View.VISIBLE);

                    HomepageGridViewAdapter gridViewAdapter = new HomepageGridViewAdapter(getActivity(), classificationBean.getBody().getShopListData());
                    gv_home_gridView.setAdapter(gridViewAdapter);

                } else {
                    iv_surface.setImageResource(R.drawable.icon_home_list);
                    iv_uspension_surface.setImageResource(R.drawable.icon_home_list);
                    type = true;
                    nl_home_list_view.setVisibility(View.VISIBLE);
                    gv_home_gridView.setVisibility(View.GONE);

                    HomeListViewAdapter homeListViewAdapter = new HomeListViewAdapter(getActivity(), classificationBean.getBody().getShopListData());
                    nl_home_list_view.setAdapter(homeListViewAdapter);

                }

                break;
            //搜索
            case R.id.iv_home_search:
                SearchActivity.startActivity(getContext());
                break;
            //消息
            case R.id.img_information:
                startActivity(new Intent(getActivity(), MessageActivity.class));
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            //首页的行业分类
            case ACTION.INDUSTRY:
                homeIndustryBean = GsonUtil.toObj(res, HomeIndustryBean.class);
                if (homeIndustryBean.isSuccess()) {
                    tv_home_esthetics.setText(homeIndustryBean.getBody().getCategoryListData().get(0).getEcCategory().getTabName());
                    tv_home_nailart.setText(homeIndustryBean.getBody().getCategoryListData().get(1).getEcCategory().getTabName());
                    tv_home_haircustom.setText(homeIndustryBean.getBody().getCategoryListData().get(2).getEcCategory().getTabName());
                    tv_home_beauty.setText(homeIndustryBean.getBody().getCategoryListData().get(3).getEcCategory().getTabName());
                    tv_home_permanent.setText(homeIndustryBean.getBody().getCategoryListData().get(4).getEcCategory().getTabName());
                } else {
                    T.show(homeIndustryBean.getMsg());
                }

                break;
            //商家分类列表
            case ACTION.CLASSIFICATION:

                L.e("....." + res);
                classificationBean = GsonUtil.toObj(res, ClassificationBean.class);
                if (classificationBean.isSuccess()) {

                    HomepageGridViewAdapter gridViewAdapter = new HomepageGridViewAdapter(getActivity(), classificationBean.getBody().getShopListData());
                    gv_home_gridView.setAdapter(gridViewAdapter);

                } else {
                    T.show(classificationBean.getMsg());
                }

                break;
            //首页的女王头条
            case ACTION.HEADLINES:
                homeHeadlinesBean = GsonUtil.toObj(res, HomeHeadlinesBean.class);
                if (homeHeadlinesBean.isSuccess()) {

                    for (int i = 0; i < homeHeadlinesBean.getBody().getTopListData().size(); i++) {
                        contntList.add(homeHeadlinesBean.getBody().getTopListData().get(i).getEcTop().getTopName());
                    }
                    mv_home_marqueeView.startWithList(contntList);
                } else {
                    T.show(homeHeadlinesBean.getMsg());
                }

                break;
            //首页banner广告
            case ACTION.ADVERTISING:
                homeAdvertisingBean = GsonUtil.toObj(res, HomeAdvertisingBean.class);
                if (homeAdvertisingBean.isSuccess()) {
                    List<String> images = new ArrayList<>();
                    for (int i = 0; i < 4; i++) {
                        images.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
                    }
                    banner.setImageLoader(new GlideImageLoader());
                    banner.setImages(images);
                    banner.start();
                    banner.setOnBannerListener(new OnBannerListener() {
                        @Override
                        public void OnBannerClick(int position) {
                            Intent intent = new Intent(getActivity(), HomeAdvertisingActivity.class);
                            intent.putExtra("weburl", homeAdvertisingBean.getBody().getAdvertisementListData().get(0).getEcAdvertisement().getAdUrl());
                            getActivity().startActivity(intent);
                        }
                    });

                    banner_middle.setImageLoader(new GlideImageLoader());
                    banner_middle.setImages(images);
                    banner_middle.start();
                    banner_middle.setOnBannerListener(new OnBannerListener() {
                        @Override
                        public void OnBannerClick(int position) {
                            Intent intent = new Intent(getActivity(), HomeAdvertisingActivity.class);
                            intent.putExtra("weburl", homeAdvertisingBean.getBody().getAdvertisementListData().get(0).getEcAdvertisement().getAdUrl());
                            getActivity().startActivity(intent);
                        }
                    });

                } else {
                    T.show(homeAdvertisingBean.getMsg());
                }
                break;
        }
    }


    private void initLocation() {
        // 获取之前定位位置，如果之前未曾定位，则重新定位
        GDLocationUtil.getLocation(new GDLocationUtil.MyLocationListener() {
            @Override
            public void result(AMapLocation location) {
                //针对location进行相关操作，如location.getCity()，无需验证location是否为null;
                city = location.getCity();

                mLocation.setText(city);
            }
        });
        // 获取当前位置，无论是否定位过，重新进行定位
        GDLocationUtil.getCurrentLocation(new GDLocationUtil.MyLocationListener() {

            @Override
            public void result(AMapLocation location) {
                //针对location进行相关操作，如location.getCity()，无需验证location是否为null;
                mLocation.setText(location.getCity());
            }
        });
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mv_home_marqueeView.stopFlipping();
    }
}
