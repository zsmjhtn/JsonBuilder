package main.com.wjs.jb.abs;

import main.com.wjs.jb.imp.JBEntry;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/5
 */
public interface IJBFilter {
    /**
     * if true then include, else exclude
     */
    boolean filter( JBEntry entry );
}
