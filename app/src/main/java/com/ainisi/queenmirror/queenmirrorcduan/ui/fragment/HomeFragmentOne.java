package com.ainisi.queenmirror.queenmirrorcduan.ui.fragment;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ainisi.queenmirror.queenmirrorcduan.R;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.GridViewAdapter;

import com.ainisi.queenmirror.queenmirrorcduan.adapter.ListViewAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.adapter.ProblemAdapter;
import com.ainisi.queenmirror.queenmirrorcduan.api.HttpCallBack;
import com.ainisi.queenmirror.queenmirrorcduan.base.BaseFragment;
import com.ainisi.queenmirror.queenmirrorcduan.bean.SortBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.DetailActivity;
import com.ainisi.queenmirror.queenmirrorcduan.utils.GlideImageLoader;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.HomeFightaloneActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.MessageActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.SearchActivity;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.activity.EstheticsActivity;
import com.ainisi.queenmirror.queenmirrorcduan.bean.ProblemBean;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.DistanceFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.SalesFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.ScreenFragment;
import com.ainisi.queenmirror.queenmirrorcduan.ui.home.fragment.SortFragment;
import com.ainisi.queenmirror.queenmirrorcduan.utils.CustomPopWindow;
import com.ainisi.queenmirror.queenmirrorcduan.utils.MarqueeView;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollGridView;
import com.ainisi.queenmirror.queenmirrorcduan.utils.NoScrollListview;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;


public class HomeFragmentOne extends BaseFragment implements HttpCallBack{

    @Bind(R.id.banner)
    Banner banner;
    @Bind(R.id.iv_sort)
    LinearLayout ivsort;
    @Bind(R.id.iv_sort1)
    ImageView ivsort1;
    @Bind(R.id.rb_sort)
    TextView hSort;
    @Bind(R.id.rb_sales)
    TextView hSales;
    @Bind(R.id.rb_distance)
    TextView hDistance;
    @Bind(R.id.rb_screen)
    TextView hscreen;
    @Bind(R.id.home_layout)
    LinearLayout hlayout;
    @Bind(R.id.marqueeview)
    MarqueeView marqueeView;
    @Bind(R.id.li_sort_bottom)
    LinearLayout li_sort_bottom;
    @Bind(R.id.li_home_screen)
    LinearLayout li_home_screen;
    @Bind(R.id.li_home_screen_bottom)
    LinearLayout li_home_screen_bottom;


    @Bind(R.id.sc_home_scroll)
    ScrollView sc_home_scroll;

    private LinearLayoutManager linearLayoutManager;
    private int top = -1;
    private int mScrollY = 0;


    ListViewAdapter listadapter;
    @Bind(R.id.listView)
    NoScrollListview listView;
    @Bind(R.id.gridView)
    NoScrollGridView gridView;
    @Bind(R.id.layout_stick_header_main)
    LinearLayout layout_stick_header_main;
    @Bind(R.id.layout_stick_header)
    LinearLayout layout_stick_header;
    @Bind(R.id.iv_surface)
    ImageView imgSurface;
    @Bind(R.id.iv_uspension_surface)
    ImageView uspensionSurface;
    View firstLayout;

    Handler handler = new Handler();
    //综合排序
    SortFragment sortFragment;
    //销量最高
    SalesFragment salesFragment;
    //距离最近
    DistanceFragment distanceFragment;
    //筛选
    ScreenFragment screenFragment;
    String[] contentArray = new String[]{
            "恭喜杨小姐领取奔驰4s店优惠券一张",
            "恭喜李先生领取奶茶特饮优惠券一张",
            "恭喜王小姐领取50元话费优惠券一张",
            "恭喜杨小姐领取奔驰4s店优惠券一张",
            "恭喜李先生领取奶茶特饮优惠券一张",
            "恭喜王小姐领取50元话费优惠券一张",};
    private FragmentManager fm;
    private CustomPopWindow popWindow;
    private PopupWindow pop;
    private View popview1;
    private List<ProblemBean> list = new ArrayList<>();
    String[] problem = {"销量最高", "价格最低", "距离最近", "优惠最多", "满减优惠", "新用最好", "用户最好"};

