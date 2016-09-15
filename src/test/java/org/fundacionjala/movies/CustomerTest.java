package org.fundacionjala.movies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link Customer}
 */
public class CustomerTest {

    public static final int DELTA = 0;
    private Customer customer;
    private Movie movieRelease;
    private Movie movieRegular;
    private Movie movieChildren;
    private Rental rentalRelease;
    private Rental rentalRegular;
    private Rental rentalChildren;

    @Before
    public void setUp() {
        final String titleMovieRelease = "Avengers";
        final String titleMovieRegular = "Pirates";
        final String titleMovieChildren = "Micky";
        final String name = "Bruno";
        final int daysRented = 5;
        customer = new Customer(name);
        movieRelease = new MovieRelease(titleMovieRelease);
        movieRegular = new MovieRegular(titleMovieRegular);
        movieChildren = new MovieChildren(titleMovieChildren);
        rentalRelease = new Rental(movieRelease, daysRented);
        rentalRegular = new Rental(movieRegular, daysRented);
        rentalChildren = new Rental(movieChildren, daysRented);
    }

    @Test
    public void test_calculateTotalFrequentRenterPoints_whitTwoMoviesNewReleases() {
        customer.addRental(rentalRelease);
        customer.addRental(rentalRelease);

        final int expectResult = 4;
        final int actualResult = customer.calculateTotalFrequentRenterPoints();
        assertEquals(expectResult, actualResult, DELTA);
    }

    @Test
    public void test_calculateTotalFrequentRenterPoints_whitTwoMoviesNewReleasesAndRegular() {
        customer.addRental(rentalRelease);
        customer.addRental(rentalRegular);

        final int expectResult = 3;
        final int actualResult = customer.calculateTotalFrequentRenterPoints();
        assertEquals(expectResult, actualResult, DELTA);
    }

    @Test
    public void test_calculateTotalFrequentRenterPoints_whitTwoMoviesNewReleasesRegularChildren() {
        customer.addRental(rentalRelease);
        customer.addRental(rentalRegular);
        customer.addRental(rentalChildren);

        final int expectResult = 4;
        final int actualResult = customer.calculateTotalFrequentRenterPoints();
        assertEquals(expectResult, actualResult, DELTA);
    }

    @Test
    public void test_calculateTotalAmount_withTwoMoviesChildren() {
        customer.addRental(rentalChildren);
        customer.addRental(rentalChildren);

        final double expectResult = 12;
        final double actualResult = customer.calculateTotalAmount();
        assertEquals(expectResult, actualResult, DELTA);
    }

    @Test
    public void test_calculateTotalAmount_withTwoMoviesNewRelease() {
        customer.addRental(rentalRelease);
        customer.addRental(rentalRelease);

        final double expectResult = 30;
        final double actualResult = customer.calculateTotalAmount();
        assertEquals(expectResult, actualResult, 0);
    }

    @Test
    public void test_calculateTotalAmount_withTwoMoviesRegular() {
        customer.addRental(rentalRegular);
        customer.addRental(rentalRegular);

        final double expectResult = 13;
        final double actualResult = customer.calculateTotalAmount();
        assertEquals(expectResult, actualResult, 0);
    }

    @Test
    public void test_calculateTotalAmount_withThreeMoviesRegularReleaseChildren() {
        customer.addRental(rentalRelease);
        customer.addRental(rentalRegular);
        customer.addRental(rentalChildren);

        final double expectResult = 27.5;
        final double actualResult = customer.calculateTotalAmount();
        assertEquals(expectResult, actualResult, 0);
    }

}
