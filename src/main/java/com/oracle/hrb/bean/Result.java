package com.oracle.hrb.bean;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private boolean ok;
    private String msg;
    private Map<String ,Object> value;

    public Result() {
        this.ok =true;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getValue() {
        return value;
    }

    public void addValue(String key,Object value) {
        if(this.value==null){
            this.value=new HashMap<>();
        }
        this.value.put(key,value);
    }

    @Override
    public String toString() {
        return "Result{" +
                "ok=" + ok +
                ", msg='" + msg + '\'' +
                ", value=" + value +
                '}';
    }
}
