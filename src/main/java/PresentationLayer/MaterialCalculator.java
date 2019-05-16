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

        session.removeAttribute("materials");

        ArrayList<Material> materialBeregning;
        materialBeregning = (ArrayList<Material>) session.getAttribute("materials");
        if(materialBeregning == null){
            materialBeregning = new ArrayList<>();
        }




        switch(source){

            case "bygcarport":

                ArrayList<Material> materialList = MaterialFacade.getMaterials();

                int nedgravningICm = 100;


                //henter materialerne ud af ArrayList her:

                Material reglar = materialList.get(0);
                Material spærtræ = materialList.get(1);
                Material stolper = materialList.get(2);
                Material remme = materialList.get(2);
                Material vinkel = materialList.get(3);
                Material beslagskruer = materialList.get(4);
                Material Skruer80mm = materialList.get(5);
                Material skruer50mm = materialList.get(6);
                Material vindtrækbånd = materialList.get(7);
                Material trapezplade = materialList.get(8);
                Material bundskrue = materialList.get(9);
                Material eternit = materialList.get(10);
                Material eternitskrue = materialList.get(11);
                Material tagkrydsfiner = materialList.get(12);
                Material tagpap = materialList.get(13);
                Material tagfod = materialList.get(14);
                Material vindskede = materialList.get(15);
                Material klinkbeklædning = materialList.get(16);
                Material bræt = materialList.get(17);

                // henter parametre her
                int size = Integer.parseInt(request.getParameter("size"));
                int shed = Integer.parseInt(request.getParameter("shed"));
                int shedtype = Integer.parseInt(request.getParameter("shedtype"));
                int length = Integer.parseInt(request.getParameter("length"));
                int width = Integer.parseInt(request.getParameter("width"));
                int height = Integer.parseInt(request.getParameter("height"));
                int shedLength = Integer.parseInt(request.getParameter("shed_length"));
                int shedWidth = Integer.parseInt(request.getParameter("shed_width"));

                //sætter længden på enhederne her:

                stolper.setUnit(height + nedgravningICm);

                // sætter mængden af enheder her:

                if(size == 0){
                    stolper.setAmount(4);

                }else{
                    stolper.setAmount(6);
                }

                //udregner nærmeste passende mål på enhed

                double passendeMål = stolper.getUnit() % 30;
                double minLængde = 240;
                double maxLængde = 600;

                if(passendeMål != 0){
                    double divideretLængde = Math.ceil(stolper.getUnit() / 30);
                    double passendeLængde = divideretLængde * 30;
                    stolper.setUnit(passendeLængde);
                }

                if(stolper.getUnit() < minLængde){
                    stolper.setUnit(minLængde);
                }else if(stolper.getUnit() > maxLængde){
                    stolper.setUnit(maxLængde);
                }


                // konverterer fra cm til m. og udregner pris for ordrelinbje
                double prisIalt = ((stolper.getPrice() * stolper.getAmount()) * stolper.getUnit()) / 100;
                stolper.setPrice(prisIalt);


                // sætter materialerne ind i session

                materialBeregning.add(stolper);
                session.setAttribute("materials", materialBeregning);



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
