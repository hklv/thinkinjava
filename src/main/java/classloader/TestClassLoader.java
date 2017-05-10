package classloader;

/**
 * @author LvHuiKang mailTo lv.huikang@ztesoft.com
 * @Date 2017-05-10 11:29.
 */
public class TestClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("classloader.TestClassLoader$UnderTestClassLoader1");
        TestClassLoader.class.getClassLoader().loadClass("classloader.TestClassLoader$UnderTestClassLoader2");
    }

    public static class UnderTestClassLoader1 {
        public static String testStr;

        static {
            testStr = "test1";
            System.out.println(testStr);
        }
    }

    public static class UnderTestClassLoader2 {
        public static String testStr;

        static {
            testStr = "test2";
            System.out.println(testStr);
        }
    }
}
