import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

public class HttpNowAnd4WeeksAgo {

//    DOLLARS
    public static String dolarHttpNOW(){
        Date dateNow = new Date(); // obecna data
        DateFormat formatDaty = new SimpleDateFormat("yyyy-MM-dd"); // tak ma wyglądać
        // żeby pasowało to ciągu http
//        System.out.println(dateNow);
        String currentDateFormated = formatDaty.format(dateNow); //ta metoda to przeformatuje na żądaną postać
//        System.out.println(currentDateFormated);
//      nasz adres http, skąd pobieramy json'a
        String httpFormatDateNOW = String.format(" http://api.nbp.pl/api/exchangerates/rates/c/usd/%s/?format=json", currentDateFormated);
//        System.out.println(httpZdataNOW);
        return httpFormatDateNOW;
    }

    public static String dolarHttpMonthAgo(){
        DateFormat formatDaty = new SimpleDateFormat("yyyy-MM-dd"); //taki format daty do http
        Date miesiacAgo = Date.from(ZonedDateTime.now().minusWeeks(4).toInstant()); // odejmuję 4 tygodnie
//        a nie dokładnie 1 miesiąc, bo można trafić wtedy na weekend (404 error)
//        System.out.println(miesiacAgo);
        String miesiacAgoFormatted = formatDaty.format(miesiacAgo); //po sformatowaniu ..
//        System.out.println(miesiacAgoFormatted);
//      nasz adres http, skąd pobieramy jsona z ceną waluty sprzed 4 tygodni
        String httpZdata4WeeksAgo = String.format(" http://api.nbp.pl/api/exchangerates/rates/c/usd/%s/?format=json", miesiacAgoFormatted);
        return httpZdata4WeeksAgo;
    }

//    EURO
    public static String euroHttpNOW(){
        Date dateNow = new Date();
        DateFormat formatDaty = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateFormated = formatDaty.format(dateNow);
        String httpFormatDateNOW = String.format(" http://api.nbp.pl/api/exchangerates/rates/c/eur/%s/?format=json", currentDateFormated);
        return httpFormatDateNOW;
    }

    public static String euroHttpMonthAgo(){
        Date miesiacAgo = Date.from(ZonedDateTime.now().minusWeeks(4).toInstant());
        DateFormat formatDaty = new SimpleDateFormat("yyyy-MM-dd");
        String miesiacAgoFormatted = formatDaty.format(miesiacAgo);
        String httpZdata4WeeksAgo = String.format(" http://api.nbp.pl/api/exchangerates/rates/c/eur/%s/?format=json", miesiacAgoFormatted);
        return httpZdata4WeeksAgo;
    }
//    CHF
    public static String chfHttpNOW(){
        Date dateNow = new Date();
        DateFormat formatDaty = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateFormated = formatDaty.format(dateNow);
        String httpFormatDateNOW = String.format(" http://api.nbp.pl/api/exchangerates/rates/c/chf/%s/?format=json", currentDateFormated);
        return httpFormatDateNOW;
    }

    public static String chfHttpMonthAgo(){
        Date miesiacAgo = Date.from(ZonedDateTime.now().minusWeeks(4).toInstant());
        DateFormat formatDaty = new SimpleDateFormat("yyyy-MM-dd");
        String miesiacAgoFormatted = formatDaty.format(miesiacAgo);
        String httpZdata4WeeksAgo = String.format(" http://api.nbp.pl/api/exchangerates/rates/c/chf/%s/?format=json", miesiacAgoFormatted);
        return httpZdata4WeeksAgo;
    }
// Great Britain Pounds
    public static String gbpHttpNOW(){
        Date dateNow = new Date();
        DateFormat formatDaty = new SimpleDateFormat("yyyy-MM-dd");
        String currentDateFormated = formatDaty.format(dateNow);
        String httpFormatDateNOW = String.format(" http://api.nbp.pl/api/exchangerates/rates/c/gbp/%s/?format=json", currentDateFormated);
        return httpFormatDateNOW;
    }

    public static String gbpHttpMonthAgo(){
        Date miesiacAgo = Date.from(ZonedDateTime.now().minusWeeks(4).toInstant());
        DateFormat formatDaty = new SimpleDateFormat("yyyy-MM-dd");
        String miesiacAgoFormatted = formatDaty.format(miesiacAgo);
        String httpZdata4WeeksAgo = String.format(" http://api.nbp.pl/api/exchangerates/rates/c/gbp/%s/?format=json", miesiacAgoFormatted);
        return httpZdata4WeeksAgo;
    }

//    public static void main(String[] args) {
//        System.out.println(dolarHttpMonthAgo());
//        System.out.println(dolarHttpNOW());
//        System.out.println(euroHttpMonthAgo());
//        System.out.println(euroHttpNOW());
//        System.out.println(gbpHttpMonthAgo());
//        System.out.println(gbpHttpNOW());
//        System.out.println(chfHttpMonthAgo());
//        System.out.println(chfHttpNOW());
//    }
}
