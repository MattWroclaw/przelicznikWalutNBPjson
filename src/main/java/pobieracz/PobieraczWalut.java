package pobieracz;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Scanner;

public class PobieraczWalut {
    private static Waluta aktualnyKurs(String waluta, int ileTygodniTemu, String sredniAskrzedarzKupnoC) throws IOException {

        String skrotWaluty = waluta.toLowerCase();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = Date.from(ZonedDateTime.now().minusWeeks(ileTygodniTemu).toInstant());
        String poprawnaData = "";
//        ************ zabezpieczenie przed nieudaną próbą pobrania danych w weekend lub w nocy
        SimpleDateFormat godziny = new SimpleDateFormat("HH");
        SimpleDateFormat dzienTygodnia = new SimpleDateFormat("u");
        int godzinyInt = Integer.parseInt(godziny.format(date));
        int numerDnia = Integer.parseInt(dzienTygodnia.format(date));

        if ((godzinyInt > 9 && godzinyInt < 23) && (numerDnia != 6 || numerDnia != 7)) {
            poprawnaData = dateFormat.format(date);
        } else if ((godzinyInt >= 0 && godzinyInt < 10) && (numerDnia != 6 || numerDnia != 7)) {
            poprawnaData = dateFormat.format(Date.from(ZonedDateTime.now().minusHours(12).toInstant()));
        } else if ((numerDnia == 6)) {
            poprawnaData = dateFormat.format(Date.from(ZonedDateTime.now().minusDays(1).toInstant()));
        } else if ((numerDnia == 7)) {
            poprawnaData = dateFormat.format(Date.from(ZonedDateTime.now().minusDays(2).toInstant()));
        }
        String http = "http://api.nbp.pl/api/exchangerates/rates/" + sredniAskrzedarzKupnoC
                + "/" + waluta + "/" + poprawnaData + "/?format=json";

//        http://api.nbp.pl/api/exchangerates/rates/c/usd/2019-04-04/?format=json"


        URL url = new URL(http);
        URLConnection connection = url.openConnection();
        String json;
        try (Scanner scanner = new Scanner(connection.getInputStream())) {
            json = scanner.nextLine();
        }

        Gson gson = new Gson();
        Waluta walutaJson = gson.fromJson(json, Waluta.class);
//
        return walutaJson;
    }

    public static void wypiszKursSredni(String waluta, int ileTygodniTemu) throws IOException {

        String symbolWaluty = aktualnyKurs(waluta, ileTygodniTemu, "A").currency;
        String zDnia = aktualnyKurs(waluta, ileTygodniTemu, "A").rates.get(0).getEffectiveDate();
        double wartosc = aktualnyKurs(waluta, ileTygodniTemu, "A").rates.get(0).getMid();
        DecimalFormat decimalFormat = new DecimalFormat("#.000");
        String ladnaCena = decimalFormat.format(wartosc);
        System.out.println("Kurs waluty: "+symbolWaluty+" z dnia: "+zDnia+" wynosi: "+ladnaCena+"PLN");

//        ile kupisz za 100zł
        double cenaSprzedarzy = aktualnyKurs(waluta, ileTygodniTemu, "c").rates.get(0).getAsk();
        double ileKupiszZaStowe = 100/cenaSprzedarzy;
        String zaStoweLadnaCena = decimalFormat.format(ileKupiszZaStowe);
        System.out.println("Za 100 PLN nabędziesz: "+zaStoweLadnaCena+" "+waluta);
        System.out.println("** ** ** ** **");
    }

    public static void wypiszZyskStrate(String waluta, int ileTygodniTemu) throws IOException {
        double cenaTeraz = aktualnyKurs(waluta, 0, "C").rates.get(0).getAsk();
        double cenaWtedy = aktualnyKurs(waluta, ileTygodniTemu, "C").rates.get(0).getAsk();
        double różnicaRaw =cenaTeraz-cenaWtedy;
        DecimalFormat decimalFormat = new DecimalFormat("#.000");
        String różnica = decimalFormat.format(różnicaRaw);

        String komentarz= "";
        if (różnicaRaw>=0){
            komentarz="Teraz cena jest wyższa o: ";
        }else {
            komentarz="Obecna cena waluty jest niższa o:";
        }
        System.out.println(waluta+"!: "+komentarz+" " +różnica+" PLN");
        System.out.println("** ** ** ** **");

    }



}
