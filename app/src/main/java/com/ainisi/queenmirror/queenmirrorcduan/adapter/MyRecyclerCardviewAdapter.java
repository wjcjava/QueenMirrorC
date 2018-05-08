package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.Bean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.EstheticsActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.HomeFightaloneActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GlideImageLoader;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MarqueeView;
import com.lzy.okgo.cache.CacheMode;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 用于首页多item布局
 */
public class MyRecyclerCardviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements HttpCallBack, View.OnClickListener {

    private final Context context;
    List<Bean.BodyBean.ApiRefundListBean> apiRefundList = new ArrayList<>();
    int type;
    String[] contentArray = new String[]{
            "恭喜杨小姐领取奔驰4s店优惠券一张",
            "恭喜李先生领取奶茶特饮优惠券一张",
            "恭喜王小姐领取50元话费优惠券一张",
            "恭喜杨小姐领取奔驰4s店优惠券一张",
            "恭喜李先生领取奶茶特饮优惠券一张",
            "恭喜王小姐领取50元话费优惠券一张",};

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


        } else if (holder instanceof VideoViewThreeHolder) {
            ((VideoViewThreeHolder) holder).homeShort.setOnClickListener(this);
        }

    }

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

        }
    }

    /**
     * 测试列表数据
     */
    private void CeshiData() {
        //传参数
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", "111");

        //doPost();  第一个参数：调用的方法       第二个：传递的参数   第三个：是否成功返回的样式    第四个：对话框     第五个：传入当前的activity
        HttpUtils.doPost(ACTION.LIST, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }


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
        MarqueeView marqueeview;
        LinearLayout home_freetrial;
        LinearLayout home_esthetics;
        private final Banner banner;
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
            banner = itemView.findViewById(R.id.banner);
            marqueeview = itemView.findViewById(R.id.marqueeview);
            initBanner(banner);
            initQuee();
        }

        /**
         * 点击首页跑马灯效果
         */
        private void initQuee() {
            marqueeview.setTextArray(contentArray);
            marqueeview.setOnItemClickListener(new MarqueeView.onItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    T.show("你点击" + position);
                }
            });
        }
    }

    //轮播
    private void initBanner(Banner banner) {
        List<String> images = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            images.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
        }
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(images);
        banner.start();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {


        private ImageView surFace;


        public VideoViewHolder(View itemView) {
            super(itemView);
            surFace = itemView.findViewById(R.id.iv_surface);


        }

    }

    private class VideoViewThreeHolder extends RecyclerView.ViewHolder {
        private LinearLayout homeShort;

        public VideoViewThreeHolder(View itemView) {
            super(itemView);
            homeShort = itemView.findViewById(R.id.li_home_short);
        }
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.LIST:
                Bean bean = GsonUtil.toObj(res, Bean.class);
                T.show(bean.getMsg());
                Bean.BodyBean body = bean.getBody();
                apiRefundList = body.getApiRefundList();

                L.e("获取列表中为什么退款的原因   " + apiRefundList.get(0).getRefundReasonLabel());
                T.show(apiRefundList.get(0).getRefundReasonLabel());

                Bean.BodyBean.ApiRefundListBean.AnsCustRefundBean ansCustRefundBean = apiRefundList.get(0).getAnsCustRefund();

                L.e("???????????????????????   获取列表中对象中的ID信息  " + ansCustRefundBean.getId());
                break;
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }


}
