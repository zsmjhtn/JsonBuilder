package main.com.wjs.jb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import main.com.wjs.jb.abs.IJBJsonAdapter;
import main.com.wjs.jb.imp.JB;
import main.com.wjs.jb.imp.JBConstants;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/12
 */
public class FastJsonJB extends JB implements IJBJsonAdapter {

    public FastJsonJB() {
        this.addFilters(JBConstants.DEFAULT_FILTER);
    }

    @Override
    public JSONObject json() {
        return (JSONObject) super.json();
    }

    @Override
    public String toString() {
        return JSON.toJSONString(json());
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
        if (v instanceof JSON) {
            return v;
        } else {
            return JSON.toJSON(v);
        }
    }

    @Override
    public void appendObject(Object jsonObject, String key, Object value) {
        JSONObject jb = (JSONObject) jsonObject;
        jb.put(key, map(value));
    }

    @Override
    public void appendArray(Object jsonArray, String key, Object value) {
        JSONArray array = (JSONArray) jsonArray;
        array.add(map(value));
    }

    @Override
    protected IJBJsonAdapter jsonAdapter() {
        return this;
    }
}
