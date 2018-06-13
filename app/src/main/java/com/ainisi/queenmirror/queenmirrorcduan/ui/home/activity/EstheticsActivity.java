package com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseActivity;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.EstheticsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.FullShortAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.PopupAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.ProblemAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.EstheticsBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ProblemBean;
import com.ainisi.queenmirror.queenmirrorcduan.popbutton.PopupButton;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.ClassificationBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.MerchantsBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.PreferentialBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.util.ScreenPoputil;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.WorkRoomDetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.customview.RefreshLoadMoreLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.cache.CacheMode;
import com.qbw.log.XLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 美学汇（美甲美手）
 */
public class EstheticsActivity extends BaseActivity implements HttpCallBack,RefreshLoadMoreLayout.CallBack {
//    @Bind(R.id.full_rb_sort)
//    TextView hSort;
    @Bind(R.id.re_recommendable_projects)
    RecyclerView reProjects;
    @Bind(R.id.full_rb_sales)
    TextView hSales;
    @Bind(R.id.full_rb_distance)
    TextView hDistance;
    @Bind(R.id.full_rb_screen)
    TextView hscreen;
//    @Bind(R.id.iv_sort)
//    ImageView ivsort;
//    @Bind(R.id.iv_sort1)
//    ImageView ivsort1;
//    @Bind(R.id.pager_home_full)
//    NoScrollViewPager fullpager;
    @Bind(R.id.newtitle_title)
    TextView newtitle_title;
    @Bind(R.id.iv_distance)
    ImageView iv_distance;
    @Bind(R.id.iv_distance1)
    ImageView iv_distance1;
    @Bind(R.id.bt_up_full)
    PopupButton btSort;
    private PopupWindow pop;
    private List<Fragment> pagerList = new ArrayList<>();
    List<EstheticsBean.BodyBean.ApiShopListBean> apiShopList = new ArrayList<>();
    private List<ProblemBean> list = new ArrayList<>();
    String[] problem = {"销量最高", "价格最低", "距离最近", "优惠最多", "满减优惠", "新用最好", "用户最好"};
    String shop_name, categoryId;
    int pageNumber = 1;
    EstheticsAdapter sortAdapter;

    private List<MerchantsBean.BodyBean.ActivityKeysListDataBean> merchantsList;
    private List<PreferentialBean.BodyBean.FeatureKeysListDataBean> preferentialList;

    @Bind(R.id.full_sore_recycler)
    RecyclerView recycler;
    List<ClassificationBean.BodyBean.ShopListDataBean> sortlist = new ArrayList<>();
    private Handler handler = new Handler();
    @Bind(R.id.rlm)
    RefreshLoadMoreLayout mRefreshLoadMoreLayout;
    private ArrayList<String> cValues;

    @Override
    public int getLayoutId() {
        return R.layout.activity_esthetics;
    }

