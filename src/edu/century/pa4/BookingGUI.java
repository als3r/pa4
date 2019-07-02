package edu.century.pa4;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParsePosition;
import java.util.Date;

/**
 * Definition for a GUI class of the book reservation program
 * 
 * Class: CSCI 1082-90 - Object Oriented Programming
 * Instructor: Matthew Sanders
 * Assignment: Programming Assignment 4
 * 
 * Date: July 02, 2019
 * Due:  Jule 04, 2019
 * @author Alexandr Sergeyev <ns1418cz@my.century.edu>
 */
public class BookingGUI extends JFrame implements ActionListener 
{
	/**
	 * If debug set to true
	 * prints console messages not only to console text area, 
	 * but also to console
	 */
	private boolean debug = false;
	
	/**
	 * Program Name
	 */
	private static final String PROGRAM_NAME = "Fly AnyWhere";
	
	/**
	 * Version
	 */
	private static final long serialVersionUID = 1;
	
	/**
	 * Window's width
	 */
	private static final int WINDOW_WIDTH  = 1024;
	
	/**
	 * Window's height
	 */
	private static final int WINDOW_HEIGHT = 768;
	
	/**
	 * Console text area's "width" in number of characters
	 */
	private static final int TEXTARE_NUMBER_OF_CHAR = 85;
	
	/**
	 * Console text area's "height" in number of lines
	 */
	private static final int TEXTAREA_NUMBER_OF_LINES = 32;
	
	/**
	 * Number of character for input text fields
	 */
	private static final int NUMBER_OF_CHAR_INPUT = 10;
    
	/**
	 * Current passenger, instance of Passenger
	 */
    public Passenger passenger = new Passenger(); 
    
    /**
	 * Max number of passengers in passengers array
	 */
	private static final int MAX_NUMBER_OF_PASSENGERS = 1000;
    
    /**
	 * Array of passengers (Passenger type)
	 */
    public Passenger[] passengers = new Passenger[MAX_NUMBER_OF_PASSENGERS];
    
    /**
     * JTextField for first name
     */
    JTextField firstNameTextField       = new JTextField(NUMBER_OF_CHAR_INPUT);
    
    /**
     * JTextField for last name
     */
    JTextField lastNameTextField        = new JTextField(NUMBER_OF_CHAR_INPUT);
    
    /**
     * JTextField for departure city
     */
    JTextField departureCityTextField   = new JTextField(NUMBER_OF_CHAR_INPUT);
    
    /**
     * JTextField for destination city
     */
    JTextField destinationCityTextField = new JTextField(NUMBER_OF_CHAR_INPUT);
    
    /**
     * JTextField for departure date
     */
    JTextField departureDateTextField   = new JTextField(NUMBER_OF_CHAR_INPUT);
    
    /**
     * JTextField for return date
     */
    JTextField returnDateTextField      = new JTextField(NUMBER_OF_CHAR_INPUT);
    
    /**
     * JComboBox for seat selector
     */
    JComboBox  seatSelectorBox          = new JComboBox(Reservation.SEATS_ARRAY);
    
    /**
     * JTextArea for Console textArea
     */
    public JTextArea consoleTextArea;
    
    
    /**
     * Main function
     * 
     * @param args
     */
    public static void main(String[] args) {
    	BookingGUI gui = new BookingGUI( );
    	// in order to display window centrally
    	gui.setLocationRelativeTo(null);
        gui.setVisible(true);
	}

