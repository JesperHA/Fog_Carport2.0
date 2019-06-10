package PresentationLayer;

import Exceptions.LoginException;
import Exceptions.OrderException;
import Exceptions.RegisterException;
import FacadeLayer.KundeFacade;
import FacadeLayer.OrderFacade;
import FunctionLayer.SVG;
import Model.Customer;
import Model.Material;
import Model.Order;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.logging.*;

@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String destination = "index.jsp";

        String source = request.getParameter("source");
        HttpSession session = request.getSession();

        Customer login = (Customer) session.getAttribute("login");
        int role = 0;

        if (login != null) {
            role = login.getRole();
        }

        switch (source) {
            case "profil":
                destination = "/WEB-INF/brugerside.jsp";
                break;
            case "logout":
                session.removeAttribute("login");
                destination = "/index.jsp";
                break;
            case "admin":
                if (role == 1) {
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
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private static final Logger LOGGER = Logger.getLogger(FrontController.class.getName());

    private Handler fileHandler = null;
    private SimpleFormatter simpleFormatter = null;
    private ConsoleHandler consoleHandler = null;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Initiate Logging
        try {
            // Tilføj filehandler med formattering
            fileHandler = new FileHandler("C:\\Users\\Jesper\\Desktop\\Fog_Carport3.0\\logs\\frontcontroller_logfile.log", true);
            simpleFormatter = new SimpleFormatter();
            LOGGER.addHandler(fileHandler);
            fileHandler.setFormatter(simpleFormatter);

            fileHandler.setLevel(Level.ALL); // Alle logging levels kommer i filer.

            // Tilføj consolehandler uden formattering (rå format)
            consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.CONFIG); // Levels som kommer i console er Severe, Warning, Info og Config
            LOGGER.addHandler(consoleHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // Logging Færdig

        String destination = "index.jsp";
        String source = request.getParameter("source");

        HttpSession session = request.getSession();

        Customer login;
        login = (Customer) session.getAttribute("login");
        int roleCheck = 0;

        session.removeAttribute("specs");

        ArrayList<Integer> specs;
        specs = (ArrayList<Integer>) session.getAttribute("specs");
        if(specs == null){
            specs = new ArrayList<>();
        }

        session.removeAttribute("materials");

        ArrayList<Material> materialBeregning;
        materialBeregning = (ArrayList<Material>) session.getAttribute("materials");
        if(materialBeregning == null){
            materialBeregning = new ArrayList<>();
        }

        if (login != null) {
            roleCheck = login.getRole();
        }



        switch (source) {

            case "login":
                String email = request.getParameter("email");
                String password = request.getParameter("password");

                try {
                    Customer customerCheck = KundeFacade.checkLogin(email, password);

                    session.setAttribute("login", customerCheck);
                    destination = "/WEB-INF/brugerside.jsp";
                } catch (LoginException e) {
                    e.printStackTrace();

                    request.setAttribute("fail", "failed");
                    destination = "login.jsp";

                    String userAddr = request.getRemoteAddr();
                    String userFailed = "(Email: " + email + " Password:" + password + ")";
                    LOGGER.log(Level.INFO, "Failed login attempt for user " + userFailed);
                    fileHandler.close();
                }
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
                    KundeFacade.checkRegister(createCustomer);
                    destination = "/login.jsp";
                } catch (RegisterException ex) {

                    ex.printStackTrace();

                    request.setAttribute("name", customer_name);
                    request.setAttribute("email", customer_email);
                    request.setAttribute("password", customer_password);
                    request.setAttribute("phone", customer_phone);
                    request.setAttribute("address", customer_address);
                    request.setAttribute("postnr", customer_zipcode);
                    request.setAttribute("by", customer_city);

                    request.setAttribute("fail", ex.getMessage());
                    destination = "registration.jsp";

                    LOGGER.log(Level.INFO, "Failed registration attempt, email used was (" + customer_email + ")");
                    fileHandler.close();
                }

                break;

            case "generate_SVG":

//                int width = Integer.parseInt(request.getParameter("width"));
//                int length = Integer.parseInt(request.getParameter("length"));
//                SVG svg = new SVG();
//
//                session.setAttribute("svg", svg.createSVG(width, length));
//                destination = "printDrawing.jsp";
//                break;

            case "bygcarport":

                ArrayList<Material> materials;

                int size = Integer.parseInt(request.getParameter("size"));
                int shed = Integer.parseInt(request.getParameter("shed"));
                int shedtype = Integer.parseInt(request.getParameter("shedtype"));
                int length = Integer.parseInt(request.getParameter("length"));
                int width = Integer.parseInt(request.getParameter("width"));
                int height = Integer.parseInt(request.getParameter("height"));
                int shedLength = Integer.parseInt(request.getParameter("shed_length"));
                int shedWidth = Integer.parseInt(request.getParameter("shed_width"));
                int rooftype = Integer.parseInt(request.getParameter("rooftype"));
                int roofsort = Integer.parseInt(request.getParameter("roofsort"));

                int[] carportSettings = {size, shed, shedtype, length, width, height, shedLength, shedWidth, rooftype, roofsort};

                session.setAttribute("carportSettings", carportSettings);

                materials = FunctionLayer.MaterialCalculator.carportUdregner(size, shed, shedtype, length, width, height, shedLength, shedWidth, rooftype, roofsort);

                session.setAttribute("materials", materials);




                int spær_antal = 0;
                int stolperAntal = materials.get(0).getAmount();

                for (int i = 0; i < materials.size(); i++) {
                    if(materials.get(i).getProduct_name().equals("spærtræ")){
                        spær_antal = materials.get(i).getAmount();
                    }

                }

                SVG svg = new SVG();

                session.setAttribute("svg", svg.createSVG(width,length, spær_antal, rooftype, stolperAntal, size,shed, shedLength, shedWidth, shedtype));


                destination = "bestilling.jsp";
                break;

            case "search":
                String action;
                Customer foundCustomer;

                ArrayList<Order> orders = OrderFacade.getOrderList();
                ArrayList<Customer> customers = KundeFacade.getKunderList();

                request.setAttribute("searched", "searched");

                if (roleCheck == 1) {

                    request.setAttribute("customers", customers);

                    String kundeSearch = request.getParameter("kunde");
                    request.setAttribute("searchterm", kundeSearch);

                    if (kundeSearch != null) {

                        if (kundeSearch.contains("@")) {
                            String kundeSearchLower = kundeSearch.toLowerCase();

                            action = "mail";
                            foundCustomer = KundeFacade.getCustomer(kundeSearchLower, action);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            boolean found = false;
                            for (char c : kundeSearch.toCharArray()) {
                                if (Character.isDigit(c)) {
                                    sb.append(c);
                                    found = true;
                                } else if (found) {
                                    break;
                                }
                            }
                            action = "id";
                            foundCustomer = KundeFacade.getCustomer(sb.toString(), action);
                        }

                        if (foundCustomer == null) {
                            request.setAttribute("customers", customers);
                            request.setAttribute("orders", orders);
                            destination = "/WEB-INF/admin.jsp";
                        } else {
                            request.setAttribute("customers", customers);
                            request.setAttribute("orders", orders);
                            request.setAttribute("foundCustomer", foundCustomer);

                            ArrayList<Order> customerOrders = OrderFacade.getOrderListForCustomer(foundCustomer.getCustomer_id());

                            request.setAttribute("foundCustomerOrders", customerOrders);

                            destination = "/WEB-INF/admin.jsp";
                        }
                    } else {
                        request.setAttribute("customers", customers);
                        request.setAttribute("orders", orders);
                        destination = "/WEB-INF/admin.jsp";
                    }
                } else {
                    destination = "index.jsp";
                }
                break;

            case "searchorders":
                String type = request.getParameter("type");
                ArrayList<Order> orderArrayList;

                switch (type) {
                    case "single":

                        String order_id = request.getParameter("order_id");
                        Order order;
                        order = OrderFacade.getOrder(Integer.parseInt(order_id));
                        Customer customerRelative = KundeFacade.getCustomer("" + order.getCustomer_id(), "id");

                        if (order != null) {
                            if (roleCheck == 1) {
                                request.setAttribute("customerIQ", customerRelative);
                                request.setAttribute("foundOrder", order);
                                request.setAttribute("type", type);

                            } else if (roleCheck == 0) {
                                if (order.getCustomer_id() == login.getCustomer_id()) {
                                    request.setAttribute("customerIQ", customerRelative);
                                    request.setAttribute("foundOrder", order);
                                    request.setAttribute("type", type);
                                } else {
                                    destination = "index.jsp";
                                    break;
                                }
                            }
                            destination = "WEB-INF/order.jsp";
                        } else {
                            destination = "index.jsp";
                        }
                        break;
                    case "personal":
                        ArrayList<Order> customerOrders = OrderFacade.getOrderListForCustomer(login.getCustomer_id());

                        request.setAttribute("orderlist", customerOrders);
                        request.setAttribute("type", type);
                        destination = "WEB-INF/order.jsp";

                        break;
                    case "all":
                        if (roleCheck == 1) {
                            orderArrayList = OrderFacade.getOrderList();

                            request.setAttribute("orderlist", orderArrayList);
                            request.setAttribute("type", type);

                            destination = "WEB-INF/order.jsp";
                        } else {
                            destination = "index.jsp";
                        }
                        break;
                    default:
                        orderArrayList = OrderFacade.getOrderList();

                        request.setAttribute("orderlist", orderArrayList);
                        request.setAttribute("type", type);

                        destination = "WEB-INF/order.jsp";
                        break;
                }
                break;

            case "changeOrder":
                if (roleCheck == 1) {

                    String typeOf;

                    ArrayList<Order> orderList = OrderFacade.getOrderList();
                    String changeType = request.getParameter("changetype");

                    switch (changeType) {
                        case "order":
                            typeOf = "single";

                            int updateOrder_id = Integer.parseInt(request.getParameter("order_id"));
                            int updateCustomer_id = Integer.parseInt(request.getParameter("customer_id"));
                            int updateSize = Integer.parseInt(request.getParameter("size"));
                            int updateLength = Integer.parseInt(request.getParameter("length"));
                            int updateWidth = Integer.parseInt(request.getParameter("width"));
                            int updateHeight = Integer.parseInt(request.getParameter("height"));
                            int updateRooftype = Integer.parseInt(request.getParameter("roof_type"));
                            int updateRoofsort = Integer.parseInt(request.getParameter("roof_sort"));
                            int updateShed = Integer.parseInt(request.getParameter("shed"));
                            int updateShedtype = Integer.parseInt(request.getParameter("shedtype"));
                            int updateShedLength = Integer.parseInt(request.getParameter("shed_length"));
                            int updateShedWidth = Integer.parseInt(request.getParameter("shed_width"));
                            int updateOrder_status = Integer.parseInt(request.getParameter("order_status")); // order_status
                            String updateDate = request.getParameter("date"); // date

                            String newDate = updateDate.replace("-", "");

                            if (updateShed == 0) {
                                updateShedtype = 0;
                                updateShedLength = 0;
                                updateShedWidth = 0;
                            }

                            Order updateOrder = new Order(updateOrder_id, updateCustomer_id, updateSize, updateLength, updateWidth, updateHeight, updateRooftype, updateRoofsort, updateShed, updateShedtype, updateShedLength, updateShedWidth, updateOrder_status, newDate);

                            Order result = OrderFacade.changeOrder(updateOrder);

                            if (result != null) {
                                Customer updatedCustomerIQ1 = KundeFacade.getCustomer("" + updateCustomer_id, "id");

                                request.setAttribute("foundOrder", result);
                                request.setAttribute("customerIQ", updatedCustomerIQ1);
                                request.setAttribute("orderlist", orderList);
                                request.setAttribute("type", typeOf);

                                destination = "WEB-INF/order.jsp";
                            } else {
                                Customer updatedCustomerIQ2 = KundeFacade.getCustomer("" + updateCustomer_id, "id");

                                request.setAttribute("updateOrderStatus", "fail");
                                request.setAttribute("updateOrderId", updateOrder_id);
                                request.setAttribute("customerIQ", updatedCustomerIQ2);
                                request.setAttribute("orderlist", orderList);
                                request.setAttribute("type", typeOf);

                                destination = "WEB-INF/order.jsp";
                            }
                            break;
                        case "status":
                            typeOf = "single";

                            String statusOrder_id = request.getParameter("order_id");
                            int newStatus = Integer.parseInt(request.getParameter("status"));

                            String success = OrderFacade.changeStatus(statusOrder_id, newStatus);

                            if (success.equals("done")) {
                                Order updatedOrder = OrderFacade.getOrder(Integer.parseInt(statusOrder_id));
                                Customer foundCustomerIQ = KundeFacade.getCustomer("" + updatedOrder.getCustomer_id(), "id");

                                request.setAttribute("customerIQ", foundCustomerIQ);
                                request.setAttribute("foundOrder", updatedOrder);
                                request.setAttribute("orderlist", orderList);
                                request.setAttribute("type", typeOf);
                                destination = "WEB-INF/order.jsp";

                            } else if (success.equals("failed")) {
                                Order updatedOrder = OrderFacade.getOrder(Integer.parseInt(statusOrder_id));
                                Customer foundCustomerIQ = KundeFacade.getCustomer("" + updatedOrder.getCustomer_id(), "id");

                                request.setAttribute("failed", "failed");
                                request.setAttribute("customerIQ", foundCustomerIQ);
                                request.setAttribute("foundOrder", updatedOrder);
                                request.setAttribute("type", typeOf);
                                destination = "WEB-INF/order.jsp";
                            }
                            break;
                        case "delete":
                            typeOf = "all";

                            String order_id = request.getParameter("order_id");

                            Order orderDelete = OrderFacade.getOrder(Integer.parseInt(order_id));

                            if (orderDelete != null) {
                                String success2 = OrderFacade.deleteOrder(orderDelete);

                                orderList = OrderFacade.getOrderList();

                                request.setAttribute("deletedOrder_id", order_id);
                                request.setAttribute("deletedOrder", success2);
                                request.setAttribute("orderlist", orderList);
                                request.setAttribute("type", typeOf);

                                destination = "WEB-INF/order.jsp";
                            }
                            break;
                    }
                }
                break;

            case "allcustomers":
                if (login != null && login.getRole() > 0) {
                    ArrayList<Customer> customerlist = KundeFacade.getKunderList();

                    request.setAttribute("customerlist", customerlist);
                    destination = "/WEB-INF/allCustomers.jsp";
                }
                break;

            case "complete":
                System.out.println("kommer til \"complete\" ");

                size = (int)session.getAttribute("size");
                length = (int)session.getAttribute("length");
                width = (int)session.getAttribute("width");
                height = (int)session.getAttribute("height");
                rooftype = (int)session.getAttribute("rooftype");
                roofsort = (int)session.getAttribute("roofsort");
                shed = (int)session.getAttribute("shed");
                shedtype = (int)session.getAttribute("shedtype");
                shedLength = (int)session.getAttribute("shedLength");
                shedWidth = (int)session.getAttribute("shedWidth");

                LocalDateTime localDateTime;
                localDateTime = LocalDateTime.now();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
                String dato = formatter.format(localDateTime);
                int customer_id = 1;

                Customer loggedIn = (Customer) session.getAttribute("login");
                if (loggedIn != null) {
                    customer_id = loggedIn.getCustomer_id();
                }

                 Order order = new Order(customer_id, size, length, width, height, rooftype, roofsort, shed, shedtype, shedLength, shedWidth, 0, dato);

                try {
                    OrderFacade.createOrder(order);
                } catch (OrderException e) {
                    System.out.println("der skete en fejl i oprettelse af ordre i databasen");

                    String failedOrder = "(ID: " + order.getCustomer_id() + " Size: " + order.getSize() + " Length: " + order.getLength() + " Width: " + order.getWidth() + " Height: " + order.getHeight() + " Tagtype: " + order.getRoof_type() + " Tag Materiale: " + order.getRoof_sort() + " Redskabsskur: " + order.getShed() + " Reds. Type: " + order.getShedtype() + " Reds. Length: " + order.getShed_length() + " Reds. Width: " + order.getShed_width() + " Dato: " + order.getDate() + ")";
                    LOGGER.log(Level.WARNING,login.getId() + ". " + login.getName() + " - Fejl: Ordren blev ikke oprettet i databasen. For ordre " + failedOrder);
                    fileHandler.close();
                }

                destination = "index.jsp";
                break;

        }

        request.getRequestDispatcher(destination).

                forward(request, response);

    }

}
