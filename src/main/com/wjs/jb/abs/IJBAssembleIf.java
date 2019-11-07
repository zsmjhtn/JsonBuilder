package main.com.wjs.jb.abs;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/7
 */
public abstract class IJBAssembleIf<Parent extends IJBAppend> extends IJBAppend{
    public abstract IJBAssembleIfPrepareEnd<Parent> v(Object value);
}
