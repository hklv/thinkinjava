package chapter21;

/**
 * Created by hklv on 2016/7/23.
 */
public class Accessor implements Runnable {
    private final int id;

    public Accessor(int idn) {
        this.id = idn;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
           ThreadLocalVariableHolder.increment();
            System.out.println(this);
            Thread.yield();
        }
    }
    public String toString(){
        return "#"+id+": "+ThreadLocalVariableHolder.get();
    }
}
