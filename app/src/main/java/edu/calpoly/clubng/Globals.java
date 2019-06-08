package edu.calpoly.clubng;

public class Globals {
    private static Globals instance;

    // Global variable
    private String city;
    private String year;
    private String month;
    private String day;
    private String clubName;
    private Event event;
    private String priceLev;
    private Long price;

    // Restrict the constructor from being instantiated
    private Globals(){}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getYear() {

        return year;
    }

    public void setYear(String year) {
        if (Integer.valueOf(year) < 2019){
            throw new IllegalArgumentException("Year cannot be less than 2019!");
        }
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        if (Integer.valueOf(month) < 1 || Integer.valueOf(month) > 12 ){
            throw new IllegalArgumentException("Month cannot be less than 1 or larger than 12!");
        }
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        if (Integer.valueOf(day) < 1 || Integer.valueOf(day) > 31 ){
            throw new IllegalArgumentException("Day cannot be less than 1 or larger than 31!");
        }

        this.day = day;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getPriceLev() {
        return priceLev;
    }

    public void setPriceLev(String priceLev) {
        this.priceLev = priceLev;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public static synchronized Globals getInstance(){
        if(instance==null){
            instance=new Globals();
        }
        return instance;
    }
}
