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
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
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
