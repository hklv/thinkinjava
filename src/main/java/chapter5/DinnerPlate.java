package chapter5;

/**
 * Created by hklv on 2016/8/14.
 */
public class DinnerPlate extends Plate {
    DinnerPlate(int i) {
        super(i);
        System.out.println("DinnerPlate Constructor");
    }

    public static void main(String[] args) {
        DinnerPlate dinnerPlate = new DinnerPlate(1);
    }

}
