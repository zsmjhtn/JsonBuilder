package main.com.wjs.jb.abs;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/5
 */
public abstract class IJBArrayElse<Parent> extends IJBAppend{

    public abstract IJBArrayElse<Parent> v(Object value);

    public abstract Parent eif();

    public abstract IJBObject<? extends IJBArrayElse<Parent>> o();

    public abstract IJBObject<? extends IJBArrayElse<Parent>> o(IJBFilter filter);

    public abstract IJBArray<? extends IJBArrayElse<Parent>> a();

    public abstract IJBArray<? extends IJBArrayElse<Parent>> a(IJBFilter filter);


}
