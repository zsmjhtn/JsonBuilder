package main.com.wjs.jb.imp;

import main.com.wjs.jb.abs.*;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/11
 */
public class JBArrayElse<ParentType extends IJBAppend> extends IJBArrayElse<ParentType> implements JBConstants {

    private final JB jb;
    private final boolean reality;
    private final ParentType parent;

    public JBArrayElse(JB jb, ParentType parent, boolean reality) {
        this.jb = jb;
        this.reality = reality;
        this.parent = parent;
    }

    @Override
    public JBArrayElse<ParentType> v(Object value) {
        if(reality()){
            this.append(null, value);
        }
        return this;
    }

    @Override
    public ParentType eif() {
        return parent;
    }

    @Override
    public JBObject<JBArrayElse<ParentType>> o() {
        return o(null);
    }

    @Override
    public JBObject<JBArrayElse<ParentType>> o(IJBFilter filter) {
        return new JBObject<JBArrayElse<ParentType>>(jb,null,this,true,filter);
    }

    @Override
    public JBArray<JBArrayElse<ParentType>> a() {
        return a(null);
    }

    @Override
    public JBArray<JBArrayElse<ParentType>> a(IJBFilter filter) {
        return new JBArray<JBArrayElse<ParentType>>(this, null, jb,true,filter);
    }

    @Override
    public void append(String key, Object value) {
        if(reality()){
            parent.append(key, value);
        }
    }

    @Override
    public boolean reality() {
        return parent.reality() && !reality;
    }
}
