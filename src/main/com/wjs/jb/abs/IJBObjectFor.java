package main.com.wjs.jb.abs;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/12
 */
public interface IJBObjectFor<ParentType extends IJBAppend, T> {
    IJBObjectForIter<ParentType> it(IJBObjectIter<T> iter);
}
