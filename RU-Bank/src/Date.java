/**
 * The Date class represents a valid date object. It provides functionality to check the validity of a date, compare it to other dates, and
 * convert it to a string for representation. This class is immutable once created.
 *
 * @author Digvijay Singh, Arun Felix
 */

import java.util.Calendar;
public class Date implements Comparable<Date>{

    // constants
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    public static final int JAN = 1;
    public static final int FEB = 2;
    public static final int MAR = 3;
    public static final int APR = 4;
    public static final int MAY = 5;
    public static final int JUN = 6;
    public static final int JUL = 7;
    public static final int AUG = 8;
    public static final int SEP = 9;
    public static final int OCT = 10;
    public static final int NOV = 11;
    public static final int DEC = 12;


    private int year;
    private int month;
    private int day;

    /**
     * Initializes a new Date object with a specified year, month, and day. 
     * Once created, the object is immutable.
     *
     * @param year The year for the date.
     * @param month The month for the date.
     * @param day The day for the date.
     */
    Date (int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public static Date makeDate(String input){
        try {
            String [] dateArray = input.split("/");
            int month = Integer.parseInt(dateArray[0]);
            int day = Integer.parseInt(dateArray[1]);
            int year = Integer.parseInt(dateArray[2]);
            return new Date(year,month,day);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
            return null;
        }
    }
    public int getyear(){
        return this.year;
    }
    public int getmonth(){
        return this.month;
    }
    public int getDay(){
        return this.day;
    }

    /**
     * Checks if the date is valid and meets the specific conditions:
     * 1. It is a future date.
     * 2. It is within the next 6 months.
     * 3. The day and month combination is valid.
     *
     * @return true if the date is valid according to the mentioned conditions,
     * @return false otherwise. If the date is not valid, it prints an error message
     */
    public Boolean isValid() {
        if (month < JAN || month > DEC || day < 1 || isInvalidDayForMonth()) return printError();

        Calendar currCalendar = Calendar.getInstance();
        Date currDate = new Date(currCalendar.get(Calendar.YEAR), currCalendar.get(Calendar.MONTH) + 1, currCalendar.get(Calendar.DAY_OF_MONTH));

        currCalendar.add(Calendar.MONTH, 6);
        Date sixMonthsLater = new Date(currCalendar.get(Calendar.YEAR), currCalendar.get(Calendar.MONTH) + 1, currCalendar.get(Calendar.DAY_OF_MONTH));
        if (this.compareTo(sixMonthsLater) > 0) {
            System.out.println(toString() + ": Event date must be within 6 months!");
            return false;
        }

        return true;
    }

    /**
     * Prints an error message with the date in case the date is invalid.
     *
     * @return returns false indicating that the date is invalid.
     */
    private boolean printError() {
        System.out.println(toString() + ": Invalid calendar date!");
        return false;
    }

    /**
     * Checks if the day is valid for the given month of the Date object.
     * It considers the different number of days in each month and also
     * accounts for leap years for February.
     *
     * @return true if the day is invalid for the given month, false otherwise.
     */
    private boolean isInvalidDayForMonth() {
        int maxDays;
        if (month == FEB) {
            maxDays = isLeapYear(year) ? 29 : 28;
        } else {
            maxDays = (month == APR || month == JUN || month == SEP || month == NOV) ? 30 : 31;
        }
        return day > maxDays;
    }

    /**
     * Compares the specified object with this date for equality.
     * Return true if and only if the specified object is
     * also a date and both dates represent the same year, month, and day.
     *
     * @param the object to be compared for equality with this date.
     * @return true if the specified object is equal to this date,
     *         false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Date otherDate = (Date) obj;

        // Check if year, month, and day are equal
        return year == otherDate.year
                && month == otherDate.month
                && day == otherDate.day;
    }

    /* This is a helper method to check if the year in the date
     * is a leap year or not
     * @param the year of the date as an int
     * return true if the year is a leap year
     */
    private boolean isLeapYear(int year) {
        if (year % QUADRENNIAL != 0) {
            return false;
        }

        if (year % CENTENNIAL != 0) {
            return true;
        }

        return year % QUATERCENTENNIAL == 0;
    }

    /* Compares the current date object to another date object.
     * @param a date object
     * @return returns an int -1 if date is less, 0 if the date is equal and 1 if the date is greater
     */
    @Override
    public int compareTo(Date o) {
        if(this.year != o.year){
            return this.year - o.year;
        };
        if(this.month != o.month){
            return this.month - o.month;
        }
        else return this.day - o.day;
    }

    /**  This method returns a string representation of the date object in the "month/day/year" format
     * @return A string representation of the date object.
     */

    @Override
    public String toString(){
        return this.month + "/" + this.day + "/" + this.year;
    }

    /* The following is the testbed for all various kinds of dates which might be entered by the user
        Here we check for all conditions that need to be met for the date to be a valid date.
    */
    public static void main(String[] args) {
        // Test with invalid month
        testDateValidity(2023, 13, 15, false);

        // Test with invalid day
        testDateValidity(2023, 11, 31, false);

        // Test with a date in the past
        testDateValidity(2023, 9, 24, false);

        // Test with a valid date more than 6 months in the future
        testDateValidity(2024, 10, 15, false);

        // Test with a valid leap year date
        testDateValidity(2024, 2, 29, true);

        // Test with a valid non-leap year date
        testDateValidity(2023, 2, 29, false);

        // Test with a valid date within the next 6 months
        testDateValidity(2023, 10, 28, true);
    }
    // A helper method to execute date checks 
    private static void testDateValidity(int year, int month, int day, boolean expected) {
        Date date = new Date(year, month, day);
        boolean isValid = date.isValid();
        String result = isValid == expected ? "PASSED" : "FAILED";
        System.out.printf("Testing Date: %s Expected: %s Actual: %s Result: %s%n", date, expected, isValid, result);
    }


}