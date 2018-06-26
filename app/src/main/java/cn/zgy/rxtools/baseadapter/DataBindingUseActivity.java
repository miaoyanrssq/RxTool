package cn.zgy.rxtools.baseadapter;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.zgy.baseadapter.BaseQuickAdapter;
import cn.zgy.rxtools.R;
import cn.zgy.rxtools.baseadapter.adapter.DataBindingUseAdapter;
import cn.zgy.rxtools.baseadapter.base.BaseActivity;
import cn.zgy.rxtools.baseadapter.entity.Movie;
import cn.zgy.rxtools.baseadapter.util.ToastUtils;

public class DataBindingUseActivity extends BaseActivity {

    RecyclerView mRecyclerView;
    DataBindingUseAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackBtn();
        setTitle("DataBinding Use");
        setContentView(R.layout.activity_data_binding_use);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mAdapter = new DataBindingUseAdapter(R.layout.item_movie, genData());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShortToast("onItemClick");
            }
        });
        mAdapter.setOnItemChildLongClickListener(new BaseQuickAdapter.OnItemChildLongClickListener() {
            @Override
            public boolean onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShortToast("onItemChildLongClick");
                return true;
            }
        });
        mAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShortToast("onItemLongClick");
                return true;
            }
        });
    }


    private List<Movie> genData() {
        ArrayList<Movie> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String name = "Chad";
            int price = random.nextInt(10) + 10;
            int len = random.nextInt(80) + 60;
            Movie movie = new Movie(name, len, price, "He was one of Australia's most distinguished artistes");
            list.add(movie);
        }
        return list;
    }
}
