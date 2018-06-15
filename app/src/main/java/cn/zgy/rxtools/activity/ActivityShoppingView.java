package cn.zgy.rxtools.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import cn.zgy.rxtools.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zgy.rxtool.RxActivityTool;
import cn.zgy.rxtool.RxBarTool;
import cn.zgy.rxview.activity.ActivityBase;
import cn.zgy.rxview.view.RxShoppingView;
import cn.zgy.rxview.view.RxTitle;

/**
 * @author vondear
 */
public class ActivityShoppingView extends ActivityBase {

    @BindView(R.id.sv_1)
    RxShoppingView mSv1;
    @BindView(R.id.sv_2)
    RxShoppingView mSv2;
    @BindView(R.id.btn_take_out)
    Button mBtnTakeOut;
    @BindView(R.id.activity_shopping_view)
    LinearLayout mActivityShoppingView;
    @BindView(R.id.rx_title)
    RxTitle mRxTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBarTool.noTitle(this);
        setContentView(R.layout.activity_shopping_view);
        ButterKnife.bind(this);
        mRxTitle.setLeftFinish(mContext);

    }

    @OnClick(R.id.btn_take_out)
    public void onClick() {
        RxActivityTool.skipActivity(mContext, ActivityELMe.class);
    }
}
