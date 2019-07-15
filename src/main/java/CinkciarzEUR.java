import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class CinkciarzEUR {

    public static void roznicaCenyEuro() throws IOException {
//        json z dzisiaj
        URL urlCenaTeraz = new URL(HttpNowAnd4WeeksAgo.euroHttpNOW());
//        json sprzed 4 tygodni
        URL urlCenaMiesiacTemu = new URL(HttpNowAnd4WeeksAgo.euroHttpMonthAgo());

        URLConnection connectionTeraz = urlCenaTeraz.openConnection();
        URLConnection connectionMiesiacTemu = urlCenaMiesiacTemu.openConnection();

        Scanner scannerTeraz = new Scanner(connectionTeraz.getInputStream());
        Scanner scannerMiesiacTemu = new Scanner(connectionMiesiacTemu.getInputStream());

        String jsonTeraz = scannerTeraz.nextLine();
        String jsonMiesiacTemu = scannerMiesiacTemu.nextLine();

        Gson gson = new Gson();

        Waluta walutaTeraz = gson.fromJson(jsonTeraz, Waluta.class);
        Waluta walutaMiesiacTemu = gson.fromJson(jsonMiesiacTemu, Waluta.class);

        double cenaTeraz = 0;
        List<Rates> ratesTeraz = walutaTeraz.rates;
        for (Rates rate : ratesTeraz) {
            cenaTeraz= rate.bid;
        }

        double cenaMiesiacTemu = 0;
        List<Rates> ratesMiesiacTemu = walutaMiesiacTemu.rates;
        for (Rates rate : ratesMiesiacTemu) {
            cenaMiesiacTemu= rate.bid;
        }
        DecimalFormat ladnaCena = new DecimalFormat("#.000");
        System.out.println("[EUR] Cena obecna - cena sprzed miesiąca = "+(ladnaCena.format(cenaTeraz-cenaMiesiacTemu))+" zł");
    }

}
