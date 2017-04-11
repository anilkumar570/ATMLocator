package com.ing.web;

import java.util.List;
import com.ing.core.JsonParser;
import com.ing.core.JsonReader;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("locate")
public class LocatorController {   
    
    //The following results in a json serialization error. I tried using Jackson to resolve the issue but the program continued to throw the error. 
    //Resolution was to use a custom javascript function found in src.main.resources.static.javascript.page.js

//    @RequestMapping(value = "/atms/{city}", method = RequestMethod.GET, produces = "application/json")
//    public List<JSONObject> getAllATMsInCity(@PathVariable("city") String city) throws Exception {                       
//        String json = JsonReader.readUrl("https://www.ing.nl/api/locator/atms/").toString();
//        return JsonParser.getATMsInCity(city, json);
//    }
    
    @RequestMapping(value = "/atms", method = RequestMethod.GET, produces = "application/json")
    public String getAllATMs() throws Exception {

        String json = IOUtils.toString(new URL("https://www.ing.nl/api/locator/atms/")); 
        return json.substring(5);
    } 

}
