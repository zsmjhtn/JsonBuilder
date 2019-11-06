package main.com.wjs.jb.abs;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/6
 */
public abstract class IJBObjectIf<Parent> extends IJBAppend{
    public abstract IJBAssemble<? extends IJBObjectIf<Parent>> k(String key);

    public abstract IJBObjectIf<? extends IJBObjectIf<Parent>> if_(boolean _if) ;

    public abstract IJBObjectIf<? extends IJBObjectIf<Parent>> if_(Object _if) ;

    public abstract IJBObjectIf<Parent> elseif(boolean _if);

    public abstract IJBObjectIf<Parent> elseif(Object _if);

    public abstract IJBObjectElse<Parent> else_();

    public abstract Parent eif();

}
