package cn.zgy.rxtools.baseadapter;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import cn.zgy.baseadapter.BaseQuickAdapter;
import cn.zgy.rxtools.R;
import cn.zgy.rxtools.baseadapter.adapter.MultipleItemQuickAdapter;
import cn.zgy.rxtools.baseadapter.base.BaseActivity;
import cn.zgy.rxtools.baseadapter.data.DataServer;
import cn.zgy.rxtools.baseadapter.entity.MultipleItem;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 * modify by AllenCoder
 */
public class MultipleItemUseActivity extends BaseActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_item_use);
        setTitle("MultipleItem Use");
        setBackBtn();
        mRecyclerView = (RecyclerView) findViewById(R.id.rv_list);
        final List<MultipleItem> data = DataServer.getMultipleItemData();
        final MultipleItemQuickAdapter multipleItemAdapter = new MultipleItemQuickAdapter(this, data);
        final GridLayoutManager manager = new GridLayoutManager(this, 4);
        mRecyclerView.setLayoutManager(manager);
        multipleItemAdapter.setSpanSizeLookup(new BaseQuickAdapter.SpanSizeLookup() {
            @Override
            public int getSpanSize(GridLayoutManager gridLayoutManager, int position) {
                return data.get(position).getSpanSize();
            }
        });
        mRecyclerView.setAdapter(multipleItemAdapter);
    }


}
