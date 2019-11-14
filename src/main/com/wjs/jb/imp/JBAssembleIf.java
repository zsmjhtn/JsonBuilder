package main.com.wjs.jb.imp;

import main.com.wjs.jb.abs.IJBAppend;
import main.com.wjs.jb.abs.IJBAssembleIf;
import main.com.wjs.jb.abs.IJBAssembleIfPrepareEnd;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/7
 */
public class JBAssembleIf<ParentType extends IJBAppend> extends IJBAssembleIf<ParentType> implements JBConstants {

    private final JB jb;
    private final boolean brotherReality;
    private final boolean selfReality;
    private final ParentType parent;
    private final String key;

    public JBAssembleIf(JB jb, ParentType parent, String key, boolean brotherReality, boolean selfReality) {
        this.jb = jb;
        this.parent = parent;
        this.brotherReality = brotherReality;
        this.selfReality = selfReality;
        this.key = key;
    }

    @Override
    public JBAssembleIfPrepareEnd<ParentType> v(Object value) {
        if(reality()) {
            parent.append(key, value);
        }
        return new JBAssembleIfPrepareEnd<ParentType>(jb, parent, key, reality());
    }

    @Override
    public void append(String key, Object value) {
        // deal in "v" scope
    }

    @Override
    public boolean reality() {
        return parent.reality() && (!brotherReality) && selfReality;
    }
}
