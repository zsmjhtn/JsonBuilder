package main.com.wjs.jb.imp;


import main.com.wjs.jb.abs.IJBFilter;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/5
 */
public final class JBUtils {


    static boolean b(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }

        if (obj instanceof String) {
            return ((String) obj).length() > 0;
        }

        if (obj instanceof Collection) {
            return ((Collection<?>) obj).size() > 0;
        }

        if (obj.getClass().isArray()) {
            int i = ((Object[]) obj).length;
            return i > 0;
        }

        return true;
    }

    static <T> T[] arrayCat(T[] a, T[] b) {
        if (b == null || b.length == 0) {
            return a;
        } else if (a == null || a.length == 0) {
            return b;
        }
        T[] c = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        return c;
    }

    static JBEntry safeFilter(String key, Object value, IJBFilter... filters) {
        JBEntry entry = new JBEntry(key, value);
        if (filters != null){
            for (IJBFilter filter : filters){
                if(filter != null && !filter.filter(entry)){
                    return null;
                }
            }
        }
        return entry;

    }
}
