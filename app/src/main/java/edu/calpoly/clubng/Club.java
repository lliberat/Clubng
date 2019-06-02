package edu.calpoly.clubng;

public class Club {
    private String name;
    private String location;
    private String info;
    private String city;
    //Ratings

    //Prices
    private Long gold;
    private Long silver;
    private Long bronze;

    public Club() {
    }

    public Club(String city, String name, String location, String info,  Long gold, Long silver, Long bronze) {
        this.name = name;
        this.location = location;
        this.info = info;
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

    public String getGold() {
        return String.valueOf(gold);
    }

    public void setGold(Long gold) {
        this.gold = gold;
    }

    public String getSilver() {
        return String.valueOf(silver);
    }

    public void setSilver(Long silver) {
        this.silver = silver;
    }

    public String getBronze() {
        return String.valueOf(bronze);
    }

    public void setBronze(Long bronze) {
        this.bronze = bronze;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String name) {
        this.city = city;
    }
}