    /**
     * Constructor
     */
    public BookingGUI( )
    {
        super(PROGRAM_NAME);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create main panel
        JPanel formPanel = new JPanel();
        SpringLayout layout = new SpringLayout();
        formPanel.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        formPanel.setLayout(layout);
        
        //define form labels
        JLabel firstNameLabel       = new JLabel("First Name", SwingConstants.RIGHT);
        JLabel lastNameLabel        = new JLabel("Last Name",  SwingConstants.RIGHT);
        JLabel departureCityLabel   = new JLabel("From",       SwingConstants.RIGHT);
        JLabel destinationCityLabel = new JLabel("To",         SwingConstants.RIGHT);
        JLabel departureDateLabel   = new JLabel("Departure",  SwingConstants.RIGHT);
        JLabel returnDateLabel      = new JLabel("Return",     SwingConstants.RIGHT);
        JLabel seatSelectorLabel    = new JLabel("Seat",       SwingConstants.RIGHT);
        
        // Define buttons
        JButton actionBookButton = new JButton("Book");
        actionBookButton.addActionListener(this);
        JButton actionListReservationButton = new JButton("List Reservation");
        actionListReservationButton.addActionListener(this);
        JButton actionClearConsoleButton = new JButton("Clear Console");
        actionClearConsoleButton.addActionListener(this);
        
        // Define Console Text Area
        // Label and border around console text area
        JPanel consolePanel = new JPanel ();
        consolePanel.setBorder ( new TitledBorder ( new EtchedBorder (), "Console" ) );
        // text area
        consoleTextArea = new JTextArea(TEXTAREA_NUMBER_OF_LINES, TEXTARE_NUMBER_OF_CHAR);
        // add scroll to text area
        JScrollPane scrollPanel = new JScrollPane(consoleTextArea);
        scrollPanel.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        consolePanel.add(scrollPanel);
        
        // set default values to form
        firstNameTextField.setText(passenger.getFirstName());
        lastNameTextField.setText(passenger.getLastName());
        departureCityTextField.setText(passenger.getReservation().getDepartureCity());
        destinationCityTextField.setText(passenger.getReservation().getDestinationCity());
        departureDateTextField.setText(Reservation.getDateFormatter().format(passenger.getReservation().getDepartureDate())); 
        returnDateTextField.setText(Reservation.getDateFormatter().format(passenger.getReservation().getReturnDate())); 
        
        
        // Layout
        formPanel.add(firstNameTextField);
        formPanel.add(lastNameTextField);
        formPanel.add(departureCityTextField);
        formPanel.add(destinationCityTextField);
        formPanel.add(departureDateTextField);
        formPanel.add(returnDateTextField);
        formPanel.add(seatSelectorBox);
        
        formPanel.add(firstNameLabel);
        formPanel.add(lastNameLabel);
        formPanel.add(departureCityLabel);
        formPanel.add(destinationCityLabel);
        formPanel.add(departureDateLabel);
        formPanel.add(returnDateLabel);
        formPanel.add(seatSelectorLabel);
        
        formPanel.add(actionBookButton);
        formPanel.add(actionListReservationButton);
        formPanel.add(actionClearConsoleButton);
        formPanel.add(consolePanel);
        
        // Padding from side of the window
        int leftPadding1 = 10; 
        int leftPadding2 = 80;
        int leftPadding3 = 250;
        int leftPadding4 = 320;

        // Row 1 - First Name
        layout.putConstraint(SpringLayout.WEST,  firstNameLabel, leftPadding1, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, firstNameLabel, 10, SpringLayout.NORTH, formPanel);
        layout.putConstraint(SpringLayout.WEST,  firstNameTextField,  leftPadding2, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, firstNameTextField,  10, SpringLayout.NORTH, formPanel);
        
        // Row 1 - Last Name
        layout.putConstraint(SpringLayout.WEST,  lastNameLabel, leftPadding3, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, lastNameLabel, 10, SpringLayout.NORTH, formPanel);
        layout.putConstraint(SpringLayout.WEST,  lastNameTextField,  leftPadding4, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, lastNameTextField,  10, SpringLayout.NORTH, formPanel);
        
        // Row 2 - From
        layout.putConstraint(SpringLayout.WEST,  departureCityLabel, leftPadding1, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, departureCityLabel, 40, SpringLayout.NORTH, formPanel);
        layout.putConstraint(SpringLayout.WEST,  departureCityTextField,  leftPadding2, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, departureCityTextField,  40, SpringLayout.NORTH, formPanel);
        
        // Row 2 - To
        layout.putConstraint(SpringLayout.WEST,  destinationCityLabel, leftPadding3, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, destinationCityLabel, 40, SpringLayout.NORTH, formPanel);
        layout.putConstraint(SpringLayout.WEST,  destinationCityTextField,  leftPadding4, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, destinationCityTextField,  40, SpringLayout.NORTH, formPanel);
        
        // Row 3 - Departure
        layout.putConstraint(SpringLayout.WEST,  departureDateLabel, leftPadding1, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, departureDateLabel, 70, SpringLayout.NORTH, formPanel);
        layout.putConstraint(SpringLayout.WEST,  departureDateTextField,  leftPadding2, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, departureDateTextField,  70, SpringLayout.NORTH, formPanel);
        
        // Row 3 - Return
        layout.putConstraint(SpringLayout.WEST,  returnDateLabel, leftPadding3, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, returnDateLabel, 70, SpringLayout.NORTH, formPanel);
        layout.putConstraint(SpringLayout.WEST,  returnDateTextField,  leftPadding4, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, returnDateTextField,  70, SpringLayout.NORTH, formPanel);
        
        // Row 4 - Seat
        layout.putConstraint(SpringLayout.WEST,  seatSelectorLabel, leftPadding1, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, seatSelectorLabel, 100, SpringLayout.NORTH, formPanel);
        layout.putConstraint(SpringLayout.WEST,  seatSelectorBox,  leftPadding2, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, seatSelectorBox,  100, SpringLayout.NORTH, formPanel);
        
        // Row 5 - Buttons
        layout.putConstraint(SpringLayout.WEST,  actionBookButton, leftPadding1, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, actionBookButton, 130, SpringLayout.NORTH, formPanel);
        layout.putConstraint(SpringLayout.WEST,  actionListReservationButton,  100, SpringLayout.EAST, actionBookButton);
        layout.putConstraint(SpringLayout.NORTH, actionListReservationButton,  130, SpringLayout.NORTH, formPanel);
        layout.putConstraint(SpringLayout.WEST,  actionClearConsoleButton,  100, SpringLayout.EAST, actionListReservationButton);
        layout.putConstraint(SpringLayout.NORTH, actionClearConsoleButton,  130, SpringLayout.NORTH, formPanel);
        
        // Row 6 - Console
        layout.putConstraint(SpringLayout.WEST,  consolePanel, leftPadding1, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, consolePanel, 170, SpringLayout.NORTH, formPanel);
        layout.putConstraint(SpringLayout.WEST,  consoleTextArea, leftPadding1, SpringLayout.WEST, formPanel);
        layout.putConstraint(SpringLayout.NORTH, consoleTextArea, 185, SpringLayout.NORTH, formPanel);
        
        add(formPanel);
    }
    
