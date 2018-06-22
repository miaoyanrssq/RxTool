package cn.zgy.rxtools.switchview;

import android.os.Bundle;
import android.transition.Slide;
import android.widget.TextView;

import cn.zgy.rxtools.R;
import cn.zgy.rxview.activity.ActivityBase;
import cn.zgy.switchview.SwitchView;

public class SwitchViewActivity extends ActivityBase implements SwitchView.SlideListener{

    TextView txt;
    SwitchView slide;
    SwitchView slide2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switchview);

        initView();

    }

    private void initView() {
        slide = (SwitchView) findViewById(R.id.swit);
        slide2 = (SwitchView) findViewById(R.id.swit2);

        //初始化
        slide.setState(false);
        txt = (TextView) findViewById(R.id.txt);
        slide.setSlideListener(this);
    }

    //监听状态
    @Override
    public void open() {
        txt.setText("first switch is opend, and set the second one is 'slideable'");
        slide2.setSlideable(true);
    }

    @Override
    public void close() {
        txt.setText("first switch is closed,and set the second one is 'unslideable'");
        slide2.setSlideable(false);
    }
}
