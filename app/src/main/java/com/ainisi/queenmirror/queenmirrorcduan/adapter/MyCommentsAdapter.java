package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity.ReplyCommentActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.mine.bean.MyCommentsBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by john on 2018/5/17.
 */

public class MyCommentsAdapter extends BaseQuickAdapter<MyCommentsBean.BodyBean.CommentsListDataBean,BaseViewHolder>{

    private final Context context;
    private List<MyCommentsBean.BodyBean.CommentsListDataBean.ApiEcAppraiseReplyListBean> replyList;

    public MyCommentsAdapter(int layoutResId, @Nullable List<MyCommentsBean.BodyBean.CommentsListDataBean> data, Context context) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, final MyCommentsBean.BodyBean.CommentsListDataBean item) {
        helper.setText(R.id.tv_shopname,item.getShopIdName());
        helper.setText(R.id.tv_name,item.getGoodsIdName()+"");
        helper.setOnClickListener(R.id.re_relayComment, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replyList=item.getApiEcAppraiseReplyList();
                Intent intent=new Intent(context, ReplyCommentActivity.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("replyList",item);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

    }
}
