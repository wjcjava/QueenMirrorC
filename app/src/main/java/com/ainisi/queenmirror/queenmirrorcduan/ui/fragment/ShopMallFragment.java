package com.ainisi.queenmirror.queenmirrorcduan.ui.fragment;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HomeListViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HomepageGridViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.ListViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyShopAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.ProblemAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ProblemBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopListHomeBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SearchActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.MerchantsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.ClassificationBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeIndustryBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.MerchantsBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.PreferentialBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.util.ScreenPoputil;
import com.ainisi.queenmirror.queenmirrorcduan.ui.shop.activity.ShopClassificationActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomPopWindow;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GlideImageLoader;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollListview;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.cache.CacheMode;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by EWorld on 2018/3/6.
 * 商城
 */

public class ShopMallFragment extends BaseFragment implements HttpCallBack {
    @Bind(R.id.banner)
    Banner banner;
    @Bind(R.id.iv_sort)
    ImageView ivsort;
    @Bind(R.id.iv_shop_sort1)
    ImageView ivsort1;
    @Bind(R.id.li_sort_bottom)
    LinearLayout li_sort_bottom;
    @Bind(R.id.li_home_screen)
    LinearLayout li_home_screen;
    @Bind(R.id.li_home_screen_bottom)
    LinearLayout li_home_screen_bottom;
    @Bind(R.id.sc_home_scroll)
    ScrollView sc_home_scroll;
    ListViewAdapter listadapter;
    @Bind(R.id.list_view)
    NoScrollListview listView;
    @Bind(R.id.layout_stick_header_main)
    LinearLayout layout_stick_header_main;
    @Bind(R.id.layout_stick_header)
    LinearLayout layout_stick_header;
    @Bind(R.id.re_shop_mall)
    RecyclerView shopRecycle;
    @Bind(R.id.iv_surface)
    ImageView imgSurface;
    @Bind(R.id.iv_uspension_surface)
    ImageView uspensionSurface;
    @Bind(R.id.shop_gridView)
    NoScrollGridView shop_gridView;
    @Bind(R.id.tv_shop_sort)
    TextView upSort;
    @Bind(R.id.tv_shop_sales)
    TextView upSales;
    @Bind(R.id.tv_shop_distance)
    TextView upDistance;
    @Bind(R.id.tv_shop_screen)
    TextView upScreen;
    @Bind(R.id.rb_sort)
    TextView bottomSort;
    @Bind(R.id.rb_sales)
    TextView bottomSales;
    @Bind(R.id.rb_screen)
    TextView bottomScreen;
    @Bind(R.id.rb_distance)
    TextView bottomDistance;
    @Bind(R.id.iv_distance_sort)
    ImageView ivdistance;
    @Bind(R.id.tv_shop_data)
    TextView shopData;
    ClassificationBean classificationBean;
    ShopListHomeBean shopListHomeBean;
    private HomeIndustryBean homeIndustryBean;
    private CustomPopWindow customPopWindow;
    private PopupWindow pop;
    private View popview1;
    private List<ShopBean> shopList;
    private List<ProblemBean> list = new ArrayList<>();
    private int[] imgTitle = {R.drawable.icon_shop_entertainment, R.drawable.icon_shop_bank_insurance,
            R.drawable.icon_shop_jewellery, R.drawable.icon_shop_medicalcare, R.drawable.icon_shop_motion,
            R.drawable.icon_shop_photography, R.drawable.icon_shop_service, R.drawable.icon_shop_train
    };
    String[] problem = {"销量最高", "价格最低", "距离最近", "优惠最多", "满减优惠", "新用最好", "用户最好"};

    int hight, pageNumber = 1;//标记ScrollView移动的距离
    private boolean isClick;
    private View popview;
    private PopupWindow popWindow;
    private List<PreferentialBean.BodyBean.FeatureKeysListDataBean> preferentialList;
    private MerchantsAdapter merchantsAdapter;
    private List<MerchantsBean.BodyBean.ActivityKeysListDataBean> merchantsList;

