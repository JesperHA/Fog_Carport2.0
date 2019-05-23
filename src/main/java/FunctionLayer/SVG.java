package FunctionLayer;

public class SVG {

    public String createSVG (int width, int length, double spær_antal, int rejsning, double stolpe_antal, int size) {

        //Length er X akse
        //Width er Y akse

        double viewBox_width = width * 1.2;
        double viewBox_length = length * 1.2;

        String start_SVG = "<?xml version='1.0'?><!DOCTYPE svg PUBLIC '-//W3C//DTD SVG 1.1//EN' 'http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd'>\n" +
                "\n" +
                "<svg version='1.1' id='SVGAREA' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' width='100%' viewBox=' 0 0 "+viewBox_length+" "+viewBox_width+"' preserveAspectRatio='xMinYMin'>\n" +
                "\n" +
                "<svg version='1.1' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' x='60' width='"+length+"' height='"+width+"' viewBox=' 0 0 "+length+" "+width+"' preserveAspectRatio='xMinYMin'>";

        int start_rem = 35;
        double end_rem = width - 39.5;
        int vindkryds_y = width - 35;

        String body_SVG = "<!-- Ramme -->\n" +
                "\n" +
                "    <rect x='0' y='0' width='"+length+"' height='"+width+"' style='stroke:black; fill: white;'/>\n" +
                "\n" +
                "    <!-- Remme -->\n" +
                "    <rect x='0' y='"+start_rem+"' width='"+length+"' height='4.5' style='stroke:black; fill: white;'/>\n" +
                "    <rect x='0' y='"+end_rem+"' width='"+length+"' height='4.5' style='stroke:black; fill: white;'/>\n" +
                "\n" +
                "    <!-- vindkryds -->\n" +
                "\n" +
                "    <line x1='55' y1='"+start_rem+"' x2='550' y2='"+vindkryds_y+"' style='stroke:black; fill white; stroke-dasharray: 10 10;'/>\n" +
                "    <line x1='50' y1='"+start_rem+"' x2='545' y2='"+vindkryds_y+"' style='stroke:black; fill white; stroke-dasharray: 10 10;'/>\n" +
                "    \n" +
                "    <line x1='550' y1='"+start_rem+"' x2='55' y2='"+vindkryds_y+"' style='stroke:black; fill white; stroke-dasharray: 10 10;'/>\n" +
                "    <line x1='545' y1='"+start_rem+"' x2='50' y2='"+vindkryds_y+"' style='stroke:black; fill white; stroke-dasharray: 10 10;'/>\n" +
                "\n" +
                "\n" ;

        //TestValues
        //size = 0;
        //stolpe_antal = 8;




        String svg_spær = "";
        int betweenSpær = 0;

        int fixSpær = (int) spær_antal;
        int fixStolpe = (int) stolpe_antal;

        for (int i = 0; i < fixSpær; i++) {
            svg_spær = svg_spær + "<rect x='" + betweenSpær + "' y='0' width='4.5' height='" + width + "' style='stroke:black; fill: white;'/>\n";
            betweenSpær = betweenSpær + 2;

        }

        //Rejsning
        String SVG_rejsning = "";
        int findMiddle = width / 2;
        if(rejsning == 1){
            SVG_rejsning = "<line x1='0' y1='"+findMiddle+"' x2='"+length+"' y2='"+findMiddle+"' style='stroke:black; fill white;'/>";
        }

        String SVG_Stolper = "";

        //Stolper
        int Halvstolper = fixStolpe / 2;
        int thirdstolper = fixStolpe / 3;

        int placementStolper_halv = length / Halvstolper;
        int placementStolper_third = length / thirdstolper;

        if(size == 1){
            //Top
            int top_stolpe_third = placementStolper_third;
            for (int i = 0; i < thirdstolper; i++) {
                SVG_Stolper = SVG_Stolper + "<circle cx='"+top_stolpe_third+"' cy='0' r='5' stroke='black' stroke-width='2' />";
                top_stolpe_third = top_stolpe_third + top_stolpe_third;
            }
            //Middle
            int middle_stolpe_third = placementStolper_third;
            for (int i = 0; i < thirdstolper; i++) {
                SVG_Stolper = SVG_Stolper + "<circle cx='"+middle_stolpe_third+"' cy='"+findMiddle+"' r='5' stroke='black' stroke-width='2' />";
                middle_stolpe_third = middle_stolpe_third + middle_stolpe_third;
            }
            //Bottom
            int bottom_stolpe_third = placementStolper_third;
            for (int i = 0; i < thirdstolper; i++) {
                SVG_Stolper = SVG_Stolper + "<circle cx='"+bottom_stolpe_third+"' cy='"+width+"' r='5' stroke='black' stroke-width='2' />";
                bottom_stolpe_third = bottom_stolpe_third + bottom_stolpe_third;
            }
        }else{
            //Top
            int top_stolpe_halv = placementStolper_halv;
            for (int i = 0; i <= Halvstolper; i++) {
                SVG_Stolper = SVG_Stolper + "<circle cx='"+top_stolpe_halv+"' cy='0' r='5' stroke='black' stroke-width='2' />";
                top_stolpe_halv = top_stolpe_halv + top_stolpe_halv;
            }
            //Bottom
            int bottom_stolpe_halv = placementStolper_halv;
            for (int i = 0; i <= Halvstolper; i++) {
                SVG_Stolper = SVG_Stolper + "<circle cx='"+bottom_stolpe_halv+"' cy='"+width+"' r='5' stroke='black' stroke-width='2' />";
                bottom_stolpe_halv = bottom_stolpe_halv + bottom_stolpe_halv;
            }
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

        String SVG_end = "</svg>";

        int width_middle_text = length / 2;
        int height_middle_text = width + 40;


        int height_arrow = width + 20;
        int length_arrow = length + 60;

        int beregn_remheight = width - 40;

        int height_rotated_text = width / 2;

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

        String return_SVG = start_SVG + body_SVG + svg_spær + SVG_rejsning + SVG_Stolper + SVG_end + function_SVG;
        return return_SVG;
    }
}
