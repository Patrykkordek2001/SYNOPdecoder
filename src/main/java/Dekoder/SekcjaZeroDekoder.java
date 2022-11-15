package Dekoder;

public class SekcjaZeroDekoder {

    private String dekodujTypStacji(String TypStacji){
        switch(TypStacji) {
            case "AAXX":
                return "depesza SYNOP";
            case "BBXX":
                return "depesza SHIP";
            case "ZZYY":
                return "depesza BUOY";
            default:
                return "Nie ma takiego kodu";

        }

    }

    private String dekodujYYGGi(String YYGGi){
        String zdekodowaneYYGGi;
        String dzien = "dzien miesiaca: " + YYGGi.substring(0,2) + "\n";
        String godzina = "godzina obserwacji (UTC):" + YYGGi.substring(2,4) + "\n";
        String wiatr = "";
        switch (YYGGi.substring(4)){
            case "0":
                wiatr = "predkosc wiatru oszacowano w m/s";
                break;
            case "1":
                wiatr = "prędkość w m/s (mierzona anemometrem)";
                break;
            case "2":
                wiatr = "prędkość w węzłach (mierzona wiatromierzem Wilda lub szacowana)";
                break;
            case "3":
                wiatr = "prędkość w węzłach (mierzona anemometrem)";
                break;
        }
        zdekodowaneYYGGi = dzien + godzina + wiatr + "\n";
        return zdekodowaneYYGGi;
    }


    private String dekodujIIiii(String IIiii){
        String zdekodowaneIIiii;
        String numerBlokowy = "Numer blokowy:" + IIiii.substring(0,2);
        String numerStacji = "Numer stacji:" + IIiii.substring(2,5);

        zdekodowaneIIiii = numerBlokowy + "\n" + numerStacji + "\n";
        return zdekodowaneIIiii;
    }


    public void dekodujSekcjeZero(String sekcjaZero){
        String zdekodowanaSekcjaZero;
        String typStacji = dekodujTypStacji(sekcjaZero.substring(0,4));
        String YYGGi = dekodujYYGGi(sekcjaZero.substring(5,10));
        String IIiii = dekodujIIiii(sekcjaZero.substring(11,16));
        zdekodowanaSekcjaZero = typStacji + "\n" + YYGGi + IIiii;
        System.out.println(zdekodowanaSekcjaZero);


    }




}
