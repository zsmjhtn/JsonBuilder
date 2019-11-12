package main.com.wjs.jb.imp;

import main.com.wjs.jb.abs.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/5
 */
public class JBObject<ParentType extends IJBAppend> extends IJBObject<ParentType> implements JBConstants {

    private final JB jb;
    private final boolean reality;
    private final ParentType parent;
    private final String key;
    private final IJBFilter filter;
    private Object target;

    public JBObject(JB jb, String key, ParentType parent, boolean reality, IJBFilter filter) {
        this.jb = jb;
        this.reality = reality;
        this.parent = parent;
        this.key = key;
        this.filter = filter;
    }

    @Override
    public JBAssemble<JBObject<ParentType>> k(String key) {
        return new JBAssemble<JBObject<ParentType>>(jb, this, key, true);
    }

    @Override
    public ParentType eo() {
        if (reality()) {
            parent.append(key, target == null ? jb.jsonAdapter().emptyObject() : target);
        }
        return parent;
    }

    @Override
    public JBObjectIf<JBObject<ParentType>> if_(Object _if) {
        boolean b = JBUtils.b(_if);
        return if_(b);
    }

    @Override
    public <T> JBObjectFor<JBObject<ParentType>, T> for_(T[] ts) {
        List<T> list = ts != null ? Arrays.asList(ts) : null;
        return for_(list);
    }

    @Override
    public <T> JBObjectFor<JBObject<ParentType>, T> for_(Collection<T> ts) {
        return new JBObjectFor<JBObject<ParentType>, T>(jb, this, ts, reality);
    }

    @Override
    public JBObjectIf<JBObject<ParentType>> if_(boolean _if) {
        return new JBObjectIf<JBObject<ParentType>>(jb, this, false, _if);
    }

    @Override
    public void append(String key, Object value) {
        JBEntry jbEntry = JBUtils.safeFilter(key, value, jb.filters());
        if (jbEntry != null) {
            jbEntry = JBUtils.safeFilter(key, value, filter);
        }
        if (jbEntry != null) {
            jb.jsonAdapter().appendObject(safeTarget(), key, value);
        }
    }

    private Object safeTarget() {
        if (target == null) {
            target = jb.jsonAdapter().object();
        }
        return target;
    }

    @Override
    public boolean reality() {
        return reality;
    }
}
