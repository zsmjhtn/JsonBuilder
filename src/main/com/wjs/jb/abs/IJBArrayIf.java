package main.com.wjs.jb.abs;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/5
 */
public abstract class IJBArrayIf<Parent> extends IJBAppend{
    //append v
    public abstract IJBArrayIf<Parent> v(Object value);

    public abstract IJBArrayIf<Parent> elseif(boolean if_);
    public abstract IJBArrayIf<Parent> elseif(Object if_);

    public abstract IJBArrayElse<Parent> else_();

    //append object
    public abstract IJBObject<? extends IJBArrayIf<Parent>> o();
    public abstract IJBObject<? extends IJBArrayIf<Parent>> o(IJBFilter filter);

    //append array
    public abstract IJBArray<? extends IJBArrayIf<Parent>> a();
    public abstract IJBArray<? extends IJBArrayIf<Parent>> a(IJBFilter filter);

    public abstract Parent eif() ;

}
