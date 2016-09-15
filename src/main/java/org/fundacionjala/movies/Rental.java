package org.fundacionjala.movies;

/**
 * Handles the activity of the movies and rentals.
 *
 * @autor Bruno Vasquez
 */
class Rental {
    private Movie movie;
    private int daysRented;

    /**
     * It is the constructor of rentals.
     *
     * @param movie      an abject to set the movie to rent
     * @param daysRented an String to set the days rented
     */
    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    /**
     * Bring back the frequent renter points of a movie
     *
     * @return the frequent points.
     */
    public int calculateFrequentRenterPoints() {
        return movie.frequentRenterPoints(daysRented);
    }

    /**
     * Calculates the amount to pay of a movie
     *
     * @return the total amount.
     */
    public double calculateAmount() {
        return movie.calculatePrice(daysRented);
    }

    /**
     * Bring back the movie to rental
     *
     * @return the movie to rental
     */
    public Movie getMovie() {
        return movie;
    }

}


