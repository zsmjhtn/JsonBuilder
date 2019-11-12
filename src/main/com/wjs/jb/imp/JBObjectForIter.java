package main.com.wjs.jb.imp;

import main.com.wjs.jb.abs.IJBAppend;
import main.com.wjs.jb.abs.IJBBase;
import main.com.wjs.jb.abs.IJBObjectForIter;
import main.com.wjs.jb.abs.IJBObjectIter;

import java.util.Collection;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/12
 */
public class JBObjectForIter <GrandParentType extends IJBAppend, T> extends IJBBase implements IJBObjectForIter<GrandParentType>{

    private final GrandParentType grandParent;
    private final Collection<T> collection;
    private final boolean reality;
    private IJBObjectIter<T> iter;

    public JBObjectForIter(JB jb, GrandParentType parent, Collection<T> ts, IJBObjectIter iter, boolean reality) {
        this.grandParent = parent;
        this.reality = reality;
        this.collection = ts;
        this.iter = iter;
    }

    @Override
    public GrandParentType efor() {
        if(reality() && collection != null && iter != null){
            int i = 0;
            for (T t : collection){
                JBEntry entry = iter.iter(++i, t);
                if(entry != null){
                    grandParent.append(entry.getKey(), entry.getValue());
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
