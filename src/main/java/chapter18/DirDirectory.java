package chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author LvHuiKang mailTo lv.huikang@ztesoft.com
 * @Date 2017-04-28 10:23.
 */
public class DirDirectory {
    public static File[] local(File dir, final String regex) {
        return dir.listFiles(new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
    }

    public static File[] local(String path, final String regex) {
        return local(new File(path), regex);
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();

        public Iterator<File> iterator() {
            return files.iterator();
        }

        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) + "\n\nfiles: " + PPrint.pformat(files);
        }

        public static TreeInfo walk(File start, String regex) {
            return recurseDirs(start, regex);
        }

        public static TreeInfo walk(File start) {
            return recurseDirs(start, ".*");
        }

        public static TreeInfo walk(String start) {
            return recurseDirs(new File(start), ".*");
        }


        private static TreeInfo recurseDirs(File start, String regex) {
            TreeInfo result = new TreeInfo();
            for (File fileItem : start.listFiles()) {
                if (fileItem.isDirectory()) {
                    result.dirs.add(fileItem);
                } else if (fileItem.getName().matches(regex)) {
                    result.files.add(fileItem);
                }
            }
            return result;
        }

        public static void main(String[] args) {
            System.out.println(walk("."));
        }

    }
}
