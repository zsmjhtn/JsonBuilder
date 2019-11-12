package main.com.wjs.jb.abs;

import java.util.Collection;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/5
 */
public abstract class IJBObject<Parent> extends IJBAppend{
    public abstract IJBAssemble<? extends IJBObject<Parent>> k(String key);
    public abstract Parent eo() ;

    public abstract IJBObjectIf<? extends IJBObject<Parent>> if_(boolean _if);
    public abstract IJBObjectIf<? extends IJBObject<Parent>> if_(Object _if);

    public abstract <T> IJBObjectFor<? extends IJBObject<Parent>, T> for_(T[] t);
    public abstract <T> IJBObjectFor<? extends IJBObject<Parent>, T> for_(Collection<T> collection);
}
