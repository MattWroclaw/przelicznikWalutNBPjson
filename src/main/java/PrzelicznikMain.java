import java.io.IOException;

public class PrzelicznikMain {
    public static void main(String[] args) throws IOException {
//        Euro.euro();
//        Dolar.dolar();
//        FrankCh.frank();
//        Pound.pound();
        Za100zlUSD.ileUSDza100zl();
        Za100zlEUR.ileEURza100zl();
        Za100zlCHF.ileCHFza100zl();
        Za100zlGBP.ileGBPza100zl();

        CinkciarzCHF.roznicaCenyFrank();
        CinkciarzUDS.roznicaCenyDolar();
        CinkciarzEUR.roznicaCenyEuro();
        CinkciarzGBP.roznicaCenyPound();
    }
}
