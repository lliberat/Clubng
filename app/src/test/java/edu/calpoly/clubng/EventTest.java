package edu.calpoly.clubng;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.junit.Assert.*;

public class EventTest {

    @Test(expected = IllegalArgumentException.class)
    public void event_DayOutOfBoundsUpperTest() {
        Event e = new Event();

        e.setDay("35");
    }

    @Test(expected = IllegalArgumentException.class)
    public void event_DayOutOfBoundsLowerTest() {
        Event e = new Event();

        e.setDay("0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void event_MonthOutOfBoundsUpperTest() {
        Event e = new Event();

        e.setMonth("13");
    }

    @Test(expected = IllegalArgumentException.class)
    public void event_MonthOutOfBoundsLowerTest() {
        Event e = new Event();

        e.setMonth("0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void event_EmptyCityTest() {
        Event e = new Event();

        e.setCity("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void event_EmptyArtistTest() {
        Event e = new Event();

        e.setArtist("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void event_NullMonthTest() {
        Event e = new Event();

        e.setMonth(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void event_NullDayTest() {
        Event e = new Event();

        e.setDay(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void event_NullYearTest() {
        Event e = new Event();

        e.setYear(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void event_EmptyClubTest() {
        Event e = new Event();

        e.setClub("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void event_YearBeforeNowTest() {
        Event e = new Event();

        e.setYear("1994");
    }

    @Test
    public void event_SetandGetYear() {
        Event e = new Event();

        e.setYear("2020");

        assertEquals(e.getYear(),"2020");
    }

}
