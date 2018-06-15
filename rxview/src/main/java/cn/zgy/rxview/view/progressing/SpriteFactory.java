package cn.zgy.rxview.view.progressing;


import cn.zgy.rxview.view.progressing.sprite.Sprite;
import cn.zgy.rxview.view.progressing.style.ChasingDots;
import cn.zgy.rxview.view.progressing.style.Circle;
import cn.zgy.rxview.view.progressing.style.CubeGrid;
import cn.zgy.rxview.view.progressing.style.DoubleBounce;
import cn.zgy.rxview.view.progressing.style.FadingCircle;
import cn.zgy.rxview.view.progressing.style.FoldingCube;
import cn.zgy.rxview.view.progressing.style.MultiplePulse;
import cn.zgy.rxview.view.progressing.style.MultiplePulseRing;
import cn.zgy.rxview.view.progressing.style.Pulse;
import cn.zgy.rxview.view.progressing.style.PulseRing;
import cn.zgy.rxview.view.progressing.style.RotatingCircle;
import cn.zgy.rxview.view.progressing.style.RotatingPlane;
import cn.zgy.rxview.view.progressing.style.ThreeBounce;
import cn.zgy.rxview.view.progressing.style.WanderingCubes;
import cn.zgy.rxview.view.progressing.style.Wave;

/**
 * @author vondear
 */
public class SpriteFactory {

    public static Sprite create(Style style) {
        Sprite sprite = null;
        switch (style) {
            case ROTATING_PLANE:
                sprite = new RotatingPlane();
                break;
            case DOUBLE_BOUNCE:
                sprite = new DoubleBounce();
                break;
            case WAVE:
                sprite = new Wave();
                break;
            case WANDERING_CUBES:
                sprite = new WanderingCubes();
                break;
            case PULSE:
                sprite = new Pulse();
                break;
            case CHASING_DOTS:
                sprite = new ChasingDots();
                break;
            case THREE_BOUNCE:
                sprite = new ThreeBounce();
                break;
            case CIRCLE:
                sprite = new Circle();
                break;
            case CUBE_GRID:
                sprite = new CubeGrid();
                break;
            case FADING_CIRCLE:
                sprite = new FadingCircle();
                break;
            case FOLDING_CUBE:
                sprite = new FoldingCube();
                break;
            case ROTATING_CIRCLE:
                sprite = new RotatingCircle();
                break;
            case MULTIPLE_PULSE:
                sprite = new MultiplePulse();
                break;
            case PULSE_RING:
                sprite = new PulseRing();
                break;
            case MULTIPLE_PULSE_RING:
                sprite = new MultiplePulseRing();
                break;
            default:
                break;
        }
        return sprite;
    }
}
