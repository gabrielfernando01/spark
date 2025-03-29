package com.everis.curso.java;

/**
 * Class Password
 *
 * Contains a password and a length
 *
 * @author Grok
 * @version 1.0
 */

/**
 * Make a class called Password that follows the following conditions:
 * It must have the attributes length and password . By default, the length will be 8.
 * The builders will be the following:
 * A default constructor.
 * A constructor with the length we pass. It will generate a random password with that length.
 * The methods it implements will be:
 * isStrong(): returns a boolean indicating whether it is strong or not. To be strong, it must have more
 * than 2 uppercase letters, more than 1 lowercase letter, and more than 5 numbers.
 * generatePassword(): generates the password of the object with the length it has.
 * Get method for password and length.
 * Set method for length.
 *
 * Now, create an executable class:
 * Creates an array of Passwords with the size you specify via keyboard.
 * Create a loop that creates an object for each position in the array.
 * It also indicates the length of the Passwords via keyboard (before the loop).
 * Create another boolean array to store whether the password in the Password array is strong or not (use the loop above).
 *
 * Finally, display the password and whether or not it's strong (use the loop above). Use this simple format:
 * password1 boolean_value1
 * password2 boolean_value2
 */

public class Password {

    // Constants

    /**
     * Default length
     */
    private final static int DEFAULT_LENGTH = 8;

    // Attributes

    /**
     * Length of the password
     */
    private int length;
    /**
     * Password character
     */
    private String password;

    // Public methods

    /**
     * Returns the length
     * @return password length
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns the password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Generates a random password with the defined length
     * @return password
     */
    public String generatePassword() {
        String password = "";
        for (int i = 0; i < length; i++) {
            // Generate a random number, based on it choose whether to add a lowercase, uppercase, or number
            int choice = ((int) Math.floor(Math.random() * 3 + 1));

            if (choice == 1) {
                char lowercase = (char) ((int) Math.floor(Math.random() * (123 - 87) + 97));
                password += lowercase;
            } else {
                if (choice == 2) {
                    char uppercase = (char) ((int) Math.floor(Math.random() * (91 - 65) + 65));
                    password += uppercase;
                } else {
                    char number = (char) ((int) Math.floor(Math.random() * (58 - 48) + 48));
                    password += number;
                }
            }
        }
        return password;
    }

    /**
     * Checks if the password is strong
     * @return true if strong, false otherwise
     */
    public boolean isStrong() {
        int numberCount = 0;
        int lowercaseCount = 0;
        int uppercaseCount = 0;
        // Go character by character and check what type of character it is
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) == 97 && password.charAt(i) <= 122) {
                lowercaseCount += 1;
            } else {
                if (password.charAt(i) >= 65 && password.charAt(i) <= 90) {
                    uppercaseCount += 1;
                } else {
                        numberCount += 1;
                    }
                }
            }
        // If the password has more than 5 numbers, more than 1 lowercase, and more than 2 uppercase
        if (numberCount >= 5 && lowercaseCount >= 1 && uppercaseCount >= 2) {
            return true;
        } else {
            return false;
        }
    }

    // Constructors
    /**
     * Creates a random password
     */
    public Password() {
        this(DEFAULT_LENGTH);
    }

    /**
     * Creates a password with the specified length
     * @param length password length
     */
    public Password(int length) {
        this.length = length;
        this.password = generatePassword();
    }
}
