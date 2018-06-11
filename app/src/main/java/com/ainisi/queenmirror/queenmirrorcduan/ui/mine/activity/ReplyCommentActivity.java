package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.MyCommentsBean;

import butterknife.Bind;

public class ReplyCommentActivity extends BaseNewActivity{
    private MyCommentsBean.BodyBean.CommentsListDataBean bean;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_reply_comment;
    }

    @Override
    protected void initData() {
        super.initData();
        bean= (MyCommentsBean.BodyBean.CommentsListDataBean) getIntent().getSerializableExtra("replyList");
        tvName.setText(bean.getApiEcAppraiseReplyList().get(0).getEcAppraiseReply().getReplyContent());
    }
}
