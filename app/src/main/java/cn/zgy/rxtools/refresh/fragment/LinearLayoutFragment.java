package cn.zgy.rxtools.refresh.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import butterknife.BindView;
import butterknife.ButterKnife;
import cn.zgy.refresh.RefreshLayout;
import cn.zgy.rxtools.R;


/**
 * Created by canyinghao on 16/1/24.
 */
public class LinearLayoutFragment extends Fragment implements RefreshLayout.OnRefreshListener, RefreshLayout.OnLoadMoreListener {

   
    @BindView(R.id.refresh)
    RefreshLayout refresh;


  


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_linear, container, false);
        ButterKnife.bind(this, v);
        initView(v);
        return v;
    }

    private void initView(View v) {






        refresh.setOnLoadMoreListener(this);
        refresh.setOnRefreshListener(this);
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

    @Override
    public void onRefresh() {
        refresh.postDelayed(new Runnable() {
            @Override
            public void run() {
                refresh.refreshComplete();
            }
        }, 2000);
    }


}
