package main.com.wjs.jb.imp;

import main.com.wjs.jb.abs.*;

import java.util.Collection;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/12
 */
public class JBArrayFor<ParentType extends IJBAppend, T> extends IJBBase implements IJBArrayFor<ParentType, T>, JBConstants{

    private final JB jb;
    private final ParentType parent;
    private final Collection<T> collection;
    private final boolean reality;

    public JBArrayFor(JB jb, ParentType parent, boolean reality, Collection<T> ts) {
        this.jb = jb;
        this.parent = parent;
        this.reality = reality;
        this.collection = ts;
    }

    @Override
    public JBArrayForIter<ParentType, T> it(IJBArrayIter<T> iter) {
        return new JBArrayForIter<ParentType, T>(parent, collection, iter, reality());
    }

    @SuppressWarnings("unchecked")
    @Override
    public JBArrayForIter<ParentType, T> it() {
        return it(DEFAULT_ARRAY_FILTER);
    }

    @Override
    public boolean reality() {
        return reality;
    }
}
