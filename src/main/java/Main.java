import PobierzDane.PobierzDane;
import Widok.Widok;
import ZmienLink.Zmien;
import java.text.ParseException;

public class Main {
    static PobierzDane d1;
    static Widok widok;

    static Zmien zmien;
    public static void main(String[] args) throws ParseException {


        widok = new Widok();
        zmien = new Zmien();
        widok.sprawdzDaty();
        String odKiedy = widok.RokMiesiacDzienCzas1();
        String doKiedy = widok.RokMiesiacDzien2Czas();
        String linkPoZmianie = zmien.zmienLink(odKiedy,doKiedy);
        d1 = new PobierzDane();
        d1.pobierz(linkPoZmianie);


    }
}