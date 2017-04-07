package com.ing.models;

public class Address
{
    private String _street;

    private String _housenumber;

    private String _postalcode;

    private String _city;

    private GeoLocation _geoLocation;

    public void SetStreet(String street){
        this._street = street;
    }
    public String GetStreet(){
        return this._street;
    }
    public void SetHousenumber(String housenumber){
        this._housenumber = housenumber;
    }
    public String GetHousenumber(){
        return this._housenumber;
    }
    public void SetPostalcode(String postalcode){
        this._postalcode = postalcode;
    }
    public String GetPostalcode(){
        return this._postalcode;
    }
    public void SetCity(String city){
        this._city = city;
    }
    public String GetCity(){
        return this._city;
    }
    public void SetGeoLocation(GeoLocation geoLocation){
        this._geoLocation = geoLocation;
    }
    public GeoLocation GetGeoLocation(){
        return this._geoLocation;
    }
}
