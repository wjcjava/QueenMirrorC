package com.ainisi.queenmirror.queenmirrorcduan.ui.mine.activity;

import android.app.Instrumentation;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 帮助与反馈
 */
public class MineProblemActivity extends BaseNewActivity {
    @Bind(R.id.title_title)
    TextView proTitle;
    @Bind(R.id.web_problem)
    WebView webProblem;
    String url = "http://192.168.30.155:7080/wg/webpage/staticSource/proposal.html";


    @Override
    public int getLayoutId() {
        return R.layout.activity_mine_problem;
    }

    @Override
    public void initView() {
        proTitle.setText(R.string.refund_progress);

    }

    @Override
    protected void initData() {
        super.initData();
        webProblem.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webProblem.loadUrl(url);
        //支持屏幕缩放
        WebSettings webSettings = webProblem.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && webProblem.canGoBack()) {
            webProblem.goBack();// 返回前一个页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @OnClick({R.id.title_back
    })
    public void click(View view) {

        switch (view.getId()) {
            case R.id.title_back:
                actionKey(KeyEvent.KEYCODE_BACK);
                break;
            default:
                break;

        }


    }

    public void actionKey(final int keyCode) {
        new Thread() {
            public void run() {
                try {
                    Instrumentation inst = new Instrumentation();
                    inst.sendKeyDownUpSync(keyCode);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
