import java.util.Arrays;
import java.util.Scanner;

public class CalcolatriceVoti {
    public static void main(String[] args) {
        Scanner keyb = new Scanner(System.in);
        int numVoti=0, numVotiSufficienti=0, numVotiInsufficienti=0;
        double sommaVoti=0;
        double votoMin=10, votoMax=0;
        boolean numVotiValido=false;

        // Richiesta numero voti
        do {
            try {
                System.out.println("Quanti voti vuoi inserire? ");
                numVoti = Integer.parseInt(keyb.nextLine());

                // Controllo numero voti
                if (numVoti <= 0) System.out.println("Hai inserito un numero negativo o nullo. Riprova.");
                else numVotiValido = true;
            } catch (Exception e){
                System.out.println("Hai inserito un numero non valido. Riprova.");
            }
        } while (!numVotiValido);

        // Crea un array per i voti
        double[] voti = new double[numVoti];

        // Richiesta dei voti
        for (int i=0; i<numVoti; i++) {
            double voto=0;
            boolean votoValido=false;

            do {
                try {
                    // Richiesta voto
                    System.out.println("Inserisci il " + (i+1) + "° voto: ");
                    voto = Double.parseDouble(keyb.nextLine());

                    // Controllo voto
                    if (voto < 0 || voto > 10) System.out.println("Hai inserito un voto non compreso nell'intervallo ammesso (0-10). Riprova.");
                    else {
                        votoValido = true;

                        voti[i] = voto;

                        sommaVoti += voto; // Calcolo della somma

                        if (voto > votoMax) votoMax = voto;
                        if (voto < votoMin) votoMin = voto;

                        if (voto >= 6) numVotiSufficienti++;
                        else numVotiInsufficienti++;
                    }
                } catch (Exception e) {
                    System.out.println("Hai inserito un voto non valido. Riprova.");
                }
            } while (!votoValido);
        }

        // Calcolo media
        double mediaVoti = sommaVoti / numVoti;

        Arrays.sort(voti);

        // Calcolo mediana
        double medianaVoti;
        if (numVoti % 2 == 0) medianaVoti = (voti[numVoti/2 - 1] + voti[numVoti/2]) / 2;
        else medianaVoti = voti[numVoti/2];

        // Sufficiente
        /*
            String sufficiente = "";
            if (mediaVoti > 5.5 && mediaVoti < 6) sufficiente = "Hai quasi raggiunto la sufficienza. Continua così! :)";
            else if (mediaVoti >= 6) sufficiente = "Bravo! Sei sufficiente :)";
            else sufficiente = "Non hai raggiunto la sufficienza :(";
         */

        // Calcolo percentuale voti sufficienti e insufficienti
        double percentualeSufficiente = ((double) numVotiSufficienti / numVoti) * 100;
        double percentualeInsufficiente = 100 - percentualeSufficiente;

        System.out.println("-------------------------------");
        System.out.println("          STATISTICHE          ");
        System.out.println("-------------------------------");

        // Stampa dei singoli voti
        /*
            System.out.printf("Voti inseriti: ");
            for (int i=0; i<numVoti; i++) {
                System.out.printf("%.2f  ", voti[i]);
            }
        */

        // Stampa risultati a schermo
        System.out.printf("%-20s %10.2f\n", "Media", mediaVoti);
        System.out.printf("%-20s %10.2f\n", "Mediana", medianaVoti);
        System.out.printf("%-20s %10d (%.1f%%)\n", "Voti sufficienti", numVotiSufficienti, percentualeSufficiente);
        System.out.printf("%-20s %10d (%.1f%%)\n", "Voti insufficienti", numVotiInsufficienti, percentualeInsufficiente);
        System.out.printf("%-20s %10.2f\n", "Voto migliore", votoMax);
        System.out.printf("%-20s %10.2f\n", "Voto peggiore", votoMin);
    }
}
