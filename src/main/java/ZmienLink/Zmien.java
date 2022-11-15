package ZmienLink;

public class Zmien {
    public static String zmienLink(String odKiedy, String doKiedy){
        String link = "https://www.ogimet.com/cgi-bin/getsynop?begin=odKiedy&end=doKiedy&state=Pol";
        link = link.replaceAll("odKiedy",odKiedy);
        link = link.replaceAll("doKiedy",doKiedy);
        return link;
    }

}
