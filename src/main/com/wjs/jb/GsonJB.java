package main.com.wjs.jb;

import com.google.gson.*;
import main.com.wjs.jb.abs.IJBJsonAdapter;
import main.com.wjs.jb.imp.JB;
import main.com.wjs.jb.imp.JBConstants;

/**
 * @Auther: nku.htn
 * @Date: 2019/11/6
 */
public class GsonJB extends JB implements IJBJsonAdapter {

    //格式化
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public GsonJB() {
        this.addFilters(JBConstants.DEFAULT_FILTER);
    }

    @Override
    protected IJBJsonAdapter jsonAdapter() {
        return this;
    }

    @Override
    public JsonElement json() {
        return (JsonElement) super.json();
    }

    @Override
    public String toString() {
        return gson.toJson(json());
    }

    @Override
    public Object object() {
        return new JsonObject();
    }

    @Override
    public Object emptyObject() {
        return object();
    }

    @Override
    public Object array() {
        return new JsonArray();
    }

    @Override
    public Object emptyArray() {
        return array();
    }

    @Override
    public JsonElement map(Object v) {
        if(v instanceof JsonElement){
            return (JsonElement) v;
        }else{
            return gson.toJsonTree(v);
        }
    }

    @Override
    public void appendObject(Object jsonObject, String key, Object value) {
        JsonObject jb = (JsonObject) jsonObject;
        jb.add(key, map(value));
    }

    @Override
    public void appendArray(Object jsonArray, String key, Object value) {
        JsonArray ja = (JsonArray) jsonArray;
        ja.add(map(value));
    }
}
