package com.ing.core;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonParser {
    public static List<JSONObject> getATMsInCity(String city, String jsonString){
        List<JSONObject> atmList = new ArrayList();
        JSONArray jsonArray = new JSONArray(jsonString);
        for(int i = 0; i < jsonArray.length(); i++){
            JSONObject element = jsonArray.getJSONObject(i);
            if(element.getJSONObject("address").get("city").equals(city)){
                atmList.add(element);
            } 
        }
        
        return atmList;
    }
}
