package main.com.wjs.jb.abs;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/7
 */
public abstract class IJBAssembleElse<Parent> extends IJBAppend {
    public abstract IJBAssembleElsePrepareEnd<Parent> v(Object value);

}
