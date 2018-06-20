package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.FightaloneBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.CollectionSpellBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.SpellDetailsBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.bumptech.glide.Glide;
import com.lzy.okgo.cache.CacheMode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

import butterknife.Bind;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 拼单
 */
public class FightaloneActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.full_recycler)
    RecyclerView frecycler;
    @Bind(R.id.full_recyclertwo)
    RecyclerView frecyclertwo;
    @Bind(R.id.title_title)
    TextView fullTitle;
    @Bind(R.id.title_photo)
    ImageView fullPhoto;
    @Bind(R.id.tv_spell_shopbrowse)
    TextView shopBrowse;
    @Bind(R.id.tv_spell_shopdetails)
    TextView shopDetails;
    @Bind(R.id.iv_spell_shopcollection)
    ImageView shopCollection;
    //    @Bind(R.id.re_spell_shop)
//    RecyclerView reShopspell;


    @Bind(R.id.full_cash)
    TextView full_cash;
    @Bind(R.id.textView)
    TextView textView;
    @Bind(R.id.tv_spell_shopname)
    TextView tv_spell_shopname;
    @Bind(R.id.tv_spell_shopabstract)
    TextView tv_spell_shopabstract;
    @Bind(R.id.tv_spell_shoptime)
    TextView tv_spell_shoptime;
    @Bind(R.id.tv_collage)
    TextView tv_collage;
    @Bind(R.id.iv_title)
    CircleImageView iv_title;
    @Bind(R.id.tv_fightalone_textname)
    TextView tv_fightalone_textname;
    @Bind(R.id.tv_surplus)
    TextView tv_surplus;

    private List<SortBean> fulllist = new ArrayList<>();
    private List<SortBean> fulllist2 = new ArrayList<>();
    private String isLogin,activityId,goodsName,goodsId,goodsBrief,goodsService,goodsSales,goodsMarket;
    private boolean iscomment = false;

    // private List<SortBean> list=new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.activity_fightalone;
    }

    @Override
    public void initView() {
        initText();
        Intent intent = this.getIntent();
        activityId = intent.getStringExtra("activityId");
        goodsName = intent.getStringExtra("goodsName");
        goodsId = intent.getStringExtra("goodsId");
        goodsBrief = intent.getStringExtra("goodsBrief");
        goodsService = intent.getStringExtra("goodsService");
        goodsSales = intent.getStringExtra("goodsSales");
        goodsMarket = intent.getStringExtra("goodsMarket");

        full_cash.setText(goodsSales);
        textView.setText(goodsMarket);
        tv_spell_shopname.setText(goodsName);
        tv_spell_shopabstract.setText(goodsBrief);
        tv_spell_shoptime.setText("服务时长："+goodsService+"分钟");


        getFigHtData();


        isLogin = SP.get(this, SpContent.isLogin, "0").toString();
        for (int i = 0; i < 6; i++) {
            SortBean sortBean = new SortBean();
            sortBean.setName("MOCO美容美发沙龙");
            sortBean.setTime("营业时间 9:00-20:00");
            sortBean.setLogo(R.drawable.ic_sortrecyle_logo);
            sortBean.setStars(R.drawable.icon_home_recommend);
            sortBean.setDistance("875m");
            fulllist.add(sortBean);
        }
        MyAdapter sortAdapter = new MyAdapter(R.layout.item_fullrecycler, fulllist);
        frecycler.setLayoutManager(new GridLayoutManager(this, 2));
        frecycler.setAdapter(sortAdapter);
        for (int i = 0; i < 8; i++) {
            SortBean sortBean = new SortBean();
            sortBean.setName("");
            sortBean.setTime("");
            sortBean.setDistance("");
            fulllist2.add(sortBean);
        }
        MyAdapter sortAdapter2 = new MyAdapter(R.layout.item_fullrecyclertwo, fulllist2);

        frecyclertwo.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        frecyclertwo.setAdapter(sortAdapter2);
    }

    /**
     * 获取拼团人数
     */
    private void getFigHtData() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("orderstatus", "PT");
        parames.put("activityId",activityId);
        //商家活动（筛选）
        HttpUtils.doPost(ACTION.GETPINTUANDATA, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    protected void initData() {
        super.initData();
       // inithttp();
    }

    private void initText() {
        fullTitle.setText(goodsName);
        fullPhoto.setImageResource(R.drawable.icon_full_fenxiang);
        fullPhoto.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.title_back, R.id.relative_look_more, R.id.tv_home_goShare, R.id.tv_startspell, R.id.rl_spell_shopcollection})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            //拼单剩余人数（查看更多）
            case R.id.relative_look_more:
                if (isLogin.equals("1")) {
                    startActivity(new Intent(this, SpellOrderListActivity.class));
                } else {
                    T.show("请登录");
                }

                break;

            case R.id.tv_home_goShare:

                break;
            //开启拼单
            case R.id.tv_startspell:
                if (isLogin.equals("1")) {
                    Intent intent = new Intent(this, SubmitActivity.class);
                    startActivity(intent);
                } else {
                    T.show("请登录");
                }

                break;

            case R.id.rl_spell_shopcollection:
                T.show("你点击了我");
                if (isLogin.equals("1")) {
                    if (iscomment) {

                    } else {
                        initCollectiongp();
                    }
                } else {
                    T.show("请先登录");
                }
                break;
        }


    }

    /**
     * 拼单详情
     */
    private void inithttp() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("groupId", "123");//拼团商品的ID
        HttpUtils.doPost(ACTION.SPELLDETAILS, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 收藏拼单
     */
    private void initCollectiongp() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("userId", "111");
        parames.put("gpId", "12");
        HttpUtils.doPost(ACTION.SPELLCOLLECTION, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            /**
             * 拼团之外的信息
             */
            case ACTION.GETPINTUANDATA:
                L.e("*******    "+res);

                FightaloneBean fightaloneBean = GsonUtil.toObj(res,FightaloneBean.class);

                tv_collage.setText(fightaloneBean.getBody().getJoinSums()+"人在拼团");
                tv_fightalone_textname.setText(fightaloneBean.getBody().getGpOrderList().get(0).getAnsCustBasic().getUserName());

                tv_surplus.setText("还差"+(fightaloneBean.getBody().getGroupNums()-fightaloneBean.getBody().getGpOrderList().get(0).getGpOrder().getJoinNums())+"人拼成");

                SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");//这里想要只保留分秒可以写成"mm:ss"
                formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
                //String hms = formatter.format(fightaloneBean.getBody().getActivity().get);

                break;
            case ACTION.SPELLDETAILS:
                SpellDetailsBean detailsBean = GsonUtil.toObj(res, SpellDetailsBean.class);
                if (detailsBean.isSuccess()) {
                    SpellDetailsBean.BodyBean.GroupActivityDataBean groupActivityData = detailsBean.getBody().getGroupActivityData();
                    tv_spell_shopname.setText(groupActivityData.getGpActivity().getGroupName());
                    tv_spell_shopabstract.setText(groupActivityData.getGpActivity().getGroupBrief());
                    tv_spell_shoptime.setText(groupActivityData.getGpActivity().getGroupStart());
                    shopBrowse.setText(groupActivityData.getGpActivity().getCurrentNumber());
                    shopDetails.setText(groupActivityData.getGpActivity().getGroupDetails());
                    String isCollection = detailsBean.getBody().getGroupActivityData().getGpActivity().getShopId();
                    if (isCollection.equals("1")) {
                        iscomment = true;
                        shopCollection.setImageResource(R.drawable.collection_bein);
                    } else {
                        iscomment = false;
                        shopCollection.setImageResource(R.drawable.icon_full_collection);
                    }

                } else {
                    T.show(detailsBean.getMsg());
                }
                break;
            case ACTION.SPELLCOLLECTION:
                iscomment = true;
                CollectionSpellBean collectionSpellBean = GsonUtil.toObj(res, CollectionSpellBean.class);
                if (collectionSpellBean.isSuccess()) {
                    shopCollection.setImageResource(R.drawable.collection_bein);
                    T.show(collectionSpellBean.getMsg());
                } else {
                    shopCollection.setImageResource(R.drawable.icon_full_collection);
                    T.show(collectionSpellBean.getMsg());
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
}
