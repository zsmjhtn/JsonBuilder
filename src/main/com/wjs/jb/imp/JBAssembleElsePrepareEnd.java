package main.com.wjs.jb.imp;

import main.com.wjs.jb.abs.IJBAppend;
import main.com.wjs.jb.abs.IJBAssembleElsePrepareEnd;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/7
 */
public class JBAssembleElsePrepareEnd<ParentType extends IJBAppend> extends IJBAssembleElsePrepareEnd<ParentType> implements JBConstants{

    private final boolean brotherReality;
    private final ParentType parent;


    public JBAssembleElsePrepareEnd(ParentType parent, boolean brotherReality) {
        this.parent = parent;
        this.brotherReality = brotherReality;
    }

    @Override
    public ParentType eif() {
        return parent;
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
