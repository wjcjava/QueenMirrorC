package com.ainisi.queenmirror.queenmirrorcduan.ui.fragment;

import android.content.Intent;
import android.net.Uri;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.MoDouBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.NewsBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.MessageActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.MondelActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.InstallActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineAuthenticationActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineBeanActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineBeautyActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineCollectionActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineDiscountActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineEvaluateActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineFollowActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineFriendsActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineGiftActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineHomepageActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineMyFootActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineMyWalletActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MinePositionActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineProblemActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.MineQueenActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.PortraitActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.user.LoginActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.OnClick;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

/**
 * Created by EWorld on 2018/3/6.
 * 我的
 */

public class MineFragment extends BaseFragment implements HttpCallBack {
    @Bind(R.id.tv_mine_uername)
    TextView tv_mine_uername;
    @Bind(R.id.img_information)
    ImageView img_information;
    @Bind(R.id.tv_mine_modou)
    TextView tv_mine_modou;
    boolean isLogin = false;
    private String service_tel = "120";
    int moDou = 0;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initPresenter() {
    }

    @Override
    public void onResume() {
        super.onResume();
        if (SP.get(getActivity(), SpContent.isLogin, "0").toString().equals("1")) {
            isLogin = true;
            tv_mine_uername.setText(SP.get(getActivity(), SpContent.UserName, "") + "");
        } else {
            isLogin = false;
            tv_mine_uername.setText("点击登录");
        }
        /**
         * 获取新消息提示
         */
        // getNewNewsData();

        getMineModouData();
    }

    /**
     * 获取我的魔豆数据
     */
    private void getMineModouData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("custId", SP.get(getActivity(), SpContent.UserId, "") + "");
        HttpUtils.doPost(ACTION.GETMINEMODOU, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取新消息提示
     */
    private void getNewNewsData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", SP.get(getActivity(), SpContent.UserId, "") + "");
        params.put("messageType", "");
        HttpUtils.doPost(ACTION.GETNEWNEWS, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    protected void initView() {
    }

    @OnClick({R.id.iv_title, R.id.iv_install, R.id.img_information,
            R.id.layout_collection, R.id.layout_follow, R.id.layout_foot,
            R.id.layout_evaluate, R.id.img_position, R.id.img_friends,
            R.id.ly_mine_discount, R.id.ly_mine_foot, R.id.ly_mine_bean,
            R.id.layout_gift, R.id.layout_beauty, R.id.li_mine_homepage,
            R.id.layout_problem, R.id.lay_service, R.id.ly_mine_wallet,
            R.id.li_mine_main_authentication, R.id.li_mine_model, R.id.tv_mine_uername})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.tv_mine_uername:
                if (isLogin) {
                    startActivity(new Intent(getContext(), PortraitActivity.class));
                } else {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            //我要认证
            case R.id.li_mine_main_authentication:
                MineAuthenticationActivity.startActivity(getActivity());
                break;
            //更改头像和个人信息
            case R.id.iv_title:
                //PortraitActivity.startActivity(getActivity());
                if (isLogin) {
                    startActivity(new Intent(getContext(), PortraitActivity.class));
                } else {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            //设置
            case R.id.iv_install:
                if (isLogin) {
                    InstallActivity.startActivity(getActivity());
                } else {
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }

                break;
            //信息
            case R.id.img_information:
                MessageActivity.startActivity(getActivity());
                break;
            //我的收藏
            case R.id.layout_collection:
                if (isLogin) {
                    MineCollectionActivity.startActivity(getActivity());
                } else {
                    T.show("请先进行登录");
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            //关注店铺
            case R.id.layout_follow:
                if (isLogin) {
                    MineFollowActivity.startActivity(getActivity());
                } else {
                    T.show("请先进行登录");
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            //我的首页
            case R.id.li_mine_homepage:
                if (isLogin) {
                    startActivity(new Intent(getActivity(), MineHomepageActivity.class));
                } else {
                    T.show("请先进行登录");
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            //我的足迹
            case R.id.layout_foot:
                if (isLogin) {
                    MineMyFootActivity.startActivity(getActivity());
                } else {
                    T.show("请先进行登录");
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            //评价
            case R.id.layout_evaluate:
                if (isLogin) {
                    MineEvaluateActivity.startActivity(getActivity());
                } else {
                    T.show("请先进行登录");
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            //我的位置
            case R.id.img_position:
                if (isLogin) {
                    startActivity(new Intent(getActivity(), MinePositionActivity.class));
                } else {
                    T.show("请先进行登录");
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            //我的好友
            case R.id.img_friends:
                if (isLogin) {
                    startActivity(new Intent(getActivity(), MineFriendsActivity.class));
                } else {
                    T.show("请先进行登录");
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            //优惠券
            case R.id.ly_mine_discount:
                if (isLogin) {
                    MineDiscountActivity.startActivity(getActivity());
                } else {
                    T.show("请先进行登录");
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            //我的资产（女王卡）
            case R.id.ly_mine_foot:
                if (isLogin) {
                    MineQueenActivity.startActivity(getActivity());
                } else {
                    T.show("请先进行登录");
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            //我的钱包
            case R.id.ly_mine_wallet:
                if (isLogin) {

                    MineMyWalletActivity.startActivity(getActivity());
                } else {
                    T.show("请先进行登录");
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            //我的魔豆
            case R.id.ly_mine_bean:
                if (isLogin) {
                    MineBeanActivity.startActivity(getActivity());
                } else {
                    T.show("请先进行登录");
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            //邀请有奖
            case R.id.layout_gift:
                if (isLogin) {
                    MineGiftActivity.startActivity(getActivity());
                } else {
                    T.show("请先进行登录");
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            //成为美业人
            case R.id.layout_beauty:
                if (isLogin) {
                    MineBeautyActivity.startActivity(getActivity());
                } else {
                    T.show("请先进行登录");
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            //帮助与反馈
            case R.id.layout_problem:
                getActivity().startActivity(new Intent(getActivity(), MineProblemActivity.class));
                break;
            //客服
            case R.id.lay_service:
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + service_tel);
                intent.setData(data);
                startActivity(intent);
                break;
            //魔豆商城
            case R.id.li_mine_model:
                if (isLogin) {
                    getActivity().startActivity(new Intent(getActivity(), MondelActivity.class));
                } else {
                    T.show("请先进行登录");
                    startActivity(new Intent(getContext(), LoginActivity.class));
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.GETMINEMODOU:
                MoDouBean moDouBean = GsonUtil.toObj(res,MoDouBean.class);
                if(moDouBean.isSuccess()){
                    moDou = moDouBean.getBody().getAnsMemberBasic().getCardBalance();
                    tv_mine_modou.setText(moDou + "个");
                }else{
                    T.show(moDouBean.getMsg());
                }
                break;
            case ACTION.GETNEWNEWS:
                NewsBean newsBean = GsonUtil.toObj(res, NewsBean.class);

                if (newsBean.isSuccess()) {
                    if (newsBean.getBody().getIsRead().equals("0")) {

                    } else {
                        QBadgeView badgeView = new QBadgeView(getActivity());
                        badgeView.bindTarget(img_information);
                        badgeView.setBadgeTextSize(10, false);
                        badgeView.setBadgeText("");
                        badgeView.setBadgeTextColor(this.getResources().getColor(R.color.white));
                        badgeView.setBadgeGravity(Gravity.END | Gravity.TOP);
                        badgeView.setBadgeBackgroundColor(this.getResources().getColor(R.color.colorPri));
                        badgeView.setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                            @Override
                            public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                            }
                        });
                    }
                } else {
                    T.show(newsBean.getMsg());
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

