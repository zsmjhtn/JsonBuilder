package main.com.wjs.jb.abs;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/12
 */
public interface IJBArrayFor<ParentType extends IJBAppend, T> {
    IJBArrayForIter<ParentType> it(IJBArrayIter<T> iter);
    IJBArrayForIter<ParentType> it();
}
