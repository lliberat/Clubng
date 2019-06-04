package edu.calpoly.clubng;

public class Event {
    private String artist;
    private String city;
    private String club;
    private Long day;
    private Long month;
    private Long year;

    public Event() {
    }

    public Event(String artist, String city, String club, Long day, Long month, Long year) {
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

    public Long getDay() {
        return day;
    }

    public void setDay(Long day) {
        this.day = day;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long month) {
        this.month = month;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }
}
