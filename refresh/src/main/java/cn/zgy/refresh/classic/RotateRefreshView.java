package cn.zgy.refresh.classic;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;


import cn.zgy.refresh.R;
import cn.zgy.refresh.Refresh;


public class RotateRefreshView extends FrameLayout implements Refresh {


    private final int ROTATION_ANIMATION_DURATION = 1200;

    private final Animation mRotateAnimation;


    private ImageView ivRotate;

    private  int rotateHight ;


    public RotateRefreshView(Context context) {
        this(context, null);
    }

    public RotateRefreshView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RotateRefreshView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mRotateAnimation = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        rotateHight=(int) getResources().getDimension(R.dimen.refresh_height_rotate);

       View v=  LayoutInflater.from(context).inflate(R.layout.layout_rotate_refresh,null);

        addView(v);



        LayoutParams params = (LayoutParams) v.getLayoutParams();
        params.height = rotateHight;
        v.setLayoutParams(params);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        ivRotate = (ImageView) findViewById(R.id.ivRotate);


        ivRotate.setScaleType(ScaleType.MATRIX);


        mRotateAnimation.setInterpolator(new LinearInterpolator());
        mRotateAnimation.setDuration(ROTATION_ANIMATION_DURATION);
        mRotateAnimation.setRepeatCount(Animation.INFINITE);
        mRotateAnimation.setRepeatMode(Animation.RESTART);

    }

    @Override
    public void onPrepare() {

    }


  

  

    @Override
    public void onRelease() {
        ivRotate.startAnimation(mRotateAnimation);
    }

    @Override
    public void onReleaseNoEnough(float currentPercent) {

    }

    @Override
    public void onComplete() {
        
    }

    @Override
    public void onPositionChange(float currentPercent) {



        ViewCompat.setRotation(ivRotate,currentPercent*rotateHight);
        
    }

    @Override
    public void setIsHeaderOrFooter(boolean isHeader) {

    }

  

    @Override
    public void onReset() {
        resetImageRotation();
    }


    private void resetImageRotation() {

        ivRotate.clearAnimation();

    }

}
