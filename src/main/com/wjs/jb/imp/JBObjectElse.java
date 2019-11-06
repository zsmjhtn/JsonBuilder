package main.com.wjs.jb.imp;

import main.com.wjs.jb.abs.IJBAppend;
import main.com.wjs.jb.abs.IJBObjectElse;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/6
 */
public class JBObjectElse<ParentType extends IJBAppend> extends IJBObjectElse<ParentType> implements JBConstants {

    private final JB jb;
    private final ParentType parent;
    private final boolean brotherReality;

    JBObjectElse(JB jb, ParentType parent, boolean brotherReality) {
        this.jb = jb;
        this.parent = parent;
        this.brotherReality = brotherReality;
    }

    @Override
    public JBAssemble<JBObjectElse<ParentType>> k(String key) {
        return new JBAssemble<JBObjectElse<ParentType>>(jb, this, key, reality());
    }

    @Override
    public ParentType eif() {
        return parent;
    }

    @Override
    public void append(String key, Object value) {
        if(reality()){
            parent.append(key, value);
        }
    }

    @Override
    public boolean reality() {
        return parent.reality() && !brotherReality;
    }
}
