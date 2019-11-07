package main.com.wjs.jb.abs;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/7
 */
public abstract class IJBAssembleIfPrepareEnd<Parent extends IJBAppend> extends IJBAppend{
    public abstract IJBAssembleIf<Parent>  elseif(boolean if_);
    public abstract IJBAssembleIf<Parent>  elseif(Object if_);

    public abstract IJBAssembleElse<Parent>  else_();

    /***
     * Parent is IJBObject
     */
    public abstract Parent eif();
}
