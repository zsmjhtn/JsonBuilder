package main.com.wjs.jb.abs;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/5
 */
public abstract class IJBArray<Parent> extends IJBAppend{
    public abstract IJBObject<? extends IJBArray<Parent>> o();
    public abstract IJBArray<? extends IJBArray<Parent>> a();
    public abstract IJBArray<? extends IJBArray<Parent>> a(IJBFilter filter);
    public abstract IJBArray<Parent> v(Object value);
    public abstract Parent ea() ;
}