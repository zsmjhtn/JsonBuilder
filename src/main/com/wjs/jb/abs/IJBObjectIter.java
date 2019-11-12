package main.com.wjs.jb.abs;

import main.com.wjs.jb.imp.JBEntry;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/12
 */
public interface IJBObjectIter<T>{

    JBEntry iter(int index, T t);
}
