package edu.calpoly.clubng;

public class Event {
    private String artist;
    private String city;
    private String club;

    private String day;
    private String month;
    private String year;

    public Event() {
    }

    public Event(String artist, String city, String club, String day, String month, String year) {
        this.artist = artist;
        this.city = city;
        this.club = club;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getDay() {
        return String.valueOf(day);
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return String.valueOf(month);
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return String.valueOf(year);
    }

    public void setYear(String year) {
        this.year = year;
    }
}
