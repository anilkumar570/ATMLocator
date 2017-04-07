package com.ing.models;

public class GeoLocation{
    private String _lat;
    private String _lng; 
    
    public void SetLat(String lat){
        this._lat = lat;
    }
    
    public String GetLat(String lat){
        return this._lat;
    }
    
    public void SetLng(String lng){
        this._lng = lng;
    }
    
    public String GetLng(String lng){
        return this._lng;
    }
}
