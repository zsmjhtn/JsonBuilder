package main.com.wjs.jb.imp;

import main.com.wjs.jb.abs.*;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/7
 */
public class JBAssembleElse<ParentType extends IJBAppend> extends IJBAssembleElse<ParentType> implements JBConstants {


    private final JB jb;
    private final boolean brotherReality;
    private final ParentType parent;
    private final String key;

    public JBAssembleElse(JB jb, ParentType parent, String key, boolean brotherReality) {
        this.jb = jb;
        this.parent = parent;
        this.brotherReality = brotherReality;
        this.key = key;
    }

    @Override
    public JBAssembleElsePrepareEnd<ParentType> v(Object value) {
        if (reality()) {
            parent.append(key, value);
        }
        return new JBAssembleElsePrepareEnd<ParentType>(parent, reality());
    }

    @Override
    public JBObject<JBAssembleElsePrepareEnd<ParentType>> o() {
        return o(null);
    }

    @Override
    public JBObject<JBAssembleElsePrepareEnd<ParentType>> o(IJBFilter filter) {
        JBAssembleElsePrepareEnd<ParentType> end = new JBAssembleElsePrepareEnd<ParentType>(parent, brotherReality);
        return new JBObject<JBAssembleElsePrepareEnd<ParentType>>(jb, key, end, reality(), filter);
    }

    @Override
    public JBArray<JBAssembleElsePrepareEnd<ParentType>> a() {
        return a(null);
    }

    @Override
    public JBArray<JBAssembleElsePrepareEnd<ParentType>> a(IJBFilter filter) {
        JBAssembleElsePrepareEnd<ParentType> end = new JBAssembleElsePrepareEnd<ParentType>(parent, brotherReality);
        return new JBArray<JBAssembleElsePrepareEnd<ParentType>>(end, key, jb, reality(), filter);
    }

    @Override
    public void append(String key, Object value) {
        // deal in "v" scope
    }

    @Override
    public boolean reality() {
        return parent.reality() && !brotherReality;
    }
}
