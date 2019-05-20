package Exceptions;

public class LoginException extends Exception {

    public LoginException(String mail, String pass, String message) {
        super(message + "for Email: " + mail + " & Password: " + pass);
    }

}
