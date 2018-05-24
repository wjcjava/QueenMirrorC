package com.ainisi.queenmirror.queenmirrorcduan.adapter;

import android.support.annotation.Nullable;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.ConfirmRefundActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.RefundReasonActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class RefundReasonAdapter  extends BaseQuickAdapter<String,BaseViewHolder> {


    public RefundReasonAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final String item) {

        helper.setText(R.id.tv_arefund_reason,item.toString());

        CheckBox check_refundreason_check = helper.getView(R.id.check_refundreason_check);
        check_refundreason_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    RefundReasonActivity.instance.finish();
                    ConfirmRefundActivity.instance.tv_arefund_select.setText(item);
                }
            }
        });
    }
}
