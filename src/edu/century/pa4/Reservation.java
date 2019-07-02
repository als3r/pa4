package edu.century.pa4;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.LocalDateTime;
import java.text.ParsePosition;


/**
 * Definition for a class to store reservation information
 * 
 * Class: CSCI 1082-90 - Object Oriented Programming
 * Instructor: Matthew Sanders
 * Assignment: Programming Assignment 4
 * 
 * Date: June 25, 2019
 * Due:  Jule 04, 2019
 * @author Alexandr Sergeyev <ns1418cz@my.century.edu>
 */
public class Reservation {
	
	/**
	 * Number of days ahead for departure date constant
	 * Used for default constructor
	 */
	private static final int      DEFAULT_DEPARTURE_DATE_NUMBER_DAYS_AHEAD = 7;
	
	/**
	 * Number of days ahead for return date constant
	 * Used for default constructor
	 */
	private static final int      DEFAULT_RETURN_DATE_NUMBER_DAYS_AHEAD = 14;
	
	/**
	 * Departure city constant
	 * Used for default constructor
	 */
	private static final String   DEFAULT_DEPARTURE_CITY = "MSP";
	
	/**
	 * Destination city constant
	 * Used for default constructor
	 */
	private static final String   DEFAULT_DESTINATION_CITY = "New York";
	
	/**
	 * Number of seats
	 */
	public static final int      NUMBER_OF_SEATS = 28;
	
	/**
	 * Array of seats available
	 */
	public static final String[] SEATS_ARRAY = {
		"1A", "1B", "1C", "1D",
		"2A", "2B", "2C", "2D",
		"3A", "3B", "3C", "3D",
		"4A", "4B", "4C", "4D",
		"5A", "5B", "5C", "5D",
		"6A", "6B", "6C", "6D",
		"7A", "7B", "7C", "7D"
	};

	/**
	 * Departure City
	 */
	private String departureCity;
	
	/**
	 * Destination City
	 */
	private String destinationCity;

	/**
	 * Departure Date
	 */
	private Date departureDate;
	
	/**
	 * Return Date
	 */
	private Date returnDate;
	
	/**
	 * Chosen Seat
	 */
	private String seat;
	
	/**
	 * Date Format Pattern
	 */
	public static String datePattern = "MM/dd/yyyy";
	
	/**
	 * DateFormatter instance of the SimpleDateFormat
	 */
	public static DateFormat dateFormatter = new SimpleDateFormat(datePattern);
	 
	
	/**
	 * Default constructor
	 * Construct an instance with default values
	 * 
	 * Sets 
	 * departureCity   to DEFAULT_DEPARTURE_CITY
	 * destinationCity to DEFAULT_DESTINATION_CITY
	 * departureDate   to today's date + DEFAULT_DEPARTURE_DATE_NUMBER_DAYS_AHEAD days
	 * returnDate      to today's date + DEFAULT_RETURN_DATE_NUMBER_DAYS_AHEAD days
	 * seat            to empty String
	 */
	Reservation() {
		
		// Settings default dates for departure and return dates
		LocalDateTime defaultDepartureDate = (new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		LocalDateTime defaultReturnDate = (new Date()).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		
		defaultDepartureDate = defaultDepartureDate.plusDays(DEFAULT_DEPARTURE_DATE_NUMBER_DAYS_AHEAD);
		defaultReturnDate = defaultReturnDate.plusDays(DEFAULT_RETURN_DATE_NUMBER_DAYS_AHEAD);
		
		setDepartureCity(DEFAULT_DEPARTURE_CITY);
		setDestinationCity(DEFAULT_DESTINATION_CITY);
		setDepartureDate(Date.from(defaultDepartureDate.atZone(ZoneId.systemDefault()).toInstant()));
		setReturnDate(Date.from(defaultReturnDate.atZone(ZoneId.systemDefault()).toInstant()));
		setSeat("");
	}

	/**
	 * Construct an instance with parameters below provided:
	 * 
	 * @param seat
	 * @param DepartureCity
	 * @param DestinationCity
	 * @param departureDate
	 * @param returnDate
	 */
	Reservation(String seat, String DepartureCity, String DestinationCity, Date departureDate, Date returnDate) {	
		setDepartureCity(DepartureCity);
		setDestinationCity(DestinationCity);
		setDepartureDate(departureDate);
		setReturnDate(returnDate);
		setSeat("seat");
	}
	
	/**
	 * Get departure city
	 * 
	 * @return departureCity
	 */
	public String getDepartureCity() {
		return departureCity;
	}
	
	/**
	 * Modify departure city
	 * 
	 * @param departureCity
	 */
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	
	/**
	 * Get Destination city
	 * 
	 * @return destinationCity
	 */
	public String getDestinationCity() {
		return destinationCity;
	}
	
	/**
	 * Modify destination city
	 * 
	 * @param destinationCity
	 */
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	
	/**
	 * Get departure date
	 * 
	 * @return Date departureDate
	 */
	public Date getDepartureDate() {
		return departureDate;
	}
	
	/**
	 * Get formatted departure date
	 * (format used from datePattern) 
	 * 
	 * @return String departureDate
	 */
	public String getFormattedDepartureDate() {
		return dateFormatter.format(getDepartureDate());
	}
	
	/**
	 * Modify departure date by passing date
	 * (Date class) 
	 * 
	 * @param departureDate
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	
	/**
	 * Modify departure date by passing
	 * string in "MM/dd/yyyy" format (see datePattern)
	 * 
	 * @param departureDate
	 */
	public void setDepartureDate(String departureDate) {
		this.departureDate = dateFormatter.parse(departureDate, new ParsePosition(0));
	}
	
	/**
	 * Get return date
	 * 
	 * @return Date returnDate
	 */
	public Date getReturnDate() {
		return returnDate;
	}
	
	/**
	 * Get formatted return date
	 * (format used from datePattern) 
	 * 
	 * @return String returnDate
	 */
	public String getFormattedReturnDate() {
		return dateFormatter.format(getReturnDate());
	}
	
	/**
	 * Modify return date by passing date
	 * (Date class) 
	 * 
	 * @param returnDate
	 */
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
	/**
	 * Modify return date by passing
	 * string in "MM/dd/yyyy" format (see datePattern)
	 * 
	 * @param returnDate
	 */
	public void setReturnDate(String returnDate) {
		this.returnDate = dateFormatter.parse(returnDate, new ParsePosition(0));
	}
	
	/**
	 * Get seat number
	 * 
	 * @return seat
	 */
	public String getSeat() {
		return seat;
	}
	
	/**
	 * Modify seat number
	 * 
	 * @param seat
	 */
	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	/**
	 * Return format datePattern
	 * @return datePattern
	 */
	public static String getDatePattern() {
		return datePattern;
	}

	/**
	 * Return dateFormatter
	 * 
	 * @return dateFormatter
	 */
	public static DateFormat getDateFormatter() {
		return dateFormatter;
	}
	
	/**
	 * Overriding method definition in order to be more verbose in output
	 * 
	 * @return the formatted string of reservation data
	 */
	@Override
	public String toString() {
		String message = "";
		message += "Seat: "       + getSeat()                   + "\n";
		message += "From: "       + getDepartureCity()          + "\n";
		message += "To: "         + getDestinationCity()        + "\n";
		message += "Departure: "  + getFormattedDepartureDate() + "\n";
		message += "Return: "     + getFormattedReturnDate()    + "\n";
		return message;
	}
}
