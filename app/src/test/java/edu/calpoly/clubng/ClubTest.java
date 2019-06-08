package edu.calpoly.clubng;

import org.junit.Test;

public class ClubTest {
    @Test(expected = IllegalArgumentException.class)
    public void club_EmptyCityTest() {
        Club c = new Club();

        c.setCity("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void club_EmptyNameTest() {
        Club c = new Club();

        c.setName("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void club_NullNameTest() {
        Club c = new Club();

        c.setName(null);
    }

}
