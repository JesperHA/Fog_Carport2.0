package PresentationLayer;

import FunctionLayer.Authentication;
import Exceptions.LoginSampleException;
import Model.Customer;
import Model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String name = request.getParameter("name");
        String email = request.getParameter( "email");
        String password = request.getParameter( "password");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String postnr = request.getParameter("postnr");
        String by = request.getParameter("by");

        Customer customer = Authentication.createCustomer( name, email, password, phone, address, postnr, by);

        HttpSession session = request.getSession();
        session.setAttribute( "user", customer );
        return "";
    }

}
