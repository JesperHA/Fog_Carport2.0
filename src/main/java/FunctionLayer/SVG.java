package FunctionLayer;

public class SVG {

    public String createSVG (int width, int length, double spær_antal, int rejsning, double stolpe_antal, int size, int shed, int shedlength, int shedwidth, int shedtype) {

        //Length er X akse
        //Width er Y akse

        double viewBox_width = width * 1.5;
        double viewBox_length = length * 1.5;
        int fixLength = 0;
        if(shed == 1){
            fixLength = length + shedlength + 50;
        }else{
            fixLength = length + 50;
        }


        String start_SVG = "<?xml version='1.0'?><!DOCTYPE svg PUBLIC '-//W3C//DTD SVG 1.1//EN' 'http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd'>\n" +
                "\n" +
                "<svg version='1.1' id='SVGAREA' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' width='100%' height='100%' viewBox=' 0 0 "+viewBox_length+" "+viewBox_width+"' preserveAspectRatio='xMinYMin' style='margin-top:40px;'>\n" +
                "\n" +
                "<svg version='1.1' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' x='60' width='"+fixLength+"' height='"+width+"' viewBox=' 0 0 "+length+" "+width+"' preserveAspectRatio='xMinYMin'>";

        int start_rem = 35;
        double end_rem = width - 39.5;


        String body_SVG =
                "    <rect x='0' y='"+start_rem+"' width='"+length+"' height='4.5' style='stroke:black; fill: white;'/>\n" +
                "    <rect x='0' y='"+end_rem+"' width='"+length+"' height='4.5' style='stroke:black; fill: white;'/>\n";

        //Vindkryds & Spær

        String svg_spær = "";
        double fixSpær = spær_antal;

        double betweenSpær = length / fixSpær;;


        double betweenSpærCount = 0;

        double SpaceSpær = (betweenSpær) / fixSpær;
        //int fixSpaceSpær = (int) SpaceSpær;


            //Vindkryds
        double vindkryds_y = width - 35;
        double vindkryds_end = ((betweenSpær * fixSpær) - betweenSpær) - 5;
        double vindkryds_start = betweenSpær;



        double vindkrydsendY =  (length - 5) - vindkryds_start;
        double vindkrydsendY_plus = vindkrydsendY + 5;

        double vindkryds_start_plus = vindkryds_start + 5;

        double vindkryds_end_plus = vindkryds_end + 5;


        String vindkryds_SVG =
                "  <!-- vindkryds -->\n" +
                "\n" +
                "    <line x1='"+vindkryds_start_plus+"' y1='"+vindkryds_start+"' x2='"+vindkrydsendY_plus+"' y2='"+vindkryds_y+"' style='stroke:black; fill white; stroke-dasharray: 10 10;'/>\n" +
                "    <line x1='"+vindkryds_start+"' y1='"+vindkryds_start+"' x2='"+vindkrydsendY+"' y2='"+vindkryds_y+"' style='stroke:black; fill white; stroke-dasharray: 10 10;'/>\n" +
                "    \n" +
                "    <line x1='"+vindkryds_end_plus+"' y1='"+vindkryds_start+"' x2='"+vindkryds_start_plus+"' y2='"+vindkryds_y+"' style='stroke:black; fill white; stroke-dasharray: 10 10;'/>\n" +
                "    <line x1='"+vindkryds_end+"' y1='"+vindkryds_start+"' x2='"+vindkryds_start+"' y2='"+vindkryds_y+"' style='stroke:black; fill white; stroke-dasharray: 10 10;'/>\n" +
                "\n" +
                "\n" ;

        for (int i = 0; i < fixSpær; i++) {
            svg_spær = svg_spær + "<rect x='" + betweenSpærCount + "' y='0' width='4.5' height='" + width + "' style='stroke:black; fill: white;'/>\n";
            betweenSpærCount = betweenSpærCount + betweenSpær + SpaceSpær;

        }

        //Rejsning
        String SVG_rejsning = "";
        int findMiddle = width / 2;
        if(rejsning == 1){
            SVG_rejsning = "<line x1='0' y1='"+findMiddle+"' x2='"+length+"' y2='"+findMiddle+"' style='stroke:black; fill white;'/>";
        }

        String SVG_Stolper = "";

        //Stolper

        double fixStolpe = stolpe_antal;

        double Halvstolper = (fixStolpe / 2) - 1;
        double thirdstolper = (fixStolpe / 3) - 1;

        double placementStolper_halv = (length - 3.5) / Halvstolper;
        double placementStolper_third = (length - 3.5) / thirdstolper;

        if(size == 1){
            //Top
            double top_stolpe_third = 0;
            for (int i = 0; i <= thirdstolper; i++) {
                if (i == 0){
                    top_stolpe_third = 0;
                }
                if(i == 1){
                    top_stolpe_third = placementStolper_third;
                }
                SVG_Stolper = SVG_Stolper + "<rect x='"+top_stolpe_third+"' y='"+start_rem+"' width='6' height='4.5' style='fill: black;'/>";
                top_stolpe_third = top_stolpe_third + placementStolper_third;
            }
            //Middle
            double middle_stolpe_third = 0;
            for (int i = 0; i <= thirdstolper; i++) {
                if (i == 0){
                    middle_stolpe_third = 0;
                }
                if(i == 1){
                    middle_stolpe_third = placementStolper_third;
                }

                SVG_Stolper = SVG_Stolper + "<rect x='"+middle_stolpe_third+"' y='"+findMiddle+"' width='6' height='4.5' style='fill: black;'/>";
                middle_stolpe_third = middle_stolpe_third + placementStolper_third;
            }
            //Bottom
            double bottom_stolpe_third = 0;
            for (int i = 0; i <= thirdstolper; i++) {
                if (i == 0){
                    bottom_stolpe_third = 0;
                }
                if (i == 1){
                    bottom_stolpe_third = placementStolper_third;
                }
                SVG_Stolper = SVG_Stolper + "<rect x='"+bottom_stolpe_third+"' y='"+end_rem+"' width='6' height='4.5' style='fill: black;'/>";
                bottom_stolpe_third = bottom_stolpe_third + placementStolper_third;
            }
        }else{
            //Top
            double top_stolpe_halv = 0;
            for (int i = 0; i <= Halvstolper; i++) {
                if(i == 0){
                    top_stolpe_halv = 0;
                }
                if(i == 1){
                    top_stolpe_halv = placementStolper_halv;
                }
                SVG_Stolper = SVG_Stolper + "<rect x='"+top_stolpe_halv+"' y='"+start_rem+"' width='6' height='4.5' style='fill: black;'/>";
                top_stolpe_halv = top_stolpe_halv + placementStolper_halv;
            }
            //Bottom
            double bottom_stolpe_halv = 0;
            for (int i = 0; i <= Halvstolper; i++) {
                if(i == 0){
                    bottom_stolpe_halv = 0;
                if(i == 1)
                    bottom_stolpe_halv = placementStolper_halv;
                }
                SVG_Stolper = SVG_Stolper + "<rect x='"+bottom_stolpe_halv+"' y='"+end_rem+"' width='6' height='4.5' style='fill: black;' />";
                bottom_stolpe_halv = bottom_stolpe_halv + placementStolper_halv;
            }


        }

        //Skur
        String SVG_Skur = "";
        if(shed == 1){

            //0 = Venstre
            //1 = Højre
            double shedstart_x = 0;
            double shedstart_y = 0;

            //test
            int shedposition = 1;

            double texttilSkur = 0;
            double texttilSkur_y = 0;

            if(shedposition == 0){
                shedstart_x = (length - shedlength) + 2;
                shedstart_y = 0;
                texttilSkur = shedstart_x + (shedlength / 2) - 10;
                texttilSkur_y = shedwidth / 2;
            }

            if(shedposition == 1){
                shedstart_x = (length - shedlength) + 2;
                shedstart_y = width - shedwidth;
                texttilSkur_y = (width - shedwidth) + shedwidth / 2;
                texttilSkur = shedstart_x + (shedlength / 2) - 10;

            }




            SVG_Skur = "<rect x='"+shedstart_x+"' y='"+shedstart_y+"' width='"+shedlength+"' height='"+shedwidth+"' style='stroke:black; fill: none;' />" +
                    "<text x='"+texttilSkur+"' y='"+texttilSkur_y+"'> Skur </text>";
        }


        //Console Helper
        System.out.println("SpærAntal_Fixed: " + fixSpær);
        System.out.println("SpærAntal: " + spær_antal);
        System.out.println("Rejsning: " + rejsning);
        System.out.println("StolpeAntal: " + stolpe_antal);
        System.out.println("StolpeAntal_Fixed: " + fixStolpe);
        System.out.println("Size: " + size);
        System.out.println("SizeBetweenStolper_Halv: " + placementStolper_halv);
        System.out.println("SizeBetweenStolper_Third: " + placementStolper_third);
        System.out.println("EachStolpe_Halv: " + Halvstolper);
        System.out.println("EachStolpe_Third: " + thirdstolper);
        System.out.println("Shed: " + shed);
        String SVG_end = "</svg>";

        double width_middle_text = length / 2;
        double height_middle_text = width + 40;


        double height_arrow = width + 20;
        double length_arrow = length + 60;

        double beregn_remheight = width - 40;

        double height_rotated_text = width / 2;

        String function_SVG = " <defs>\n" +
                "    <marker id='beginArrow' \n" +
                "    \tmarkerWidth='9' markerHeight='9' \n" +
                "    \trefX='0' refY='4' \n" +
                "    \torient='auto'>\n" +
                "        <path d='M0,4 L8,0 L8,8 L0,4' style='fill: #000000s;' />\n" +
                "    </marker>\n" +
                "    <marker id='endArrow' \n" +
                "    \tmarkerWidth='9' markerHeight='9' \n" +
                "    \trefX='8' refY='4' \n" +
                "    \torient='auto'>\n" +
                "        <path d='M0,0 L8,4 L0,8 L0,0' style='fill: #000000;' />\n" +
                "    </marker>\n" +
                "</defs>\n" +
                "<line x1='20'  y1='0' x2='20'   y2='"+width+"' \n" +
                "\tstyle='stroke:black;\n" +
                "\tmarker-start: url(#beginArrow);\n" +
                "   marker-end: url(#endArrow);'/>\n" +
                "\n" +
                "   <text transform='rotate(-90 15, "+height_rotated_text+")' x='' y='"+height_rotated_text+"'>"+width+" cm </text>\n" +
                "\n" +
                "<line x1='40'  y1='35' x2='40' y2='"+beregn_remheight+"' \n" +
                "\tstyle='stroke:black;\n" +
                "\tmarker-start: url(#beginArrow);\n" +
                "   marker-end: url(#endArrow);'/>\n" +
                "\n" +
                "   <line x1='60'  y1='"+height_arrow+"' x2='"+length_arrow+"'   y2='"+height_arrow+"' \n" +
                "\tstyle='stroke:black;\n" +
                "\tmarker-start: url(#beginArrow);\n" +
                "   marker-end: url(#endArrow);'/>\n" +
                "\n" +
                "   <text transform='rotate(15, 300)' x='"+width_middle_text+"' y='"+height_middle_text+"'>"+length+" cm </text>\n" +
                "\n" +
                "</svg>\n";

        String return_SVG = start_SVG + body_SVG + vindkryds_SVG + svg_spær + SVG_rejsning + SVG_Stolper + SVG_Skur + SVG_end + function_SVG;
        return return_SVG;
    }
}
