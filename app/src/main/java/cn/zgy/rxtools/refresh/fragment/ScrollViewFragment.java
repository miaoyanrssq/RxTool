package cn.zgy.rxtools.refresh.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.zgy.refresh.RefreshLayout;
import cn.zgy.rxtools.R;


public class ScrollViewFragment extends Fragment implements RefreshLayout.OnRefreshListener,RefreshLayout.OnLoadMoreListener {

    private RefreshLayout refresh;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_scroll_view, container, false);

        initView(v);

        return v;
    }

    private void initView(View v) {
        refresh = (RefreshLayout) v.findViewById(R.id.refresh);


        refresh.setOnRefreshListener(this);


        refresh.setMaxFooterHeight(300);


//        refresh.setLoadMoreEnabled(false);

        refresh.setOnLoadMoreListener(this);



        refresh.autoRefresh();

    }


    @Override
    public void onRefresh() {
        refresh.postDelayed(new Runnable() {
            @Override
            public void run() {

                refresh.refreshComplete();



            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        refresh.postDelayed(new Runnable() {
            @Override
            public void run() {

                refresh.loadMoreComplete();



            }
        }, 2000);
    }
}
