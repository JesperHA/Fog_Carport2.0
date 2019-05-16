package PresentationLayer;

import FacadeLayer.MaterialFacade;
import FunctionLayer.SVG;
import Model.Material;

import java.io.IOException;
import java.util.ArrayList;
import javax.activation.MimeType;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet( name = "MaterialCalculator", urlPatterns = { "/MaterialCalculator" } )
public class MaterialCalculator extends HttpServlet {



    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        String destination = "index.jsp";

        String source = request.getParameter("source");
        HttpSession session = request.getSession();

        session.removeAttribute("specs");

        ArrayList<String> specs;
        specs = (ArrayList<String>) session.getAttribute("specs");
        if(specs == null){
            specs = new ArrayList<>();
        }



        switch(source){

            case "bygcarport":


                // henter parametre her
                int size = Integer.parseInt(request.getParameter("size"));
                int shed = Integer.parseInt(request.getParameter("shed"));
                int shedtype = Integer.parseInt(request.getParameter("shedtype"));
                int length = Integer.parseInt(request.getParameter("length"));
                int width = Integer.parseInt(request.getParameter("width"));
                int height = Integer.parseInt(request.getParameter("height"));
                int shedLength = Integer.parseInt(request.getParameter("shed_length"));
                int shedWidth = Integer.parseInt(request.getParameter("shed_width"));







//                for (int i = 0; i < materials.size(); i++) {
//
//                    System.out.println("Looper igennem antal gange: " + i);
//
//                    String productName = materials.get(i).getProduct_name();
//                    materialSession.add(new Material(0, productName, "Dette er et material", 0));
//                    session.setAttribute("materials", materialSession);
//
//                }



                SVG svg = new SVG();

                session.setAttribute("svg", svg.createSVG(width,length));

                destination = "bestilling.jsp";

                break;
        }

        request.getRequestDispatcher(destination).forward(request,response);
    }



    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        String destination = "index.jsp";


        request.getRequestDispatcher(destination).forward(request,response);
    }
}
