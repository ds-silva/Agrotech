package validacoes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author lluan
 */
public class ValidadorSenha {

    public static boolean
            isValidPassword(String password) {
                
                /***
                 * ^ represents starting character of the string.
                   (?=.*[0-9]) represents a digit must occur at least once.
                   (?=.*[a-z]) represents a lower case alphabet must occur at least once.
                   (?=.*[A-Z]) represents an upper case alphabet that must occur at least once.
                   (?=.*[@#$%^&-+=()] represents a special character that must occur at least once.
                   (?=\\S+$) white spaces don’t allowed in the entire string.
                   .{8, 20} represents at least 8 characters and at most 20 characters.
                   $ represents the end of the string.
                 */

        // Regex to check valid password. 
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";

        // Compile the ReGex 
        Pattern p = Pattern.compile(regex);

        // If the password is empty 
        // return false 
        if (password == null) {
            return false;
        }

        // Pattern class contains matcher() method 
        // to find matching between given password 
        // and regular expression. 
        Matcher m = p.matcher(password);

        // Return if the password 
        // matched the ReGex 
        return m.matches();
    }

}
