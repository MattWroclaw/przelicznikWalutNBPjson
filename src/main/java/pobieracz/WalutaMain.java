package pobieracz;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

public class WalutaMain {
    public static void main(String[] args) throws IOException {
        String [] waluta ={"eur", "usd", "gbp", "chf"};
        for (String symbolWaluty : waluta) {
            PobieraczWalut.wypiszKursSredni(symbolWaluty, 0);
        PobieraczWalut.wypiszZyskStrate(symbolWaluty, 8);
        }



    }
}
