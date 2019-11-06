package main.com.wjs.jb.imp;

import main.com.wjs.jb.abs.IJBAppend;
import main.com.wjs.jb.abs.IJBFilter;
import main.com.wjs.jb.abs.IJBJsonAdapter;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/5
 */
public abstract class JB extends IJBAppend {
    private IJBFilter[] globalFilters;
    private Object root;

    public JB() {
    }

    protected abstract IJBJsonAdapter jsonAdapter();

    public IJBFilter[] filters() {
        return globalFilters;
    }

    public JB addFilters(IJBFilter... filters) {
        this.globalFilters = JBUtils.arrayCat(globalFilters, filters);
        return this;
    }

    public Object json() {
        return root;
    }

    public JBObject<JB> o() {
        return this.o(null);
    }

    public JBObject<JB> o(IJBFilter filter) {
        return new JBObject<JB>(this, null, this, true, filter);
    }

    public JBArray<JB> a() {
        return this.a(null);
    }

    public JBArray<JB> a(IJBFilter filter) {
        return new JBArray<JB>(this, null, this, true, filter);
    }

    @Override
    public boolean reality() {
        //unused
        return false;
    }

    @Override
    public void append(String key, Object value) {
        root = value;
    }
}
