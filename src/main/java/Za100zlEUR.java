import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class Za100zlEUR {
    public static void ileEURza100zl() throws IOException {
        double wartosc100zl= 0;

        URL urlEuro = new URL("http://api.nbp.pl/api/exchangerates/rates/c/eur/today/?format=json");
        URLConnection connectionEuro = urlEuro.openConnection();
        Scanner scannerEuro = new Scanner(connectionEuro.getInputStream());
        String jsonEuro = scannerEuro.nextLine();
        Gson gsonEuro = new Gson();
        Waluta waluta = gsonEuro.fromJson(jsonEuro, Waluta.class);
        System.out.println(waluta.currency+" "+ waluta.code+" ");
        List<Rates> tabelaDanych = waluta.rates;
        for (Rates dane : tabelaDanych) {
            System.out.println(dane.ask);
            wartosc100zl = 100/dane.ask;
            DecimalFormat ladnaCena = new DecimalFormat("#.000");
            System.out.println("Za 100zł kupisz :"+(ladnaCena.format(wartosc100zl))+" EUR");

        }
        System.out.println("**********************************");
    }
}
