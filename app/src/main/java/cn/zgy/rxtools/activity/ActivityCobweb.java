package cn.zgy.rxtools.activity;

import android.os.Bundle;
import android.widget.SeekBar;

import cn.zgy.rxtools.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.zgy.rxtool.RxBarTool;
import cn.zgy.rxtool.model.ModelSpider;
import cn.zgy.rxview.activity.ActivityBase;
import cn.zgy.rxview.view.RxCobwebView;
import cn.zgy.rxview.view.RxTitle;
import cn.zgy.rxview.view.colorpicker.ColorPickerView;
import cn.zgy.rxview.view.colorpicker.OnColorChangedListener;
import cn.zgy.rxview.view.colorpicker.OnColorSelectedListener;
import cn.zgy.rxview.view.colorpicker.slider.AlphaSlider;
import cn.zgy.rxview.view.colorpicker.slider.LightnessSlider;

/**
 * @author vondear
 */
public class ActivityCobweb extends ActivityBase implements SeekBar.OnSeekBarChangeListener {

    @BindView(R.id.rx_title)
    RxTitle mRxTitle;
    @BindView(R.id.cobweb_view)
    RxCobwebView mCobwebView;
    @BindView(R.id.seekbar_level)
    SeekBar mSeekbarLevel;
    @BindView(R.id.seekbar_spider_number)
    SeekBar mSeekbarSpiderNumber;
    @BindView(R.id.color_picker_view)
    ColorPickerView mColorPickerView;
    @BindView(R.id.v_lightness_slider)
    LightnessSlider mVLightnessSlider;
    @BindView(R.id.v_alpha_slider)
    AlphaSlider mVAlphaSlider;
    @BindView(R.id.color_picker_view_level)
    ColorPickerView mColorPickerViewLevel;
    @BindView(R.id.v_lightness_slider_level)
    LightnessSlider mVLightnessSliderLevel;
    @BindView(R.id.v_alpha_slider_level)
    AlphaSlider mVAlphaSliderLevel;

    private String[] nameStrs = {
            "金钱", "能力", "美貌", "智慧", "交际",
            "口才", "力量", "智力", "体力", "体质",
            "敏捷", "精神", "耐力", "精通", "急速",
            "暴击", "回避", "命中", "跳跃", "反应",
            "幸运", "魅力", "感知", "活力", "意志"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RxBarTool.setTransparentStatusBar(mContext);
        setContentView(R.layout.activity_cobweb);
        ButterKnife.bind(this);
        mRxTitle.setLeftFinish(mContext);
        mSeekbarLevel.setOnSeekBarChangeListener(this);
        mSeekbarSpiderNumber.setOnSeekBarChangeListener(this);

        mColorPickerView.addOnColorChangedListener(new OnColorChangedListener() {
            @Override
            public void onColorChanged(int selectedColor) {
                // Handle on color change
                mCobwebView.setSpiderColor(selectedColor);
            }
        });
        mColorPickerView.addOnColorSelectedListener(new OnColorSelectedListener() {
            @Override
            public void onColorSelected(int selectedColor) {
                //mCobwebView.setSpiderColor(selectedColor);
            }
        });
        mColorPickerViewLevel.addOnColorChangedListener(new OnColorChangedListener() {
            @Override
            public void onColorChanged(int selectedColor) {
                mCobwebView.setSpiderLevelColor(selectedColor);
            }
        });
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.seekbar_level:
                mCobwebView.setSpiderMaxLevel(progress + 1);
                break;
            case R.id.seekbar_spider_number:
                int number = progress + 1;
                List<ModelSpider> modelSpiders = new ArrayList<>();
                List<ModelSpider> modelSpiders2 = new ArrayList<>();
                for (int i = 0; i < number; i++) {
                    modelSpiders.add(new ModelSpider(nameStrs[i], 1 + new Random().nextInt(mCobwebView.getSpiderMaxLevel())));
                    modelSpiders2.add(new ModelSpider(nameStrs[i], 1 + new Random().nextInt(mCobwebView.getSpiderMaxLevel())));
                }
                mCobwebView.setSpiderList(modelSpiders);
                mCobwebView.setSpiderList2(modelSpiders2);
                break;
                default:
                    break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
