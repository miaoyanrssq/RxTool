package cn.zgy.rxtools.refresh.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.canyinghao.canadapter.CanHolderHelper;
import com.canyinghao.canadapter.CanOnItemListener;
import com.canyinghao.canadapter.CanRVAdapter;
import com.canyinghao.canrecyclerview.CanRecyclerViewHeaderFooter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zgy.refresh.RefreshLayout;
import cn.zgy.rxtools.R;
import cn.zgy.rxtools.refresh.MainBean;


/**
 * Created by canyinghao on 16/1/21.
 */
public class RVRefreshFragment1 extends Fragment implements RefreshLayout.OnRefreshListener, CanRecyclerViewHeaderFooter.OnLoadMoreListener {


    public final static String TYPE = "type";

    @BindView(R.id.can_content_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh)
    RefreshLayout refresh;
    CanRVAdapter adapter;

    int type;

    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.header)
    CanRecyclerViewHeaderFooter header;
    @BindView(R.id.pb)
    ProgressBar pb;
    @BindView(R.id.tv_loadmore)
    TextView tvLoadmore;
    @BindView(R.id.footer)
    CanRecyclerViewHeaderFooter footer;


    public static RVRefreshFragment1 newInstance(int type) {
        RVRefreshFragment1 fragment = new RVRefreshFragment1();
        Bundle bundle = new Bundle();
        bundle.putInt(TYPE, type);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getArguments().getInt(TYPE, 0);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_rv_load, container, false);
        ButterKnife.bind(this, v);


        initView();
        return v;


    }


    private void initView() {

        refresh.setOnRefreshListener(this);


        refresh.setStyle(type, type);

        refresh.setMaxHeaderHeight((int) getResources().getDimension(R.dimen.dimen_super_super));

        refresh.setOnStartUpListener(new RefreshLayout.OnStartUpListener() {
            @Override
            public void onUp() {

                Log.e("Canyinghao", "onUp");
            }

            @Override
            public void onReset() {
                Log.e("Canyinghao", "onReset");
            }
        });

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL));


        adapter = new CanRVAdapter<MainBean>(recyclerView, R.layout.item_main) {


            @Override
            protected void setView(CanHolderHelper helper, int position, MainBean model) {
                if (position == 0) {
                    helper.setVisibility(R.id.tv_content, View.GONE);
                } else {

                    helper.setVisibility(R.id.tv_content, View.VISIBLE);
                }

                helper.setText(R.id.tv_content, model.content);
                helper.setText(R.id.tv_title, model.title);


            }

            @Override
            protected void setItemListener(CanHolderHelper helper) {


            }
        };

        recyclerView.setAdapter(adapter);


        adapter.setOnItemListener(new CanOnItemListener() {

            public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                MainBean bean = (MainBean) adapter.getItem(position);

            }


        });


        adapter.setList(MainBean.getList());

        header.attachTo(recyclerView, true);
        footer.attachTo(recyclerView, false);
        footer.setLoadMoreListener(this);


    }


    @OnClick(R.id.iv_head)
    public void click(View v) {


    }


    @Override
    public void onRefresh() {

        refresh.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.setList(MainBean.getList());
                refresh.refreshComplete();

                tvLoadmore.setVisibility(View.GONE);
                pb.setVisibility(View.VISIBLE);
                footer.setLoadEnable(true);

            }
        }, 1000);

    }


    int i = 0;

    @Override
    public void onLoadMore() {


        refresh.postDelayed(new Runnable() {
            @Override
            public void run() {

                adapter.addMoreList(MainBean.getList());

                i++;

                if (i == 2) {
                    tvLoadmore.setVisibility(View.VISIBLE);
                    pb.setVisibility(View.GONE);
                    footer.setLoadEnable(false);
                }


                footer.loadMoreComplete();
            }
        }, 1000);

    }
}
