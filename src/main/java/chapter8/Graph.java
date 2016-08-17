package chapter8;

/**
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/8/17
 */
public class Graph {
    void draw() {
        System.out.println("Graph.draw()");
    }

    Graph() {
        System.out.println("Graph before draw()");
        draw();
        System.out.println("Graph after draw()");
    }
}
