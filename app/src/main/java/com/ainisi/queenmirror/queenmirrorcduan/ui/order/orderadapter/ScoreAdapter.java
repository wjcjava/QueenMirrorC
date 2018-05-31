package com.ainisi.queenmirror.queenmirrorcduan.ui.order.orderadapter;

import android.support.annotation.Nullable;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by 王军超 on 2018/3/22.
 */

public class ScoreAdapter extends BaseQuickAdapter<SortBean,BaseViewHolder> {


    private TextView scoreText;

    public ScoreAdapter(int layoutResId, @Nullable List<SortBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SortBean item) {
//        CustomRatingBar customRatingBar=helper.getView(R.id.score_custom);
//        scoreText = helper.getView(R.id.tv_score);
//        customRatingBar.setTouchAble(true);
//        customRatingBar.setmOnStarChangeListener(new CustomRatingBar.onStarChangedListener() {
//            @Override
//            public void onStarChange(CustomRatingBar ratingBar, float mark) {
//                initcoustom(mark);
//            }
//        });
    }
    private void initcoustom(float mark) {
        switch ((int) mark) {
            case 1:
                scoreText.setText("差");
                break;
            case 2:
                scoreText.setText("差");
                break;
            case 3:
                scoreText.setText("一般");
                break;
            case 4:
                scoreText.setText("一般");
                break;
            case 5:
                scoreText.setText("非常好");
                break;
        }
    }
}
