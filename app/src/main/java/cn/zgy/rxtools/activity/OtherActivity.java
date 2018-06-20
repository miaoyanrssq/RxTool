package cn.zgy.rxtools.activity;


import android.os.Bundle;
import android.view.View;

import cn.zgy.rxtool.RxActivityTool;
import cn.zgy.rxtools.R;
import cn.zgy.rxtools.multitype.normal.NormalActivity;
import cn.zgy.rxview.activity.ActivityBase;

public class OtherActivity extends ActivityBase implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        initView();
    }

    private void initView() {
        findViewById(R.id.banner).setOnClickListener(this);
        findViewById(R.id.multitype).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.banner){
            RxActivityTool.skipActivity(this, BannerActivity.class);
        }

        if(v.getId() == R.id.multitype){
            RxActivityTool.skipActivity(this, NormalActivity.class);
        }
    }
}
