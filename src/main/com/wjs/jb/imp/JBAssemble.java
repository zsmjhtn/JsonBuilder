package main.com.wjs.jb.imp;

import main.com.wjs.jb.abs.IJBAppend;
import main.com.wjs.jb.abs.IJBAssemble;
import main.com.wjs.jb.abs.IJBFilter;

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
    public void append(String key, Object value) {

    }

    @Override
    public boolean reality() {
        return reality;
    }
}
