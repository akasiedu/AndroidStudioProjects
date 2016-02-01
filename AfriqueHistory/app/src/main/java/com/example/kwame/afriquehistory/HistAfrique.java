package com.example.kwame.afriquehistory;

/**
 * Created by kwame on 10/8/15.
 */
public class HistAfrique {

    private String likes;
    private String latitude, longitude,id;
    private String placeName, history, source, country, province, absoluteImageUrl;

    public void setPlaceName(String placeName){
        this.placeName=placeName;
    }
    public String getPlaceName(){
        return placeName;
    }

    public void setHistory(String history){
        this.history=history;
    }
    public String getHistory() {
        return history;
    }


    public void setSource(String source){
        this.source=source;
    }
    public String getSource(){
        return source;
    }

    public void setCountry(String country){
        this.country=country;
    }
    public String getCountry(){
        return country;
    }





    public void setLatitude(String latitude){
        this.latitude = latitude;
    }

    public String getLatitude(){
        return latitude;
    }

    public void setLongitude(String longitude){
        this.longitude = longitude;

    }

    public String getLongitude(){
        return longitude;
    }


    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }



    public void setProvince(String province){
        this.province=province;
    }
    public String getProvince(){
        return province;
    }

    public String setAbsoluteImageUrl(String absoluteImageUrl){
        return absoluteImageUrl;
    }
    public String getAbsouteImageUrl(){
        return absoluteImageUrl;
    }





    public void setLikes(String likes){
        this.likes=likes;

    }

    public String getLikes(){
        return likes;
    }

}
