package org.fundacionjala.movies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link MovieChildren}
 */
public class MovieChildrenTest {
    public static final int DELTA = 0;
    private Movie movie;

    @Before
    public void setUp() {
        final String title = "Micky";
        movie = new MovieChildren(title);
    }

    @Test
    public void test_calculatePrice_whenTheDaysAreHigherToTwo() {
        int daysRented = 3;
        final int expectResult = 3;
        final double actualResult = movie.calculatePrice(daysRented);
        assertEquals(expectResult, actualResult, DELTA);
    }

    @Test
    public void test_calculatePrice_whenTheDaysAreMinorOrEqualToTwo() {
        int daysRented = 2;
        final double expectResult = 1.5;
        final double actualResult = movie.calculatePrice(daysRented);
        assertEquals(expectResult, actualResult, DELTA);
    }



}

