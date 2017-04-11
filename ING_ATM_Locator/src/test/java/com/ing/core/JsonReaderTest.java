package com.ing.core;

import org.json.JSONArray;
import org.junit.Test;
import static org.junit.Assert.*;

public class JsonReaderTest {    
    
    @Test
    public void testReadUrl() throws Exception {
        System.out.println("readUrl");
        String urlString = "https://www.ing.nl/api/locator/atms/";
        JSONArray result = JsonReader.readUrl(urlString);
        assertEquals(1548, result.length());
        fail("The JSON Parser did not return the correct number of results");
    }
    
}
