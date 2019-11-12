package main.com.wjs.jb.abs;

import java.util.Collection;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/5
 */
public abstract class IJBArray<Parent> extends IJBAppend{
    public abstract IJBObject<? extends IJBArray<Parent>> o();

    public abstract IJBArray<? extends IJBArray<Parent>> a();
    public abstract IJBArray<? extends IJBArray<Parent>> a(IJBFilter filter);

    public abstract IJBArray<Parent> v(Object value);

    public abstract IJBArrayIf<? extends IJBArray<Parent>> if_(boolean if_);
    public abstract IJBArrayIf<? extends IJBArray<Parent>> if_(Object if_);

    public abstract Parent ea() ;

    public abstract <T> IJBArrayFor<? extends IJBArray<Parent>, T> for_(T[] t);
    public abstract <T> IJBArrayFor<? extends IJBArray<Parent>, T> for_(Collection<T> collection);

    public abstract IJBArray<Parent> parse(Object... beans);
}
