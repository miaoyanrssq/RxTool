package cn.zgy.rxtools.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import cn.zgy.rxtools.R;
import cn.zgy.rxview.view.banner.BannerPagerAdapter;
import cn.zgy.rxview.view.banner.BannerView;
import cn.zgy.rxview.view.banner.magic.GalleryPageTransformer;
import cn.zgy.rxview.view.banner.view.BannerViewPager;

public class GallerySimpleActivity extends Activity {

    BannerView banner;
    private BannerPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_simple);

        banner = (BannerView) findViewById(R.id.banner_view);

        adapter = new BannerPagerAdapter() {

            @Override
            public int getTruthCount() {
                return 8;
            }

            @Override
            protected View getItem(ViewGroup container, int position) {
                View inflate = LayoutInflater.from(container.getContext()).inflate(R.layout
                        .module_pager_item, container, false);
                TextView textView = (TextView) inflate.findViewById(R.id.image_view);
                textView.setText(String.valueOf(position));
                inflate.setTag(position);
                return inflate;
            }

        };

        BannerViewPager viewPager = banner.getViewPager();

        viewPager.setPageTransformer(true,
                new GalleryPageTransformer(viewPager, dip2px(20), 1, 0.86f));
        banner.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        banner.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        banner.onStop();
    }

    /**
     * dip转换px
     */
    public int dip2px(float dip) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

}
