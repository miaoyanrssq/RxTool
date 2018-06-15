package cn.zgy.rxtools.activity;

import android.os.Bundle;

import cn.zgy.rxtools.R;

import cn.zgy.rxtool.RxBarTool;
import cn.zgy.rxview.activity.ActivityBase;

/**
 * @author vondear
 */
public class ActivityAutoImageView extends ActivityBase {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBarTool.noTitle(this);
        RxBarTool.setTransparentStatusBar(this);
        setContentView(R.layout.activity_auto_image_view);
    }
}