    @Override
    protected int getLayoutResource() {
        return R.layout.fragment_shop_mall;
    }

    @Override
    public void initPresenter() {

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initView() {
        /**
         * 获取首页数据
         */
        doFirstData();
        getYiyeData();
        initDate();
        initpopwindow();
        initImgTitle();
        initshopList();
        inithttp();

        sc_home_scroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                hight = i1;
                if (i1 >= 1150) {
                    layout_stick_header.setVisibility(View.GONE);
                    layout_stick_header_main.setVisibility(View.VISIBLE);
                } else {
                    layout_stick_header.setVisibility(View.VISIBLE);
                    layout_stick_header_main.setVisibility(View.GONE);
                }
            }
        });
    }

    /**
     * 获取异业分类数据
     */
    private void getYiyeData() {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("tabType", "4");//type  2代表美业    4代表异业
        hashMap.put("tabFather", "0");
        HttpUtils.doPost(ACTION.INDUSTRY, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);//首页的行业分类
    }

    private void initshopList() {
        HashMap<String, String> params = new HashMap<>();
        params.put("categoryId", "");
        params.put("pageNumber", "1");
        params.put("pageSize", "10");
        HttpUtils.doPost(ACTION.MERCHANTSLIST, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取数据
     */
    private void doFirstData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("pageNumber", pageNumber + "");
        params.put("contentByTitle", "");
        params.put("pageSize", "10");
        params.put("shopCate", "2");
        HttpUtils.doPost(ACTION.SHOPLIST, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 特色筛选
     */
    private void inithttp() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("", "");
        //商家活动（筛选）
        HttpUtils.doPost(ACTION.MERCHANTACTIVITY, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
        //商家特色（筛选）
        HttpUtils.doPost(ACTION.MERCHANTFEATURES, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }
    private void initImgTitle() {

    }

    private void initpopwindow() {
        pop = new PopupWindow(CollapsingToolbarLayout.LayoutParams.MATCH_PARENT, CollapsingToolbarLayout.LayoutParams.WRAP_CONTENT);
        popview1 = View.inflate(getActivity(), R.layout.pop_myitem, null);
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
    }

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha 屏幕透明度0.0-1.0 1表示完全不透明
     */
    public void setBackgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getActivity().getWindow()
                .getAttributes();
        lp.alpha = bgAlpha;
        getActivity().getWindow().setAttributes(lp);
    }

    private void initDate() {

        List<Integer> images = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            images.add(R.drawable.icon_shop_banner);
        }
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(images);
        banner.start();
    }


    private void initpop(View popview1) {
        final RecyclerView ce = popview1.findViewById(R.id.rc_popview);
        ivsort.setFocusable(false);
        ivsort1.setFocusable(false);
        for (int i = 0; i < problem.length; i++) {
            ProblemBean problemBean = new ProblemBean();
            problemBean.setName(problem[i]);
            list.add(problemBean);
        }

        ProblemAdapter problemAdapter = new ProblemAdapter(R.layout.item_pop_sort, list);
        ce.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        ce.setAdapter(problemAdapter);
        problemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                upSort.setText(problem[position]);
                pop.dismiss();

            }
        });
    }

    @OnClick({R.id.rb_sort, R.id.rb_sales, R.id.tv_shop_sales, R.id.rb_distance
            , R.id.li_sort_bottom, R.id.li_home_screen, R.id.li_home_screen_bottom
            , R.id.line_surface, R.id.line_uspension_surface, R.id.ed_keyword, R.id.li_distance_bottom
    })
    public void click(View view) {
        //  FragmentTransaction transaction = fm.beginTransaction();
        switch (view.getId()) {
            case R.id.ed_keyword:
                SearchActivity.startActivity(getContext());
                break;
            //点击流式布局，和瀑布流布局切换
            case R.id.line_surface:
                if (isClick) {
                    isClick = false;
                    HomeListViewAdapter homeListViewAdapter = new HomeListViewAdapter(getActivity(), shopListHomeBean.getBody().getShopList(), "shop");
                    listView.setAdapter(homeListViewAdapter);
                    /*listadapter = new ListViewAdapter(getContext(), shopListNew);
                    listView.setAdapter(listadapter);*/
                    shop_gridView.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    imgSurface.setImageResource(R.drawable.icon_home_list);
                } else {
                    imgSurface.setImageResource(R.drawable.icon_home_recycler);
                    shop_gridView.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);

                    HomepageGridViewAdapter gridViewAdapter = new HomepageGridViewAdapter(getActivity(), shopListHomeBean.getBody().getShopList(), "shop");
                    shop_gridView.setAdapter(gridViewAdapter);

                    /*gridViewAdapter = new GridViewAdapter(getContext(),drtalist);
                    shop_gridView.setAdapter(gridViewAdapter);*/
                    isClick = true;

                }
                break;
            case R.id.line_uspension_surface:
                if (isClick) {
                    isClick = false;
                    HomeListViewAdapter homeListViewAdapter = new HomeListViewAdapter(getActivity(), shopListHomeBean.getBody().getShopList(), "shop");
                    listView.setAdapter(homeListViewAdapter);
                  /*  listadapter = new ListViewAdapter(getContext(), shopListNew);
                    listView.setAdapter(listadapter);*/
                    shop_gridView.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    uspensionSurface.setImageResource(R.drawable.icon_home_list);
                } else {
                    uspensionSurface.setImageResource(R.drawable.icon_home_recycler);
                    shop_gridView.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);

                    HomepageGridViewAdapter gridViewAdapter = new HomepageGridViewAdapter(getActivity(), shopListHomeBean.getBody().getShopList(), "shop");
                    shop_gridView.setAdapter(gridViewAdapter);

                   /* gridViewAdapter = new GridViewAdapter(getContext(),drtalist);
                    shop_gridView.setAdapter(gridViewAdapter);*/
                    isClick = true;
                }
                break;

            //综合选择

            case R.id.li_sort_bottom:

                ivsort.setVisibility(View.GONE);
                ivsort1.setVisibility(View.VISIBLE);

                if (hight >= 1180) {
                    pop.showAsDropDown(layout_stick_header_main);
                } else {
                    sc_home_scroll.smoothScrollTo(0, 1180);
                    pop.showAsDropDown(upSort);
                }
                initSorttext();
                break;
            case R.id.rb_sort:
                sc_home_scroll.smoothScrollTo(0, 1180);
                pop.showAsDropDown(upSort);
                initSorttext();
              /*  if (sortFragment == null) {
                    sortFragment = new SortFragment();
                    transaction.add(R.id.fl_home_recommend_layout, sortFragment);
                } else {
                    transaction.show(sortFragment);
                }
                hideFragment(salesFragment, transaction);
                hideFragment(distanceFragment, transaction);*/
