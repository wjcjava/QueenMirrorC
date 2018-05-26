package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.ProblemListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/5/26.
 *
 */

public class CommonProblemAdapter extends BaseQuickAdapter<ProblemListBean.BodyBean.QaCateListDataBean, BaseViewHolder> {
    public CommonProblemAdapter(int layoutResId, @Nullable List<ProblemListBean.BodyBean.QaCateListDataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ProblemListBean.BodyBean.QaCateListDataBean item) {
        helper.setText(R.id.problem_name, item.getLabel());
        final CheckBox check_problem = helper.getView(R.id.check_problem);
        final TextView answer = helper.getView(R.id.tv_answer);
        check_problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check_problem.isChecked()){
                    answer.setVisibility(View.VISIBLE);
                }else {
                    answer.setVisibility(View.GONE);
                }
            }
        });
    }

}
