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
        if(reality()) {
            parent.append(key, value);
        }
        return new JBAssembleElsePrepareEnd<ParentType>(parent, reality());
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
