package cn.zgy.rxtools.refresh.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.zgy.refresh.RefreshLayout;
import cn.zgy.refresh.classic.RotateRefreshView;
import cn.zgy.refresh.shapeloading.ShapeLoadingRefreshView;
import cn.zgy.rxtools.R;
import cn.zgy.rxtools.refresh.fragment.TestFragment;
import cn.zgy.rxtools.refresh.fragment.TestFragment1;

/**
 * Created by canyinghao on 16/6/29.
 */
public class CooActivity2 extends AppCompatActivity implements RefreshLayout.OnRefreshListener, RefreshLayout.OnLoadMoreListener {


    @BindView(R.id.can_refresh_footer)
    RotateRefreshView canRefreshFooter;
    @BindView(R.id.header)
    ImageView header;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbarlayout)
    CollapsingToolbarLayout toolbarlayout;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.can_scroll_view)
    ViewPager viewPager;
    @BindView(R.id.can_content_view)
    CoordinatorLayout canContentView;
    @BindView(R.id.refresh)
    RefreshLayout refresh;

    @BindView(R.id.can_refresh_header)
    ShapeLoadingRefreshView canRefreshHeader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coo2);
        ButterKnife.bind(this);


        refresh.setOnLoadMoreListener(this);
        refresh.setOnRefreshListener(this);

        refresh.setRefreshBackgroundResource(R.color.google_yellow);
        refresh.setLoadMoreBackgroundResource(R.color.window_background);

        canRefreshHeader.setColors(getResources().getColor(R.color.color_button), getResources().getColor(R.color.color_text), getResources().getColor(R.color.color_red));





        Adapter  adapter = new Adapter(getSupportFragmentManager());

        String[] strs = getResources().getStringArray(R.array.array_list3);



        adapter.addFragment(TestFragment.newInstance(), strs[0]);
        adapter.addFragment(TestFragment1.newInstance(), strs[1]);
        adapter.addFragment(TestFragment.newInstance(), strs[2]);


        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);


        viewPager.setCurrentItem(1);


    }



    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

    @Override
    public void onLoadMore() {
        refresh.postDelayed(new Runnable() {
            @Override
            public void run() {


                refresh.loadMoreComplete();
            }
        }, 1000);
    }

    @Override
    public void onRefresh() {
        refresh.postDelayed(new Runnable() {
            @Override
            public void run() {

                refresh.refreshComplete();
            }
        }, 1500);
    }
}
