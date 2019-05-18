/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import DBAccess.CustomerMapper;
import Exceptions.LoginSampleException;
import FacadeLayer.KundeFacade;
import FacadeLayer.OrderFacade;
import FunctionLayer.SVG;
import Model.Customer;
import Model.Order;
import Model.User;

import java.io.IOException;
import java.util.ArrayList;
import javax.activation.MimeType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**

 @author kasper
 */
@WebServlet( name = "FrontController", urlPatterns = { "/FrontController" } )
public class FrontController extends HttpServlet {


    /**
     Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     methods.

     @param request servlet request
     @param response servlet response
     @throws ServletException if a servlet-specific error occurs
     @throws IOException if an I/O error occurs
     */
    protected void processRequest( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        try {
            Command action = Command.from( request );
            String view = action.execute( request, response );
            request.getRequestDispatcher( "/WEB-INF/" + view + ".jsp" ).forward( request, response );
        } catch ( LoginSampleException ex ) {
            request.setAttribute( "error", ex.getMessage() );
            request.getRequestDispatcher( "fejl.jsp" ).forward( request, response );
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     Handles the HTTP <code>GET</code> method.

     @param request servlet request
     @param response servlet response
     @throws ServletException if a servlet-specific error occurs
     @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        String destination = "index.jsp";

        String source = request.getParameter("source");
        HttpSession session = request.getSession();

        ArrayList<Customer> login = (ArrayList<Customer>) session.getAttribute("login");
        int role;

        switch(source){

            case "profil":
                destination = "/WEB-INF/brugerside.jsp";
                break;

            case "logout":
                session.removeAttribute("login");

                destination = "/index.jsp";
                break;
            case "admin":

                role = 0;
                role = login.get(0).getRole();

                if (login != null && role == 1) {
                    ArrayList<Customer> customers = KundeFacade.getKunderList();
                    ArrayList<Order> orders = OrderFacade.getOrderList();

                    request.setAttribute("customers", customers);
                    request.setAttribute("orders", orders);

                    destination = "/WEB-INF/admin.jsp";
                } else {
                    destination = "index.jsp";
                }
                break;

        }

        request.getRequestDispatcher(destination).forward(request,response);
    }

    /**
     Handles the HTTP <code>POST</code> method.

     @param request servlet request
     @param response servlet response
     @throws ServletException if a servlet-specific error occurs
     @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {


        String destination = "index.jsp";
        String source = request.getParameter("source");

        HttpSession session = request.getSession();

        ArrayList<Customer> login = (ArrayList<Customer>) session.getAttribute("login");
        int roleCheck;

        ArrayList<Customer> customer;
        customer = (ArrayList<Customer>) session.getAttribute("login");
        if(customer == null){
            customer = new ArrayList<>();
        }


        switch(source){

            case "login":

                ArrayList<Customer> customerList = FacadeLayer.KundeFacade.getKunderList();

                String email = request.getParameter("email");
                String password = request.getParameter("password");


                for (int i = 0; i < customerList.size(); i++) {
                    if(customerList.get(i).getEmail().equals(email) && customerList.get(i).getPassword().equals(password)){

                        int customer_id = customerList.get(i).getCustomer_id();
                        String name = customerList.get(i).getName();
                        String phone = customerList.get(i).getPhone();
                        String address = customerList.get(i).getAdress();
                        String zipcode = customerList.get(i).getZipcode();
                        String city = customerList.get(i).getCity();
                        int role = customerList.get(i).getRole();
                        customer.add(new Customer(customer_id, name, email, password, phone, address, zipcode, city, role));
                        session.setAttribute("login", customer);
                    }

                }
                destination = "/WEB-INF/brugerside.jsp";
                break;

            case "register":

                String customer_name = request.getParameter("name");
                String customer_email = request.getParameter("email");
                String customer_password = request.getParameter("password");
                String customer_phone = request.getParameter("phone");
                String customer_address = request.getParameter("address");
                String customer_zipcode = request.getParameter("postnr");
                String customer_city = request.getParameter("by");

                Customer createCustomer = new Customer(customer_name, customer_email, customer_password, customer_phone, customer_address, customer_zipcode, customer_city, 0);

                try {
                    CustomerMapper.createCustomer(createCustomer);

                    destination = "/login.jsp";

                } catch (LoginSampleException ex) {
                    ex.printStackTrace();
                }

                break;

            case "generate_SVG":

                int width = Integer.parseInt(request.getParameter("width"));
                int length = Integer.parseInt(request.getParameter("length"));
                SVG svg = new SVG();

                session.setAttribute("svg", svg.createSVG(width,length));

                destination = "printDrawing.jsp";
                break;

            case "bygcarport":
                destination = "bestilling.jsp";
                break;
            case "search":

                roleCheck = 0;

                roleCheck = login.get(0).getRole();

                String action;
                Customer foundCustomer = null;

                request.setAttribute("searched", "searched");

                if (login != null && roleCheck == 1) {

                    ArrayList<Customer> customers = KundeFacade.getKunderList();

                    request.setAttribute("customers", customers);

                    String kundeSearch = (String) request.getParameter("kunde");
                    request.setAttribute("searchterm", kundeSearch);

                    System.out.println("SearchTerm: " + kundeSearch);

                    if (kundeSearch != null || !kundeSearch.isEmpty()) {

                        if (kundeSearch.contains("@")) {
                            // Extract full string as email

                            String kundeSearchLower = kundeSearch.toLowerCase();

                            action = "mail";
                            foundCustomer = KundeFacade.getCustomer(kundeSearchLower, action);
                        } else {
                            // Extract all numbers to make sure it's only numbers.

                            StringBuilder sb = new StringBuilder();
                            boolean found = false;
                            for (char c : kundeSearch.toCharArray()) {
                                if (Character.isDigit(c)) {
                                    sb.append(c);
                                    found = true;
                                } else if (found) {
                                    // If we already found a digit before and this char is not a digit, stop looping
                                    break;
                                }
                            }

                            System.out.println("Numbers: " + sb.toString());

                            action = "id";
                            foundCustomer = KundeFacade.getCustomer(sb.toString(), action);
                        }

                        if (foundCustomer == null || foundCustomer.equals(null)) {
                            destination = "/WEB-INF/admin.jsp";
                        } else {

                            request.setAttribute("foundCustomer", foundCustomer);

                            destination = "/WEB-INF/admin.jsp";
                        }

                    } else {
                        destination = "/WEB-INF/admin.jsp";
                    }
                } else {
                    destination = "index.jsp";
                }
                break;
            case "searchorders":

                roleCheck = 0;
                roleCheck = login.get(0).getRole();

                String type = (String) request.getParameter("type");
                ArrayList<Order> orders;

                if (login != null && roleCheck == 1) {
                    if (type.equals("single")) {
                        // find en enkelt ordre

                        String order_id = (String) request.getParameter("order_id");

                        Order order = null;
                        order = OrderFacade.getOrder(Integer.parseInt(order_id));
                        if (order != null) {

                            Customer customerRelative = KundeFacade.getCustomer("" + order.getCustomer_id(), "id");

                            request.setAttribute("customerIQ", customerRelative);
                            request.setAttribute("foundOrder", order);
                            request.setAttribute("type", type);

                            destination = "WEB-INF/order.jsp";
                        }
                    } else {
                        // send alle ordre

                        orders = OrderFacade.getOrderList();

                        request.setAttribute("orderlist", orders);
                        request.setAttribute("type", type);

                        destination = "WEB-INF/order.jsp";
                    }

                } else {
                    destination = "index.jsp";
                }
                break;
            case "changeOrder":
                roleCheck = 0;
                roleCheck = login.get(0).getRole();

                if (login != null && roleCheck == 1) {

                    String typeOf;

                    ArrayList<Order> orderList = OrderFacade.getOrderList();
                    String changeType = request.getParameter("changetype");

                    if (changeType.equals("order")) {

                        typeOf = "single";

                        int updateOrder_id = Integer.parseInt(request.getParameter("updateOrder_id"));
                        int updateCustomer_id = Integer.parseInt(request.getParameter("updateCustomer_id"));
                        int updateLength = Integer.parseInt(request.getParameter("updateLength")); // length
                        int updateHeight = Integer.parseInt(request.getParameter("updateHeight")); // height
                        int updateWidth = Integer.parseInt(request.getParameter("updateWidth")); // width
                        int updateRoof = Integer.parseInt(request.getParameter("updateRoof")); // roof
                        int updateShed = Integer.parseInt(request.getParameter("updateShed")); // shed
                        int updateShedtype = Integer.parseInt(request.getParameter("updateShedtype")); // shedtype
                        int updateOrder_status = Integer.parseInt(request.getParameter("updateOrder_status")); // order_status
                        String updateDate = request.getParameter("updateDate"); // date

                        Order updateOrder = new Order(updateOrder_id, updateCustomer_id, updateLength, updateHeight, updateWidth, updateRoof, updateShed, updateShedtype, updateOrder_status, updateDate);

                        Order result = OrderFacade.changeOrder(updateOrder);

                        if (result != null) {
                            request.setAttribute("foundOrder", result);
                            request.setAttribute("orderlist", orderList);
                            request.setAttribute("type", typeOf);
                            destination = "WEB-INF/order.jsp";
                        } else {
                            request.setAttribute("updateOrderStatus", "fail");
                            request.setAttribute("updateOrderId", updateOrder_id);

                            request.setAttribute("orderlist", orderList);
                            request.setAttribute("type", typeOf);
                            destination = "WEB-INF/order.jsp";
                        }
                    } else if (changeType.equals("status")){
                        typeOf = "single";

                        String statusOrder_id = request.getParameter("statusOrder_id");
                        int newStatus = Integer.parseInt(request.getParameter("newStatus"));

                        String success = OrderFacade.changeStatus(statusOrder_id, newStatus);

                        if (success.equals("done")) {
                            Order updatedOrder = OrderFacade.getOrder(Integer.parseInt(statusOrder_id));
                            request.setAttribute("foundOrder", updatedOrder);
                            request.setAttribute("orderlist", orderList);
                            request.setAttribute("type", typeOf);
                            destination = "WEB-INF/order.jsp";
                        } else if (success.equals("delete")) {
                            // To Be Done
                        }
                    }
                }
                break;

        }

        request.getRequestDispatcher(destination).forward(request,response);

//        processRequest( request, response );

    }

    /**
     Returns a short description of the servlet.

     @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
