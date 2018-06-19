package cn.zgy.rxtools.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.zgy.rxtool.RxActivityTool;
import cn.zgy.rxtools.R;
import cn.zgy.rxview.view.banner.BannerIndicatorLayout;
import cn.zgy.rxview.view.banner.BannerPagerAdapter;
import cn.zgy.rxview.view.banner.BannerView;
import cn.zgy.rxview.view.banner.OnItemClickListener;

public class BannerActivity extends Activity implements View.OnClickListener, OnItemClickListener {

    BannerIndicatorLayout indicator;
    BannerView banner;

    private BannerPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        indicator = (BannerIndicatorLayout) findViewById(R.id.banner_indicator);
        banner = (BannerView) findViewById(R.id.banner_view);
        findViewById(R.id.btn_start).setOnClickListener(this);
        findViewById(R.id.btn_stop).setOnClickListener(this);
        findViewById(R.id.btn_0_num).setOnClickListener(this);
        findViewById(R.id.btn_1_num).setOnClickListener(this);
        findViewById(R.id.btn_5_num).setOnClickListener(this);
        findViewById(R.id.btn_gallery).setOnClickListener(this);

        adapter = new BannerPagerAdapter() {
            @Override
            public int getTruthCount() {
                return 5;
            }

            @Override
            protected View getItem(ViewGroup container, int position) {
                View view = inflate(R.layout.item_banner_view_test, container);
                TextView tv = (TextView) view.findViewById(R.id.tv_content);
                tv.setText("index " + position);
                return view;
            }

        };
        adapter.setOnItemClickListener(this);

        banner.setAdapter(adapter);
        banner.getViewPager().setTransitionAnimationScale(4); // 新增控制过渡动画比例的方法

        indicator.setAdapter(new BannerIndicatorLayout.IndicatorAdapter() {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    return inflate(R.layout.item_banner_indicator_dot, parent);
                }
                return convertView;
            }

            @Override
            public void onPagerScrolled(int index, View indexView, float indexOffset, int
                    laterIndex, View laterIndexView, float laterIndexOffset) {

            }
        });

        indicator.setupWithBanner(banner);

    }

    private View inflate(int resId, ViewGroup root) {
        return LayoutInflater.from(this).inflate(resId, root, false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                banner.setAuto(true);
                banner.startAuto();
                break;
            case R.id.btn_stop:
                banner.stopAuto();
                break;
            case R.id.btn_0_num:
                adapter = new BannerPagerAdapter() {

                    @Override
                    public int getTruthCount() {
                        return 0;
                    }

                    @Override
                    protected View getItem(ViewGroup container, int position) {
                        View view = inflate(R.layout.item_banner_view_test, container);
                        TextView tv = (TextView) view.findViewById(R.id.tv_content);
                        tv.setText("index " + position);
                        return view;
                    }

                };
                banner.setAdapter(adapter);
                break;
            case R.id.btn_1_num:
                adapter = new BannerPagerAdapter(false) {

                    @Override
                    public int getTruthCount() {
                        return 1;
                    }

                    @Override
                    protected View getItem(ViewGroup container, int position) {
                        View view = inflate(R.layout.item_banner_view_test, container);
                        TextView tv = (TextView) view.findViewById(R.id.tv_content);
                        tv.setText("index " + position);
                        return view;
                    }

                };
                banner.setAdapter(adapter);
                banner.setAuto(false);
                break;
            case R.id.btn_5_num:
                adapter = new BannerPagerAdapter() {

                    @Override
                    public int getTruthCount() {
                        return 5;
                    }

                    @Override
                    protected View getItem(ViewGroup container, int position) {
                        View view = inflate(R.layout.item_banner_view_test, container);
                        TextView tv = (TextView) view.findViewById(R.id.tv_content);
                        tv.setText("index " + position);
                        return view;
                    }

                };
                banner.setAdapter(adapter);
                banner.setAuto(true);
                break;
            case R.id.btn_gallery:
                RxActivityTool.skipActivity(this, GallerySimpleActivity.class);
                break;
        }
    }

    @Override
    public void onItemClick(View item, int position) {
        Log.e("TAG", "position " + position);
    }
}
