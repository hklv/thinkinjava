package chapter21;

/**
 * Created by hklv on 2016/7/12.
 */
public class MoreBasicThreads {
    public static void main(String[] args){
        for (int i=0;i<5;i++){
            new Thread(new LiftOff()).start();
            System.out.println("Waiting for chapter21.LiftOff");
        }
    }
}
