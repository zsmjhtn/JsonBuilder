package main.com.wjs.jb.imp;

import main.com.wjs.jb.abs.*;

import java.util.Collection;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/12
 */
public class JBObjectFor<ParentType extends IJBAppend, T> extends IJBBase implements IJBObjectFor<ParentType, T>{

    private final JB jb;
    private final ParentType parent;
    private final Collection<T> collection;
    private final boolean reality;

    public JBObjectFor(JB jb, ParentType parent, Collection<T> ts, boolean reality) {
        this.jb = jb;
        this.parent = parent;
        this.reality = reality;
        this.collection = ts;
    }

    @Override
    public JBObjectForIter<ParentType, T> it(IJBObjectIter<T> iter) {
        return new JBObjectForIter<ParentType, T>(jb, parent, collection, iter, reality());
    }

    @Override
    public boolean reality() {
        return reality;
    }
}
