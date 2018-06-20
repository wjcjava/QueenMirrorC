package com.ainisi.queenmirror.queenmirrorcduan.ui;

import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseNewActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.HackyViewPager;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utils.ViewPager;

import butterknife.Bind;
import butterknife.OnClick;

public class GuidePageActivity extends BaseNewActivity {

    @Bind(R.id.view_pager)
    HackyViewPager view_pager;
    @Bind(R.id.login)
    TextView login;
    SamplePagerAdapter adapter;
    private int[] imgs = { R.drawable.wecome1, R.drawable.wecome2,R.drawable.wecome3 };


    @Override
    protected int getLayoutId() {
        return R.layout.activity_guide_page;
    }

    protected void initView() {
        SP.put(GuidePageActivity.this, SpContent.IsFirst,"1");

        adapter = new SamplePagerAdapter();
        view_pager.setAdapter(adapter);
    }

    protected void initData() {
        login.setVisibility(View.INVISIBLE);
    }

    @OnClick({R.id.login})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.login:
                /**
                 * tabhost主页
                 */
                /*Intent intent = new Intent(SplashActivity.this,
                        MainTabActivity.class);*/
                /**
                 * 这里是侧滑主页MainSideslipActivity
                 */
                Intent intent = new Intent(GuidePageActivity.this,
                        HomePageActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }
    protected void doFirstRequest() {

    }

    class SamplePagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return imgs.length;
        }

        @Override
        public View instantiateItem(ViewGroup container, final int position) {
            ImageView photoView = new ImageView(container.getContext());
            photoView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            photoView.setImageResource(imgs[position]);
            // Now just add PhotoView to ViewPager and return it
            if(position == 2){
                login.setVisibility(View.VISIBLE);
            }else{
                login.setVisibility(View.INVISIBLE);
            }
            container.addView(photoView, ViewGroup.LayoutParams.MATCH_PARENT,
                    android.support.v4.view.ViewPager.LayoutParams.MATCH_PARENT);

            return photoView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }
}
