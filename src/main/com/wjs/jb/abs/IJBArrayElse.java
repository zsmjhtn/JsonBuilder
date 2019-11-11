package main.com.wjs.jb.abs;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/5
 */
public abstract class IJBArrayElse<Parent> extends IJBAppend{

    public abstract IJBArrayElse<Parent> v(Object value);

    public abstract Parent eif();

}
