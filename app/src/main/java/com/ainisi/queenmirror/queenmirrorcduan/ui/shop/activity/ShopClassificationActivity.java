package com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.EstheticsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.ProblemAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.EstheticsBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ProblemBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SearchActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.MerchantsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.MerchantsBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.PreferentialBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.ShopMainFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.util.ScreenPoputil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollViewPager;
import com.ainisi.queenmirror.queenmirrorcduan.utils.ViewPager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.cache.CacheMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 休闲娱乐
 */
public class ShopClassificationActivity extends BaseActivity implements HttpCallBack{
    @Bind(R.id.full_rb_sort)
    TextView hSort;
    @Bind(R.id.re_recommendable_projects)
    RecyclerView reProjects;
    @Bind(R.id.full_rb_sales)
    TextView hSales;
    @Bind(R.id.full_rb_distance)
    TextView hDistance;
    @Bind(R.id.full_rb_screen)
    TextView hscreen;
    @Bind(R.id.iv_sort)
    ImageView ivsort;
    @Bind(R.id.iv_sort1)
    ImageView ivsort1;
    @Bind(R.id.pager_home_full)
    NoScrollViewPager fullpager;
    @Bind(R.id.newtitle_title)
    TextView newtitle_title;

    //综合排序
    ShopMainFragment sortFragment = new ShopMainFragment();
    //销量最高
    ShopMainFragment salesFragment = new ShopMainFragment();
    //距离最近
    ShopMainFragment distanceFragment = new ShopMainFragment();
    //筛选
    ShopMainFragment screenFragment = new ShopMainFragment();
    private View popview1;
    private PopupWindow pop;
    private List<Fragment> pagerList = new ArrayList<>();
    private List<ProblemBean> list = new ArrayList<>();
    String[] problem = {"销量最高", "价格最低", "距离最近", "优惠最多", "满减优惠", "新用最好", "用户最好"};

    public String catName,catId;
    int pageNumber = 1;
    List<EstheticsBean.BodyBean.ApiShopListBean> apiShopList = new ArrayList<>();

    EstheticsAdapter sortAdapter;
    public static ShopClassificationActivity instance = null;
    private List<MerchantsBean.BodyBean.ActivityKeysListDataBean> merchantsList;
    private List<PreferentialBean.BodyBean.FeatureKeysListDataBean> preferentialList;
    private View popview;
    private PopupWindow popWindow;
    private MerchantsAdapter merchantsAdapter;

    public int getLayoutId() {
        instance = this;
        return R.layout.activity_shop_classification;
    }
    @Override
    public void initPresenter() {
    }
    @Override
    public void initView() {

        Intent intent  = this.getIntent();
        catName = intent.getStringExtra("catName");
        catId = intent.getStringExtra("catId");
        newtitle_title.setText(catName);

        doFirstData();
        initDate();
        initfragment();
        inithttp();
    }

