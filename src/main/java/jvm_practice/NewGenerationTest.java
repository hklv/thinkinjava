package jvm_practice;

/**
 * @Author: HuiKang Lv
 * @Description: 新生代空间测试
 * @Date: create at 2018/1/8 22:24
 */
public class NewGenerationTest {
    public static void main(String[] args){
        byte[] b = null;
        for (int i = 0;i<10;i++){
            b = new byte[1*1024*1024];
        }
    }
}
