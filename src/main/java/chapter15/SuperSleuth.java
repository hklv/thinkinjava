package chapter15;

/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2016/11/29 16:09.
 */
public class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER> {
    SuperSleuth(POWER power) {
        super(power);
    }

    void see(){
        power.seeThroughWalls();
    }
}
