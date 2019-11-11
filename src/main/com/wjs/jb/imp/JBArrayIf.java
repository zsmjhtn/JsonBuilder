package main.com.wjs.jb.imp;

import main.com.wjs.jb.abs.IJBAppend;
import main.com.wjs.jb.abs.IJBArrayIf;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/11
 */
public class JBArrayIf<ParentType extends IJBAppend> extends IJBArrayIf<ParentType> implements JBConstants{

    private final JB jb;
    private final boolean selfReality;
    private final boolean brotherReality;
    private final ParentType parent;

    public JBArrayIf(JB jb, ParentType parent,  boolean brotherReality, boolean selfReality) {
        this.jb = jb;
        this.brotherReality = brotherReality;
        this.selfReality = selfReality;
        this.parent = parent;
    }

    @Override
    public IJBArrayIf<ParentType> v(Object value) {
        if(reality()){
            this.append(null, value);
        }
        return this;
    }

    @Override
    public IJBArrayIf<ParentType> elseif(boolean if_) {
        return new JBArrayIf<>(jb, parent, brotherReality || selfReality, if_);
    }

    @Override
    public IJBArrayIf<ParentType> elseif(Object if_) {
        return elseif(JBUtils.b(if_));
    }

    @Override
    public JBArrayElse<ParentType> else_() {
        return new JBArrayElse<ParentType>(jb, parent, brotherReality || selfReality);
    }

    @Override
    public void append(String key, Object value) {
        if(reality()){
            parent.append(key, value);
        }
    }

    @Override
    public boolean reality() {
        return  parent.reality() && (!brotherReality) && selfReality;
    }
}
