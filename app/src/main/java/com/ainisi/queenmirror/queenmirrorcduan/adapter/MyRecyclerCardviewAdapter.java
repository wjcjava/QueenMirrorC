package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.Bean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.fragment.HomeFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.EstheticsActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.HomeAdvertisingActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.HomeFightaloneActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeAdvertising;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeHeadlines;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeIndustry;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.LoadingDialog;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GlideImageLoader;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MarqueeView;
import com.lzy.okgo.cache.CacheMode;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 用于首页多item布局
 */
public class MyRecyclerCardviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements HttpCallBack, View.OnClickListener {

    private final Context context;
    private MarqueeView marqueeview;
    List<Bean.BodyBean.ApiRefundListBean> apiRefundList = new ArrayList<>();
    private HomeIndustry homeIndustry;
    int type;

    private TextView esthetics;
    private TextView nailart;
    private TextView haircustom;
    private TextView beauty;
    private TextView permanent;
    private HomeHeadlines homeHeadlines;
    private String[] contentArray;
    private HomeAdvertising homeAdvertising;
    private Banner banner;
    private LoadingDialog dialog;


    public static enum ITEM_TYPE {
        ITEM_TYPE_Theme,
        ITEM_TYPE_Video,
        ITEM_TYPE_Image
    }


    public MyRecyclerCardviewAdapter(Context context, int type) {
        super();
        this.context = context;
        this.type = type;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == ITEM_TYPE.ITEM_TYPE_Theme.ordinal()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_shop, parent, false);
            return new ThemeVideoHolder(view);
        } else if (viewType == ITEM_TYPE.ITEM_TYPE_Video.ordinal()) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_appbarlayout, parent, false);
            return new VideoViewHolder(view);
        } else if (viewType == ITEM_TYPE.ITEM_TYPE_Image.ordinal()) {
            if (type == 0) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shortrecycler, parent, false);
                return new VideoViewThreeHolder(view);
            } else {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_waterfall, parent, false);
                return new VideoViewThreeHolder(view);
            }
        }

        return null;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof ThemeVideoHolder) {
            ((ThemeVideoHolder) holder).home_esthetics.setOnClickListener(this);
            ((ThemeVideoHolder) holder).home_freetrial.setOnClickListener(this);
            ((ThemeVideoHolder) holder).home_nailart.setOnClickListener(this);
            ((ThemeVideoHolder) holder).home_haircustom.setOnClickListener(this);
            ((ThemeVideoHolder) holder).home_beauty.setOnClickListener(this);
            ((ThemeVideoHolder) holder).home_permanent.setOnClickListener(this);
            ((ThemeVideoHolder) holder).home_newuserprg.setOnClickListener(this);
            ((ThemeVideoHolder) holder).home_specialoffer.setOnClickListener(this);
            ((ThemeVideoHolder) holder).home_goodshop.setOnClickListener(this);

        } else if (holder instanceof VideoViewHolder) {
            ((VideoViewHolder) holder).surFace.setOnClickListener(this);

            ((VideoViewHolder) holder).li_hime_sort.setOnClickListener(this);
            ((VideoViewHolder) holder).screen_bottom.setOnClickListener(this);
        } else if (holder instanceof VideoViewThreeHolder) {
            if (type == 0) {
                ((VideoViewThreeHolder) holder).homeShort.setOnClickListener(this);
            } else {
                return;
            }
        }

        inithttp();
    }

    private void inithttp() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("tabType", "2");
        hashMap.put("tabFather", "0");
        HttpUtils.doPost(ACTION.INDUSTRY, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
        HttpUtils.doPost(ACTION.HEADLINES, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
        HttpUtils.doPost(ACTION.ADVERTISING, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);

    }

    private Handler handler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            // 隐藏dialog
            dialog.dismiss();

        };
    };
    //item的点击事件
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //美受美甲
            case R.id.home_esthetics:
                context.startActivity(new Intent(context, EstheticsActivity.class));
                break;
            //店铺
            case R.id.li_home_short:
                context.startActivity(new Intent(context, WorkRoomDetailActivity.class));
                break;
            //美手美甲
            case R.id.li_home_nailart:
                context.startActivity(new Intent(context, EstheticsActivity.class));
                break;
            //美发定制
            case R.id.li_home_haircustom:
                context.startActivity(new Intent(context, EstheticsActivity.class));
                break;
            //美容美体
            case R.id.li_home_beauty:
                context.startActivity(new Intent(context, EstheticsActivity.class));
                break;
            //半永久
            case R.id.li_home_permanent:
                context.startActivity(new Intent(context, EstheticsActivity.class));
                break;
            //新用户特权
            case R.id.li_home_newuserprg:
                T.show("新用户特权");
                break;
            //免费试用（拼团）
            case R.id.linear_home_freetrial:
                context.startActivity(new Intent(context, HomeFightaloneActivity.class));
                break;
            //天天特价
            case R.id.li_home_specialoffer:
                T.show("天天特价");
                break;
            //人气好店
            case R.id.li_home_goodshop:
                T.show("人气好店");
                break;
            //综合排序
            case R.id.li_hime_sort:
                HomeFragment.instance.recyclerView.smoothScrollToPosition(6);
                HomeFragment.instance.layout_stick_header_main.setVisibility(View.VISIBLE);
                HomeFragment.instance.pop.showAsDropDown(HomeFragment.instance.hSort);
                break;
            //筛选
            case R.id.li_home_screen_bottom:
                HomeFragment.instance.recyclerView.smoothScrollToPosition(6);
                HomeFragment.instance.layout_stick_header_main.setVisibility(View.VISIBLE);
                HomeFragment.instance.popWindow.showAsDropDown(HomeFragment.instance.hSort);
                break;
            //瀑布流切换
            case R.id.iv_surface:
                HomeFragment.instance.recyclerView.smoothScrollToPosition(6);
                HomeFragment.instance.layout_stick_header_main.setVisibility(View.VISIBLE);
                HomeFragment.instance.onclick = false;


        }
    }

    /**
     * 测试列表数据
     */
