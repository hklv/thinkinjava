package chapter18;


import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * @author LvHuiKang mailTo lv.huikang@ztesoft.com
 * @Date 2017-0-28 9:45.
 */
public class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
