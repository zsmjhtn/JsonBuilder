package main.com.wjs.jb.abs;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/5
 */
public abstract class IJBArrayIf<Parent> extends IJBAppend{

    public abstract IJBArrayIf<Parent> v(Object value);

    public abstract IJBArrayIf<Parent> elseif(boolean if_);
    public abstract IJBArrayIf<Parent> elseif(Object if_);

    public abstract IJBArrayElse<Parent> else_();

}