    /**
     * 获取推荐好店的数据
     */
    private void doFirstData() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("categoryId", catId);
        hashMap.put("pageNumber", pageNumber + "");
        hashMap.put("pageSize", "10");
        hashMap.put("shopCate","2");
        HttpUtils.doPost(ACTION.MERCHANTSLIST, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 筛选
     */
    private void inithttp() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("", "");
        //商家活动（筛选）
        HttpUtils.doPost(ACTION.MERCHANTACTIVITY, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
        //商家特色（筛选）
        HttpUtils.doPost(ACTION.MERCHANTFEATURES, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }
    private void initfragment() {
        pagerList.add(sortFragment);
        pagerList.add(salesFragment);
        pagerList.add(distanceFragment);
        pagerList.add(screenFragment);
        ViewPager pager = new ViewPager(getSupportFragmentManager(), pagerList, null);
        fullpager.setScanScroll(true);
        fullpager.setAdapter(pager);
    }
    private void initDate() {
        pop = new PopupWindow(CollapsingToolbarLayout.LayoutParams.MATCH_PARENT, CollapsingToolbarLayout.LayoutParams.WRAP_CONTENT);
        popview1 = View.inflate(this, R.layout.pop_myitem, null);
        initpop(popview1);
        pop.setContentView(popview1);
        pop.setBackgroundDrawable(new ColorDrawable(0));
        pop.setOutsideTouchable(true);
        pop.setAnimationStyle(R.style.CustomPopWindowStyle);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                ivsort.setVisibility(View.VISIBLE);
                ivsort1.setVisibility(View.GONE);
            }
        });
        pop.dismiss();
    }
    private void initpop(View popview1) {
        final RecyclerView ce = popview1.findViewById(R.id.rc_popview);
        for (int i = 0; i < problem.length; i++) {
            ProblemBean problemBean = new ProblemBean();
            problemBean.setName(problem[i]);
            list.add(problemBean);
        }
        ProblemAdapter problemAdapter = new ProblemAdapter(R.layout.item_pop_sort, list);
        ce.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ce.setAdapter(problemAdapter);
        problemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                hSort.setText(problem[position]);
                pop.dismiss();
            }
        });
    }

    @OnClick({R.id.ed_keyword,R.id.iv_back,R.id.full_rb_sort, R.id.full_rb_sales, R.id.full_rb_distance, R.id.full_rb_screen, R.id.iv_sort, R.id.iv_sort1})
    public void click(View view) {
        switch (view.getId()) {
            //搜素
            case R.id.ed_keyword:
                SearchActivity.startActivity(this);
                break;
            case R.id.iv_back:
                finish();
                break;
//            //订单详情
//            case R.id.full_guijiao:
//                startActivity(new Intent(this, FullActivity.class));
//                break;
            //综合选择
            case R.id.iv_sort:
                ivsort.setVisibility(View.GONE);
                ivsort1.setVisibility(View.VISIBLE);
                pop.showAsDropDown(hSort);
                break;
            case R.id.iv_sort1:
                pop.dismiss();
                ivsort.setVisibility(View.VISIBLE);
                ivsort1.setVisibility(View.GONE);
                break;
            //综合排序
            case R.id.full_rb_sort:
                fullpager.setCurrentItem(0);
                break;
            //销量最高
            case R.id.full_rb_sales:
                fullpager.setCurrentItem(1);
                break;
            //距离最近
            case R.id.full_rb_distance:
                fullpager.setCurrentItem(2);
                break;
            //筛选
            case R.id.full_rb_screen:
                new ScreenPoputil(this).showscreenPop(hscreen,merchantsList,preferentialList,"shopification");
                break;
            default:
                break;
        }
    }
    @Override
    public void onSuccess(int action, String res) {
        switch (action){
            case ACTION.MERCHANTSLIST:
                EstheticsBean estheticsBean = GsonUtil.toObj(res, EstheticsBean.class);
                apiShopList = estheticsBean.getBody().getApiShopList();

                if (apiShopList.size()>0) {

                    sortAdapter = new EstheticsAdapter(R.layout.re_full_recommend, apiShopList);
                    reProjects.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                    reProjects.setAdapter(sortAdapter);

                    sortAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            Intent intent = new Intent(ShopClassificationActivity.this, ShopStoreActivity.class);
                            intent.putExtra("shopName", apiShopList.get(position).getAnsShopBasic().getShopName());
                            intent.putExtra("shopId", apiShopList.get(position).getAnsShopBasic().getId());
                            startActivity(intent);
                        }
                    });
                } else {
                    T.show(estheticsBean.getMsg());
                }
                break;
            //商家活动（筛选）
            case ACTION.MERCHANTACTIVITY:
                MerchantsBean merchantsBean = GsonUtil.toObj(res, MerchantsBean.class);
                if (merchantsBean.isSuccess()) {
                    merchantsList = merchantsBean.getBody().getActivityKeysListData();
                } else {
                    T.show(merchantsBean.getMsg());
                }

                break;
            //商家特色（筛选）
            case ACTION.MERCHANTFEATURES:
                PreferentialBean preferentialBean = GsonUtil.toObj(res, PreferentialBean.class);
                if (preferentialBean.isSuccess()) {
                    preferentialList = preferentialBean.getBody().getFeatureKeysListData();
                } else {
                    T.show(preferentialBean.getMsg());
                }
                break;
        }
    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
