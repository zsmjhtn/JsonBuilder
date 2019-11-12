package main.com.wjs.jb.imp;

import main.com.wjs.jb.abs.*;

import java.util.Collection;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/12
 */
public class JBArrayForIter<GrandParentType extends IJBAppend, T> extends IJBBase implements IJBArrayForIter<GrandParentType>{

    private final GrandParentType grandParent;
    private final Collection<T> collection;
    private final boolean reality;
    private IJBArrayIter<T> iter;

    public JBArrayForIter(GrandParentType parent, Collection<T> ts, IJBArrayIter<T> iter, boolean reality) {
        this.grandParent = parent;
        this.reality = reality;
        this.collection = ts;
        this.iter = iter;
    }

    @Override
    public GrandParentType efor() {
        if(reality()){
            if(collection != null && iter != null){
                for (T t : collection){
                    Object entry = iter.iter(t);
                    if(entry != null){
                        grandParent.append(null, entry);
                    }
                }
            }
        }
        return grandParent;
    }

    @Override
    public boolean reality() {
        return reality;
    }
}
