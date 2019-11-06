package main.com.wjs.jb.imp;

import main.com.wjs.jb.abs.IJBFilter;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/5
 */
public interface JBConstants {
    public static final IJBFilter DEFAULT_FILTER = new IJBFilter() {
        public boolean filter(JBEntry entry) {
            return entry != null && JBUtils.b(entry.getValue());
        }
    };
}
