package org.fundacionjala.movies;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Test");
        customer.addRental(new Rental(new MovieChildren("Bambie"), 10));
        customer.addRental(new Rental(new MovieRelease("Batman "), 30));
        customer.addRental(new Rental(new MovieRegular("Mad max"), 20));
        System.out.println(customer.statement());
    }
}

