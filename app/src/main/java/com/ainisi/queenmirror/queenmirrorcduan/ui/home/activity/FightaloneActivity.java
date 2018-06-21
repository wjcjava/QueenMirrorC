package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.FightaloneAddBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.FightaloneBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.CollectionSpellBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.SpellDetailsBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.DateUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.bumptech.glide.Glide;
import com.lzy.okgo.cache.CacheMode;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    @Bind(R.id.iv_spell_shopcollection)
    ImageView shopCollection;

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
    /*@Bind(R.id.iv_title)
    CircleImageView iv_title;*/
    @Bind(R.id.tv_fightalone_textname)
    TextView tv_fightalone_textname;
    @Bind(R.id.tv_surplus)
    TextView tv_surplus;
    @Bind(R.id.tv_fightalone_shengyu)
    TextView tv_fightalone_shengyu;
    @Bind(R.id.tv_fightalone_name2)
    TextView tv_fightalone_name2;
    @Bind(R.id.tv_surplustwo)
    TextView tv_surplustwo;
    @Bind(R.id.tv_fightalone_shengyu2)
    TextView tv_fightalone_shengyu2;
    @Bind(R.id.re_surplus)
    RelativeLayout re_surplus;
    @Bind(R.id.view_fightaltwo)
    View view_fightaltwo;
    @Bind(R.id.re_surplustwo)
    RelativeLayout re_surplustwo;
    @Bind(R.id.tv_home_goShare)
    TextView tv_home_goShare;
    @Bind(R.id.tv_home_goShare1)
    TextView tv_home_goShare1;

    private List<SortBean> fulllist = new ArrayList<>();
    private List<SortBean> fulllist2 = new ArrayList<>();
    private String isLogin,activityId,goodsName,goodsId,goodsBrief,goodsService,goodsSales,goodsMarket;
    private boolean iscomment = false;
    String groupId = "",isOwner;

    String groupOrderId;
    String orderId;

    FightaloneBean fightaloneBean;

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
        textView.setText("￥"+goodsMarket);
        textView.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG);
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
       //inithttp();
    }

    private void initText() {
        fullTitle.setText(goodsName);
        fullPhoto.setImageResource(R.drawable.icon_full_fenxiang);
        fullPhoto.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.title_back, R.id.relative_look_more, R.id.tv_home_goShare, R.id.tv_startspell, R.id.rl_spell_shopcollection,R.id.tv_home_goShare1})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            //拼单剩余人数（查看更多）
            case R.id.relative_look_more:
                    /**
                     * 点击查看更多
                     */

                    Intent intent = new Intent(this, SpellOrderListActivity.class);
                    intent.putExtra("bean",(Serializable)fightaloneBean);
                    startActivity(intent);
                   // startActivity(new Intent(this, SpellOrderListActivity.class));
                break;
            case R.id.tv_home_goShare1:
                if (isLogin.equals("1")) {
                    isOwner = "1";
                    groupId = fightaloneBean.getBody().getGpOrderList().get(1).getGpOrder().getGroupId();

                    PinTuanData();
                } else {
                    T.show("请登录");
                }
                break;
            case R.id.tv_home_goShare:
                if (isLogin.equals("1")) {
                    isOwner = "1";
                    groupId = fightaloneBean.getBody().getGpOrderList().get(0).getGpOrder().getGroupId();

                    PinTuanData();
                } else {
                    T.show("请登录");
                }
                break;
            //开启拼单
            case R.id.tv_startspell:
                if (isLogin.equals("1")) {
                    isOwner = "0";
                    groupId = "";
                    PinTuanData();
                } else {
                    T.show("请登录");
                }

                break;

            case R.id.rl_spell_shopcollection:
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
     * 拼团Data(点击拼团)
     */
    private void PinTuanData() {
        /**
         * platform ：3”（固定值）  purchaseNumber ：1”（购买数量）  groupId：“”(建团不需要传值，参加拼团传拼团ID)
         * grouptype：“2”（拼团模式固定值）
         * ifrefund：“1”（固定值）   isOwner：“0”（是否房主    建团传0，参团传1）
         */
        HashMap<String, String> parames = new HashMap<>();
        parames.put("goodsId", goodsId);//拼团商品的ID
        parames.put("userId",SP.get(this,SpContent.UserId,"0")+"");
        parames.put("platform","3");
        parames.put("purchaseNumber","1");
        parames.put("activityId",activityId);
        parames.put("groupId",groupId);
        parames.put("grouptype","2");
        parames.put("ifrefund","1");
        parames.put("isOwner",isOwner);
        HttpUtils.doPost(ACTION.ADDPINTUAN, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 拼单详情
     */
    private void inithttp() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("groupId", goodsId);//拼团商品的ID
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
             * 点击拼团
             */
            case ACTION.ADDPINTUAN:

                FightaloneAddBean fightaloneAddBean = GsonUtil.toObj(res,FightaloneAddBean.class);
                if(fightaloneAddBean.isSuccess()&&fightaloneAddBean.getErrorCode().equals("0")){
                    groupOrderId = fightaloneAddBean.getBody().getGroupOrderId();
                    orderId = fightaloneAddBean.getBody().getOrderId();

                    Intent intent = new Intent(this,SubmitPinTuanActivity.class);
                    intent.putExtra("businessIds",orderId);
                    intent.putExtra("amount",goodsSales);
                    intent.putExtra("groupId",groupId);
                    startActivity(intent);
                }else{
                    T.show(fightaloneAddBean.getMsg());
                }

                break;
            /**
             * 拼团之外的信息
             */
            case ACTION.GETPINTUANDATA:

                fightaloneBean = GsonUtil.toObj(res,FightaloneBean.class);
                tv_collage.setText(fightaloneBean.getBody().getJoinSums()+"人在拼团");

                if(fightaloneBean.getBody().getGpOrderList().size() == 0||fightaloneBean.getBody().getGpOrderList() == null||
                        fightaloneBean.getBody().getJoinSums() == 0){
                    re_surplus.setVisibility(View.GONE);
                    view_fightaltwo.setVisibility(View.GONE);
                    re_surplustwo.setVisibility(View.GONE);
                }else if(fightaloneBean.getBody().getGpOrderList().size() == 1){
                    re_surplus.setVisibility(View.VISIBLE);
                    view_fightaltwo.setVisibility(View.GONE);
                    re_surplustwo.setVisibility(View.GONE);

                    tv_fightalone_textname.setText(fightaloneBean.getBody().getGpOrderList().get(0).getAnsCustBasic().getUserName());
                    tv_surplus.setText("还差"+(fightaloneBean.getBody().getGroupNums()-fightaloneBean.getBody().getGpOrderList().get(0).getGpOrder().getJoinNums())+"人拼成");
                    int second =Integer.parseInt(fightaloneBean.getBody().getGpOrderList().get(0).getGpOrder().getEndTimes().toString());
                    Date date1 = new Date(second);
                    SimpleDateFormat format1 = new SimpleDateFormat("HH:MM");
                    tv_fightalone_shengyu.setText("剩余："+ format1.format(date1));
                }else{
                    re_surplus.setVisibility(View.VISIBLE);
                    view_fightaltwo.setVisibility(View.VISIBLE);
                    re_surplustwo.setVisibility(View.VISIBLE);
                    tv_fightalone_textname.setText(fightaloneBean.getBody().getGpOrderList().get(0).getAnsCustBasic().getUserName());
                    tv_surplus.setText("还差"+(fightaloneBean.getBody().getGroupNums()-fightaloneBean.getBody().getGpOrderList().get(0).getGpOrder().getJoinNums())+"人拼成");
                    view_fightaltwo.setVisibility(View.VISIBLE);

                    int second =Integer.parseInt(fightaloneBean.getBody().getGpOrderList().get(0).getGpOrder().getEndTimes().toString());
                    Date date1 = new Date(second);
                    SimpleDateFormat format1 = new SimpleDateFormat("HH:MM");
                    tv_fightalone_shengyu.setText("剩余："+ format1.format(date1));

                    tv_fightalone_name2.setText(fightaloneBean.getBody().getGpOrderList().get(1).getAnsCustBasic().getUserName());
                    tv_surplustwo.setText("还差"+(fightaloneBean.getBody().getGroupNums()-fightaloneBean.getBody().getGpOrderList().get(1).getGpOrder().getJoinNums())+"人拼成");
                    int second1 =Integer.parseInt(fightaloneBean.getBody().getGpOrderList().get(1).getGpOrder().getEndTimes().toString());

                    Date date = new Date(second1);
                    SimpleDateFormat format = new SimpleDateFormat("HH:MM");
                    tv_fightalone_shengyu2.setText("剩余："+ format.format(date));
                }

                break;
            case ACTION.SPELLDETAILS:
                SpellDetailsBean detailsBean = GsonUtil.toObj(res, SpellDetailsBean.class);
                if (detailsBean.isSuccess()) {
                 /*   SpellDetailsBean.BodyBean.GroupActivityDataBean groupActivityData = detailsBean.getBody().getGroupActivityData();
                    tv_spell_shopname.setText(groupActivityData.getGpActivity().getGroupName());
                    tv_spell_shopabstract.setText(groupActivityData.getGpActivity().getGroupBrief());
                    tv_spell_shoptime.setText(groupActivityData.getGpActivity().getGroupStart());
                    shopBrowse.setText(groupActivityData.getGpActivity().getCurrentNumber());
                    shopDetails.setText(groupActivityData.getGpActivity().getGroupDetails());*/
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
