package com.intertec.util.interfaces;

public interface JsonService {
    
    String toJson(Object data);
    
    Object fromJson(String json, Class clazz);    
    
}
