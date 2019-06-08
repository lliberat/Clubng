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

        e.setClub("");
    }

}
