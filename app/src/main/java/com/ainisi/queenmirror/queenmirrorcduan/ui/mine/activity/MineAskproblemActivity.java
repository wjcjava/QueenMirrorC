package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 常见问题
 */
public class MineAskproblemActivity extends BaseActivity {
    @Bind(R.id.title_title)
    TextView askTitle;
    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_askproblem;
    }

    @Override
    public void initPresenter() {

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
}
