package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.MyCommentsBean;

import java.util.ArrayList;

import butterknife.Bind;

public class ReplyCommentActivity extends BaseNewActivity{
    private ArrayList<MyCommentsBean.BodyBean.CommentsListDataBean.ApiEcAppraiseReplyListBean> replyList;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_reply_comment;
    }

    @Override
    protected void initData() {
        super.initData();
        replyList= (ArrayList<MyCommentsBean.BodyBean.CommentsListDataBean.ApiEcAppraiseReplyListBean>)getIntent().getSerializableExtra("replyList");

        tvName.setText(replyList.get(1).getEcAppraiseReply().getReplyContent());
    }
}