//    private void CeshiData() {
//        //传参数
//        HashMap<String, String> params = new HashMap<>();
//        params.put("userId", "111");
//
//        //doPost();  第一个参数：调用的方法       第二个：传递的参数   第三个：是否成功返回的样式    第四个：对话框     第五个：传入当前的activity
//        HttpUtils.doPost(ACTION.LIST, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
//    }
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM_TYPE.ITEM_TYPE_Theme.ordinal();
        } else if (position == 1) {
            return ITEM_TYPE.ITEM_TYPE_Video.ordinal();
        } else {
            return ITEM_TYPE.ITEM_TYPE_Image.ordinal();
        }

    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class ThemeVideoHolder extends RecyclerView.ViewHolder {

        LinearLayout home_freetrial;
        LinearLayout home_esthetics;

        private final LinearLayout home_nailart;
        private final LinearLayout home_haircustom;
        private final LinearLayout home_beauty;
        private final LinearLayout home_permanent;
        private final LinearLayout home_newuserprg;
        private final LinearLayout home_specialoffer;
        private final LinearLayout home_goodshop;

        public ThemeVideoHolder(View itemView) {
            super(itemView);
            home_esthetics = itemView.findViewById(R.id.home_esthetics);
            home_freetrial = itemView.findViewById(R.id.linear_home_freetrial);
            home_nailart = itemView.findViewById(R.id.li_home_nailart);
            home_haircustom = itemView.findViewById(R.id.li_home_haircustom);
            home_beauty = itemView.findViewById(R.id.li_home_beauty);
            home_permanent = itemView.findViewById(R.id.li_home_permanent);
            home_newuserprg = itemView.findViewById(R.id.li_home_newuserprg);
            home_specialoffer = itemView.findViewById(R.id.li_home_specialoffer);
            home_goodshop = itemView.findViewById(R.id.li_home_goodshop);
            esthetics = itemView.findViewById(R.id.tv_home_esthetics);
            nailart = itemView.findViewById(R.id.tv_home_nailart);
            haircustom = itemView.findViewById(R.id.tv_home_haircustom);
            beauty = itemView.findViewById(R.id.tv_home_beauty);
            permanent = itemView.findViewById(R.id.tv_home_permanent);
            banner = itemView.findViewById(R.id.banner);
            marqueeview = itemView.findViewById(R.id.marqueeview);
        }
    }
    public class VideoViewHolder extends RecyclerView.ViewHolder {
        LinearLayout screen_bottom;
        private ImageView surFace;
        LinearLayout li_hime_sort;

        public VideoViewHolder(View itemView) {
            super(itemView);
            surFace = itemView.findViewById(R.id.iv_surface);
            li_hime_sort = itemView.findViewById(R.id.li_hime_sort);
            screen_bottom = itemView.findViewById(R.id.li_home_screen_bottom);
        }
    }
    private class VideoViewThreeHolder extends RecyclerView.ViewHolder {
        private LinearLayout homeShort;

        public VideoViewThreeHolder(View itemView) {
            super(itemView);
            if (type == 0) {
                homeShort = itemView.findViewById(R.id.li_home_short);
            } else {
                return;
            }

        }
    }

    @Override
    public void onSuccess(int action, String res) {

        switch (action) {
            case ACTION.LIST:
                dialog.dismiss();
                Bean bean = GsonUtil.toObj(res, Bean.class);
                T.show(bean.getMsg());
                Bean.BodyBean body = bean.getBody();
                apiRefundList = body.getApiRefundList();

                L.e("获取列表中为什么退款的原因   " + apiRefundList.get(0).getRefundReasonLabel());
                T.show(apiRefundList.get(0).getRefundReasonLabel());

                Bean.BodyBean.ApiRefundListBean.AnsCustRefundBean ansCustRefundBean = apiRefundList.get(0).getAnsCustRefund();

                L.e("???????????????????????   获取列表中对象中的ID信息  " + ansCustRefundBean.getId());
                break;
            //首页的行业分类
            case ACTION.INDUSTRY:
                homeIndustry = GsonUtil.toObj(res, HomeIndustry.class);
                esthetics.setText(homeIndustry.getBody().getCategoryListData().get(0).getEcCategory().getTabName());
                nailart.setText(homeIndustry.getBody().getCategoryListData().get(1).getEcCategory().getTabName());
                haircustom.setText(homeIndustry.getBody().getCategoryListData().get(2).getEcCategory().getTabName());
                beauty.setText(homeIndustry.getBody().getCategoryListData().get(3).getEcCategory().getTabName());
                permanent.setText(homeIndustry.getBody().getCategoryListData().get(4).getEcCategory().getTabName());
                break;
            //首页的女王头条
            case ACTION.HEADLINES:
                homeHeadlines = GsonUtil.toObj(res, HomeHeadlines.class);
                contentArray = new String[]{homeHeadlines.getBody().getTopListData().get(0).getEcTop().getTopName(),
                        homeHeadlines.getBody().getTopListData().get(1).getEcTop().getTopName(),
                        homeHeadlines.getBody().getTopListData().get(2).getEcTop().getTopName()};
                marqueeview.setTextArray(contentArray);
                break;
            //首页banner广告
            case ACTION.ADVERTISING:
                homeAdvertising = GsonUtil.toObj(res, HomeAdvertising.class);
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
                       Intent intent=new Intent(context, HomeAdvertisingActivity.class);
                       intent.putExtra("weburl",homeAdvertising.getBody().getAdvertisementListData().get(0).getEcAdvertisement().getAdUrl());
                       context.startActivity(intent);
                    }
                });

                break;
        }
    }

    /**
     * 点击首页跑马灯效果
     */


    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }


}
