package chapter17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hklv on 2016/11/18.
 */
public class FillingLists {
    public static void main(String[] args){
        List<StringAddress> list = new ArrayList<StringAddress>(Collections.nCopies(4,new StringAddress("Hello")));
        System.out.println(list);
        Collections.fill(list,new StringAddress("World"));
        System.out.println(list);
    }
}
