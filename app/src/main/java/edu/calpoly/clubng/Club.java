package edu.calpoly.clubng;

public class Club {
    private String name;
    private String location;
    private String info;
    private String city;
    //Ratings
    private String service;
    private String safety;
    private String ambience;
    private String locRating;
    //Prices
    private String gold;
    private String silver;
    private String bronze;

    public Club() {
    }

    public Club(String city, String name, String location, String info, String service, String safety, String ambience, String locRating, String gold, String silver, String bronze) {
        this.name = name;
        this.location = location;
        this.info = info;
        this.service = service;
        this.safety = safety;
        this.ambience = ambience;
        this.locRating = locRating;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getSafety() {
        return safety;
    }

    public void setSafety(String safety) {
        this.safety = safety;
    }

    public String getAmbience() {
        return ambience;
    }

    public void setAmbience(String ambience) {
        this.ambience = ambience;
    }

    public String getLocRating() {
        return locRating;
    }

    public void setLocRating(String locRating) {
        this.locRating = locRating;
    }

    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public String getSilver() {
        return silver;
    }

    public void setSilver(String silver) {
        this.silver = silver;
    }

    public String getBronze() {
        return bronze;
    }

    public void setBronze(String bronze) {
        this.bronze = bronze;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String name) {
        this.city = city;
    }
}
