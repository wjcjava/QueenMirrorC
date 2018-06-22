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
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.ainisi.queenmirror.common.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HomeListViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HomeNewShopAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.HomepageGridViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.PopupAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.ProblemAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.ACTION;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpUtils;
import com.ainisi.queenmirror.queenmirrorcduan.bean.HomeNewShopBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.NewsBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ProblemBean;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ShopListHomeBean;
import com.ainisi.queenmirror.queenmirrorcduan.popbutton.PopupButton;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.EstheticsActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.FullActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.HomeAdvertisingActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.HomeFightaloneActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.MessageActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.PageBannerActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SearchActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SelectCityActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.HomeIndustryBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.MerchantsBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.PageBannerBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.bean.PreferentialBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.util.Banner;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.util.ScreenPoputil;
import com.ainisi.queenmirror.queenmirrorcduan.ui.order.activity.ConfirmRefundActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.GsonUtil;
import com.ainisi.queenmirror.queenmirrorcduan.utilnomal.L;
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
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.cache.CacheMode;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.sunfusheng.marqueeview.MarqueeView;
import com.youth.banner.BannerConfig;
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
    com.youth.banner.Banner banner_middle;
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
//    @Bind(R.id.tv_shop_sort)
//    TextView tv_shop_sort;
    @Bind(R.id.li_top_select)
    LinearLayout li_top_select;
