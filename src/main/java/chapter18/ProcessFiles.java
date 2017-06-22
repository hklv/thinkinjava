package chapter18;

import java.io.File;

/**
 * @author LvHuiKang mailTo lv.huikang@ztesoft.com
 * @Date 2017-06-21 11:51.
 */
public class ProcessFiles {
    public interface Strategy{
        void process(File file);
    }

    private Strategy strategy;
    private String ext;
    public ProcessFiles(Strategy strategy,String ext){
        this.strategy  = strategy;
        this.ext = ext;
    }

    public void start(String[] args){

    }

    public void processDirectoryTree(File root){
    }
}
