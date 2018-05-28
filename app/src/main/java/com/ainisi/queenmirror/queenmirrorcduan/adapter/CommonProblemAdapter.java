package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.ProblemDataBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.ProblemListBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;
import java.util.List;

/**
 * Created by john on 2018/5/26.
 *
 */

public class CommonProblemAdapter extends BaseQuickAdapter<ProblemListBean.BodyBean.QaCateListDataBean, BaseViewHolder> implements HttpCallBack{
    private String qaQuestion;

    public CommonProblemAdapter(int layoutResId, @Nullable List<ProblemListBean.BodyBean.QaCateListDataBean> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, ProblemListBean.BodyBean.QaCateListDataBean item) {
        helper.setText(R.id.problem_name, item.getLabel());
        final CheckBox check_problem = helper.getView(R.id.check_problem);
        final TextView answer = helper.getView(R.id.tv_answer);
        inithttp();
        check_problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check_problem.isChecked()){

                    answer.setVisibility(View.VISIBLE);
                    answer.setText(qaQuestion);

                }else {
                    answer.setVisibility(View.GONE);
                }
            }
        });
    }
    private void inithttp() {
        HashMap<String,String> parames=new HashMap<>();
        parames.put("qaCategory","1");
        HttpUtils.doPost(ACTION.PROBLEMDATA,parames, CacheMode.REQUEST_FAILED_READ_CACHE,true,this);
    }

    @Override
    public void onSuccess(int action, String res) {
            switch (action){
                case ACTION.PROBLEMDATA:
                   ProblemDataBean dataBean=GsonUtil.toObj(res, ProblemDataBean.class);
                   if(dataBean.isSuccess()){
                       qaQuestion=dataBean.getBody().getQaListData().get(0).getEcQa().getQaQuestion();
                   }else {
                       T.show(dataBean.getMsg());
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
