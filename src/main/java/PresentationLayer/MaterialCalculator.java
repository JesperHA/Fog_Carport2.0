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

                //henter materialerne ud af ArrayList her:

                Material reglar = materialList.get(0);
                Material spærtræ = new Material(materialList.get(1).getProduct_id(),materialList.get(1).getProduct_name(),materialList.get(1).getProduct_description(), materialList.get(1).getPrice(), materialList.get(1).getUnit(), materialList.get(1).getAmount());
                Material spærtræ2 = new Material(materialList.get(1).getProduct_id(),materialList.get(1).getProduct_name(),materialList.get(1).getProduct_description(), materialList.get(1).getPrice(), materialList.get(1).getUnit(), materialList.get(1).getAmount());
                Material stolper = new Material(materialList.get(2).getProduct_id(),materialList.get(2).getProduct_name(),materialList.get(2).getProduct_description(), materialList.get(2).getPrice(), materialList.get(2).getUnit(), materialList.get(2).getAmount());
                Material stolper2 = new Material(materialList.get(2).getProduct_id(),materialList.get(2).getProduct_name(),materialList.get(2).getProduct_description(), materialList.get(2).getPrice(), materialList.get(2).getUnit(), materialList.get(2).getAmount());
                Material remme = new Material(materialList.get(2).getProduct_id(),materialList.get(2).getProduct_name(),materialList.get(2).getProduct_description(), materialList.get(2).getPrice(), materialList.get(2).getUnit(), materialList.get(2).getAmount());
                Material remme2 = new Material(materialList.get(2).getProduct_id(),materialList.get(2).getProduct_name(),materialList.get(2).getProduct_description(), materialList.get(2).getPrice(), materialList.get(2).getUnit(), materialList.get(2).getAmount());
                Material vinkel = new Material(materialList.get(3).getProduct_id(),materialList.get(3).getProduct_name(),materialList.get(3).getProduct_description(), materialList.get(3).getPrice(), materialList.get(3).getUnit(), materialList.get(3).getAmount());
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
                int rooftype = Integer.parseInt(request.getParameter("rooftype"));

                // Sletter session variabler for at kunne gemme sin konfiguration
                session.removeAttribute("sessionSize");
                session.removeAttribute("sessionShed");
                session.removeAttribute("sessionShedtype");
                session.removeAttribute("sessionLength");
                session.removeAttribute("sessionWidth");
                session.removeAttribute("sessionHeight");
                session.removeAttribute("sessionShedlength");
                session.removeAttribute("sessionShedwidth");
                session.removeAttribute("sessionRooftype");

                // Sætter session variabler for at kunne gemme sin konfiguration i en session og kan komme tilbage til den!
                session.setAttribute("sessionSize", size);
                session.setAttribute("sessionShed", shed);
                session.setAttribute("sessionShedtype", shedtype);
                session.setAttribute("sessionLength", length);
                session.setAttribute("sessionWidth", width);
                session.setAttribute("sessionHeight", height);
                session.setAttribute("sessionShedlength", shedLength);
                session.setAttribute("sessionShedwidth", shedWidth);
                session.setAttribute("sessionRooftype", rooftype);

                //sætter længden på enhederne her:

                int nedgravningICm = 100;
                int maxLængde = 600;
                int minLængde = 240;
                int ekstraStolper = 0;
                int maxSpændvidde = 300;
                int maxSpærafstand = 90;
                int ekstraSpær = 1;

                stolper.setUnit(height + nedgravningICm);
                stolper2.setUnit(height + nedgravningICm);
                remme.setUnit(length);
                remme2.setUnit(length);
                spærtræ.setUnit(width);
                spærtræ2.setUnit(width);
                if(rooftype == 1){
                    spærtræ.setUnit(width / 2);
                    spærtræ2.setUnit(width / 2);
                }
                vinkel.setUnit(1);

                // checker for længder længere end maxLængde, og beregner hvor mange ekstra længder der skal til.
                double stolpeAntal = stolper.getUnit() / maxLængde;
                double remAntal = remme.getUnit() / maxLængde;
                double spærLængder = spærtræ.getUnit() / maxLængde;


                // tilføjer ekstra stolper hvis rem spændvidden er for lang

                if(length > maxSpændvidde) {
                    ekstraStolper = ekstraStolpeUdregner(length, size);
                }

                // sætter mængden af enheder her:

                stolper.setAmount(mængdeUdregner(size, stolpeAntal, 4, 6) + ekstraStolper);
                remme.setAmount(mængdeUdregner(size, remAntal, 2, 3));

                double antalSpær = Math.ceil((double)length / maxSpærafstand);
                if(rooftype == 1){
                    antalSpær = antalSpær * 2;
                    ekstraSpær = 2;
                }
                spærtræ.setAmount((int)antalSpær + ekstraSpær);
                vinkel.setAmount(vinkelBeregner(size, rooftype, spærtræ.getAmount(), stolper.getAmount()));

