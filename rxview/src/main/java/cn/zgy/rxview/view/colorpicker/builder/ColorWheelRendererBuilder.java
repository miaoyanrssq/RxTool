package cn.zgy.rxview.view.colorpicker.builder;


import cn.zgy.rxview.view.colorpicker.ColorPickerView;
import cn.zgy.rxview.view.colorpicker.renderer.ColorWheelRenderer;
import cn.zgy.rxview.view.colorpicker.renderer.FlowerColorWheelRenderer;
import cn.zgy.rxview.view.colorpicker.renderer.SimpleColorWheelRenderer;

/**
 * @author vondear
 */
public class ColorWheelRendererBuilder {
    public static ColorWheelRenderer getRenderer(ColorPickerView.WHEEL_TYPE wheelType) {
        switch (wheelType) {
            case CIRCLE:
                return new SimpleColorWheelRenderer();
            case FLOWER:
                return new FlowerColorWheelRenderer();
                default:
                    break;
        }
        throw new IllegalArgumentException("wrong WHEEL_TYPE");
    }
}