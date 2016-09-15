package org.fundacionjala.movies;

import java.util.LinkedList;
import java.util.List;

/**
 * Handles the activity of the customer.
 *
 * @autor Bruno Vasquez
 */
class Customer {
    private static final String BREAK_LINE = "\n";
    public static final String TABULAR = "\t";

    private final String name;
    private final List<Rental> rentals = new LinkedList<Rental>();

    /**
     * It is the constructor of customer.
     *
     * @param name an String to set the name of customer
     */
    public Customer(String name) {
        this.name = name;
    }

    /**
     * Adds a list of rentals.
     *
     * @param rental an object Rental.
     */
    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    /**
     * Calculates the total frequent renter points of a customer
     *
     * @return the total frequent point.
     */
    public int calculateTotalFrequentRenterPoints() {
        return rentals.stream().mapToInt(Rental::calculateFrequentRenterPoints).sum();
    }

    /**
     * Calculates the total amount to pay of a customer
     *
     * @return the total amount.
     */
    public double calculateTotalAmount() {
        return rentals.stream().mapToDouble(Rental::calculateAmount).sum();
    }

    /**
     * Handles of string of the output dates of customer
     *
     * @return the output string.
     */
    public String statement() {
        StringBuilder result = new StringBuilder();
        result.append("Rental Record for ");
        result.append(getName());
        result.append(BREAK_LINE);
        for (Rental rental : rentals) {
            result.append(TABULAR);
            result.append(rental.getMovie().getTitle());
            result.append(TABULAR);
            result.append(rental.calculateAmount());
            result.append(BREAK_LINE);
        }
        result.append("Amount owed is ");
        result.append(calculateTotalAmount());
        result.append(BREAK_LINE);
        result.append("You earned ");
        result.append(calculateTotalFrequentRenterPoints());
        result.append(" frequent renter points");
        return result.toString();
    }

    /**
     * Bring back the name of customer.
     *
     * @return the name of customer.
     */
    public String getName() {
        return name;
    }

}

