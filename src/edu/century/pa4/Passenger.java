package edu.century.pa4;

/**
 * Definition for a class to store passenger information
 * Passenger include information about reservation
 * 
 * Class: CSCI 1082-90 - Object Oriented Programming
 * Instructor: Matthew Sanders
 * Assignment: Programming Assignment 4
 * 
 * Date: July 02, 2019
 * Due:  Jule 04, 2019
 * @author Alexandr Sergeyev <ns1418cz@my.century.edu>
 */
public class Passenger {
	
	/**
	 * First name of the passenger
	 */
	private String firstName;
	
	/**
	 * Last name of the passenger
	 */
	private String lastName;
	
	/**
	 * Reservation
	 * Instance of Reservation
	 */
	private Reservation reservation;
	
	
	/**
	 * Default Constructor
	 */
	Passenger() {
		setFirstName("");
		setLastName("");
		setReservation(new Reservation());
	}
	
	/**
	 * Construct an instance with firstName and LastName provided
	 * 
	 * @param firstName
	 * @param lastName
	 */
	Passenger(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
		setReservation(new Reservation());
	}

	/**
	 * Get first name
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Modify first name
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get last name
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Modify last name
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Get reservation
	 * 
	 * @return reservation
	 */
	public Reservation getReservation() {
		return reservation;
	}

	/**
	 * Modify reservation
	 * 
	 * @param Reservation reservation
	 */
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	/**
	 * Overriding method definition in order to be more verbose in output
	 * 
	 * @return the formatted string of passenger data including reservation data
	 */
	@Override
	public String toString() {
		String message = "";
		message += "First Name: " + getFirstName() + "\n";
		message += "Last Name: "  + getLastName()  + "\n";
		message += getReservation().toString();
		return message;
	}
}
