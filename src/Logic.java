import java.util.Random;

// this class works as the backend and will generate the password
public class Logic {
    //Character pool
    public static final String lowerCase = "abcdefghijklmnopqrstuvwxyz";
    public static final String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String digits = "0123456789";
    public static final String specialChars = "!@#$%^&*()-_=+{}[]:;,.<>/?";

    // the random class allows us to generate a random number which will be used to randomly choose the characters
    private final Random random;

    public Logic() {
        this.random = new Random();
    }

    public  String generatePass(int length, boolean includeUppercase, boolean includeLowercase,
                                      boolean includeNumbers, boolean includeSpecialSymbols){
        // String Builder for better Efficiency
        StringBuilder pass = new StringBuilder();

        // store valid Characters
        String validChar = "";
        if(includeUppercase) validChar += upperCase;
        if(includeLowercase) validChar += lowerCase;
        if(includeNumbers) validChar += digits;
        if (includeSpecialSymbols) validChar += specialChars;

        // build password
        for (int i = 0; i < length; i++) {
            //generate a random index
            int randomIdx = random.nextInt(validChar.length());

            //get the char based on the random index
            char randomChar = validChar.charAt(randomIdx);

            //store char into password builder
            pass.append(randomChar);

            //do this till we reach the length user provided us
        }

        return pass.toString();
    }
}
