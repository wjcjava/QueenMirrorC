package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class ModifyPayActivity extends BaseNewActivity {
    @Bind(R.id.title_title)
    TextView paymodify;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_modify_pay;
    }

    @Override
    protected void initView() {
        super.initView();
        paymodify.setText("设置支付密码");

    }

    @OnClick({R.id.title_back, R.id.tv_ok_submit
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                finish();
                break;
            case R.id.tv_ok_submit:
                MineSettingActivity.startActivity(this);
                break;
        }


    }
}
