package FunctionLayer;

public class SVG {

    public String createSVG (int width, int length, double spær_antal, int rejsning, double stolpe_antal) {

        //Length er X akse
        //Width er Y akse

        double viewBox_width = width * 1.2;
        double viewBox_length = length * 1.2;

        String start_SVG = "<?xml version='1.0'?><!DOCTYPE svg PUBLIC '-//W3C//DTD SVG 1.1//EN' 'http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd'>\n" +
                "\n" +
                "<svg version='1.1' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' height='100%' width='100%' viewBox=' 0 0 "+viewBox_length+" "+viewBox_width+"' preserveAspectRatio='xMinYMin'>\n" +
                "\n" +
                "<svg version='1.1' xmlns='http://www.w3.org/2000/svg' xmlns:xlink='http://www.w3.org/1999/xlink' x='60' width='"+length+"' height='"+width+"' viewBox=' 0 0 "+length+" "+width+"' preserveAspectRatio='xMinYMin'>";

        int start_rem = 35;
        double end_rem = width - 39.5;
        int vindkryds_y = width - 35;
        //Spær beregning
        if(rejsning == 1){
            spær_antal = spær_antal / 2;
        }

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

        String svg_spær = "";

        int betweenSpær = 55;
        for (int i = 0; i < spær_antal; i++) {
            betweenSpær = betweenSpær + betweenSpær;
            if(i == 0){
                svg_spær = "<rect x='0' y='0' width='4.5' height='"+width+"' style='stroke:black; fill: white;'/>\n";
            }else{
                svg_spær = "<rect x='"+betweenSpær+"' y='0' width='4.5' height='"+width+"' style='stroke:black; fill: white;'/>\n";
            }
        }
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

        String return_SVG = start_SVG + body_SVG + svg_spær + function_SVG +SVG_end;
        return return_SVG;
    }
}
