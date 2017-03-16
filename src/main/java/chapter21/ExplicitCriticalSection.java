package chapter21;

/**
 * Created by hklv on 2016/7/23.
 */
public class ExplicitCriticalSection {
    public static void main(String[] args) throws Exception {

        PairManager pairManager1 = new ExplicitPairManager1();
        PairManager pairManager2 = new ExplicitPairManager2();
        CriticalSection.testApproaches(pairManager1, pairManager2);
    }
}
