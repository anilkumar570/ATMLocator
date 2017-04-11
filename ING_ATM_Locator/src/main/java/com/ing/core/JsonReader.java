package com.ing.core;


import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ing.pojos.ATM;
import java.net.URL;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

public class JsonReader {

    public static JSONArray readUrl(String urlString) throws Exception {
        String url = urlString;
        String json = IOUtils.toString(new URL(url));            

        ObjectMapper mapper = new ObjectMapper();  
        mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);      
        
        List<ATM> atms = mapper.readValue(json.substring(5), new TypeReference<List<ATM>>(){});

        //ATM[] atms = mapper.readValue(json.substring(5), ATM[].class);        
        JSONArray jArray = new JSONArray(atms); 
        return jArray;
    }
}
