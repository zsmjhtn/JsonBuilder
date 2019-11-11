package main.com.wjs.jb.imp;

import main.com.wjs.jb.abs.*;

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
    public JBArrayIf<ParentType> v(Object value) {
        if(reality()){
            this.append(null, value);
        }
        return this;
    }

    @Override
    public JBArrayIf<ParentType> elseif(boolean if_) {
        return new JBArrayIf<>(jb, parent, brotherReality || selfReality, if_);
    }

    @Override
    public JBArrayIf<ParentType> elseif(Object if_) {
        return elseif(JBUtils.b(if_));
    }

    @Override
    public JBArrayElse<ParentType> else_() {
        return new JBArrayElse<ParentType>(jb, parent, brotherReality || selfReality);
    }

    @Override
    public JBObject<JBArrayIf<ParentType>> o() {
        return o(null);
    }

    @Override
    public JBObject<JBArrayIf<ParentType>> o(IJBFilter filter) {
        return new JBObject<JBArrayIf<ParentType>>(jb,null,this,true,filter);
    }

    @Override
    public JBArray<JBArrayIf<ParentType>> a() {
        return a(null);
    }

    @Override
    public JBArray<JBArrayIf<ParentType>> a(IJBFilter filter) {
        return new JBArray<JBArrayIf<ParentType>>(this,null,  jb,true, filter);
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
        return  parent.reality() && (!brotherReality) && selfReality;
    }
}
