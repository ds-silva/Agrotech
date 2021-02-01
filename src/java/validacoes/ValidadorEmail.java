package validacoes;

import java.util.regex.Pattern;

/**
 *
 * @author lluan
 */

public class ValidadorEmail {

    public static boolean isEmailValid(String email) {
        final Pattern EMAIL_REGEX = Pattern.compile("([A-Za-z0-9-_.]+@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)", Pattern.CASE_INSENSITIVE);
        return EMAIL_REGEX.matcher(email).matches();
    }

}
