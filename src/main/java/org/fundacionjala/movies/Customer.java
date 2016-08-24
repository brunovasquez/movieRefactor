package org.fundacionjala.movies;

import java.util.LinkedList;
import java.util.List;

class Customer {

    private static final String BREAK_LINE = "\n";
    public static final String TABULAR = "\t";

    private final String name;
    private final List<Rental> rentals = new LinkedList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public int calculateTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            // add frequent renter points
            frequentRenterPoints += rental.calculateFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }

    public double calculateTotalAmount() {
        double totalAmount = 0;
        for (Rental rental : rentals) {
            //determine amounts for each line
            totalAmount += rental.calculateAmount();
        }
        return totalAmount;
    }

    public String statement() {
        StringBuilder result = new StringBuilder();
        result.append("Rental Record for ");
        result.append(getName());
        result.append(BREAK_LINE);
        for (Rental rental : rentals) {
            //show figures for this rental
            result.append(TABULAR);
            result.append(rental.getMovie().getTitle());
            result.append(TABULAR);
            result.append(rental.calculateAmount());
            result.append(BREAK_LINE);
        }
        //add footer lines
        result.append("Amount owed is ");
        result.append(calculateTotalAmount());
        result.append(BREAK_LINE);
        result.append("You earned ");
        result.append(calculateTotalFrequentRenterPoints());
        result.append(" frequent renter points");
        return result.toString();
    }

    public String getName() {
        return name;
    }

}
