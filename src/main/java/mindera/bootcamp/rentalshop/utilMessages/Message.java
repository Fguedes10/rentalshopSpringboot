package mindera.bootcamp.rentalshop.utilMessages;

public class Message {

    //  VEHICLEDTO MESSAGES
    public static final String BLANK_BRAND = "Must have a brand";
    public static final String BLANK_PLATE_NUMBER = "Must have a plateNumber";
    public static final String BLANK_COLOR = "Must have a color";
    public static final String BLANK_CUBIC = "Must have Cubic Capacity";
    public static final String BLANK_HORSE_POWER = "Must have a number of horse power";
    public static final String BLANK_MILEAGE = "Must have a mileage number";
    public static final String BLANK_NUMBER_OF_SEATS = "Must have a number of seats";
    public static final String INVALID_NUMBER_OF_SEATS = "Please input a valid number of seats";
    public static final String BLANK_REGISTRATION_DATE = "Must have a vehicle registration date";
    public static final String INVALID_REGISTRATION_DATE = "Please input a valid date";
    public static final String BLANK_DAILY_PRICE = "Must have a daily price";
    public static final String INVALID_DAILY_PRICE = "Please input a Daily Price";


    //CLIENTSERVICEIMPL MESSAGES

    public static final String CLIENT_WITH_ID = "The client with id ";
    public static final String NOT_EXISTS = " does not exist";
    public static final String REPEATED_EMAIL_ERROR = "A client with these email already exists.";

    //VEHICLESERVICEIMPL MESSAGES

    public static final String VEHICLE_WITH_ID = "The vehicle with id ";
    public static final String REPEATED_PLATE_ERROR = "A vehicle with these plate number already exists.";

    //RENTALSERVICEIMPL MESSAGES
    public static final String RENTAL_WITH_ID = "The rental with id ";
    public static final String ALREADY_RENTED = "This vehicle is currently rented.";


    //CLIENTDBO

    public static final String BLANK_FIRSTNAME = "Must have a First Name";
    public static final String BLANK_LASTNAME = "Must have a Last Name";
    public static final String BLANK_EMAIL = "Must have a Email";

    public static final String INVALID_NIF = "Please input a valid NIF number";
    public static final String BLANK_NIF = "Must have a NIF";
    public static final String BLANK_DATEOFBIRTH = "Must have a date of birth";
    public static final String INVALID_DATEOFBIRTH = "Must be a valid date of birth";
    public static final String BLANK_DRIVERLICENSE = "Must have a Driver License number";
    public static final String INVALID_DRIVERLICENSE = "Please input a valid Driver License number";


    // CLIENTPATCHDTO

    public static final String INVALID_FIRSTNAME = "Please input a valid First Name";
    public static final String INVALID_LASTNAME = "Please input a valid First Name";



    //RENTALPATCHDTO

    public static final String INVALID_END_DATE = "Please input a valid End Date";



    //RENTALCREATEDTO

    public static final String INVALID_VEHICLE_ID = "Please input a valid Vehicle Id";
    public static final String INVALID_CLIENT_ID = "Please input a valid Client Id";
    public static final String INVALID_START_DATE = "Please input a Start Date";


    //Execptions

    public static final String KNOW_EXPECTION = "Known Exception: %d";

}
