package main.com.wjs.jb.imp;

import main.com.wjs.jb.abs.*;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/5
 */
public class JBArray<ParentType extends IJBAppend> extends IJBArray<ParentType> implements JBConstants {

    private final JB jb;
    private final boolean reality;
    private final ParentType parent;
    private final String key;
    private final IJBFilter filter;
    private Object target;

    public JBArray(ParentType parent, String key, JB jb, boolean reality, IJBFilter filter) {
        this.jb = jb;
        this.reality = reality;
        this.parent = parent;
        this.key = key;
        this.filter = filter;
    }

    @Override
    public IJBObject<? extends IJBArray<ParentType>> o() {
        return null;
    }

    @Override
    public JBArray<JBArray<ParentType>> a(IJBFilter filter) {
        return new JBArray<JBArray<ParentType>>(this, null, jb, true, filter);
    }

    @Override
    public JBArray<JBArray<ParentType>> a() {
        return a(null);
    }


    @Override
    public JBArray<ParentType> v(Object value) {
        if (reality()) {
            append(null, value);
        }
        return this;
    }

    @Override
    public ParentType ea() {
        if (reality()) {
            parent.append(key, target == null ? jb.jsonAdapter().emptyArray() : target);
        }
        return parent;
    }

    @Override
    public void append(String key, Object value) {
        JBEntry jbEntry = JBUtils.safeFilter(key, value, jb.filters());
        if (jbEntry != null) {
            jbEntry = JBUtils.safeFilter(key, value, filter);
        }
        if (jbEntry != null) {
            jb.jsonAdapter().appendArray(safeTarget(), key, value);
        }
    }

    private Object safeTarget() {
        if (target == null) {
            target = jb.jsonAdapter().array();
        }
        return target;
    }

    @Override
    public boolean reality() {
        return reality;
    }
}
