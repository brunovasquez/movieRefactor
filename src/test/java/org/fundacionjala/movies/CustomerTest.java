package org.fundacionjala.movies;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for {@link Customer}
 */
public class CustomerTest {

    private static final int DELTA = 0;
    private static final String NAME = "Bruno";
    private static final String BREAK_LINE = "\n";
    private static final String TABULAR = "\t";
    private static final String LITTLE_MOVIE_RELEASE = "Avengers";
    private static final String LITTLE_MOVIE_REGULAR = "Pirates";
    private static final String LITTLE_MOVIE_CHILDREN = "Micky";
    private Customer customer;
    private Movie movieRelease;
    private Movie movieRegular;
    private Movie movieChildren;
    private Rental rentalRelease;
    private Rental rentalRegular;
    private Rental rentalChildren;

    @Before
    public void setUp() {
        final int daysRented = 5;
        customer = new Customer(NAME);
        movieRelease = new MovieRelease(LITTLE_MOVIE_RELEASE);
        movieRegular = new MovieRegular(LITTLE_MOVIE_REGULAR);
        movieChildren = new MovieChildren(LITTLE_MOVIE_CHILDREN);
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

    @Test
    public void test_statement() {
        customer.addRental(rentalRelease);
        customer.addRental(rentalRegular);
        customer.addRental(rentalChildren);

        final double amountRelease = 15;
        final double amountRegular = 6.5;
        final double amountChildren = 6.0;
        final double totalAmount = 27.5;
        final int totalPoints = 4;
        final StringBuilder expectResult = new StringBuilder();

        expectResult.append("Rental Record for ");
        expectResult.append(NAME);
        expectResult.append(BREAK_LINE);
        expectResult.append(TABULAR);
        expectResult.append(LITTLE_MOVIE_RELEASE);
        expectResult.append(TABULAR);
        expectResult.append(amountRelease);
        expectResult.append(BREAK_LINE);
        expectResult.append(TABULAR);
        expectResult.append(LITTLE_MOVIE_REGULAR);
        expectResult.append(TABULAR);
        expectResult.append(amountRegular);
        expectResult.append(BREAK_LINE);
        expectResult.append(TABULAR);
        expectResult.append(LITTLE_MOVIE_CHILDREN);
        expectResult.append(TABULAR);
        expectResult.append(amountChildren);
        expectResult.append(BREAK_LINE);
        expectResult.append("Amount owed is ");
        expectResult.append(totalAmount);
        expectResult.append(BREAK_LINE);
        expectResult.append("You earned ");
        expectResult.append(totalPoints);
        expectResult.append(" frequent renter points");

        final String actualResult = customer.statement();
        assertEquals(expectResult.toString(), actualResult);
    }

}
