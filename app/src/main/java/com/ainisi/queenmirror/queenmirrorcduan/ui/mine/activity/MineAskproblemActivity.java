package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.CommonProblemAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.ProblemListBean;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.cache.CacheMode;

import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 常见问题
 */
public class MineAskproblemActivity extends BaseNewActivity implements HttpCallBack {
    @Bind(R.id.title_title)
    TextView askTitle;
    @Bind(R.id.re_problem)
    RecyclerView reProblem;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_askproblem;
    }

    @Override
    protected void initData() {
        super.initData();
        HashMap<String, String> parames = new HashMap<>();
        parames.put("", "");
        HttpUtils.doPost(ACTION.PROBLEMLIST, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);

    }

    @Override
    public void initView() {
        askTitle.setText(R.string.common_problem);
    }

    @OnClick({R.id.title_back
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
        }
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.PROBLEMLIST:
                ProblemListBean problemListBean = GsonUtil.toObj(res, ProblemListBean.class);
                if (problemListBean.isSuccess()) {
                    final List<ProblemListBean.BodyBean.QaCateListDataBean> list = problemListBean.getBody().getQaCateListData();
                    CommonProblemAdapter problemAdapter = new CommonProblemAdapter(R.layout.item_askproblem, list);
                    reProblem.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                    reProblem.setAdapter(problemAdapter);
                    problemAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
                        @Override
                        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                            TextView name = view.findViewById(R.id.problem_name);
                            switch (view.getId()) {
                                case R.id.problem_name:
                                    T.show("你点击了我");
                                    name.setText("你点击了我");
                                    break;
                            }
                        }
                    });
                    break;
                }
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
