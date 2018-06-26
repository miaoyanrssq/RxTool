package cn.zgy.rxtools.baseadapter;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

import cn.zgy.baseadapter.entity.MultiItemEntity;
import cn.zgy.rxtools.R;
import cn.zgy.rxtools.baseadapter.adapter.ExpandableItemAdapter;
import cn.zgy.rxtools.baseadapter.base.BaseActivity;
import cn.zgy.rxtools.baseadapter.entity.Level0Item;
import cn.zgy.rxtools.baseadapter.entity.Level1Item;
import cn.zgy.rxtools.baseadapter.entity.Person;

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
public class ExpandableUseActivity extends BaseActivity {
    RecyclerView mRecyclerView;
    ExpandableItemAdapter adapter;
    ArrayList<MultiItemEntity> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setBackBtn();
        setTitle("ExpandableItem Activity");
        setContentView(R.layout.activity_expandable_item_use);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv);

        list = generateData();
        adapter = new ExpandableItemAdapter(list);

        final GridLayoutManager manager = new GridLayoutManager(this, 3);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.getItemViewType(position) == ExpandableItemAdapter.TYPE_PERSON ? 1 : manager.getSpanCount();
            }
        });

        mRecyclerView.setAdapter(adapter);
        // important! setLayoutManager should be called after setAdapter
        mRecyclerView.setLayoutManager(manager);
        adapter.expandAll();
    }

    private ArrayList<MultiItemEntity> generateData() {
        int lv0Count = 9;
        int lv1Count = 3;
        int personCount = 5;

        String[] nameList = {"Bob", "Andy", "Lily", "Brown", "Bruce"};
        Random random = new Random();

        ArrayList<MultiItemEntity> res = new ArrayList<>();
        for (int i = 0; i < lv0Count; i++) {
            Level0Item lv0 = new Level0Item("This is " + i + "th item in Level 0", "subtitle of " + i);
            for (int j = 0; j < lv1Count; j++) {
                Level1Item lv1 = new Level1Item("Level 1 item: " + j, "(no animation)");
                for (int k = 0; k < personCount; k++) {
                    lv1.addSubItem(new Person(nameList[k], random.nextInt(40)));
                }
                lv0.addSubItem(lv1);
            }
            res.add(lv0);
        }
        res.add(new  Level0Item("This is " + lv0Count + "th item in Level 0", "subtitle of " + lv0Count));
        return res;
    }
}
