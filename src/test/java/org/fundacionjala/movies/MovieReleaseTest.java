package org.fundacionjala.movies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for {@link MovieChildren}
 */
public class MovieReleaseTest {
    public static final int DELTA = 0;
    private Movie movie;

    @Before
    public void setUp() {
        final String title = "Avengers";
        movie = new MovieRelease(title);
    }

    @Test
    public void test_calculatePrice_toRelease() {
        int daysRented = 3;
        final double expectResult = 9;
        final double actualResult = movie.calculatePrice(daysRented);
        assertEquals(expectResult, actualResult, DELTA);
    }

    @Test
    public void test_frequentRenterPoints_toReleaseWhenDaysRentedHigherThatOne() {
        final int daysRented = 5;
        final int expectResult = 2;
        final int actualResult = movie.frequentRenterPoints(daysRented);
        assertEquals(expectResult, actualResult);
    }

    @Test
    public void test_frequentRenterPoints_toReleaseWhenDaysRentedMinorOrEqualThatOne() {
        final int daysRented = 1;
        final int expectResult = 1;
        final int actualResult = movie.frequentRenterPoints(daysRented);
        assertEquals(expectResult, actualResult);
    }

}
