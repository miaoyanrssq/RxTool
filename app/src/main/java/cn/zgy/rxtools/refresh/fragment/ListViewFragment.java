package cn.zgy.rxtools.refresh.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.canyinghao.canadapter.CanAdapter;
import com.canyinghao.canadapter.CanHolderHelper;
import com.canyinghao.canadapter.CanOnItemListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.zgy.refresh.RefreshLayout;
import cn.zgy.rxtools.R;
import cn.zgy.rxtools.refresh.MainBean;


/**
 * Created by canyinghao on 16/1/21.
 */
public class ListViewFragment extends Fragment implements RefreshLayout.OnRefreshListener,RefreshLayout.OnLoadMoreListener {

    @BindView(R.id.can_content_view)
    ListView listView;
    @BindView(R.id.refresh)
    RefreshLayout refresh;

    CanAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listview, container, false);
        ButterKnife.bind(this, v);

        initView();
        return v;
    }


    private void initView() {
        refresh.setOnRefreshListener(this);
        refresh.setOnLoadMoreListener(this);

        refresh.autoRefresh();


      adapter = new CanAdapter<MainBean>(getContext(), R.layout.item_main) {


            @Override
            protected void setView(CanHolderHelper helper, int position, MainBean model) {
                helper.setText(R.id.tv_title, model.title);
                helper.setText(R.id.tv_content, model.content);

            }

            @Override
            protected void setItemListener(CanHolderHelper helper) {

                helper.setItemChildClickListener(R.id.tv_title);
                helper.setItemChildClickListener(R.id.tv_content);

            }
        };

        listView.setAdapter(adapter);


        adapter.setOnItemListener(new CanOnItemListener() {

            public void onItemChildClick(View view, int position) {

                MainBean bean = (MainBean) adapter.getItem(position);
                switch (view.getId()) {


                    case R.id.tv_title:

                        break;

                    case R.id.tv_content:
                        break;
                }


            }

        });


        adapter.setList(MainBean.getList());





    }

    @Override
    public void onRefresh() {

        listView.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.setList(MainBean.getList());
                refresh.refreshComplete();
            }
        }, 1000);

    }

    @Override
    public void onLoadMore() {

        listView.postDelayed(new Runnable() {
            @Override
            public void run() {

                adapter.addMoreList(MainBean.getList());
                refresh.loadMoreComplete();
            }
        }, 1000);

    }



}