//              hideFragment(screenFragment, transaction);
                break;
            //销量最高
            case R.id.rb_sales:
                sc_home_scroll.smoothScrollTo(0, 1180);
                initSalestext();
            /*    if (salesFragment == null) {
                    salesFragment = new SalesFragment();
                    transaction.add(R.id.fl_home_recommend_layout, salesFragment);
                } else {
                    transaction.show(salesFragment);
                }
                hideFragment(sortFragment, transaction);
//                hideFragment(screenFragment, transaction);
                hideFragment(distanceFragment, transaction);*/
                break;
            case R.id.tv_shop_sales:
                initSalestext();
                break;
            //距离最近
            case R.id.li_distance_bottom:
                initDistancetext();
                initDistancepop();
                break;
            case R.id.rb_distance:
                sc_home_scroll.smoothScrollTo(0, 1180);
                initDistancetext();
                initDistancepop();

               /* if (distanceFragment == null) {
                    distanceFragment = new DistanceFragment();
                    transaction.add(R.id.fl_home_recommend_layout, distanceFragment);
                } else {
                    transaction.show(distanceFragment);
                }
                hideFragment(sortFragment, transaction);
                hideFragment(salesFragment, transaction);
//                hideFragment(screenFragment, transaction);*/
                break;

            //筛选
            case R.id.li_home_screen_bottom:
                sc_home_scroll.smoothScrollTo(0, 1180);
                initSreentext();
                new ScreenPoputil(getActivity()).showscreenPop(upSort,merchantsList,preferentialList,"shop");
                break;

            case R.id.li_home_screen:
                initSreentext();
                new ScreenPoputil(getActivity()).showscreenPop(upSort,merchantsList,preferentialList,"shop");
                break;

            default:
                break;
        }
    }


    private void initDistancepop() {
        popview = View.inflate(getActivity(), R.layout.pop_myitem, null);
        //initview(popview);
        popWindow = new PopupWindow(CollapsingToolbarLayout.LayoutParams.MATCH_PARENT, CollapsingToolbarLayout.LayoutParams.WRAP_CONTENT);
        popWindow.setContentView(popview);
        popWindow.setOutsideTouchable(true);
        popWindow.setAnimationStyle(R.style.CustomPopWindowStyle);
        popWindow.showAsDropDown(upSort, 0, 0);
        ivdistance.setBackground(getActivity().getResources().getDrawable(R.drawable.arrow_up_black));
        popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                ivdistance.setBackground(getActivity().getResources().getDrawable(R.drawable.arrow_dwon_blue));
            }
        });
    }

    /**
     * 全部，销量最高，距离最近，筛选的字体色值变化
     */
    private void initSorttext() {
        upSort.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
        bottomSort.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
        upSales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        bottomSales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        upDistance.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        bottomDistance.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        upScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        bottomScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
    }

    private void initSalestext() {
        upSales.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
        bottomSales.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
        upSort.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        bottomSort.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        upDistance.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        bottomDistance.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        upScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        bottomScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
    }

    private void initDistancetext() {
        upDistance.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
        bottomDistance.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
        upSales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        bottomSales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        upSort.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        bottomSort.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        upScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        bottomScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
    }

    private void initSreentext() {
        upScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
        bottomScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
        upSales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        bottomSales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        upSort.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        bottomSort.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        upDistance.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        bottomDistance.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
    }
    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            /**
             * 获取异业分类数据
             */
            case ACTION.INDUSTRY:
                homeIndustryBean = GsonUtil.toObj(res, HomeIndustryBean.class);

                shopList = new ArrayList<>();
                for (int i = 0; i < 8; i++) {
                    ShopBean shopBean = new ShopBean();
                    shopBean.setImageTitle(imgTitle[i]);
                    shopBean.setTextName(homeIndustryBean.getBody().getCategoryListData().get(i).getEcCategory().getTabName());
                    shopList.add(shopBean);
                }

                MyShopAdapter myShopAdapter = new MyShopAdapter(R.layout.re_shopmall_shop, shopList);
                shopRecycle.setLayoutManager(new GridLayoutManager(getActivity(), 4));
                shopRecycle.setAdapter(myShopAdapter);
                myShopAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        Intent intent = new Intent(getActivity(), ShopClassificationActivity.class);
                        intent.putExtra("catName", shopList.get(position).getTextName());
                        intent.putExtra("catId", homeIndustryBean.getBody().getCategoryListData().get(position).getEcCategory().getId());
                        startActivity(intent);
                    }
                });
                break;
            //商城列表分类
            case ACTION.SHOPLIST:
                shopListHomeBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if (shopListHomeBean.isSuccess()) {
                    if (shopListHomeBean.getBody().getShopList().size() > 0) {
                        HomepageGridViewAdapter gridViewAdapter = new HomepageGridViewAdapter(getActivity(), shopListHomeBean.getBody().getShopList(), "shop");
                        shop_gridView.setAdapter(gridViewAdapter);
                    } else {
                        shopData.setVisibility(View.VISIBLE);
                    }
                } else {
                    T.show(classificationBean.getMsg());
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
                //特色筛选
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

    private void hideFragment(Fragment fragment, FragmentTransaction transaction) {
        if (null != fragment) {
            transaction.hide(fragment);
        }
    }
}
