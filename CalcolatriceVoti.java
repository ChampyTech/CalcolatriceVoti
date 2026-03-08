import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CalcolatriceVoti {
    public static void main(String[] args) {
        Scanner keyb = new Scanner(System.in);
        int numVotiSufficienti=0, numVotiInsufficienti=0;
        double sommaVoti=0, votoMin=10, votoMax=0;

        // Array per i voti
        ArrayList<Double> voti = new ArrayList<>();

        // Acquisizione voti
        while (true) {
            System.out.println("Inserisci un voto (X per terminare): ");
            String input = keyb.nextLine();

            // Se è "X" esci
            if (input.equalsIgnoreCase("X")) break;

            try {
                double voto =  Double.parseDouble(input);

                // Controllo voto
                if (voto < 0 || voto > 10) {
                    System.out.println("Hai inserito un voto non valido (0-10).");
                } else {
                    voti.add(voto);

                    sommaVoti += voto; // Calcolo della somma

                    if (voto > votoMax) votoMax = voto;
                    if (voto < votoMin) votoMin = voto;

                    if (voto >= 6) numVotiSufficienti++;
                    else numVotiInsufficienti++;
                }
            } catch (Exception e) {
                System.out.println("Hai inserito un valore non valido. Riprova.");
            }
        }

        // Numero voti
        int numVoti = voti.size();

        // Se non è stato inserito nessun voto
        if (numVoti == 0) {
            System.out.println("Non hai inserito nessun voto.");
            return;
        }

        // Calcolo media
        double mediaVoti = sommaVoti / numVoti;

        // Ordina l'array di voti dal più piccolo al più grande
        Collections.sort(voti);

        // Calcolo mediana
        double medianaVoti;
        if (numVoti % 2 == 0) medianaVoti = (voti.get(numVoti/2 - 1) + voti.get(numVoti/2)) / 2;
        else medianaVoti = voti.get(numVoti/2);

        // Sufficiente
        String sufficiente;
        if (mediaVoti > 5.5 && mediaVoti < 6) sufficiente = "Hai quasi raggiunto la sufficienza. Continua così! ;)";
        else if (mediaVoti >= 6) sufficiente = "Bravo! Sei sufficiente :)";
        else sufficiente = "Non hai raggiunto la sufficienza :(\nPer arrivare alla media del 6 nel prossimo compito devi prendere minimo " + ((6 * (numVoti + 1)) - sommaVoti);

        // Calcolo percentuale voti sufficienti e insufficienti
        double percentualeSufficiente = ((double) numVotiSufficienti / numVoti) * 100;
        double percentualeInsufficiente = 100 - percentualeSufficiente;

        System.out.println("-------------------------------");
        System.out.println("          STATISTICHE          ");
        System.out.println("-------------------------------");

        // Stampa risultati a schermo
        System.out.printf("%-20s %10.2f\n", "Media", mediaVoti);
        System.out.printf("%-20s %10.2f\n", "Mediana", medianaVoti);
        System.out.printf("%-20s %10d\n", "Voti totali", numVoti);
        System.out.printf("%-20s %10d (%.1f%%)\n", "Voti sufficienti", numVotiSufficienti, percentualeSufficiente);
        System.out.printf("%-20s %10d (%.1f%%)\n", "Voti insufficienti", numVotiInsufficienti, percentualeInsufficiente);
        System.out.printf("%-20s %10.2f\n", "Voto migliore", votoMax);
        System.out.printf("%-20s %10.2f\n", "Voto peggiore", votoMin);
        System.out.printf("\n%s\n", sufficiente);

        keyb.close();
    }
}
