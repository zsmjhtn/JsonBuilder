package main.com.wjs.jb.imp;

import main.com.wjs.jb.abs.*;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/6
 */
public class JBObjectIf<ParentType extends IJBAppend> extends IJBObjectIf<ParentType> implements JBConstants {


    private final JB jb;
    private final boolean brotherReality;
    private final boolean selfReality;
    private final ParentType parent;

    public JBObjectIf(JB jb, ParentType parent, boolean brotherReality, boolean selfReality) {
        this.jb = jb;
        this.parent = parent;
        this.brotherReality = brotherReality;
        this.selfReality = selfReality;
    }


    @Override
    public JBAssemble<JBObjectIf<ParentType>> k(String key) {
        return new JBAssemble<JBObjectIf<ParentType>>(jb, this, key, reality());
    }

    @Override
    public JBObjectIf<JBObjectIf<ParentType>> if_(boolean _if) {
        return new JBObjectIf<JBObjectIf<ParentType>>(jb, this, false, _if);
    }

    @Override
    public JBObjectIf<JBObjectIf<ParentType>> if_(Object _if) {
        return if_(JBUtils.b(_if));
    }

    @Override
    public JBObjectIf<ParentType> elseif(boolean _if) {
        return new JBObjectIf<ParentType>(jb, parent, brotherReality || selfReality, _if);
    }

    @Override
    public JBObjectIf<ParentType> elseif(Object _if) {
        return elseif(JBUtils.b(_if));
    }

    @Override
    public JBObjectElse<ParentType> else_() {
        return new JBObjectElse<ParentType>(jb, parent, (brotherReality || selfReality));
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
        return parent.reality() && (!brotherReality) && selfReality;
    }
}
