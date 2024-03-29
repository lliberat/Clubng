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
        if(artist == null || artist.length() < 1)  {
            throw new IllegalArgumentException("Artist string cannot be empty/null");
        }
        this.artist = artist;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if(city == null || city.length() < 1) {
            throw new IllegalArgumentException("City string cannot be empty/null");
        }
        this.city = city;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        if(club == null || club.length() < 1) {
            throw new IllegalArgumentException("Club string cannot be null/empty");
        }
        this.club = club;
    }

    public String getDay() {
        return String.valueOf(day);
    }

    public void setDay(String day) {
        if(day == null) {
            throw new IllegalArgumentException("Day value cannot be null");
        }
        if (Integer.valueOf(day) < 1 || Integer.valueOf(day) > 31 ){
            throw new IllegalArgumentException("Day cannot be less than 1 or larger than 31!");
        }
        this.day = day;
    }

    public String getMonth() {
        return String.valueOf(month);
    }

    public void setMonth(String month) {
        if(month == null) {
            throw new IllegalArgumentException("Month value cannot be null");
        }
        if (Integer.valueOf(month) < 1 || Integer.valueOf(month) > 12 ){
            throw new IllegalArgumentException("Month cannot be less than 1 or larger than 12!");
        }
        this.month = month;
    }

    public String getYear() {
        return String.valueOf(year);
    }

    public void setYear(String year) {
        if(year == null) {
            throw new IllegalArgumentException("Year value cannot be null");
        }
        if (Integer.valueOf(year) < 2019){
            throw new IllegalArgumentException("Year cannot be less than 2019!");
        }
        this.year = year;
    }
}
