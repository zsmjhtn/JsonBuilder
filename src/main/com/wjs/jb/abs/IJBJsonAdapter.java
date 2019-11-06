package main.com.wjs.jb.abs;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/5
 */
public interface IJBJsonAdapter {

    /**
     * generate a json_object
     */
    Object object();

    Object emptyObject();

    /**
     * generate an json_array
     */
    Object array();

    Object emptyArray();

    /**
     * transform a value to a json_object
     */
    Object map(Object v);

    /**
     * append a key/value to a json_object
     */
    void appendObject(Object jsonObject, String key, Object value);

    /**
     * append a key/value to an json_array
     */
    void appendArray(Object jsonArray, String key, Object value);
}
