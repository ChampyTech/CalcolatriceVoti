import java.util.Scanner;

public class CalcolatriceVoti {
    public static void main(String[] args) {
        Scanner keyb = new Scanner(System.in);
        int numVoti=0;
        double sommaVoti=0;
        double votoMin=Integer.MAX_VALUE, votoMax=Integer.MIN_VALUE;
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
                    }
                } catch (Exception e) {
                    System.out.println("Hai inserito un voto non valido. Riprova.");
                }
            } while (!votoValido);
        }

        // Calcolo media
        double mediaVoti = sommaVoti / numVoti;

        // Stampa dei singoli voti
        System.out.printf("Voti inseriti: ");
        for (int i=0; i<numVoti; i++) {
            System.out.printf("%.2f  ", voti[i]);
        }

        // Stampa risultati a schermo
        // System.out.printf("Numero di voti: %d\n", numVoti);
        System.out.printf("\nMedia: %.2f\n", mediaVoti);
        System.out.printf("Voto migliore: %.2f\n", votoMax);
        System.out.printf("Voto peggiore: %.2f\n", votoMin);
    }
}