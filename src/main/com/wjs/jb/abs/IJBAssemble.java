package main.com.wjs.jb.abs;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/5
 */
public abstract class IJBAssemble<Parent extends IJBAppend> extends IJBAppend{
    public abstract Parent v(Object value);
    public abstract IJBObject<Parent> o();
    public abstract IJBObject<Parent> o(IJBFilter filter);

    public abstract IJBAssembleIf<Parent> if_(boolean if_);
    public abstract IJBAssembleIf<Parent> if_(Object if_);

    public abstract IJBArray<Parent> a();
    public abstract IJBArray<Parent> a(IJBFilter filter);


}
