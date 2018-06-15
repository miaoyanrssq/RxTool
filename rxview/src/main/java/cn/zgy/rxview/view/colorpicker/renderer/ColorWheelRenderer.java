package cn.zgy.rxview.view.colorpicker.renderer;



import java.util.List;

import cn.zgy.rxview.view.colorpicker.ColorCircle;

/**
 * @author vondear
 */
public interface ColorWheelRenderer {
    float GAP_PERCENTAGE = 0.025f;

    void draw();

    ColorWheelRenderOption getRenderOption();

    void initWith(ColorWheelRenderOption colorWheelRenderOption);

    List<ColorCircle> getColorCircleList();
}
