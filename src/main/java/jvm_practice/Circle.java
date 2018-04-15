package jvm_practice;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2018/3/14 18:41
 */
public class Circle {
    private double radius = 0;
    public static int count = 1;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void getInnerRadius(){
        System.out.println();
    }
    class Draw {
        private Double radius;

        public Draw(double radius) {
            this.radius = radius;
        }

        public void drawShape() {
            System.out.println("drawShape");
            System.out.println(radius);
            System.out.println(Circle.this.radius);
            System.out.println(count);
        }
    }

    public static void test(){

    }

    public static void main(String[] args) {
        Circle circle = new Circle(1);
        Draw draw = circle.new Draw(2.0);
        draw.drawShape();
    }
}