//            if(size == 0){
//                stolper.setAmount(4);
//                if(stolpeAntal > 1){
//                    stolper.setAmount(4 * (int)stolpeAntal);
//                }
//
//            }else if(size == 1){
//                stolper.setAmount(6);
//                if(stolpeAntal > 1){
//                    stolper.setAmount(6 * (int)stolpeAntal);
//                }
//            }

            //udregner nærmeste passende mål på enhed
            // sætter længden på enheder her:

            stolper.setUnit(længdeUdregning(stolper.getUnit()));
            remme.setUnit(længdeUdregning(remme.getUnit()));
            spærtræ.setUnit(længdeUdregning(spærtræ.getUnit()));


            // udregner priser på materialer

            double stolpePrisIalt = prisUdregner(stolper.getPrice(), stolper.getAmount(), stolper.getUnit());
            double remPrisIalt = prisUdregner(remme.getPrice(), remme.getAmount(), remme.getUnit());
            double spærPrisIalt = prisUdregner(spærtræ.getPrice(), spærtræ.getAmount(), spærtræ.getUnit());
            double vinkelPrisIalt = ((vinkel.getPrice() * vinkel.getUnit()) * vinkel.getAmount());


            //indsætter priser på materialer

            stolper.setPrice(stolpePrisIalt);
            remme.setPrice(remPrisIalt);
            spærtræ.setPrice(spærPrisIalt);
            vinkel.setPrice(vinkelPrisIalt);


            // sætter materialerne ind i session
            // stolper:
            materialBeregning.add(stolper);
            ekstraEnhedUdregner(materialBeregning, stolper2, size, maxLængde, stolpeAntal, 4, 6);
            // remme:
            materialBeregning.add(remme);
            ekstraEnhedUdregner(materialBeregning, remme2, size, maxLængde, remAntal, 2, 3);
            // spær:
            materialBeregning.add(spærtræ);
            ekstraEnhedUdregner(materialBeregning, spærtræ2, size, maxLængde, spærLængder, (int)antalSpær + ekstraSpær, (int)antalSpær + ekstraSpær);
            // vinkler:
                materialBeregning.add(vinkel);



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



            // SVG

            SVG svg = new SVG();

            session.setAttribute("svg", svg.createSVG(width,length));

            destination = "bestilling.jsp";

            break;
        }

        request.getRequestDispatcher(destination).forward(request,response);
    }

    private int vinkelBeregner(int size, int rooftype, int spær, int antalStolper){

        int antalVinkler = 0;

        if (size == 0 && rooftype == 0) {
            antalVinkler = (spær * 4) - 4;
            antalVinkler = antalVinkler + ((antalStolper * 2) - 4);
        } else if (size == 1 || rooftype == 1) {
            antalVinkler = (spær * 6) - 6;
            antalVinkler = antalVinkler + ((antalStolper * 2) - 6);
        }
        return antalVinkler;
    }

    private int ekstraStolpeUdregner(int length, int size){

        int ekstraLængder = 0;

        if (size == 0) {

            int temp = length / 300;
            ekstraLængder = temp * 2;

        }else if(size == 1){

            int temp = length / 300;
            ekstraLængder = temp * 3;

        }
     return ekstraLængder;
    }

    private void ekstraEnhedUdregner(ArrayList<Material> materialBeregning, Material material, int size, int maxLængde, double stolpeAntal, int i1, int i2) {
        if(stolpeAntal > 1){
            double længdeRest = material.getUnit() % maxLængde;
            material.setUnit(længdeUdregning(længdeRest));

            if(size == 0){
                material.setAmount(i1);
            }else{
                material.setAmount(i2);
            }


            double prisIalt = prisUdregner(material.getPrice(), material.getAmount(), material.getUnit());
            material.setPrice(prisIalt);


            materialBeregning.add(material);

        }
    }

    private double prisUdregner(double pris, double amount, double unit){

        double prisIalt = ((pris * amount) * unit) / 100;

        return prisIalt;
    }
    private int mængdeUdregner(int size, double Antal, int min, int max) {

        int amount = 0;

        if (size == 0) {
            amount = min;
            if (Antal > 1) {
                amount = min * (int) Antal;
            }
        } else if (size == 1) {
            amount = max;
            if (Antal > 1) {
                amount = max * (int) Antal;
            }
        }
        return amount;
    }

    private double længdeUdregning(double l) {

        double længde = l;

        double passendeMål = længde % 30;
        double minLængde = 240;
        double maxLængde = 600;

        if(passendeMål != 0){
            double divideretLængde = Math.ceil(længde / 30);
            double passendeLængde = divideretLængde * 30;
            længde = passendeLængde;
        }

        if(længde < minLængde){
            længde = minLængde;
        }else if(længde > maxLængde){
            længde = maxLængde;
            System.out.println("Længden sendt til længdeberegneren er større end maxlængden!!");
        }

        return længde;
    }


    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        String destination = "index.jsp";


        request.getRequestDispatcher(destination).forward(request,response);
    }
}
