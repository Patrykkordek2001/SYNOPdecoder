package PobierzDane;
import Dekoder.SekcjaJedenDekoder;
import Dekoder.SekcjaZeroDekoder;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class PobierzDane{
    private URL url;
    private InputStream is = null;
    private BufferedReader br;




    public void pobierz(String link)

    {

        SekcjaZeroDekoder dekoduj0 = new SekcjaZeroDekoder();
        SekcjaJedenDekoder dekoduj1 = new SekcjaJedenDekoder();
        try {
            String dane = "";
            url = new URL(link);
            is = url.openStream();
            br = new BufferedReader(new InputStreamReader(is));

            while ((dane = br.readLine()) != null) {
                dane = przygotujDane(dane);
                System.out.println(dane);
                String sekcjaZeroDane = dane.substring(0,16);
                dekoduj0.dekodujSekcjeZero(sekcjaZeroDane);
                String sekcjaJedenDane = dane.substring(17);
                dekoduj1.dekodujSekcjeJeden(sekcjaJedenDane);


            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (is != null) ((InputStream) is).close();
            } catch (IOException ioe) {
            }
        }
    }


public String przygotujDane(String linia)
{
        int index222= -1;
        int index333= -1;
        int index444= -1;
        int index555 = -1;
        String danePrzygotowane;
        danePrzygotowane = linia.substring(23);
        if(danePrzygotowane.contains("==")) danePrzygotowane = danePrzygotowane.replaceAll("==","");
        index222 = danePrzygotowane.indexOf("222");
        index333 = danePrzygotowane.indexOf("333");
        index444 = danePrzygotowane.indexOf("444");
        index555 = danePrzygotowane.indexOf("555");
        if (index222 != -1) danePrzygotowane = danePrzygotowane.substring(0,index222);
        else if (index333 != -1) danePrzygotowane = danePrzygotowane.substring(0,index333);
        else if (index444 != -1) danePrzygotowane = danePrzygotowane.substring(0, index444);
        else if (index555 != -1)danePrzygotowane = danePrzygotowane.substring(0,index555);
        return danePrzygotowane;
}





}