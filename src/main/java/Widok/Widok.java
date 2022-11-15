package Widok;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.*;

public class Widok {
    private Scanner scanner;
    public Widok()
    {scanner = new Scanner(System.in);}

    List<String> datyPoSprawdzeniu = new ArrayList<>();
    SimpleDateFormat dataFormat = new SimpleDateFormat("yyMMddHHmm");
    public String podajDzien(){
        System.out.println("Podaj dzien(01-31): ");
        String dzien = scanner.nextLine();
        if( Integer.parseInt(dzien)> 0 && Integer.parseInt(dzien) < 32) {
            return dzien;
        }
        else {
            System.out.println("Blad! Podales zly dzien.");
            exit(1);
        }
        return dzien;
    }

    public String podajMiesiac(){
        System.out.println("Podaj miesiac(1-12): ");
        String miesiac = scanner.nextLine();
        if( Integer.parseInt(miesiac) > 0 && Integer.parseInt(miesiac) < 13) {
            return miesiac;
        }
        else {
            System.out.println("Blad! Podales zly miesiac.");
            exit(1);
        }
        return miesiac;
    }

    public String podajRok(){
        String r = null;
        System.out.println("Podaj rok(2019-2022): ");
        String rok = scanner.nextLine();
        if( Integer.parseInt(rok) >= 2019 && Integer.parseInt(rok) <= 2023) {
            return rok;
        }
        else {
            System.out.println("Blad! Podales zly rok.");
            exit(1);
        }
        return rok;
    }

    public String podajCzas() {
        System.out.println("Podaj godzine (00-24): ");
        String godzina = scanner.nextLine();
        if (Integer.parseInt(godzina) >= 00 && Integer.parseInt(godzina) <= 24) {
            System.out.println("Podaj minuty (00-59): ");
            String minuty = scanner.nextLine();
            if (Integer.parseInt(minuty) >= 00 && Integer.parseInt(minuty )<= 59) {
                godzina = godzina + minuty;

            } else {
                System.out.println("Blad! Podales zle minuty.");
                exit(1);
            }
        } else {
            System.out.println("Blad! Podales zla godzine.");
            exit(1);
        }

        return godzina;
    }


    public String RokMiesiacDzienCzas1(){
        String r = datyPoSprawdzeniu.get(0);
        String m = datyPoSprawdzeniu.get(1);
        String d = datyPoSprawdzeniu.get(2);
        String cz = datyPoSprawdzeniu.get(3);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1 = stringBuilder1.append(r);
        stringBuilder1 = stringBuilder1.append(m);
        stringBuilder1 = stringBuilder1.append(d);
        stringBuilder1 = stringBuilder1.append(cz);
        String dataPolaczona1 = stringBuilder1.toString();

        return dataPolaczona1;
    }

    public String RokMiesiacDzien2Czas(){
        String r2 = datyPoSprawdzeniu.get(4);
        String m2 = datyPoSprawdzeniu.get(5);
        String d2 = datyPoSprawdzeniu.get(6);
        String cz2 = datyPoSprawdzeniu.get(7);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1 = stringBuilder1.append(r2);
        stringBuilder1 = stringBuilder1.append(m2);
        stringBuilder1 = stringBuilder1.append(d2);
        stringBuilder1 = stringBuilder1.append(cz2);
        String dataPolaczona2 = stringBuilder1.toString();

        return dataPolaczona2;
    }

    public List<String> sprawdzDaty() throws ParseException {
        List<String> datatmp = new ArrayList<>();

        System.out.println("Podaj poczatek obserwacji");
        String r1 = podajRok();
        datatmp.add(r1);
        String m1 = podajMiesiac();
        datatmp.add(m1);
        String d1= podajDzien();
        datatmp.add(d1);
        String cz1 = podajCzas();
        datatmp.add(cz1);
        System.out.println("Podaj koniec obserwacji");
        String r2 = podajRok();
        datatmp.add(r2);
        String m2 = podajMiesiac();
        datatmp.add(m2);
        String d2= podajDzien();
        datatmp.add(d2);
        String cz2 = podajCzas();
        datatmp.add(cz2);
        Date tmp1 = dataFormat.parse(datatmp.get(0)+datatmp.get(1)+datatmp.get(2)+datatmp.get(3));
        Date tmp2 = dataFormat.parse(datatmp.get(4)+datatmp.get(5)+datatmp.get(6)+ datatmp.get(7));
        if(tmp1.compareTo(tmp2) > 0) {
            System.out.println("Poczatek obserwacji musi byc przed koncem");
            exit(1);
        } else if(tmp1.compareTo(tmp2) <= 0) {
            datyPoSprawdzeniu.addAll(datatmp);
        }
        return datyPoSprawdzeniu;
    }

}
