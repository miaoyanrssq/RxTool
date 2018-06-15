package cn.zgy.rxtools.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.zgy.rxtools.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zgy.rxtool.RxVibrateTool;
import cn.zgy.rxview.activity.ActivityBase;
import cn.zgy.rxview.view.RxTitle;

/**
 * @author vondear
 */
public class ActivityVibrate extends ActivityBase {


    @BindView(R.id.btn_vibrate_once)
    Button mBtnVibrateOnce;
    @BindView(R.id.btn_vibrate_Complicated)
    Button mBtnVibrateComplicated;
    @BindView(R.id.btn_vibrate_stop)
    Button mBtnVibrateStop;
    @BindView(R.id.rx_title)
    RxTitle mRxTitle;

    private long[] temp = {100, 10, 100, 1000};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibrate);
        ButterKnife.bind(this);
        mRxTitle.setLeftFinish(mContext);
    }

    @OnClick({R.id.btn_vibrate_once, R.id.btn_vibrate_Complicated, R.id.btn_vibrate_stop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_vibrate_once:
                RxVibrateTool.vibrateOnce(this, 2000);
                break;
            case R.id.btn_vibrate_Complicated:
                RxVibrateTool.vibrateComplicated(this, temp, 0);
                break;
            case R.id.btn_vibrate_stop:
                RxVibrateTool.vibrateStop();
                break;
        }
    }
}
