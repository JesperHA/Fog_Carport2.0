package PresentationLayer;

import FunctionLayer.Authentication;
import Exceptions.LoginSampleException;
import Model.Customer;
import Model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 The purpose of Login is to...

 @author kasper
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );

        Customer customer = Authentication.login( email, password );

        HttpSession session = request.getSession();
        session.setAttribute( "user", customer );
        return "page";
    }

}
