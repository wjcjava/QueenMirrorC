package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;
import butterknife.OnClick;

//我的位置
public class MinePositionActivity extends BaseNewActivity {
    @Bind(R.id.title_title)
    TextView postitle;
    @Bind(R.id.title_right)
    TextView postitleright;

    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_position;
    }


    @Override
    protected void initView() {
        super.initView();
        postitle.setText(R.string.myposition);
        postitle.setTextSize(16);
        postitleright.setText(R.string.administration);
        postitleright.setTextSize(14);
        postitle.setTextColor(ContextCompat.getColor(this, R.color.alpha_95_black));

    }

    @Override
    protected void initData() {
        super.initData();

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