    int hight;//标记ScrollView移动的距离
    private boolean isClick;
    private GridViewAdapter gridadapter;
    private GridViewAdapter gridViewAdapter;

    public HomeFragmentOne() {
    }

   /* @Override
    protected int getLayoutResource() {
        return R.layout.fragment_home;
    }

    @Override
    public void initPresenter() {

    }*/

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_home;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void initView() {
        initDate();
        initQuee();
        initpopwindow();
        sc_home_scroll.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                hight = i1;
                if (i1 >= 1621) {
                    layout_stick_header.setVisibility(View.GONE);
                    layout_stick_header_main.setVisibility(View.VISIBLE);
                } else {
                    layout_stick_header.setVisibility(View.VISIBLE);
                    layout_stick_header_main.setVisibility(View.GONE);
                }
            }
        });
        listadapter = new ListViewAdapter(getContext());
        listView.setAdapter(listadapter);
    }
    /**
     * 点击首页跑马灯效果
     */
    private void initQuee() {
        marqueeView.setTextArray(contentArray);
        marqueeView.setOnItemClickListener(new MarqueeView.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("content", contentArray[position]);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                marqueeView.resume();
            }
        }, 1000);
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
                setBackgroundAlpha(1.0f);
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
        List<String> images = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            images.add("http://pic3.zhimg.com//144edd4fa57e8b0b9c70bfea5c6b5dee.jpg");
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
        ProblemAdapter problemAdapter = new ProblemAdapter( R.layout.item_pop_sort,list);
        ce.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        ce.setAdapter(problemAdapter);
        problemAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                hSort.setText(problem[position]);
                pop.dismiss();
            }
        });
    }

    @OnClick({R.id.rb_sort, R.id.rb_sales, R.id.rb_distance, R.id.rb_screen, R.id.txt_bustling
            , R.id.img_search, R.id.img_information, R.id.home_esthetics, R.id.iv_sort, R.id.iv_sort1
            , R.id.bt_screen, R.id.li_sort_bottom, R.id.li_home_screen, R.id.li_home_screen_bottom, R.id.line_surface
            , R.id.line_uspension_surface, R.id.linear_home_freetrial})
    public void click(View view) {
        //  FragmentTransaction transaction = fm.beginTransaction();
        switch (view.getId()) {
            //点击流式布局，和瀑布流布局切换
            case R.id.line_surface:
                sc_home_scroll.smoothScrollTo(0, 1621);
                layout_stick_header.setVisibility(View.GONE);
                layout_stick_header_main.setVisibility(View.VISIBLE);
                if (isClick) {
                    isClick = false;
                    listadapter = new ListViewAdapter(getContext());
                    listView.setAdapter(listadapter);

                    gridView.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    imgSurface.setImageResource(R.drawable.icon_home_list);
                } else {
                    imgSurface.setImageResource(R.drawable.icon_home_recycler);
                    gridView.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                    gridViewAdapter = new GridViewAdapter(getContext());
                    gridView.setAdapter(gridViewAdapter);
                    isClick = true;
                }
                break;
            case R.id.line_uspension_surface:
                sc_home_scroll.smoothScrollTo(0, 1621);
                layout_stick_header.setVisibility(View.GONE);
                layout_stick_header_main.setVisibility(View.VISIBLE);
                if (isClick) {
                    isClick = false;
                    listadapter = new ListViewAdapter(getContext());
                    listView.setAdapter(listadapter);
                    gridView.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                    uspensionSurface.setImageResource(R.drawable.icon_home_list);
                } else {
                    uspensionSurface.setImageResource(R.drawable.icon_home_recycler);
                    gridView.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.GONE);
                    gridViewAdapter = new GridViewAdapter(getContext());
                    gridView.setAdapter(gridViewAdapter);
                    isClick = true;
                }

                break;
            case R.id.bt_screen:

                break;
            //综合选择
            case R.id.li_sort_bottom:
                break;
            case R.id.iv_sort:
                setBackgroundAlpha(0.5f);
                ivsort.setVisibility(View.GONE);
                ivsort1.setVisibility(View.VISIBLE);
                if (hight >= 1621) {
                    pop.showAsDropDown(layout_stick_header_main);
                } else {
                    sc_home_scroll.smoothScrollTo(0, 1621);
                    pop.showAsDropDown(hSort);
                }

                break;
            case R.id.iv_sort1:
                pop.dismiss();
                ivsort1.setVisibility(View.GONE);
                ivsort.setVisibility(View.VISIBLE);
                break;
            //美学汇
            case R.id.home_esthetics:
                startActivity(new Intent(getActivity(), EstheticsActivity.class));
                break;
            //我的位置
            case R.id.txt_bustling:
                //startProgressDialog();
                break;
            //搜索
            case R.id.img_search:
                SearchActivity.startActivity(getContext());
                break;
            //信息
            case R.id.img_information:
                startActivity(new Intent(getActivity(), MessageActivity.class));
                break;
            //免费试用（拼单）
            case R.id.linear_home_freetrial:
                startActivity(new Intent(getActivity(),HomeFightaloneActivity.class));
                break;
            case R.id.rb_sort:
              /*  if (sortFragment == null) {
                    sortFragment = new SortFragment();
                    transaction.add(R.id.fl_home_recommend_layout, sortFragment);
                } else {
                    transaction.show(sortFragment);
                }
                hideFragment(salesFragment, transaction);
                hideFragment(distanceFragment, transaction);*/
//                hideFragment(screenFragment, transaction);
                break;
            case R.id.rb_sales:
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
            case R.id.rb_distance:

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
            case R.id.li_home_screen:
                break;
            case R.id.rb_screen:
                break;
            case R.id.li_home_screen_bottom:

//                if (screenFragment == null) {
//                    screenFragment = new ScreenFragment();
//                    transaction.add(R.id.fl_home_recommend_layout, screenFragment);
//                } else {
//                    transaction.show(screenFragment);
//                }
//                hideFragment(sortFragment, transaction);
//                hideFragment(salesFragment, transaction);
//                hideFragment(distanceFragment, transaction);
                // coorHm.setVisibility(View.INVISIBLE);


                View popview = View.inflate(getActivity(), R.layout.pop_right, null);

                initview(popview);
                popWindow = new CustomPopWindow.PopupWindowBuilder(getActivity())
                        .setView(popview)
                        .setFocusable(true)
                        .size(CollapsingToolbarLayout.LayoutParams.MATCH_PARENT, CollapsingToolbarLayout.LayoutParams.MATCH_PARENT)
                        .setOutsideTouchable(true)
                        .setAnimationStyle(R.style.CustomPopWindowStyle)
                        .create()
                        .showAsDropDown(layout_stick_header_main);


                break;
            default:
                break;
        }
        //提交事务
        //transaction.commit();


    }

    private void initview(final View popview) {
        TextView eliminateTv = popview.findViewById(R.id.tv_eliminate);
        TextView okTv = popview.findViewById(R.id.tv_ok);
        eliminateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popWindow.dissmiss();
                // coorHm.setVisibility(View.VISIBLE);
            }
        });
    }

    private void hideFragment(Fragment fragment, FragmentTransaction transaction) {
        if (null != fragment) {
            transaction.hide(fragment);
        }
    }

    @Override
    public void onSuccess(int action, String res) {

    }

    @Override
    public void showLoadingDialog() {

    }

    @Override
    public void showErrorMessage(String s) {

    }
}
