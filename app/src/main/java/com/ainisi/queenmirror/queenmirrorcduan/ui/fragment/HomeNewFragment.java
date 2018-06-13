package com.ainisi.queenmirror.queenmirrorcduan.ui.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HomeListViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HomepageGridViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.MyAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.ProblemAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.NewsBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ProblemBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopListHomeBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.EstheticsActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.HomeAdvertisingActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.HomeFightaloneActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.MessageActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SearchActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SelectCityActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.adapter.MerchantsAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeAdvertisingBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeHeadlinesBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeIndustryBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.MerchantsBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.PreferentialBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.util.ScreenPoputil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SP;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.ScrollRecyclerView;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.SpContent;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.T;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GDLocationUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GlideImageLoader;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollListview;
import com.ainisi.queenmirror.queenmirrorcduan.utils.ScrollInterceptScrollView;
import com.amap.api.location.AMapLocation;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.cache.CacheMode;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class HomeNewFragment extends BaseFragment implements HttpCallBack {

    @Bind(R.id.banner)
    Banner banner;
    @Bind(R.id.banner_middle)
    Banner banner_middle;
    @Bind(R.id.tv_home_esthetics)
    TextView tv_home_esthetics;
    @Bind(R.id.tv_home_nailart)
    TextView tv_home_nailart;
    @Bind(R.id.tv_home_haircustom)
    TextView tv_home_haircustom;
    @Bind(R.id.tv_home_beauty)
    TextView tv_home_beauty;
    @Bind(R.id.tv_home_permanent)
    TextView tv_home_permanent;
    @Bind(R.id.mv_home_marqueeView)
    MarqueeView mv_home_marqueeView;
    @Bind(R.id.rv_home_new_every)
    ScrollRecyclerView rv_home_new_every;
    @Bind(R.id.nl_home_list_view)
    NoScrollListview nl_home_list_view;
    @Bind(R.id.gv_home_gridView)
    NoScrollGridView gv_home_gridView;
    @Bind(R.id.iv_surface)
    ImageView iv_surface;
    @Bind(R.id.line_surface)
    LinearLayout line_surface;
    @Bind(R.id.iv_uspension_surface)
    ImageView iv_uspension_surface;
    @Bind(R.id.layout_stick_header_main)
    LinearLayout layout_stick_header_main;
    @Bind(R.id.sc_home_scroll)
    ScrollInterceptScrollView sc_home_scroll;
    @Bind(R.id.tv_home_bustling)
    public
    TextView mLocation;
    @Bind(R.id.img_information)
    ImageView img_information;

    @Bind(R.id.li_hime_sort)
    LinearLayout li_hime_sort;
    @Bind(R.id.li_new_top)
    LinearLayout li_new_top;
    @Bind(R.id.home_layout)
    LinearLayout home_layout;
    @Bind(R.id.li_home_paixu)
    LinearLayout li_home_paixu;
    @Bind(R.id.view_new_fragment_half)
    View view_new_fragment_half;
    @Bind(R.id.li_sort_bottom)
    LinearLayout li_sort_bottom;
    @Bind(R.id.tv_shop_sort)
    TextView tv_shop_sort;
    @Bind(R.id.li_top_select)
    LinearLayout li_top_select;
    @Bind(R.id.rb_sort)
    TextView rb_sort;
    @Bind(R.id.iv_home_sort)
    ImageView iv_home_sort;
    @Bind(R.id.iv_shop_sort)
    ImageView iv_shop_sort;
    @Bind(R.id.rb_sales)
    TextView rb_sales;
    @Bind(R.id.tv_sales)
    TextView tv_sales;
    @Bind(R.id.rb_distance)
    TextView rb_distance;
    @Bind(R.id.li_home_screen)
    LinearLayout li_home_screen;
    @Bind(R.id.rb_screen)
    TextView tvScreen;
    @Bind(R.id.tv_screen)
    TextView textScreen;
    @Bind(R.id.tv_distance)
    TextView tvdistance;
    @Bind(R.id.iv_distance_sort)
    ImageView ivdistance;
    private HomeIndustryBean homeIndustryBean;
    private HomeHeadlinesBean homeHeadlinesBean;
    private HomeAdvertisingBean homeAdvertisingBean;
    List<String> contntList = new ArrayList<>();
    List<SortBean> sortlist = new ArrayList<>();

    int hight;
    boolean type = false;

    ShopListHomeBean shopListHomeBean;
    Intent intent;

    public static HomeNewFragment instance = null;

    private PopupWindow popWindow;
    private MerchantsAdapter merchantsAdapter;
    private List<MerchantsBean.BodyBean.ActivityKeysListDataBean> merchantsList;
    private List<PreferentialBean.BodyBean.FeatureKeysListDataBean> preferentialList;
    private List<ShopListHomeBean.BodyBean.ShopListBean> shoplist;
    private PopupWindow popWindowdistance;

    @Override
    protected int getLayoutResource() {
        instance = this;
        return R.layout.activity_home_new_fragment;
    }

    @Override
    public void initPresenter() {
    }

    /**
     * 获取首页顶部Banner图
     */
    private void getBannerData() {

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("tabType", "2");//type  2代表美业    4代表异业
        hashMap.put("tabFather", "0");
        HttpUtils.doPost(ACTION.INDUSTRY, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);//首页的行业分类
        HttpUtils.doPost(ACTION.HEADLINES, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);//头条
        HttpUtils.doPost(ACTION.ADVERTISING, hashMap, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);//Banner
    }

    /**
     * 获取首页底部商家列表
     */
    private void getShopData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("pageNumber", "1");
        params.put("contentByTitle", "");
        params.put("pageSize", "10");
        params.put("shopCate", "1");
        HttpUtils.doPost(ACTION.SHOPLIST, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    /**
     * 获取新消息提示
     */
    private void getNewNewsData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("userId", SP.get(getActivity(), SpContent.UserId, "") + "");
        params.put("messageType", "");
        HttpUtils.doPost(ACTION.GETNEWNEWS, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initView() {

        /**
         * 获取首页部分数据
         */
        getBannerData();
        getShopData();
        for (int i = 0; i < 10; i++) {
            SortBean sortBean = new SortBean();
            sortlist.add(sortBean);
        }
        MyAdapter sortAdapter = new MyAdapter(R.layout.re_full_recommend, sortlist);
        rv_home_new_every.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        rv_home_new_every.setAdapter(sortAdapter);
        sortAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), FullActivity.class));
            }
        });
        sc_home_scroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                hight = i1;
                if (li_new_top.getVisibility() != 0) {

                } else {
                    if (i1 >= 3315) {
                        layout_stick_header_main.setVisibility(View.VISIBLE);
                    } else {
                        layout_stick_header_main.setVisibility(View.GONE);
                    }
                }
            }
        });
        inithttp();
    }

    private void inithttp() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("", "");
        //商家活动（筛选）
        HttpUtils.doPost(ACTION.MERCHANTACTIVITY, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
        //商家特色（筛选）
        HttpUtils.doPost(ACTION.MERCHANTFEATURES, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // 没有权限，申请权限。
            // 申请一个（或多个）权限，并提供用于回调返回的获取码（用户定义）
            ActivityCompat.requestPermissions(getActivity()
                    , new String[]{"android.permission.ACCESS_COARSE_LOCATION"}, 100);
        } else {
            GDLocationUtil.init(getActivity());
            GDLocationUtil.getCurrentLocation(new GDLocationUtil.MyLocationListener() {
                @Override
                public void result(AMapLocation location) {
                    mLocation.setText(location.getCity());
                }
            });
        }
        /**
         * 获取新消息提示
         */
        // getNewNewsData();
    }

    String[] problem = {"销量最高", "价格最低", "距离最近", "优惠最多", "满减优惠", "新用最好", "用户最好"};
    private List<ProblemBean> list;
    View popview;

    private void initview(final View popview) {
        final RecyclerView ce = popview.findViewById(R.id.rc_popview);
        list = new ArrayList<>();
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
                tv_shop_sort.setText(problem[position]);
                rb_sort.setText(problem[position]);
                view_new_fragment_half.setVisibility(View.INVISIBLE);
                li_home_paixu.setVisibility(View.VISIBLE);
                iv_home_sort.setBackground(getActivity().getResources().getDrawable(R.drawable.arrow_dwon_blue));
                iv_shop_sort.setBackground(getActivity().getResources().getDrawable(R.drawable.arrow_dwon_blue));
                popWindow.dismiss();
            }
        });
        popview.findViewById(R.id.pop_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_new_fragment_half.setVisibility(View.INVISIBLE);
                li_home_paixu.setVisibility(View.VISIBLE);
                iv_home_sort.setBackground(getActivity().getResources().getDrawable(R.drawable.arrow_dwon_blue));
                iv_shop_sort.setBackground(getActivity().getResources().getDrawable(R.drawable.arrow_dwon_blue));
                popWindow.dismiss();
            }
        });
    }
    @OnClick({R.id.li_home_esthetics, R.id.li_home_nailart, R.id.li_home_haircustom, R.id.li_home_beauty, R.id.li_home_permanent, R.id.linear_home_freetrial,
            R.id.line_surface, R.id.line_uspension_surface, R.id.tv_home_bustling, R.id.iv_home_search, R.id.img_information, R.id.li_hime_sort,
            R.id.li_sort_bottom, R.id.rb_sales, R.id.rb_distance, R.id.li_home_screen_bottom, R.id.li_home_screen,R.id.li_sales_bottom})
    public void onClick(View view) {
        switch (view.getId()) {
            /**
             * 筛选
             */
            case R.id.li_home_screen_bottom:
                initScreentext();
                new ScreenPoputil(getActivity()).showscreenPop(li_top_select,merchantsList,preferentialList,"home");
                break;
            case R.id.li_home_screen:
                initScreentext();
                new ScreenPoputil(getActivity()).showscreenPop(li_top_select,merchantsList,preferentialList,"home");
                break;
            /**
             * 按距离排序
             */
            case R.id.rb_distance:
                sc_home_scroll.smoothScrollTo(0, 3315);
                initshowdistance();
                break;
            case R.id.li_sales_bottom:
                initshowdistance();
                break;
            /**
             * 底部销量最高
             */
            case R.id.rb_sales:
                tvdistance.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                sc_home_scroll.smoothScrollTo(0, 3315);
                rb_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
                tv_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
                rb_distance.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                tvdistance.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                tv_shop_sort.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                rb_sort.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                tvScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                textScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                break;
            case R.id.li_sort_bottom:
                tv_shop_sort.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
                rb_sort.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
                rb_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                rb_distance.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                tvdistance.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                rb_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                tv_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                tvScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                textScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                layout_stick_header_main.setVisibility(View.VISIBLE);
                view_new_fragment_half.setVisibility(View.VISIBLE);
                initShowPop();

                layout_stick_header_main.setVisibility(View.VISIBLE);
                view_new_fragment_half.setVisibility(View.VISIBLE);
                iv_home_sort.setBackground(getActivity().getResources().getDrawable(R.drawable.arrow_up_black));
                iv_shop_sort.setBackground(getActivity().getResources().getDrawable(R.drawable.arrow_up_black));

                popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        view_new_fragment_half.setVisibility(View.INVISIBLE);
                        li_home_paixu.setVisibility(View.VISIBLE);

                        iv_home_sort.setBackground(getActivity().getResources().getDrawable(R.drawable.arrow_dwon_blue));
                        iv_shop_sort.setBackground(getActivity().getResources().getDrawable(R.drawable.arrow_dwon_blue));
                    }
                });

                break;
            /**
             * 点击底部的综合排序
             */
            case R.id.li_hime_sort:
                tvdistance.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                tv_shop_sort.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
                rb_sort.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
                rb_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                rb_distance.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                rb_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                tv_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                textScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                popview = View.inflate(getActivity(), R.layout.pop_myitem, null);
                initview(popview);
                popWindow = new PopupWindow(CollapsingToolbarLayout.LayoutParams.MATCH_PARENT, CollapsingToolbarLayout.LayoutParams.MATCH_PARENT);
                popWindow.setContentView(popview);
                popWindow.setOutsideTouchable(true);
                popWindow.setAnimationStyle(R.style.CustomPopWindowStyle);
                popWindow.showAsDropDown(li_top_select, 0, 0);
                layout_stick_header_main.setVisibility(View.VISIBLE);
                view_new_fragment_half.setVisibility(View.VISIBLE);
                iv_home_sort.setBackground(getActivity().getResources().getDrawable(R.drawable.arrow_up_black));
                iv_shop_sort.setBackground(getActivity().getResources().getDrawable(R.drawable.arrow_up_black));
                sc_home_scroll.smoothScrollTo(0, 3315);
                popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        view_new_fragment_half.setVisibility(View.INVISIBLE);
                        li_home_paixu.setVisibility(View.VISIBLE);

                        iv_home_sort.setBackground(getActivity().getResources().getDrawable(R.drawable.arrow_dwon_blue));
                        iv_shop_sort.setBackground(getActivity().getResources().getDrawable(R.drawable.arrow_dwon_blue));
                    }
                });
                popview.findViewById(R.id.pop_layout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        popWindow.dismiss();
                    }
                });
                break;

            case R.id.tv_home_bustling:
                intent = new Intent(getActivity(), SelectCityActivity.class);
                startActivity(intent);
                break;
            /**
             * 行业分类
             */
            case R.id.li_home_esthetics:
                intent = new Intent(getActivity(), EstheticsActivity.class);
                intent.putExtra("categoryId", homeIndustryBean.getBody().getCategoryListData().get(0).getEcCategory().getId());
                intent.putExtra("shop_name", tv_home_esthetics.getText().toString());
                startActivity(intent);
                break;
            case R.id.li_home_nailart:
                intent = new Intent(getActivity(), EstheticsActivity.class);
                intent.putExtra("categoryId", homeIndustryBean.getBody().getCategoryListData().get(1).getEcCategory().getId());
                intent.putExtra("shop_name", tv_home_nailart.getText().toString());
                startActivity(intent);
                break;
            case R.id.li_home_haircustom:
                intent = new Intent(getActivity(), EstheticsActivity.class);
                intent.putExtra("categoryId", homeIndustryBean.getBody().getCategoryListData().get(2).getEcCategory().getId());
                intent.putExtra("shop_name", tv_home_haircustom.getText().toString());
                startActivity(intent);
                break;
            case R.id.li_home_beauty:
                intent = new Intent(getActivity(), EstheticsActivity.class);
                intent.putExtra("categoryId", homeIndustryBean.getBody().getCategoryListData().get(3).getEcCategory().getId());
                intent.putExtra("shop_name", tv_home_beauty.getText().toString());
                startActivity(intent);
                break;
            case R.id.li_home_permanent:
                intent = new Intent(getActivity(), EstheticsActivity.class);
                intent.putExtra("categoryId", homeIndustryBean.getBody().getCategoryListData().get(4).getEcCategory().getId());
                intent.putExtra("shop_name", tv_home_permanent.getText().toString());
                startActivity(intent);
                break;
            /**
             * 拼团
             */
            case R.id.linear_home_freetrial:
                startActivity(new Intent(getActivity(), HomeFightaloneActivity.class));
                break;
            /**
             * 展示形式改变
             */
            case R.id.line_surface:
            case R.id.line_uspension_surface:
                if (type) {
                    iv_surface.setImageResource(R.drawable.icon_home_recycler);
                    iv_uspension_surface.setImageResource(R.drawable.icon_home_recycler);
                    type = false;
                    nl_home_list_view.setVisibility(View.GONE);
                    gv_home_gridView.setVisibility(View.VISIBLE);

                    if (shopListHomeBean.getBody().getShopList().size() > 0) {
                        HomepageGridViewAdapter gridViewAdapter = new HomepageGridViewAdapter(getActivity(),shoplist, "home");
                        gv_home_gridView.setAdapter(gridViewAdapter);
                    } else {

                    }
                } else {
                    iv_surface.setImageResource(R.drawable.icon_home_list);
                    iv_uspension_surface.setImageResource(R.drawable.icon_home_list);
                    type = true;
                    nl_home_list_view.setVisibility(View.VISIBLE);
                    gv_home_gridView.setVisibility(View.GONE);

                    if (shopListHomeBean.getBody().getShopList().size() > 0) {
                        HomeListViewAdapter homeListViewAdapter = new HomeListViewAdapter(getActivity(), shoplist, "home");
                        nl_home_list_view.setAdapter(homeListViewAdapter);
                    }
                }
                break;
            //搜索
            case R.id.iv_home_search:
                SearchActivity.startActivity(getContext());
                break;
            //消息
            case R.id.img_information:
                startActivity(new Intent(getActivity(), MessageActivity.class));
                break;
        }
    }

    private void initshowdistance() {
        rb_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        tv_shop_sort.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        rb_sort.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        rb_distance.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
        tvdistance.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
        rb_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        tv_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        tvScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        textScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        layout_stick_header_main.setVisibility(View.VISIBLE);
        view_new_fragment_half.setVisibility(View.VISIBLE);
        initShowPop();
        ivdistance.setBackground(getActivity().getResources().getDrawable(R.drawable.arrow_up_black));
        popWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                ivdistance.setBackground(getActivity().getResources().getDrawable(R.drawable.arrow_dwon_blue));
                view_new_fragment_half.setVisibility(View.INVISIBLE);
                li_home_paixu.setVisibility(View.VISIBLE);
            }
        });
    }

    private void initScreentext() {
        sc_home_scroll.smoothScrollTo(0, 3315);
        tvScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
        textScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
        rb_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        tv_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        tv_shop_sort.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        rb_sort.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        rb_distance.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        tvdistance.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));

    }


    private void initShowPop() {
        popview = View.inflate(getActivity(), R.layout.pop_myitem, null);
        initview(popview);
        popWindow = new PopupWindow(CollapsingToolbarLayout.LayoutParams.MATCH_PARENT, CollapsingToolbarLayout.LayoutParams.MATCH_PARENT);
        popWindow.setContentView(popview);
        popWindow.setOutsideTouchable(true);
        popWindow.setAnimationStyle(R.style.CustomPopWindowStyle);
        popWindow.showAsDropDown(li_top_select, 0, 0);

    }
    private void initdistancePop() {
        popview = View.inflate(getActivity(), R.layout.pop_myitem, null);
        initview(popview);
        popWindowdistance = new PopupWindow(CollapsingToolbarLayout.LayoutParams.MATCH_PARENT, CollapsingToolbarLayout.LayoutParams.MATCH_PARENT);
        popWindowdistance.setContentView(popview);
        popWindowdistance.setOutsideTouchable(true);
        popWindowdistance.setAnimationStyle(R.style.CustomPopWindowStyle);
        popWindowdistance.showAsDropDown(li_top_select, 0, 0);

    }
    @Override
    public void onSuccess(int action, String res) {
        switch (action) {
            //获取新消息提示
            case ACTION.GETNEWNEWS:
                NewsBean newsBean = GsonUtil.toObj(res, NewsBean.class);

                if (newsBean.isSuccess()) {
                    if (newsBean.getBody().getIsRead().equals("0")) {
                    } else {
                        QBadgeView badgeView = new QBadgeView(getActivity());
                        badgeView.bindTarget(img_information);
                        badgeView.setBadgeTextSize(10, false);
                        badgeView.setBadgeText("");
                        badgeView.setBadgeTextColor(this.getResources().getColor(R.color.white));
                        badgeView.setBadgeGravity(Gravity.END | Gravity.TOP);
                        badgeView.setBadgeBackgroundColor(this.getResources().getColor(R.color.colorPri));
                        badgeView.setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                            @Override
                            public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                            }
                        });
                    }
                } else {
                    T.show(newsBean.getMsg());
                }

                break;
            //首页的行业分类
            case ACTION.INDUSTRY:
                homeIndustryBean = GsonUtil.toObj(res, HomeIndustryBean.class);
                if (homeIndustryBean.isSuccess()) {
                    tv_home_esthetics.setText(homeIndustryBean.getBody().getCategoryListData().get(0).getEcCategory().getTabName());
                    tv_home_nailart.setText(homeIndustryBean.getBody().getCategoryListData().get(1).getEcCategory().getTabName());
                    tv_home_haircustom.setText(homeIndustryBean.getBody().getCategoryListData().get(2).getEcCategory().getTabName());
                    tv_home_beauty.setText(homeIndustryBean.getBody().getCategoryListData().get(3).getEcCategory().getTabName());
                    tv_home_permanent.setText(homeIndustryBean.getBody().getCategoryListData().get(4).getEcCategory().getTabName());
                } else {
                    T.show(homeIndustryBean.getMsg());
                }
                break;
            //商家分类列表
            case ACTION.SHOPLIST:
                shopListHomeBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if (shopListHomeBean.isSuccess()) {
                    if (shopListHomeBean.getBody().getShopList().size() > 0) {
                        shoplist=shopListHomeBean.getBody().getShopList();
                        HomepageGridViewAdapter gridViewAdapter = new HomepageGridViewAdapter(getActivity(),shoplist, "home");
                        gv_home_gridView.setAdapter(gridViewAdapter);
                    } else {
                        T.show("暂无店铺信息");
                    }
                } else {
                    T.show(shopListHomeBean.getMsg());
                }

                break;
            //首页的女王头条
            case ACTION.HEADLINES:
                homeHeadlinesBean = GsonUtil.toObj(res, HomeHeadlinesBean.class);
                if (homeHeadlinesBean.isSuccess()) {
                    for (int i = 0; i < homeHeadlinesBean.getBody().getTopListData().size(); i++) {
                        contntList.add(homeHeadlinesBean.getBody().getTopListData().get(i).getEcTop().getTopName());
                    }
                    mv_home_marqueeView.startWithList(contntList);
                } else {
                    T.show(homeHeadlinesBean.getMsg());
                }

                break;
            //首页banner广告
            case ACTION.ADVERTISING:
                homeAdvertisingBean = GsonUtil.toObj(res, HomeAdvertisingBean.class);
                if (homeAdvertisingBean.isSuccess()) {
                    List<String> images = new ArrayList<>();
                    for (int i = 0; i < 4; i++) {
                        images.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic21363tj30ci08ct96.jpg");
                    }
                    banner.setImageLoader(new GlideImageLoader());
                    banner.setImages(images);
                    banner.start();
                    banner.setOnBannerListener(new OnBannerListener() {
                        @Override
                        public void OnBannerClick(int position) {
                            Intent intent = new Intent(getActivity(), HomeAdvertisingActivity.class);
                            intent.putExtra("weburl", homeAdvertisingBean.getBody().getAdvertisementListData().get(0).getEcAdvertisement().getAdUrl());
                            getActivity().startActivity(intent);
                        }
                    });

                    banner_middle.setImageLoader(new GlideImageLoader());
                    banner_middle.setImages(images);
                    banner_middle.start();
                    banner_middle.setOnBannerListener(new OnBannerListener() {
                        @Override
                        public void OnBannerClick(int position) {
                            Intent intent = new Intent(getActivity(), HomeAdvertisingActivity.class);
                            intent.putExtra("weburl", homeAdvertisingBean.getBody().getAdvertisementListData().get(0).getEcAdvertisement().getAdUrl());
                            getActivity().startActivity(intent);
                        }
                    });

                } else {
                    T.show(homeAdvertisingBean.getMsg());
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

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mv_home_marqueeView.stopFlipping();
    }
}
