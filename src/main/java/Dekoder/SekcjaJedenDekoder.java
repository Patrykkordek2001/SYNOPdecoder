package Dekoder;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SekcjaJedenDekoder {
    private String dekodujIrIxhVV(String IrIxhVV) throws IOException, ParseException {
        String zdekodowaneIrIxhVV;
        String zdekodowaneIr;
        String zdekodowaneIx;
        String zdekodowaneh;
        String zdekodowaneVV;
        zdekodowaneIr = IrIxhVV.substring(0, 1);
        switch (zdekodowaneIr) {
            case "0":
                zdekodowaneIr = "grupa opadowa w rozdziale 1 i 3";
                break;
            case "1":
                zdekodowaneIr = "grupa opadowa tylko w rozdziale 1";
                break;
            case "2":
                zdekodowaneIr = "grupa opadowa tylko w rozdziale 3 ";
                break;
            case "3":
                zdekodowaneIr = "grupa opadowa pominieta (opady nie wystąpily)";
                break;
            case "4":
                zdekodowaneIr = "grupa opadowa pominieta (nie wykonywano pomiarow opadu)";
                break;
            default:
                zdekodowaneIx = "Bledy kod";
                break;
        }
        zdekodowaneIx = IrIxhVV.substring(1, 2);
        switch (zdekodowaneIx) {
            case "1":
                zdekodowaneIx = "stacja nieautomatyczna";
                break;
            case "2":
                zdekodowaneIx = "stacja nieautomatyczna (brak zjawisk)";
                break;
            case "3":
                zdekodowaneIx = "stacja nieautomatyczna (brak danych)";
                break;
            case "4":
                zdekodowaneIx = "stacja automatyczna, kodowana za pomoca WMO Code Table 4677 i 4561";
                break;
            case "5":
                zdekodowaneIx = "stacja automatyczna (brak zjawisk)";
                break;
            case "6":
                zdekodowaneIx = "stacja automatyczna (brak danych)";
                break;
            default:
                zdekodowaneIx = "Bledy kod";
                break;
        }
        zdekodowaneh = IrIxhVV.substring(2, 3);
        switch (zdekodowaneh) {
            case "0":
                zdekodowaneh = "wysokosc wzgledna podstawy najnizszych chmur od 0 do 50 m";
                break;
            case "1":
                zdekodowaneh = "wysokosc wzgledna podstawy najnizszych chmur od 50 do 100 m";
                break;
            case "2":
                zdekodowaneh = "wysokosc wzgledna podstawy najnizszych chmur od 100 do 200 m ";
                break;
            case "3":
                zdekodowaneh = "wysokosc wzgledna podstawy najnizszych chmur od 200 do 300 m";
                break;
            case "4":
                zdekodowaneh = "wysokosc wzgledna podstawy najnizszych chmur od 300 do 600 m";
                break;
            case "5":
                zdekodowaneh = "wysokosc wzgledna podstawy najnizszych chmur od 600 do 1000 m";
                break;
            case "6":
                zdekodowaneh = "wysokosc wzgledna podstawy najnizszych chmur od 1000 do 1500 m";
                break;
            case "7":
                zdekodowaneh = "wysokosc wzgledna podstawy najnizszych chmur od 1500 do 2000 m";
                break;
            case "8":
                zdekodowaneh = "wysokosc wzgledna podstawy najnizszych chmur od 2000 do 2500 m";
                break;
            case "9":
                zdekodowaneh = "wysokosc wzgledna podstawy najnizszych chmur od 2500 do 50 m";
                break;
            case "/":
                zdekodowaneh = "wysokosc podstawy chmur nieznana";
                break;
            default:
                zdekodowaneh = "Bledy kod";
                break;
        }
        zdekodowaneVV = IrIxhVV.substring(3, 5);
        zdekodowaneVV = plikJSON("widocznosc", zdekodowaneVV);

        zdekodowaneIrIxhVV = zdekodowaneIr + "\n" + zdekodowaneIx + "\n" + zdekodowaneh + "\n" + zdekodowaneVV;
        return zdekodowaneIrIxhVV;
    }


    private String dekodujNddff(String Nddff) throws IOException, ParseException {
        String zdekodowaneNddff;
        String zdekodowaneN;
        String zdekodowanedd;
        String zdekodowaneff;
        zdekodowaneN = Nddff.substring(0, 1);
        switch (zdekodowaneN) {
            case "0":
                zdekodowaneN = "niebo bezchmurne";
                break;
            case "1":
                zdekodowaneN = "wielkosc zachmurzenia ogolnego 1/8 lub mniej lecz nie 0";
                break;
            case "2":
                zdekodowaneN = "wielkosc zachmurzenia ogolnego 2/8";
                break;
            case "3":
                zdekodowaneN = "wielkosc zachmurzenia ogolnego 3/8";
                break;
            case "4":
                zdekodowaneN = "wielkosc zachmurzenia ogolnego 4/8";
                break;
            case "5":
                zdekodowaneN = "wielkosc zachmurzenia ogolnego 5/8";
                break;
            case "6":
                zdekodowaneN = "wielkosc zachmurzenia ogolnego 6/8";
                break;
            case "7":
                zdekodowaneN = "wielkosc zachmurzenia ogolnego 7/8";
                break;
            case "8":
                zdekodowaneN = "wielkosc zachmurzenia ogolnego 8/8";
                break;
            case "9":
                zdekodowaneN = "wielkosc zachmurzenia ogolnego niebo niewidoczne (zasłoniete mgla lub innymi zjawiskami meteorologicznymi)";
                break;
            case "/":
                zdekodowaneN = "chmury niewidoczne z powodow innych niż mgla czy inne zjawiska meteorologiczne lub nie prowadzi się obserwacji";
                break;
            default:
                zdekodowaneN = "Bledy kod";
                break;
        }
        zdekodowanedd = Nddff.substring(1, 3);
        zdekodowanedd = plikJSON("sredniKierunekWiatru",zdekodowanedd);


        if(Nddff.startsWith("99",3)) zdekodowaneff = "";
        else if (Nddff.charAt(3) == '0') zdekodowaneff = "\npredkosc wiatru okreslona w grupie YYGGi: 1" + Nddff.charAt(4);
        else zdekodowaneff = "\n predkosc wiatru okreslona w grupie YYGGi" + Nddff.substring(3,5);

        zdekodowaneNddff = zdekodowaneN + "\n" + zdekodowanedd + zdekodowaneff;
        return zdekodowaneNddff;
    }

private String dekoduj00fff(String fff){
        if(fff.startsWith("0")) return fff.substring(3);
        else return fff.substring(2);
}

private String znakTemperatury(String znak){
        switch (znak){
            case "1":
                return "-";
            case "0":
                return "+";
            default:
                return "Blad w zapisie danych";
        }
}
private String dekoduj1sTTT(String sTTT){
        String zdekodowaneSTTT;
        String zdekodowaneS = "Aktualna temperatura powietrza: "+ znakTemperatury(sTTT.substring(1,2));
        zdekodowaneSTTT = zdekodowaneS + sTTT.substring(2,4) + "," + sTTT.charAt(4) + "stopni Celcjusza";
        return zdekodowaneSTTT;
    }

private String dekoduj2sTTT(String sTTT){
        String zdekodowaneSTTT;
        if(sTTT.startsWith("29")){
            zdekodowaneSTTT = sTTT.substring(2,5);
            return "Wilgotnosc wzgledna powietrza: " + zdekodowaneSTTT.substring(0,2) + "," + zdekodowaneSTTT.charAt(2) + "%";
        }
        else {
            String zdekodowaneS = znakTemperatury(sTTT.substring(1,2));
            String zdekodowaneTTT = sTTT.substring(2,5);
            zdekodowaneSTTT = "Aktualna temperatura rosy: " + zdekodowaneS + zdekodowaneTTT.substring(0,2) + "," + zdekodowaneTTT.charAt(2) + "stopni Celcjusza";
            return zdekodowaneSTTT;
        }
}

private String dekoduj3PPPP(String PPPP){
        String zdekodowanePPP = PPPP.substring(1);
        if(PPPP.substring(1).startsWith("0")) zdekodowanePPP = "1" + zdekodowanePPP;
        return "Cisnienie atmosferyczner na poziomie stacji: " + zdekodowanePPP.substring(0,zdekodowanePPP.length()-2) + ", " + zdekodowanePPP.charAt(zdekodowanePPP.length()-1) + "hPa";

}

private String dekoduj4PPPP(String PPPP){
        String zdekodowanePPPP = PPPP.substring(1);
        if(PPPP.substring(1).startsWith("0")) zdekodowanePPPP = "1" + zdekodowanePPPP;
        return "Cisnienie atmosferyczner po redukcji do poziomu morza: " + zdekodowanePPPP.substring(0,zdekodowanePPPP.length()-2) + ", " + zdekodowanePPPP.charAt(zdekodowanePPPP.length()-1) + "hPa";
}

private String dekoduj5appp(String appp){
        String zdekodowaneAPPP;
        String zdekodowaneA = appp.substring(1,2);
        switch (zdekodowaneA){
            case "0":
                zdekodowaneA = "wzrost, nastepnie spadek";
                break;
            case "1":
                zdekodowaneA = "wzrost, nastepnie stale";
                break;
            case "2":
                zdekodowaneA = "wzrost";
                break;
            case "3":
                zdekodowaneA = "spadek lub stale, nastepnie wzrost";
                break;
            case "4":
                zdekodowaneA = "stale";
                break;
            case "5":
                zdekodowaneA = "spadek, nastepnie wzrost";
                break;
            case "6":
                zdekodowaneA = "spadek, nastepnie stale";
                break;
            case "7":
                zdekodowaneA = "spadek";
                break;
            case "8":
                zdekodowaneA = "wzrost lub stale, nastepnie spadek";
                break;
            default:
                zdekodowaneA = "Blad w zapisie danych";
                break;
        }
        String zdekodowanePPP = appp.substring(2,5);
        zdekodowaneAPPP = "Tendencja cisnienia: " + zdekodowaneA + "\nZmiana cisnienia w ciagu ostatnich 3 godzin: " + zdekodowanePPP.substring(0,2) + ", " + appp.charAt(2) + "hPa";
        return zdekodowaneAPPP;
}

private String dekoduj6RRRt(String RRRt){
        String zdekodowaneRRRt;
        String zdekodowaneRRR = RRRt.substring(1,3);
    if(Integer.parseInt(zdekodowaneRRR) > 990) {
        zdekodowaneRRR = "0," + RRRt.charAt(3);
    } else if(Integer.parseInt(zdekodowaneRRR) == 990) {
        zdekodowaneRRR = "slad opadu";
    }

    String zdekodowaneT;
    switch(RRRt.substring(4,5)) {
        case "1":
            zdekodowaneT = "ostatnie 6 godzin";
            break;
        case "2" :
            zdekodowaneT = "ostatnie 12 godzin";
            break;
        case "3" :
            zdekodowaneT ="ostatnie 18 godzin";
            break;
        case "4" :
            zdekodowaneT = "ostatnie 24 godziny";
            break;
        case "5" :
            zdekodowaneT = "ostatnia godzina";
            break;
        case "6" :
            zdekodowaneT = "ostatnie 2 godziny";
            break;
        case "7" :
            zdekodowaneT = "ostatnie 3 godziny";
            break;
        case "8" :
            zdekodowaneT = "ostatnie 9 godzin";
            break;
        case "9" :
            zdekodowaneT = "ostatnie 15 godzin";
            break;
        case "/" :
            zdekodowaneT = "ostatnie 24 godzin";
            break;
        default :
            zdekodowaneT = "blad w zapisie danych!";
            break;
    }

    zdekodowaneRRRt = "Wielkosc opadu: " + zdekodowaneRRR + "mm\nOkres, z ktorego pochodza dane o opadzie: " + zdekodowaneT;
    return zdekodowaneRRRt;
}

    private String dekoduj7wwWW(String wwWW) throws IOException, ParseException {
        String zdekodowanewwWWW, opis = "";
        String zdekodowaneww = plikJSON("pogodaPrzed", wwWW.substring(1,3));

        int opisPogody = Integer.parseInt(wwWW.substring(1,3));
        if(opisPogody > 0.3 && opisPogody < 20) {
            opis = "Zmetnienie, pyl, piasek lub dym - ";
        } else if(opisPogody > 19 && opisPogody < 30) {
            opis = "Opady, mgla, burza na stacji w ciagu ostatniej godziny, lecz nie w czasie obserwacji - ";
        } else if(opisPogody > 29 && opisPogody < 40) {
            opis = "Wichura pylowa, piaskowa, zamiec sniezna - ";
        } else if(opisPogody > 39 && opisPogody < 80) {
            opis = "Mgla lub mgla lodowa w czasie obserwacji - ";
        } else if(opisPogody > 79 && opisPogody < 91) {
            opis = "Opady przelotne - ";
        } else if(opisPogody > 90 && opisPogody < 100) {
            opis = "Burza - ";
        }

        String zdekodowaneWW = "";
        switch (wwWW.substring(3,5))
        {
            case "0":
                zdekodowaneWW = "chmury pokrywaly polowe lub mniej niz polowe nieba w ciagu branego pod uwage okresu";
                break;
            case "1":
                zdekodowaneWW = "chmury pokrywaly ponad polowe nieba przez cześc okresu i mniej niz polowe przez pozostala cześc okresu";
                break;
            case "2":
                zdekodowaneWW = "chmury pokrywaly ponad polowe nieba w ciagu branego pod uwage okresu";
                break;
            case "3":
                zdekodowaneWW = "wichura pylowa, wichura piaskowa lub zamiec śniezna wysoka";
                break;
            case "4":
                zdekodowaneWW = "mgla, mgla lodowa lub geste zmetnienie (widzialnośc ponizej 1000 m)";
                break;
            case "5":
                zdekodowaneWW = "mzawka";
                break;
            case "6":
                zdekodowaneWW = "deszcz ciagly";
                break;
            case "7":
                zdekodowaneWW = "snieg lub snieg z deszczem lub ziarna lodowe";
                break;
            case "8":
                zdekodowaneWW = "opady przelotne";
                break;
            case "9":
                zdekodowaneWW = "burza z opadem lub bez opadu";
                break;
            case "/":
                zdekodowaneWW = "brak danych";
                break;
        }

        zdekodowanewwWWW = "Aktualny stan pogody: " + opis + zdekodowaneww + "\nPrzeszly stan pogody: " + zdekodowaneWW;
        return zdekodowanewwWWW;
    }

    private String dekoduj8NCLCMCH(String NCLCMCH) throws IOException, ParseException {
        String zdekodowane8NCLCMCH;
        String zdekodowaneN = "Zachmurzenie chmurami niskimi, gdy ich nie ma - srednimi";

        String zdekodowaneCL = plikJSON("chmuryCL", NCLCMCH.substring(2,3));
        String zdekodowaneCM = plikJSON("chmuryCM", NCLCMCH.substring(3,4));
        String zdekodowaneCH = plikJSON("chmuryCH", NCLCMCH.substring(4,5));

        zdekodowane8NCLCMCH = zdekodowaneN + "\n    " + zdekodowaneCL + "\n    " + zdekodowaneCM + "\n     " + zdekodowaneCH;
        return zdekodowane8NCLCMCH;
    }
    private String dekoduj9NGGmm(String NGGmm) {
        return "Dokladny czas obserwacji: " + NGGmm.substring(1,3) + ":" + NGGmm.substring(3,5);
    }


    public void dekodujSekcjeJeden(String sekcjaJeden) throws IOException, ParseException {
        List<String> sekcjaJedenLista = Arrays.asList(sekcjaJeden.split(" "));
        String zdekodowanaSekcjaJeden;
        for(int i = 0; i < sekcjaJedenLista.size(); i++) {
            String grupa = sekcjaJedenLista.get(i);
            if(i==0) System.out.println(dekodujIrIxhVV(grupa));
            else if(i==1) System.out.println(dekodujNddff(grupa));
            else if(i==2 && sekcjaJedenLista.get(i).startsWith("00")) System.out.println(dekoduj00fff(dekodujNddff(grupa) + grupa));
            else if(grupa.startsWith("1")) System.out.println(dekoduj1sTTT(grupa));
            else if(grupa.startsWith("2")) System.out.println( dekoduj2sTTT(grupa));
            else if(grupa.startsWith("3")) System.out.println(dekoduj3PPPP(grupa));
            else if(grupa.startsWith("4")) System.out.println(dekoduj4PPPP(grupa));
            else if(grupa.startsWith("5")) System.out.println(dekoduj5appp(grupa));
            else if(grupa.startsWith("6")) System.out.println(dekoduj6RRRt(grupa));
            else if(grupa.startsWith("7")) System.out.println(dekoduj7wwWW(grupa));
            else if(grupa.startsWith("8")) System.out.println(dekoduj8NCLCMCH(grupa));
            else if(grupa.startsWith("9")) System.out.println(dekoduj9NGGmm(grupa));

        }
        System.out.println("\n\n------------------------------------------------------------\n\n");

    }


    protected String plikJSON(String plik, String variable) throws IOException, ParseException {
        FileReader czytaj = new FileReader("C:\\Users\\Admin\\IdeaProjects\\SYNOPdecoder\\src\\dane\\" + plik + ".json");
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(czytaj);
        JSONObject jsonObject = (JSONObject) obj;

        return (String) jsonObject.get(variable);
    }

}











