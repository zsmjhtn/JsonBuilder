package main.com.wjs.jb;

import main.com.wjs.jb.abs.IJBJsonAdapter;
import main.com.wjs.jb.imp.JB;
import main.com.wjs.jb.imp.JBConstants;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/12
 */
public class JsonJB extends JB implements IJBJsonAdapter {

    public JsonJB() {
        this.addFilters(JBConstants.DEFAULT_FILTER);
    }

    @Override
    public Object json() {
        return super.json();
    }

    @Override
    public String toString() {
        return json().toString();
    }


    @Override
    public Object object() {
        return new JSONObject();
    }

    @Override
    public Object emptyObject() {
        return object();
    }

    @Override
    public Object array() {
        return new JSONArray();
    }

    @Override
    public Object emptyArray() {
        return array();
    }

    @Override
    public Object map(Object v) {
        return JSONObject.wrap(v);
    }

    @Override
    public void appendObject(Object jsonObject, String key, Object value) {
        JSONObject jb = (JSONObject) jsonObject;
        jb.put(key, map(value));
    }

    @Override
    public void appendArray(Object jsonArray, String key, Object value) {
        JSONArray ja = (JSONArray) jsonArray;
        ja.put(map(value));
    }

    @Override
    public Collection<? extends Map.Entry<String, ? extends Object>> split(Object bean) {
        Object je = this.map(bean);
        if(je != null){
            if(je instanceof JSONObject){
                JSONObject jo = (JSONObject) je;

                Map<String, Object> map = new HashMap<String, Object>();
                for (final String key : ((JSONObject) je).keySet()) {
                    final Object value = jo.get(key);
                    map.put(key, value);
                }
                return map.entrySet();
            }
        }
        return null;
    }

    @Override
    protected IJBJsonAdapter jsonAdapter() {
        return this;
    }
}