    /**
     * Buttons click handler
     */
    public void actionPerformed(ActionEvent e)
    {
        String actionCommand = e.getActionCommand( );
        
        if (actionCommand.equals("Book")) {
        	
        	// Book action
        	bookReservation();   
        
        } else if (actionCommand.equals("List Reservation")) {
        	
        	// List Reservation action
        	listReservations();
        	
        } else if (actionCommand.equals("Clear Console")) {
        	
        	// Clear Console action
        	clearConsole();
        	
	    } else {
	    	
	    	// Could not find action
        	consoleTextArea.setText("Unexpected error.");
        }
    }
    
    /**
     * Validate reservation form
     * 
     * @return String with error message, empty String if no error
     */
    public String validateReservation()
    {
		String errorMessage = "";
    	
    	// Validate  if input empty
    	if(firstNameTextField.getText().isEmpty()) {
    		errorMessage += "First Name cannot be blank." + "\n";
    	}
    	if(lastNameTextField.getText().isEmpty()) {
    		errorMessage += "Last Name cannot be blank." + "\n";
    	}
    	if(departureCityTextField.getText().isEmpty()) {
    		errorMessage += "Destination City cannot be blank." + "\n";
    	}
    	if(destinationCityTextField.getText().isEmpty()) {
    		errorMessage += "Destination City cannot be blank." + "\n";
    	}
    	if(departureDateTextField.getText().isEmpty()) {
    		errorMessage += "Departure Date cannot be blank." + "\n";
    	}	
    	if(returnDateTextField.getText().isEmpty()) {
    		errorMessage += "Return Date cannot be blank." + "\n";
    	}
    	
    	// Validate dates
    	if(! departureDateTextField.getText().isEmpty() && ! returnDateTextField.getText().isEmpty()) {
    		
    		Date today         = Reservation.getDateFormatter().parse(Reservation.getDateFormatter().format(new Date()), new ParsePosition(0));
    		Date departureDate = Reservation.getDateFormatter().parse(departureDateTextField.getText(), new ParsePosition(0));
    		Date returnDate    = Reservation.getDateFormatter().parse(returnDateTextField.getText(), new ParsePosition(0));
    		
    		try {
    			// Validate departure date against today
    			if(departureDate.before(today)) {
            		errorMessage += "Deparure Date cannot be in the past." + "\n";
            	}
    			
    			// Validate return date against today
    			if(returnDate.before(today)) {
            		errorMessage += "Return Date cannot be in the past." + "\n";
            	}
    			
    			// Validate return and departure date
        		if(returnDate.before(departureDate)) {
        			errorMessage += "Return date must be after deparure date." + "\n";
            	}
        		
        		// Validate seat - if seat available for specific dates
            	if(! isSeatAvailable(String.valueOf(seatSelectorBox.getSelectedItem()), departureDate, returnDate, departureCityTextField.getText(), destinationCityTextField.getText())) {
            		errorMessage += "Sorry seat has been reserved!" + "\n";
            		errorMessage += "Please check seat number, departure city, destination city, departure and return dates!" + "\n";
            	}
        		
        		
			} catch (java.lang.NullPointerException e) {
				errorMessage += "Dates should be in 'MM/DD/YYYY' format." + "\n";
			}        	
    	}
    	
    	
    	
    	return errorMessage;
    }
    

