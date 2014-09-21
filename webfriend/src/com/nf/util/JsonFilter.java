package com.nf.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.PropertyFilter;

public class JsonFilter
{
	private JsonConfig cfg = null;
	
	public <T> JSONArray PropertyFilter(List<T> list,final String[] jsonKeys){
		cfg = new JsonConfig();
		//final String[] jsonKeys = {"children","atUserToComments","mood","user"};
		//时间转换
		cfg.registerJsonValueProcessor(Date.class, new JsonValueProcessor() {  
            
            @Override  
            public Object processObjectValue(String key, Object value, JsonConfig arg2) {  
                // TODO Auto-generated method stub  
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(value);  
            }  
              
            @Override  
            public Object processArrayValue(Object value, JsonConfig arg1) {  
                // TODO Auto-generated method stub  
                return value;  
            }  
        });
		//属性过滤
		cfg.setJsonPropertyFilter(new PropertyFilter()
		{
		     public boolean apply(Object source, String name, Object value) {           
		     for(String jsonKey : jsonKeys){  
		         if(name.equals(jsonKey))
		              return true;
		          }     
		          return false;
		      }
		});
		
		return JSONArray.fromObject(list,cfg);
	}

}
