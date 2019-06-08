package edu.calpoly.clubng;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class GlobalsTest {

    @Test
    public void globals_SingletonTest() {
        Globals g = Globals.getInstance();
        assertNotNull(g);

        Globals h = Globals.getInstance();

        // Test to see if Singleton is working
        assertSame(h,g);
    }

    @Test(expected = IllegalArgumentException.class)
    public void globals_DayOutOfBoundsUpperTest() {
        Globals g = Globals.getInstance();

        g.setDay("35");
    }

    @Test(expected = IllegalArgumentException.class)
    public void globals_DayOutOfBoundsLowerTest() {
        Globals g = Globals.getInstance();

        g.setDay("0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void globals_MonthOutOfBoundsUpperTest() {
        Globals g = Globals.getInstance();

        g.setMonth("13");
    }

    @Test(expected = IllegalArgumentException.class)
    public void globals_MonthOutOfBoundsLowerTest() {
        Globals g = Globals.getInstance();

        g.setMonth("0");
    }

    @Test(expected = IllegalArgumentException.class)
    public void globals_EmptyCityTest() {
        Globals g = Globals.getInstance();

        g.setCity("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void globals_EmptyArtistTest() {
        Globals g = Globals.getInstance();

        g.setClubName("");
    }


}
