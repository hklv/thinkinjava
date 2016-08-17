package chapter8;

/**
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/8/17
 */
public class RoundGraph extends Graph {
    private int radius = 1;

    RoundGraph(int r) {
        radius = r;
        System.out.println("RoundGraph,radius = " + r);
    }

    void draw() {
        System.out.println("RoundGraph.draw(),radius = " + radius);
    }
}