    /**
     * "Book" reservation
     * validate form first, then
     * add information about passenger to array of passengers
     * 
     * if there are some errors in the form print error message to console
     * 
     * @return whether "booking" was successful
     */
    public boolean bookReservation() {
    	
    	String errorMessage = validateReservation();
    	
    	if(! errorMessage.isEmpty()) {
    		clearConsole();
    		writeToConsole("Form Validation Errors: \n" + errorMessage);
    		return false;
    	}

    	// assigning form fields to current/temporary passenger
    	passenger = new Passenger();
    	passenger.setFirstName(firstNameTextField.getText());
    	passenger.setLastName(lastNameTextField.getText());
    	passenger.getReservation().setDepartureCity(departureCityTextField.getText());
    	passenger.getReservation().setDestinationCity(destinationCityTextField.getText());
    	passenger.getReservation().setDepartureDate(departureDateTextField.getText());
    	passenger.getReservation().setReturnDate(returnDateTextField.getText());
    	passenger.getReservation().setSeat(String.valueOf(seatSelectorBox.getSelectedItem()));
    	
    	// try to add passenger to passengers' array
    	if(! addPassenger(passenger)) {
    		writeToConsole("Cannot add passenger.");
    		return false;
    	} else {
    		String successMessage = "Reservation completed for ";
    		successMessage += passenger.getFirstName() + " " + passenger.getLastName() + "!" + "\n";
    		writeToConsole(successMessage);
    		passenger = null;
    		return true;
    	}    	
    }
    
    /**
     * Print out all reservations to console text area
     * 
     * @return
     */
    public String listReservations() {
    	String message = "";
    	for(int i=0; i < passengers.length; i++) {
    		if(passengers[i] != null && passengers[i] instanceof Passenger) {
    			if(! message.isEmpty()) {
    				message += "\n";
    			}
    			message += "*****Reservation" + (i+1) + "*****" + "\n";
    			message += passengers[i].toString();
    		}
    	}
    	if(! message.isEmpty()) {
    		message = "Reservation List" + "\n" + message;
    		clearConsole();
    		writeToConsole(message);
    		return message;
    	} else {
    		message = "No reservations." + "\n";
    		writeToConsole(message);
    		return message;
    	}
    	
    }
    
    /**
     * Add passenger to passengers array 
     * 
     * @param passenger
     * @return
     */
    public boolean addPassenger(Passenger passenger) {    	  
    	for(int i=0; i < passengers.length; i++) {
    		if(passengers[i] == null) {
    			passengers[i] = passenger;
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Checks if seat is taken for specified dates, destination and departure cities
     * 
     * The same passenger can have several seats, 
     * but 1 seat cannot be available for several passengers
     * 
     * @param seat
     * @return whether there is a passenger in passengers array 
     * with the same seat, destination and departure cities,
     * same departure and return dates
     */
    public boolean isSeatAvailable(String seat, Date departureDate, Date returnDate, String departureCity, String destinationCity) {
    	for(int i=0; i < passengers.length; i++) {
    		if(passengers[i] != null) {
    			if(
    					passengers[i].getReservation().getSeat().equals(seat) &&
    					passengers[i].getReservation().getDepartureCity().equals(departureCity) &&
    					passengers[i].getReservation().getDestinationCity().equals(destinationCity) &&
    					passengers[i].getReservation().getDepartureDate().equals(departureDate) && 
    					passengers[i].getReservation().getReturnDate().equals(returnDate)
				) {    				
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    /**
     * Clear console text area
     */
    public void clearConsole() {
    	consoleTextArea.setText("");
    }
    
    /**
     * Write to console text area
     * 
     * If debug set to true print message also in the system console
     * 
     * @param message
     */
    public void writeToConsole(String message) {
    	String currentConsoleText = consoleTextArea.getText();
    	consoleTextArea.setText(currentConsoleText + message);
    	if(debug) {
        	System.out.print(currentConsoleText + message);
    	}
    }
}
