package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class BackPayActivity extends BaseNewActivity {
    @Bind(R.id.title_title)
    TextView payBack;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_back_pay;
    }

    @Override
    protected void initView() {
        super.initView();
        payBack.setText(getIntent().getStringExtra("payback"));
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