//    @Bind(R.id.rb_sort)
//    TextView rb_sort;
//    @Bind(R.id.iv_home_sort)
//    ImageView iv_home_sort;
//    @Bind(R.id.iv_shop_sort)
//    ImageView iv_shop_sort;
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
    @Bind(R.id.bt_app_home)
    PopupButton bt;
    @Bind(R.id.bt_up_home)
    PopupButton bt2;
    @Bind(R.id.iv_home_newuserprg)
    ImageView ivNewuserprg;
    @Bind(R.id.iv_home_freetrial)
    ImageView ivFreetrial;
    @Bind(R.id.iv_home_goodshop)
    ImageView ivGoodshop;
    @Bind(R.id.iv_home_specialoffer)
    ImageView ivSpecialoffer;
    @Bind(R.id.iv_good_itemShop)
    ImageView ivItemShop;
    @Bind(R.id.iv_modou_convert)
    ImageView ivConvert;
    @Bind(R.id.iv_invitation_prize)
    ImageView ivPrize;
    @Bind(R.id.iv_queen_shop)
    ImageView ivQueenShop;
    @Bind(R.id.iv_home_new_first)
    ImageView iv_home_new_first;
    @Bind(R.id.iv_home_new_two)
    ImageView iv_home_new_two;
    @Bind(R.id.iv_home_new_three)
    ImageView iv_home_new_three;
    @Bind(R.id.iv_home_new_four)
    ImageView iv_home_new_four;
    @Bind(R.id.iv_home_new_five)
    ImageView iv_home_new_five;
    private HomeIndustryBean homeIndustryBean;
    int hight;
    boolean type = false;
    ShopListHomeBean shopListHomeBean;
    Intent intent;
    public static HomeNewFragment instance = null;
    private PopupWindow popWindow;
    private List<MerchantsBean.BodyBean.ActivityKeysListDataBean> merchantsList;
    private List<PreferentialBean.BodyBean.FeatureKeysListDataBean> preferentialList;
    private List<ShopListHomeBean.BodyBean.ShopListBean> shoplist = new ArrayList<>();
    private ArrayList<String> cValues;
    private String bannerDetails;
    private List<PageBannerBean.BodyBean.BannerListDataBean> bannerList;

    @Bind(R.id.home_refreshLayout)
    SmartRefreshLayout home_refreshLayout;
    int pageNumber = 1, pageIndex = 0, pageSum = 0;
    HomepageGridViewAdapter gridViewAdapter;
    HomeListViewAdapter homeListViewAdapter;

    @Override
    protected int getLayoutResource() {
        instance = this;
        return R.layout.activity_home_new_fragment;
    }

    @Override
    public void initPresenter() {
    }

    private void initBanner() {
        HashMap<String, String> parames = new HashMap<>();
        HttpUtils.doPost(ACTION.PAGEBANNER, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
    }
    /**
     * 获取首页的行业分类
     * 首页的那我头条
     */
    private void getBannerData() {
        HashMap<String, String> params= new HashMap<>();
        params.put("tabType", "2");//type  2代表美业    4代表异业
        params.put("tabFather", "0");
        HttpUtils.doPost(ACTION.INDUSTRY, params, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);//首页的行业分类
    }

    /**
     * 获取首页底部商家列表
     */
    private void getShopData() {
        HashMap<String, String> params = new HashMap<>();
        params.put("pageNumber", pageNumber + "");
        params.put("contentByTitle", "");
        params.put("pageSize", SpContent.pageSize);
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
        gridViewAdapter = new HomepageGridViewAdapter(getActivity(), shoplist, "home");
        gv_home_gridView.setAdapter(gridViewAdapter);
        homeListViewAdapter = new HomeListViewAdapter(getActivity(), shoplist, "home");
        nl_home_list_view.setAdapter(homeListViewAdapter);
        home_refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                pageNumber = 1;
                pageIndex = 0;
                /**
                 * 获取首页部分数据
                 */
                initBanner();
                getBannerData();
                getShopData();
                initnewShop();
                inithttp();
                refreshlayout.finishRefresh(2000);
            }
        });
        home_refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                if (pageSum > pageIndex && pageSum <= (pageIndex + Integer.parseInt(SpContent.pageSize))) {
                    refreshlayout.finishLoadmore(2000);
                    T.show("您已加载完全部数据");
                } else {
                    pageNumber++;
                    getShopData();
                    refreshlayout.finishLoadmore(2000);
                }

            }
        });
        /**
         * 获取首页部分数据
         */
        initBanner();
        getBannerData();

        if(shoplist.size()==0){
            getShopData();
        } else {

        }
        initnewShop();
        sc_home_scroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                hight = i1;
                if (li_new_top.getVisibility() != 0) {

                } else {
                    if (i1 >= 2935) {
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

    private void initnewShop() {
        HashMap<String, String> parames = new HashMap<>();
        parames.put("shopCate", "1");
        HttpUtils.doPost(ACTION.NEWSHOPlIST, parames, CacheMode.REQUEST_FAILED_READ_CACHE, true, this);
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
                    if (TextUtils.isEmpty(location.getCity())) {
                        mLocation.setText("全国");
                    } else {
                        mLocation.setText(location.getCity());
                        String lon = location.getLongitude() + "";
                        String lat = location.getLatitude() + "";
                        SP.put(getActivity(), SpContent.UserLon, lon);
                        SP.put(getActivity(), SpContent.UserLat, lat);

                        loadData(shoplist);
                    }
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
                view_new_fragment_half.setVisibility(View.INVISIBLE);
                li_home_paixu.setVisibility(View.VISIBLE);
                popWindow.dismiss();
            }
        });
        popview.findViewById(R.id.pop_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view_new_fragment_half.setVisibility(View.INVISIBLE);
                li_home_paixu.setVisibility(View.VISIBLE);
                popWindow.dismiss();
            }
        });
    }
    @OnClick({R.id.li_home_esthetics, R.id.li_home_nailart, R.id.li_home_haircustom, R.id.li_home_beauty, R.id.li_home_permanent, R.id.iv_home_freetrial,
            R.id.line_surface, R.id.line_uspension_surface, R.id.tv_home_bustling, R.id.iv_home_search, R.id.img_information, R.id.bt_app_home,
            R.id.bt_up_home, R.id.rb_sales, R.id.rb_distance, R.id.li_home_screen_bottom, R.id.li_home_screen, R.id.li_sales_bottom})
    public void onClick(View view) {
        switch (view.getId()) {
            /**
             * 筛选
             */
            case R.id.li_home_screen_bottom:
                initScreentext();
                new ScreenPoputil(getActivity()).showscreenPop(li_top_select, merchantsList, preferentialList, "home");
                break;
            case R.id.li_home_screen:
                initScreentext();
                new ScreenPoputil(getActivity()).showscreenPop(li_top_select, merchantsList, preferentialList, "home");
                break;
            /**
             * 按距离排序
             */
            case R.id.rb_distance:
                sc_home_scroll.smoothScrollTo(0, 2935);
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
                sc_home_scroll.smoothScrollTo(0, 2935);
                rb_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
                tv_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
                rb_distance.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                tvdistance.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                tvScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                textScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
                break;
            //case R.id.li_sort_bottom:
            case R.id.bt_up_home:
                inithomepop();
                initpop();
                break;
            /**
             * 点击底部的综合排序
             */
            //case R.id.li_hime_sort:
            case R.id.bt_app_home:
                sc_home_scroll.smoothScrollTo(0, 2935);
                inithomepop();
                initpop1();
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
                       /* HomepageGridViewAdapter gridViewAdapter = new HomepageGridViewAdapter(getActivity(), shoplist, "home");
                        gv_home_gridView.setAdapter(gridViewAdapter);*/

                        loadData(shoplist);
                    } else {

                    }
                } else {
                    iv_surface.setImageResource(R.drawable.icon_home_list);
                    iv_uspension_surface.setImageResource(R.drawable.icon_home_list);
                    type = true;
                    nl_home_list_view.setVisibility(View.VISIBLE);
                    gv_home_gridView.setVisibility(View.GONE);

                    if (shopListHomeBean.getBody().getShopList().size() > 0) {
                       /* HomeListViewAdapter homeListViewAdapter = new HomeListViewAdapter(getActivity(), shoplist, "home");
                        nl_home_list_view.setAdapter(homeListViewAdapter);
*/
                        loadData(shoplist);
                    }
                }
                break;
            //搜索
            case R.id.iv_home_search:
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                intent.putExtra("shopCate", "1");
                startActivity(intent);
                break;
            //消息
            case R.id.img_information:
                startActivity(new Intent(getActivity(), MessageActivity.class));
                break;

        }
    }

    private void inithomepop() {
        tvdistance.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
//        bt.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
//        bt2.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
        rb_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        rb_distance.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        rb_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        tv_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        textScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
    }

    private void initpop() {
        View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.popup2, null);
        ListView pLv = view2.findViewById(R.id.parent_lv);
        final ListView cLv = view2.findViewById(R.id.child_lv);
        List<String> pList = new ArrayList<>();
        final List<List<String>> cList = new ArrayList<>();
        pList.add("姑苏区");
        pList.add("虎丘区");
        pList.add("吴中区");
        pList.add("相城区");
        for (int i = 0; i < pList.size(); i++) {
            List<String> citylist = new ArrayList<>();
            citylist.add("1千米");
            citylist.add("3千米");
            citylist.add("5千米");
            citylist.add("1千米");
            citylist.add("全城");
            cList.add(citylist);
        }

        cValues = new ArrayList<>();
        cValues.addAll(cList.get(0));
        final PopupAdapter pAdapter = new PopupAdapter(getActivity(), R.layout.popup_item, pList, R.drawable.normal, R.drawable.press2);
        final PopupAdapter cAdapter = new PopupAdapter(getActivity(), R.layout.popup_item, cValues, R.drawable.normal, R.drawable.press);
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
                bt2.hidePopup();
                bt.hidePopup();
            }
        });

      //  bt2.setPopupView(view2);
        bt2.setPopupView(view2);
    }

    private void initpop1() {
        View view2 = LayoutInflater.from(getActivity()).inflate(R.layout.popup2, null);
        ListView pLv = view2.findViewById(R.id.parent_lv);
        final ListView cLv = view2.findViewById(R.id.child_lv);
        List<String> pList = new ArrayList<>();
        final List<List<String>> cList = new ArrayList<>();
        pList.add("姑苏区");
        pList.add("虎丘区");
        pList.add("吴中区");
        pList.add("相城区");
        for (int i = 0; i < pList.size(); i++) {
            List<String> citylist = new ArrayList<>();
            citylist.add("1千米");
            citylist.add("3千米");
            citylist.add("5千米");
            citylist.add("1千米");
            citylist.add("全城");
            cList.add(citylist);
        }
        cValues = new ArrayList<>();
        cValues.addAll(cList.get(0));
        final PopupAdapter pAdapter = new PopupAdapter(getActivity(), R.layout.popup_item, pList, R.drawable.normal, R.drawable.press2);
        final PopupAdapter cAdapter = new PopupAdapter(getActivity(), R.layout.popup_item, cValues, R.drawable.normal, R.drawable.press);
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
                bt2.hidePopup();
            }
        });
        bt2.setPopupView(view2);
    }
    private void initshowdistance() {
        rb_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
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
        sc_home_scroll.smoothScrollTo(0, 2935);
        tvScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
        textScreen.setTextColor(getActivity().getResources().getColor(R.color.alpha_violet01));
        rb_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
        tv_sales.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
//        bt.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
//        bt2.setTextColor(getActivity().getResources().getColor(R.color.alpha_55_black));
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
                    Glide.with(this).load(homeIndustryBean.getBody().getCategoryListData().get(0).getEcCategory().getTabPic()).into(iv_home_new_first);
                    tv_home_nailart.setText(homeIndustryBean.getBody().getCategoryListData().get(1).getEcCategory().getTabName());
                    Glide.with(this).load(homeIndustryBean.getBody().getCategoryListData().get(1).getEcCategory().getTabPic()).into(iv_home_new_two);
                    tv_home_haircustom.setText(homeIndustryBean.getBody().getCategoryListData().get(2).getEcCategory().getTabName());
                    Glide.with(this).load(homeIndustryBean.getBody().getCategoryListData().get(2).getEcCategory().getTabPic()).into(iv_home_new_three);
                    tv_home_beauty.setText(homeIndustryBean.getBody().getCategoryListData().get(3).getEcCategory().getTabName());
                    Glide.with(this).load(homeIndustryBean.getBody().getCategoryListData().get(3).getEcCategory().getTabPic()).into(iv_home_new_four);
                    tv_home_permanent.setText(homeIndustryBean.getBody().getCategoryListData().get(4).getEcCategory().getTabName());
                    Glide.with(this).load(homeIndustryBean.getBody().getCategoryListData().get(4).getEcCategory().getTabPic()).into(iv_home_new_five);
                } else {
                    T.show(homeIndustryBean.getMsg());
                }
                break;
            //商家分类列表
            case ACTION.SHOPLIST:
                shopListHomeBean = GsonUtil.toObj(res, ShopListHomeBean.class);
                if (shopListHomeBean.isSuccess()) {
                    if (shopListHomeBean.getBody().getShopList().size() > 0) {
                        pageSum = shopListHomeBean.getBody().getShopList().size();
                        if (pageSum < Integer.parseInt(SpContent.pageSize)) {
                            T.show("您已加载全部数据");
                            home_refreshLayout.setEnableLoadmore(false);
                        } else {
                            home_refreshLayout.setEnableLoadmore(true);
                        }
                        loadMoreData(shopListHomeBean.getBody().getShopList());
                    } else {
                        T.show("暂无店铺信息");
                    }
                } else {
                    T.show(shopListHomeBean.getMsg());
                }

                break;
            case ACTION.PAGEBANNER:
                PageBannerBean bannerBean = GsonUtil.toObj(res, PageBannerBean.class);
                if (bannerBean.isSuccess()) {
                    bannerList = bannerBean.getBody().getBannerListData();
                    List<String> images = new ArrayList<>();
                    List<String> imagesTwo = new ArrayList<>();
                    List<String> bannerName = new ArrayList<>();
                    for (int i = 0; i < bannerList.size(); i++) {
                        if (bannerList.get(i).getPageLocation().equals("1")) {
                            images.add(bannerList.get(i).getBannerLogo());
                            banner.setImageLoader(new GlideImageLoader());
                            banner.setBannerStyle(BannerConfig.NOT_INDICATOR);
                            banner.setImages(images);
                            banner.setViewPagerIsScroll(true);
                            banner.setFocusable(true);
                            banner.requestFocus();
                            banner.start();
                            initBannerOnClick(banner);
                        } else if (bannerList.get(i).getPageLocation().equals("2")) {
                            bannerName.add(bannerList.get(i).getBannerName());
                            mv_home_marqueeView.startWithList(bannerName);
                            bannerDetails = bannerList.get(i).getBannerDetails();
                            if (bannerList.get(i).getBannerStyle().equals("1")) {
                                mv_home_marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(int position, TextView textView) {
                                        Intent intent = new Intent(getActivity(), PageBannerActivity.class);
                                        intent.putExtra("bannerDetails", bannerDetails);
                                        startActivity(intent);
                                    }
                                });
                            }
                        } else if (bannerList.get(i).getPageLocation().equals("3")) {
                            initShowSort(i, 1, ivNewuserprg);
                            initShowSort(i, 2, ivFreetrial);
                            initOnClick(i, 1, ivNewuserprg);
                            ivFreetrial.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(new Intent(getActivity(), HomeFightaloneActivity.class));
                                }
                            });
                            initShowSort(i, 3, ivSpecialoffer);
                            initShowSort(i, 4, ivGoodshop);
                            initOnClick(i, 3, ivSpecialoffer);
                            initOnClick(i, 4, ivGoodshop);
                        } else if (bannerList.get(i).getPageLocation().equals("4")) {
                            initShowSort(i, 1, ivItemShop);
                            initShowSort(i, 2, ivConvert);
                            initShowSort(i, 3, ivPrize);
                            initShowSort(i, 4, ivQueenShop);
                            initOnClick(i, 1, ivItemShop);
                            initOnClick(i, 2, ivConvert);
                            initOnClick(i, 3, ivPrize);
                            initOnClick(i, 4, ivQueenShop);
                        } else if (bannerList.get(i).getPageLocation().equals("5")) {
                            imagesTwo.add(bannerList.get(i).getBannerLogo());
                            banner_middle.setBannerStyle(BannerConfig.NOT_INDICATOR);
                            banner_middle.setImageLoader(new GlideImageLoader());
                            banner_middle.setImages(imagesTwo);
                            banner_middle.setViewPagerIsScroll(true);
                            banner_middle.setFocusable(true);
                            banner_middle.requestFocus();
//                            final String id = bannerList.get(i).getId();
//                            final String style = bannerList.get(i).getBannerStyle();
//                            final String url = bannerList.get(i).getBannerUrl();
//                            final String name = bannerList.get(i).getBannerName();
                            banner_middle.start();
                            banner_middle.setOnBannerListener(new OnBannerListener() {
                                @Override
                                public void OnBannerClick(int position) {
                                    L.e("======================" + bannerList.get(position).getBannerName());
                                    Intent intent = new Intent(getActivity(), HomeAdvertisingActivity.class);
                                    intent.putExtra("bannerId", bannerList.get(position).getId());
                                    intent.putExtra("bannerStyle", bannerList.get(position).getBannerStyle());
                                    intent.putExtra("weburl", bannerList.get(position).getBannerUrl());
                                    intent.putExtra("bannerTitle", bannerList.get(position).getBannerName());
                                    getActivity().startActivity(intent);

                                }
                            });
                        }
                    }
                } else {
                    T.show(bannerBean.getMsg());
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
            //每日新店
            case ACTION.NEWSHOPlIST:
                HomeNewShopBean newShopBean = GsonUtil.toObj(res, HomeNewShopBean.class);
                if (newShopBean.isSuccess()) {
                    List<HomeNewShopBean.BodyBean.NewShopListBean> shopList = newShopBean.getBody().getNewShopList();
                    HomeNewShopAdapter shopAdapter = new HomeNewShopAdapter(R.layout.re_home_recommend, shopList);
                    rv_home_new_every.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
                    rv_home_new_every.setAdapter(shopAdapter);
                    shopAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            startActivity(new Intent(getActivity(), FullActivity.class));
                        }
                    });
                } else {
                    T.show(newShopBean.getMsg());
                }
                break;
        }
    }

    private void initOnClick(final int i, final int sort, ImageView imageView) {
        if (bannerList.get(i).getShowSort() == sort) {
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), HomeAdvertisingActivity.class);
                    intent.putExtra("bannerId", bannerList.get(i).getId());
                    intent.putExtra("bannerStyle", bannerList.get(i).getBannerStyle());
                    intent.putExtra("weburl", bannerList.get(i).getBannerUrl());
                    intent.putExtra("bannerLogo", bannerList.get(i).getBannerLogo());
                    intent.putExtra("bannerTitle", bannerList.get(i).getBannerName());
                    getActivity().startActivity(intent);
                }
            });
        }
    }

    private void initBannerOnClick(Banner banner) {
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent = new Intent(getActivity(), HomeAdvertisingActivity.class);
                intent.putExtra("bannerId", bannerList.get(position).getId());
                intent.putExtra("bannerStyle", bannerList.get(position).getBannerStyle());
                intent.putExtra("weburl", bannerList.get(position).getBannerUrl());
                intent.putExtra("bannerLogo", bannerList.get(position).getBannerLogo());
                intent.putExtra("bannerTitle", bannerList.get(position).getBannerName());


                getActivity().startActivity(intent);
            }
        });
    }



    private void initShowSort(int i, int sort, ImageView ivNewuserprg) {
        if (bannerList.get(i).getShowSort() == sort) {
            glideImage(bannerList.get(i).getBannerLogo(), ivNewuserprg);
        }
    }

    private void glideImage(String url, ImageView img) {
        Glide.with(this).load(url).centerCrop().into(img);
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

    public void loadData(List<ShopListHomeBean.BodyBean.ShopListBean> apiOrderListMore) {
        if (pageIndex == 0) {
            gridViewAdapter.setmDate(shoplist);
            homeListViewAdapter.setmDate(shoplist);
        } else {
            gridViewAdapter.notifyDataSetChanged();
            homeListViewAdapter.notifyDataSetChanged();
        }
    }

    public void loadMoreData(List<ShopListHomeBean.BodyBean.ShopListBean> apiOrderListMore) {

        if (shoplist == null) {
            shoplist = new ArrayList<>();
        }
        if (pageIndex == 0) {
            gridViewAdapter.Clear();
            homeListViewAdapter.Clear();
        }
        shoplist.addAll(apiOrderListMore);
        if (pageIndex == 0) {
            gridViewAdapter.setmDate(shoplist);
            homeListViewAdapter.setmDate(shoplist);
        } else {
            gridViewAdapter.notifyDataSetChanged();
            homeListViewAdapter.notifyDataSetChanged();
        }
        pageIndex += Integer.parseInt(SpContent.pageSize);

    }

}
