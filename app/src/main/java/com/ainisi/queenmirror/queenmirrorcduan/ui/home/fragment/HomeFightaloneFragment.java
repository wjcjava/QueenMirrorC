package com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.PintuanListAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.PinTuanBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FightaloneActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.zxing.WriterException;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 * 拼团
 */
public class HomeFightaloneFragment extends BaseFragment implements HttpCallBack {
    @Bind(R.id.recycler_fragment_fightalone)
    RecyclerView reFightalone;
    List<PinTuanBean.BodyBean.GroupActivityListDataBean> sortlist = new ArrayList<>();
    String state = "0";
    int pageNumber = 1;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_home_fightalone;
    }

    public HomeFightaloneFragment newInstance(String flag) {
        Bundle bundle = new Bundle();
        bundle.putString("state", flag);
        HomeFightaloneFragment testFm = new HomeFightaloneFragment();
        testFm.setArguments(bundle);
        return testFm;
    }

    @Override
    public void initPresenter() {
    }


    @Override
    protected void initView() {
        getData();
    }

    /**
     * 获取数据
     */
    private void getData() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            state = bundle.getString("state");
        }
        HashMap<String, String> params = new HashMap<>();
        params.put("groupStatus", "3");
        params.put("pageNumber", pageNumber + "");
        params.put("contentByTitle", state);
        params.put("pageSize", SpContent.pageSize);
        HttpUtils.doPost(ACTION.TUANDUILISTDATA, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onSuccess(int action, String res) throws WriterException {
        switch (action){
            case ACTION.TUANDUILISTDATA:
                PinTuanBean pinTuanBean = GsonUtil.toObj(res,PinTuanBean.class);

                if(pinTuanBean.isSuccess()){

                    sortlist = pinTuanBean.getBody().getGroupActivityListData();
                    PintuanListAdapter pintuanListAdapter = new PintuanListAdapter(R.layout.re_home_fightalone,sortlist);
                    reFightalone.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
                    reFightalone.setAdapter(pintuanListAdapter);

                    pintuanListAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            /**
                             * 这里需要传商品的相关信息的？
                             */
                            Intent intent = new Intent(getActivity(),FightaloneActivity.class);
                            intent.putExtra("activityId",sortlist.get(position).getGpActivity().getId());
                            intent.putExtra("goodsName",sortlist.get(position).getEcGoodsBasic().getGoodsName());
                            intent.putExtra("goodsId",sortlist.get(position).getEcGoodsBasic().getId());
                            intent.putExtra("goodsBrief",sortlist.get(position).getEcGoodsBasic().getGoodsBrief());
                            intent.putExtra("goodsService",sortlist.get(position).getEcGoodsBasic().getServiceTime());
                            intent.putExtra("goodsSales",sortlist.get(position).getEcGoodsBasic().getSalesPrice());
                            if(sortlist.get(position).getEcGoodsBasic().getMarketPrice() == null){
                                intent.putExtra("goodsMarket", "0");
                            }else {
                                intent.putExtra("goodsMarket", sortlist.get(position).getEcGoodsBasic().getMarketPrice());
                            }
                          //  intent.putExtra("goodsNumber",sortlist.get(position).getEcGoodsBasic().get)
                            startActivity(intent);
                        }
                    });
                }else{
                    T.show("暂无相关信息");
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
