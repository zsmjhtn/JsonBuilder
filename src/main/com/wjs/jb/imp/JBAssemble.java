package main.com.wjs.jb.imp;

import main.com.wjs.jb.abs.*;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/5
 */
public class JBAssemble<ParentType extends IJBAppend> extends IJBAssemble<ParentType> implements JBConstants {

    private final JB jb;
    private final String key;
    private final boolean reality;
    private final ParentType parent;

    public JBAssemble(JB jb, ParentType parent, String key, boolean reality) {
        this.jb = jb;
        this.key = key;
        this.reality = reality;
        this.parent = parent;
    }

    @Override
    public ParentType v(Object value) {
        if (reality()) {
            parent.append(key, value);
        }
        return parent;
    }

    @Override
    public JBObject<ParentType> o() {
        return o(null);
    }

    @Override
    public JBObject<ParentType> o(IJBFilter filter) {
        return new JBObject<ParentType>(jb, key, this.parent, true, filter);
    }

    @Override
    public JBAssembleIf<ParentType> if_(boolean if_) {
        return new JBAssembleIf<ParentType>(jb, parent, key, false, if_);
    }

    @Override
    public JBAssembleIf<ParentType> if_(Object if_) {
        return if_(JBUtils.b(if_));
    }

    @Override
    public JBArray<ParentType> a() {
        return a(null);
    }

    @Override
    public JBArray<ParentType> a(IJBFilter filter) {
        return new JBArray<ParentType>(parent, key, jb,true, filter);
    }

    @Override
    public void append(String key, Object value) {

    }

    @Override
    public boolean reality() {
        return reality;
    }
}
