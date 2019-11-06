package main.com.wjs.jb.abs;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/6
 */
public abstract class IJBObjectElse<Parent> extends IJBAppend{
    public abstract IJBAssemble<? extends IJBObjectElse<Parent>> k(String key);

    public abstract Parent eif();
}
