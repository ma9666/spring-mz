package com.mz.utils.json;

import org.json.JSONString;

/**
 * 
 * @ProjectName ：SpringMvcMz   
 * @ClassName：JSONStringObject   
 * @Description：   JSON转换工具类
 * @author：Ma Zhen   
 * @date：2016-04-22       
 * @version
 */
public class JSONStringObject implements JSONString{

    private String jsonString = null;
    
    public JSONStringObject(String jsonString){
        this.jsonString = jsonString;
    }

    @Override
    public String toString(){
        return jsonString;
    }

    public String toJSONString(){
        return jsonString;
    }
}