    @Override
    public void initPresenter() {
        mRefreshLoadMoreLayout.init(new RefreshLoadMoreLayout.Config(this).canRefresh(true)
                .canLoadMore(true)
                .autoLoadMore()

                .showLastRefreshTime(
                        RefreshLoadMoreLayout.class,
                        "yyyy-MM-dd")
                .multiTask());
    }

    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            case ACTION.MERCHANTSLIST:
                EstheticsBean estheticsBean = GsonUtil.toObj(res, EstheticsBean.class);
                apiShopList = estheticsBean.getBody().getApiShopList();
                if (estheticsBean.isSuccess()) {
                    sortAdapter = new EstheticsAdapter(R.layout.re_full_recommend, apiShopList);
                    reProjects.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                    reProjects.setAdapter(sortAdapter);

                    sortAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            Intent intent = new Intent(EstheticsActivity.this, WorkRoomDetailActivity.class);
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
            case ACTION.CLASSIFICATION:
                ClassificationBean classificationBean = GsonUtil.toObj(res, ClassificationBean.class);

                if (classificationBean.isSuccess()) {
                    sortlist = classificationBean.getBody().getShopListData();

                    FullShortAdapter sortAdapter = new FullShortAdapter(this, R.layout.item_shortrecycler, sortlist);
                    recycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                    recycler.setAdapter(sortAdapter);
                    sortAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            startActivity(new Intent(EstheticsActivity.this, WorkRoomDetailActivity.class));
                        }
                    });

                } else {
                    T.show(classificationBean.getMsg());
                }
        }
    }

    @Override
    public void initView() {
        Intent intent = this.getIntent();
        shop_name = intent.getStringExtra("shop_name");
        newtitle_title.setText(shop_name);
        categoryId = intent.getStringExtra("categoryId");
        getTuijianData();
        initDate();

        inithttp();
        inithttpshop();
    }

    private void inithttpshop() {
        HashMap<String, String> params = new HashMap<>();
        params.put("pageNumber", "1");
        params.put("contentByTitle", "");
        params.put("categoryId", "0");
        params.put("pageSize", "10");
        params.put("shopCate", "1");
        HttpUtils.doPost(ACTION.CLASSIFICATION, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);

    }
    /**
     * 获取推荐好店的数据
     */
    private void getTuijianData() {
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("categoryId", categoryId);
        hashMap.put("pageNumber", pageNumber + "");
        hashMap.put("pageSize", "10");
        hashMap.put("shopCate", "1");
        HttpUtils.doPost(ACTION.MERCHANTSLIST, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void inithttp() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("", "");
        //商家活动（筛选）
        HttpUtils.doPost(ACTION.MERCHANTACTIVITY, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
        //商家特色（筛选）
        HttpUtils.doPost(ACTION.MERCHANTFEATURES, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    private void initDate() {
        pop = new PopupWindow(CollapsingToolbarLayout.LayoutParams.MATCH_PARENT, CollapsingToolbarLayout.LayoutParams.WRAP_CONTENT);
        View popview1 = View.inflate(this, R.layout.pop_myitem, null);
        initpop(popview1);
        pop.setContentView(popview1);
        pop.setBackgroundDrawable(new ColorDrawable(0));
        pop.setOutsideTouchable(true);
        pop.setAnimationStyle(R.style.CustomPopWindowStyle);
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                ///ivsort.setVisibility(View.VISIBLE);
                //ivsort1.setVisibility(View.GONE);
                iv_distance.setVisibility(View.VISIBLE);
                iv_distance1.setVisibility(View.GONE);
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
                hDistance.setText(problem[position]);
                pop.dismiss();
            }
        });
    }

    @OnClick({R.id.ed_keyword, R.id.iv_back, R.id.bt_up_full, R.id.full_rb_sales,
            R.id.full_rb_distance, R.id.full_rb_screen, R.id.tv_more})
    public void click(View view) {
        switch (view.getId()) {
            //搜索
            case R.id.ed_keyword:
                SearchActivity.startActivity(this);
                break;
            case R.id.iv_back:
                finish();
                break;
            //更多
            case R.id.tv_more:
                startActivity(new Intent(this, RecommendedActivity.class));
                break;
            //综合排序
            case R.id.bt_up_full:
                //ivsort.setVisibility(View.GONE);
                //ivsort1.setVisibility(View.VISIBLE);
                initpop();
                colorText(hscreen,hSales,hDistance,btSort);
               // pop.showAsDropDown(hSort);

                break;
            //销量最高
            case R.id.full_rb_sales:
                colorText(hscreen,btSort,hDistance,hSales);

                break;
            //距离最近
            case R.id.full_rb_distance:
                iv_distance.setVisibility(View.GONE);
                iv_distance1.setVisibility(View.VISIBLE);
                pop.showAsDropDown(hDistance);
                colorText(btSort,hscreen,hSales,hDistance);

                break;
            //筛选
            case R.id.full_rb_screen:
                colorText(btSort,hDistance,hSales,hscreen);
                new ScreenPoputil(this).showscreenPop(hscreen, merchantsList, preferentialList, "esthetics");
                break;

            default:
                break;
        }
    }
    private void initpop() {
        View view2 = LayoutInflater.from(this).inflate(R.layout.popup2,null);
        ListView pLv = view2.findViewById(R.id.parent_lv);
        final ListView cLv =view2.findViewById(R.id.child_lv);
        List<String> pList = new ArrayList<>();
        final List<List<String>> cList = new ArrayList<>();
        for(int i = 0; i < 10; i ++) {
            pList.add("p" + i);
            List<String> t = new ArrayList<>();
            for(int j = 0; j < 15; j++) {
                t.add(pList.get(i) + "-c" + j);
            }
            cList.add(t);
        }

        cValues = new ArrayList<>();
        cValues.addAll(cList.get(0));
        final PopupAdapter pAdapter = new PopupAdapter(this,R.layout.popup_item,pList,R.drawable.normal,R.drawable.press2);
        final PopupAdapter cAdapter = new PopupAdapter(this,R.layout.popup_item, cValues,R.drawable.normal,R.drawable.press);
        pAdapter.setPressPostion(0);

        pLv.setAdapter(pAdapter);
        cLv.setAdapter(cAdapter);

        pLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pAdapter.setPressPostion(position);
                pAdapter.notifyDataSetChanged();
                cValues.clear();
                cValues.addAll(cList.get(position));
                cAdapter.notifyDataSetChanged();
                cAdapter.setPressPostion(-1);
                cLv.setSelection(0);
            }
        });

        cLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                cAdapter.setPressPostion(position);
                cAdapter.notifyDataSetChanged();
                btSort.setText(cValues.get(position));
                btSort.hidePopup();
            }
        });


        btSort.setPopupView(view2);
    }
    private void colorText(TextView viewOne,TextView viewTwo,TextView viewStree,TextView viewfour) {
        viewOne.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
        viewTwo.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
        viewStree.setTextColor(this.getResources().getColor(R.color.alpha_55_black));
        viewfour.setTextColor(this.getResources().getColor(R.color.alpha_violet01));
    }
    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }

    @Override
    public void onRefresh() {
        XLog.v("onRefresh");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                T.show("下拉成功");

                mRefreshLoadMoreLayout.stopRefresh();
            }
        }, 200);
    }

    @Override
    public void onLoadMore() {
        XLog.v("onLoadMore");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                T.show("上拉成功");

                mRefreshLoadMoreLayout.stopLoadMore();
            }
        }, 1000);
    }
}