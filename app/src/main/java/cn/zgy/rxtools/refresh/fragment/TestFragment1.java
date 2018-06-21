package cn.zgy.rxtools.refresh.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.canyinghao.canadapter.CanHolderHelper;
import com.canyinghao.canadapter.CanRVAdapter;
import com.canyinghao.canrecyclerview.RecyclerViewEmpty;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.zgy.rxtools.R;

/**
 * Created by canyinghao on 2016/12/6.
 */

public class TestFragment1 extends BaseFragment {


    @BindView(R.id.recycler)
    RecyclerViewEmpty recycler;

    public static TestFragment1 newInstance() {
        TestFragment1 fragment = new TestFragment1();

        return fragment;
    }


    @Override
    public void initView(Bundle savedInstanceState) {

        setContentView(R.layout.fragment_test1);
        ButterKnife.bind(this, rootView);

        recycler.setLayoutManager(new LinearLayoutManager(context));


        CanRVAdapter<String>  adapter = new CanRVAdapter<String>(recycler,R.layout.item_main) {
            @Override
            protected void setView(CanHolderHelper helper, int position, String bean) {

            }

            @Override
            protected void setItemListener(CanHolderHelper helper) {

            }
        };


        for(int i=0;i<40;i++){

            adapter.addLastItem("xxx");
        }


        recycler.setAdapter(adapter);




    }

    @Override
    public void initListener(Bundle savedInstanceState) {

    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }


}
