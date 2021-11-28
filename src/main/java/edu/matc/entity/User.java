package edu.matc.entity;

import lombok.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * A class to represent a user.
 *
 * @author pwaite
 */
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private LocalDate dateOfBirth;

    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    /**
     * Instantiates a new User.
     *
     * @param firstName   the first name
     * @param lastName    the last name
     * @param userName    the user name
     * @param dateOfBirth the user date of birth
     */
    public User(String firstName, String lastName, String userName, String dateOfBirth) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.dateOfBirth = LocalDate.parse(dateOfBirth, dateTimeFormatter);
    }

    /**
     * Instantiates a new User.
     *
     * @param id          the id
     * @param firstName   the first name
     * @param lastName    the last name
     * @param userName    the user name
     * @param dateOfBirth the date of birth
     */
    public User(int id, String firstName, String lastName, String userName, String dateOfBirth) {
        this(firstName, lastName, userName, dateOfBirth);
        this.id = id;

    }


    /**
     * Gets date of birth for display in datepicker
     *
     * @return the date of birth as a string
     */
    public String getDateOfBirthForDisplay() {
        return dateTimeFormatter.format(dateOfBirth);
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {

        return (int)ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
    }

}