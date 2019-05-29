package FunctionLayer;

import FacadeLayer.MaterialFacade;
import Model.Material;

import java.util.ArrayList;

public class MaterialCalculator {


        public static ArrayList<Material> carportUdregner(int size, int shed, int shedtype, int length, int width, int height, int shedLength, int shedwidth, int rooftype, int roofsort){

            ArrayList<Material> materialBeregning = new ArrayList<>();

            ArrayList<Material> materialList = MaterialFacade.getMaterials();

            //henter materialerne ud af ArrayList her:

            Material reglar = materialList.get(0);
            Material reglar2 = new Material(materialList.get(0).getProduct_id(),materialList.get(0).getProduct_name(),materialList.get(0).getProduct_description(), materialList.get(0).getPrice(), materialList.get(0).getUnit(), materialList.get(0).getAmount());
            Material spærtræ = new Material(materialList.get(1).getProduct_id(),materialList.get(1).getProduct_name(),materialList.get(1).getProduct_description(), materialList.get(1).getPrice(), materialList.get(1).getUnit(), materialList.get(1).getAmount());
            Material spærtræ2 = new Material(materialList.get(1).getProduct_id(),materialList.get(1).getProduct_name(),materialList.get(1).getProduct_description(), materialList.get(1).getPrice(), materialList.get(1).getUnit(), materialList.get(1).getAmount());
            Material stolper = new Material(materialList.get(2).getProduct_id(),materialList.get(2).getProduct_name(),materialList.get(2).getProduct_description(), materialList.get(2).getPrice(), materialList.get(2).getUnit(), materialList.get(2).getAmount());
            Material stolper2 = new Material(materialList.get(2).getProduct_id(),materialList.get(2).getProduct_name(),materialList.get(2).getProduct_description(), materialList.get(2).getPrice(), materialList.get(2).getUnit(), materialList.get(2).getAmount());
            Material remme = new Material(materialList.get(2).getProduct_id(),materialList.get(2).getProduct_name(),materialList.get(2).getProduct_description(), materialList.get(2).getPrice(), materialList.get(2).getUnit(), materialList.get(2).getAmount());
            Material remme2 = new Material(materialList.get(2).getProduct_id(),materialList.get(2).getProduct_name(),materialList.get(2).getProduct_description(), materialList.get(2).getPrice(), materialList.get(2).getUnit(), materialList.get(2).getAmount());
            Material vinkel = new Material(materialList.get(3).getProduct_id(),materialList.get(3).getProduct_name(),materialList.get(3).getProduct_description(), materialList.get(3).getPrice(), materialList.get(3).getUnit(), materialList.get(3).getAmount());
            Material beslagskruer = new Material(materialList.get(4).getProduct_id(),materialList.get(4).getProduct_name(),materialList.get(4).getProduct_description(), materialList.get(4).getPrice(), materialList.get(4).getUnit(), materialList.get(4).getAmount());
            Material Skruer80mm = materialList.get(5);
            Material skruer50mm = materialList.get(6);
            Material vindtrækbånd = new Material(materialList.get(7).getProduct_id(),materialList.get(7).getProduct_name(),materialList.get(7).getProduct_description(), materialList.get(7).getPrice(), materialList.get(7).getUnit(), materialList.get(7).getAmount());
            Material trapezplade = new Material(materialList.get(8).getProduct_id(),materialList.get(8).getProduct_name(),materialList.get(8).getProduct_description(), materialList.get(8).getPrice(), materialList.get(8).getUnit(), materialList.get(8).getAmount());
            Material trapezplade2 = new Material(materialList.get(8).getProduct_id(),materialList.get(8).getProduct_name(),materialList.get(8).getProduct_description(), materialList.get(8).getPrice(), materialList.get(8).getUnit(), materialList.get(8).getAmount());
            Material bundskrue = new Material(materialList.get(9).getProduct_id(),materialList.get(9).getProduct_name(),materialList.get(9).getProduct_description(), materialList.get(9).getPrice(), materialList.get(9).getUnit(), materialList.get(9).getAmount());
            Material eternit = new Material(materialList.get(10).getProduct_id(),materialList.get(10).getProduct_name(),materialList.get(10).getProduct_description(), materialList.get(10).getPrice(), materialList.get(10).getUnit(), materialList.get(10).getAmount());
            Material eternitskrue = new Material(materialList.get(11).getProduct_id(),materialList.get(11).getProduct_name(),materialList.get(11).getProduct_description(), materialList.get(11).getPrice(), materialList.get(11).getUnit(), materialList.get(11).getAmount());
            Material tagkrydsfiner = new Material(materialList.get(12).getProduct_id(),materialList.get(12).getProduct_name(),materialList.get(12).getProduct_description(), materialList.get(12).getPrice(), materialList.get(12).getUnit(), materialList.get(12).getAmount());
            Material tagpap = materialList.get(13);
            Material tagfod = materialList.get(14);
            Material vindskede = materialList.get(15);
            Material vindskede2 = new Material(materialList.get(15).getProduct_id(),materialList.get(15).getProduct_name(),materialList.get(15).getProduct_description(), materialList.get(15).getPrice(), materialList.get(15).getUnit(), materialList.get(15).getAmount());
            Material klinkbeklædning = materialList.get(16);
            Material klinkbeklædning2 = new Material(materialList.get(16).getProduct_id(),materialList.get(16).getProduct_name(),materialList.get(16).getProduct_description(), materialList.get(16).getPrice(), materialList.get(16).getUnit(), materialList.get(16).getAmount());
            Material klinkbeklædning3 = new Material(materialList.get(16).getProduct_id(),materialList.get(16).getProduct_name(),materialList.get(16).getProduct_description(), materialList.get(16).getPrice(), materialList.get(16).getUnit(), materialList.get(16).getAmount());
            Material klinkbeklædning4 = new Material(materialList.get(16).getProduct_id(),materialList.get(16).getProduct_name(),materialList.get(16).getProduct_description(), materialList.get(16).getPrice(), materialList.get(16).getUnit(), materialList.get(16).getAmount());
            Material bræt = materialList.get(17);
            Material bræt2 = new Material(materialList.get(17).getProduct_id(),materialList.get(17).getProduct_name(),materialList.get(17).getProduct_description(), materialList.get(17).getPrice(), materialList.get(17).getUnit(), materialList.get(17).getAmount());
            Material enPåTo = new Material(materialList.get(17).getProduct_id(),materialList.get(17).getProduct_name(),materialList.get(17).getProduct_description(), materialList.get(17).getPrice(), materialList.get(17).getUnit(), materialList.get(17).getAmount());
            Material enPåTo2 = new Material(materialList.get(17).getProduct_id(),materialList.get(17).getProduct_name(),materialList.get(17).getProduct_description(), materialList.get(17).getPrice(), materialList.get(17).getUnit(), materialList.get(17).getAmount());
            Material taglægte = new Material(materialList.get(18).getProduct_id(),materialList.get(18).getProduct_name(),materialList.get(18).getProduct_description(), materialList.get(18).getPrice(), materialList.get(18).getUnit(), materialList.get(18).getAmount());
            Material taglægte2 = new Material(materialList.get(18).getProduct_id(),materialList.get(18).getProduct_name(),materialList.get(18).getProduct_description(), materialList.get(18).getPrice(), materialList.get(18).getUnit(), materialList.get(18).getAmount());


            //sætter længden på enhederne her:

            int nedgravningICm = 100;
            int maxLængde = 600;
            int minLængde = 240;
            int ekstraStolper = 0;
            int maxSpændvidde = 300;
            int maxSpærafstand = 90;
            int ekstraSpær = 1;
            int størrelseM2 = (width * length) / 10000;
            int maxLægteafstand = 100;
            int ekstraLægte = 1;
            int ekstraVindskede = 2;
            if(rooftype == 1){
                ekstraVindskede = 4;
            }
            int ekstraReglar = 0;
            int maxBrætafstand = 16;
            int skurOmkreds = (shedLength * 2) + (shedwidth * 2);
            int klinkDækBredde = 12;

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
            beslagskruer.setUnit(1);
            vindtrækbånd.setUnit(1);
            taglægte.setUnit(length);
            taglægte2.setUnit(length);
            trapezplade.setUnit(width);
            trapezplade2.setUnit(width);
            if(rooftype == 1){
                trapezplade.setUnit(width / 2);
                trapezplade2.setUnit(width / 2);
            }
            bundskrue.setUnit(1);
            eternitskrue.setUnit(1);
            vindskede.setUnit(width);
            vindskede2.setUnit(width);
            if(rooftype == 1){
                vindskede.setUnit(width / 2);
                vindskede2.setUnit(width / 2);
            }
            bræt.setUnit(length);
            bræt2.setUnit(length);
            reglar.setUnit(height + nedgravningICm);
            reglar2.setUnit(height + nedgravningICm);
            enPåTo.setUnit(height);
            enPåTo2.setUnit(height);
            klinkbeklædning.setUnit(shedLength);
            klinkbeklædning2.setUnit(shedLength);
            klinkbeklædning3.setUnit(shedwidth);
            klinkbeklædning4.setUnit(shedwidth);



            // checker for længder længere end maxLængde, og beregner hvor mange ekstra længder der skal til.
            double stolpeAntal = stolper.getUnit() / maxLængde;
            double remAntal = remme.getUnit() / maxLængde;
            double spærLængder = spærtræ.getUnit() / maxLængde;
            double tagLægterAntal = taglægte.getUnit() / maxLængde;
            double trapezpladeLængder = trapezplade.getUnit() / maxLængde;
            double vindskedeLængder = vindskede.getUnit() / maxLængde;
            double brætLængder = bræt.getUnit() / maxLængde;
            double reglarAntal = reglar.getUnit() / maxLængde;
            double bræddeAntal = enPåTo.getUnit() / maxLængde;
            double klinkLengthAntal = klinkbeklædning.getUnit() / maxLængde;
            double klinkWidthAntal = klinkbeklædning3.getUnit() / maxLængde;



            // tilføjer ekstra stolper hvis rem spændvidden er for lang

            if(length > maxSpændvidde) {
                ekstraStolper = ekstraStolpeUdregner(length, size, maxSpændvidde);
            }
            if(width > maxSpændvidde){
                ekstraReglar = ekstraReglarUdregner(width);
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
            beslagskruer.setAmount(skrueBeregner(size, rooftype,størrelseM2));
            vindtrækbånd.setAmount(vindtrækbåndBeregner(størrelseM2));
            double antalLægter = Math.ceil((double)width / maxLægteafstand);
            taglægte.setAmount((mængdeUdregner(size, tagLægterAntal, 0, 0)) + (int)antalLægter + ekstraLægte);
            double antalTrapezplader = Math.ceil((double)length / 100);
            if(rooftype == 1){
                antalTrapezplader = antalTrapezplader * 2;
            }
            trapezplade.setAmount((int)antalTrapezplader);
            bundskrue.setAmount(skrueBeregner(size, rooftype, størrelseM2));
            eternit.setAmount(pladeBeregner(width, length, eternit.getUnit()));
            eternitskrue.setAmount(skrueBeregner(size, rooftype, størrelseM2));
            tagkrydsfiner.setAmount(pladeBeregner(width, length, tagkrydsfiner.getUnit()));
            tagpap.setAmount(pladeBeregner(width, length, tagpap.getUnit()));
            tagfod.setAmount((int) Math.ceil(((double)length / 100) * 2));
            vindskede.setAmount(mængdeUdregner(size, vindskedeLængder, 2, 2));
            if(rooftype == 1){
                vindskede.setAmount(vindskede.getAmount() * 2);
            }
            bræt.setAmount(mængdeUdregner(size, brætLængder, 2, 2));
            reglar.setAmount(mængdeUdregner(size, reglarAntal, 2, 2) + ekstraReglar);
            double antalBrædder = Math.ceil((double)skurOmkreds / maxBrætafstand);
            antalBrædder = antalBrædder * 2;
            enPåTo.setAmount((int)antalBrædder);
            double antalKlink = Math.ceil((double)height / klinkDækBredde);
            antalKlink = antalKlink * 2;
            klinkbeklædning.setAmount((int)antalKlink);
            klinkbeklædning3.setAmount((int)antalKlink);




            stolper.setUnit(længdeUdregning(stolper.getUnit()));
            remme.setUnit(længdeUdregning(remme.getUnit()));
            spærtræ.setUnit(længdeUdregning(spærtræ.getUnit()));
            taglægte.setUnit(længdeUdregning(taglægte.getUnit()));
            trapezplade.setUnit(længdeUdregning(trapezplade.getUnit()));
            vindskede.setUnit(længdeUdregning(vindskede.getUnit()));
            bræt.setUnit(længdeUdregning(bræt.getUnit()));
            reglar.setUnit(længdeUdregning(reglar.getUnit()));
            enPåTo.setUnit(længdeUdregning(enPåTo.getUnit()));
            klinkbeklædning.setUnit(længdeUdregning(klinkbeklædning.getUnit()));
            klinkbeklædning3.setUnit(længdeUdregning(klinkbeklædning3.getUnit()));



            // udregner priser på materialer

            double stolpePrisIalt = prisUdregner(stolper.getPrice(), stolper.getAmount(), stolper.getUnit());
            double remPrisIalt = prisUdregner(remme.getPrice(), remme.getAmount(), remme.getUnit());
            double spærPrisIalt = prisUdregner(spærtræ.getPrice(), spærtræ.getAmount(), spærtræ.getUnit());
            double vinkelPrisIalt = ((vinkel.getPrice() * vinkel.getUnit()) * vinkel.getAmount());
            double beslagsSkruerPrisIalt = ((beslagskruer.getPrice() * beslagskruer.getUnit()) * beslagskruer.getAmount());
            double vindtrækbåndPrisIalt = ((vindtrækbånd.getPrice() * vindtrækbånd.getUnit()) * vindtrækbånd.getAmount());
            double taglægtePrisIalt = prisUdregner(taglægte.getPrice(), taglægte.getAmount(), taglægte.getUnit());
            double bundskruePrisIalt = ((bundskrue.getPrice() * bundskrue.getUnit()) * bundskrue.getAmount());
            double trapezpladePrisIalt = prisUdregner(trapezplade.getPrice(), trapezplade.getAmount(), trapezplade.getUnit());
            double eternitPrisIalt = round((eternit.getPrice() * eternit.getAmount()) * eternit.getUnit(), 2);
            double eternitskruePrisIalt = ((eternitskrue.getPrice() * eternitskrue.getAmount()) * eternitskrue.getUnit());
            double tagkrydsfinerPrisIalt = round((tagkrydsfiner.getPrice() * tagkrydsfiner.getUnit()) * tagkrydsfiner.getAmount(), 2);
            double tagpapPrisIalt = (tagpap.getPrice() * tagpap.getUnit() * tagpap.getAmount());
            double tagfodPrisIalt = (tagfod.getPrice() * tagfod.getAmount() * tagfod.getUnit());
            double vindskedePrisIalt = prisUdregner(vindskede.getPrice(), vindskede.getAmount(), vindskede.getUnit());
            double brætPrisIalt = prisUdregner(bræt.getPrice(), bræt.getAmount(), bræt.getUnit());
            double reglarPrisIalt = prisUdregner(reglar.getPrice(), reglar.getAmount(), reglar.getUnit());
            double enPåToPrisIalt = prisUdregner(enPåTo.getPrice(), enPåTo.getAmount(), enPåTo.getUnit());
            double klinkLængdePrisIalt = prisUdregner(klinkbeklædning.getPrice(), klinkbeklædning.getAmount(), klinkbeklædning.getUnit());
            double klinkBreddePrisIalt = prisUdregner(klinkbeklædning3.getPrice(), klinkbeklædning3.getAmount(), klinkbeklædning3.getUnit());


            //indsætter priser på materialer

            stolper.setPrice(stolpePrisIalt);
            remme.setPrice(remPrisIalt);
            spærtræ.setPrice(spærPrisIalt);
            vinkel.setPrice(vinkelPrisIalt);
            beslagskruer.setPrice(beslagsSkruerPrisIalt);
            vindtrækbånd.setPrice(vindtrækbåndPrisIalt);
            taglægte.setPrice(taglægtePrisIalt);
            trapezplade.setPrice(trapezpladePrisIalt);
            bundskrue.setPrice(bundskruePrisIalt);
            eternit.setPrice(eternitPrisIalt);
            eternitskrue.setPrice(eternitskruePrisIalt);
            tagkrydsfiner.setPrice(tagkrydsfinerPrisIalt);
            tagpap.setPrice(tagpapPrisIalt);
            tagfod.setPrice(tagfodPrisIalt);
            vindskede.setPrice(vindskedePrisIalt);
            bræt.setPrice(brætPrisIalt);
            reglar.setPrice(reglarPrisIalt);
            enPåTo.setPrice(enPåToPrisIalt);
            klinkbeklædning.setPrice(klinkLængdePrisIalt);
            klinkbeklædning3.setPrice(klinkBreddePrisIalt);

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
            // beslagsskruer:
            materialBeregning.add(beslagskruer);
            // vindtrækbånd:
            materialBeregning.add(vindtrækbånd);
            // taglægter:
            if(roofsort == 1 || roofsort == 2) {
                materialBeregning.add(taglægte);
                ekstraEnhedUdregner(materialBeregning, taglægte2, size, maxLængde, tagLægterAntal, (int) antalLægter + ekstraLægte, (int) antalLægter + ekstraLægte);
            }
            // trapezplader
            if(roofsort == 1) {
                materialBeregning.add(trapezplade);
                ekstraEnhedUdregner(materialBeregning, trapezplade2, size, maxLængde, trapezpladeLængder, (int) antalTrapezplader, (int) antalTrapezplader);
                materialBeregning.add(bundskrue);
            }
            // eternitplader
            if(roofsort == 2){
                materialBeregning.add(eternit);
                materialBeregning.add(eternitskrue);
            }
            if(roofsort == 3){
                materialBeregning.add(tagkrydsfiner);
                materialBeregning.add(tagpap);
                materialBeregning.add(tagfod);
            }
            // vindskeder
            materialBeregning.add(vindskede);
            ekstraEnhedUdregner(materialBeregning, vindskede2, size, maxLængde, vindskedeLængder, ekstraVindskede, ekstraVindskede);
            // Sternbrædder
            materialBeregning.add(bræt);
            ekstraEnhedUdregner(materialBeregning, bræt2, size, maxLængde, brætLængder, 2, 2);
            // reglar (Skurstolper) og beklædning
            if(shed == 1) {
                materialBeregning.add(reglar);
                ekstraEnhedUdregner(materialBeregning, reglar2, size, maxLængde, reglarAntal, 2, 2);
                if(shedtype == 1){
                    materialBeregning.add(enPåTo);
                    ekstraEnhedUdregner(materialBeregning, enPåTo2, size, maxLængde, bræddeAntal, (int)antalBrædder, (int)antalBrædder);
                }else if(shedtype == 2){
                    if(klinkbeklædning.getUnit() == klinkbeklædning3.getUnit()){
                        klinkbeklædning.setAmount(klinkbeklædning.getAmount() + klinkbeklædning3.getAmount());
                        materialBeregning.add(klinkbeklædning);
                        ekstraEnhedUdregner(materialBeregning, klinkbeklædning2, size, maxLængde, klinkLengthAntal, (int)antalKlink, (int)antalKlink);
                        ekstraEnhedUdregner(materialBeregning, klinkbeklædning4, size, maxLængde, klinkWidthAntal, (int)antalKlink, (int)antalKlink);
                    }else {
                        materialBeregning.add(klinkbeklædning);
                        ekstraEnhedUdregner(materialBeregning, klinkbeklædning2, size, maxLængde, klinkLengthAntal, (int) antalKlink, (int) antalKlink);
                        materialBeregning.add(klinkbeklædning3);
                        ekstraEnhedUdregner(materialBeregning, klinkbeklædning4, size, maxLængde, klinkWidthAntal, (int) antalKlink, (int) antalKlink);
                    }
                }
            }


//            session.setAttribute("materials", materialBeregning);


            return materialBeregning;
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public static int pladeBeregner(int width, int length, double unit){
            double oprundetAntal = 0;
            double m2 = ((double)width * (double)length) / 10000;
        System.out.println(m2);

            oprundetAntal = Math.ceil(m2 / unit);
        System.out.println(oprundetAntal);

            return (int)oprundetAntal;
    }

    private static int vindtrækbåndBeregner(int størrelseM2){

        double antalVindtrækbånd = 0;


        antalVindtrækbånd = Math.ceil((double)størrelseM2 / 80);

        return (int)antalVindtrækbånd;
    }

    private static int skrueBeregner(int size, int rooftype, int størrelseM2){

        double antalSkruer = 0;

        if (size == 0 && rooftype == 0) {
            antalSkruer = Math.ceil((double)størrelseM2 / 15);
        } else if (size == 1 || rooftype == 1) {
            antalSkruer = Math.ceil((double)størrelseM2 / 10);

        }
        return (int)antalSkruer;
    }

    private static int vinkelBeregner(int size, int rooftype, int spær, int antalStolper){

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

    private static int ekstraReglarUdregner(int width){
            int ekstraLængder = 0;

            int temp = width / 300;
            ekstraLængder = temp * 2;

            return ekstraLængder;
    }

    public static int ekstraStolpeUdregner(int length, int size, int maxSpændvidde){

        int ekstraLængder = 0;

        if (size == 0) {
            int temp = length / maxSpændvidde;
            ekstraLængder = temp * 2;
        }else if(size == 1){
            int temp = length / maxSpændvidde;
            ekstraLængder = temp * 3;
        }
        return ekstraLængder;
    }

    private static void ekstraEnhedUdregner(ArrayList<Material> materialBeregning, Material material, int size, int maxLængde, double enhedAntal, int i1, int i2) {
        if(enhedAntal > 1){
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

    private static double prisUdregner(double pris, double amount, double unit){

        double prisIalt = ((pris * amount) * unit) / 100;

        return prisIalt;
    }
    private static int mængdeUdregner(int size, double Antal, int min, int max) {

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

    private static double længdeUdregning(double l) {

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
        }

        return længde;
    }





}
