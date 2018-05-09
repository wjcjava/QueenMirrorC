package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class MineHomepageActivity extends BaseNewActivity {

    @Bind(R.id.title_title)
    TextView pageTitle;
    @Override
    protected int getLayoutId() {
        return R.layout.mine_pager;
    }

    @Override
    protected void initData() {
        super.initData();
        pageTitle.setText(R.string.MyHomepage);
        pageTitle.setTextSize(18);
    }
    @OnClick({R.id.title_back
    })
    public void click(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            default:
                break;

        }
    }
}
