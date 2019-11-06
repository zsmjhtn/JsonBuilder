package main.com.wjs.jb.imp;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/5
 */
public class JBEntry {
    private String key;
    private Object value;

    public JBEntry(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    JBEntry() {
        this(null, null);
    }

    /**
     * get key
     *
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * set key
     *
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * get value
     *
     * @return value
     */
    public Object getValue() {
        return value;
    }

    /**
     * set value
     *
     * @param value
     */
    public void setValue(Object value) {
        this.value = value;
    }
}
