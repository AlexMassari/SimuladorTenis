import java.util.ArrayList;
import java.util.Random;

public class SimuladorTenis {
    private String jugador1;
    private String jugador2;
    private String torneo;
    private String sets;
    private String probabilidadJugador1;
    private String probabilidadJugador2;

    public SimuladorTenis(String jugador1, String jugador2, String torneo, String sets, String probabilidadJugador1, String probabilidadJugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.torneo=torneo;
        this.sets = sets;
        this.probabilidadJugador1 = probabilidadJugador1;
        this.probabilidadJugador2 = probabilidadJugador2;
    }
    int contadorSetsJugador1 = 0;
    int contadorSetsJugador2 = 0;

    public void simularPartido() {
        int setsParaGanar=(int) Math.ceil(Double.parseDouble(sets)/2);
        int setJugado=0;
        ArrayList <String> setJugador1 = new ArrayList<>();
        ArrayList <String> setJugador2 = new ArrayList<>();

            while (contadorSetsJugador1 < setsParaGanar && contadorSetsJugador2 < setsParaGanar) {
                int contadorGamesJugador1 = 0;
                int contadorGamesJugador2 = 0;
                int contadorPuntosJugador1 = 0;
                int contadorPuntosJugador2 = 0;
                String [] valoresPuntos= {"0","15","30","40"};
                String puntosJ1="0";
                String puntosJ2="0";
                boolean juegoTerminado = false;
                boolean saqueJugador1=true;

                while (!juegoTerminado) {

                if(contadorPuntosJugador1 + contadorPuntosJugador2 == 0){
                    System.out.println();
                    System.out.println("El jugador "+ (saqueJugador1 ? jugador1 : jugador2) +" esta al saque");
                }

                // Simulación del Game

                String ganadorPunto = simularPunto(probabilidadJugador1, probabilidadJugador2);
                if (ganadorPunto.equals(jugador1)) {
                    contadorPuntosJugador1++;
                    if(contadorPuntosJugador1<3) {
                        puntosJ1 = valoresPuntos[contadorPuntosJugador1];
                    }
                    else{
                        if(contadorPuntosJugador1==3){
                            puntosJ1=valoresPuntos[contadorPuntosJugador1];
                        }
                        else {
                            if(contadorPuntosJugador1>=4){
                                if(contadorPuntosJugador2<=2) {
                                    puntosJ1 = valoresPuntos[3];
                                }
                                else {
                                    if(contadorPuntosJugador1==contadorPuntosJugador2){
                                        puntosJ1="40";
                                        puntosJ2="40";
                                    }
                                    else{
                                        if(contadorPuntosJugador1>contadorPuntosJugador2)  {
                                            puntosJ1="40(V)";
                                            puntosJ2="40";
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    contadorPuntosJugador2++;
                    if(contadorPuntosJugador2<3) {
                        puntosJ2 = valoresPuntos[contadorPuntosJugador2];
                    }
                    else{
                        if(contadorPuntosJugador2==3){
                            puntosJ2=valoresPuntos[contadorPuntosJugador2];
                        }
                        else {
                            if(contadorPuntosJugador2>=4){
                                if(contadorPuntosJugador1<=2) {
                                    puntosJ2 = valoresPuntos[3];
                                }
                                else {
                                    if(contadorPuntosJugador1==contadorPuntosJugador2){
                                        puntosJ1="40";
                                        puntosJ2="40";
                                    }
                                    else{
                                        if(contadorPuntosJugador1<contadorPuntosJugador2)  {
                                            puntosJ1="40";
                                            puntosJ2="40(V)";
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                System.out.println();
                System.out.println("Ganador del punto: " + ganadorPunto);
                if (contadorPuntosJugador1 >= 4 && contadorPuntosJugador1 - contadorPuntosJugador2 >= 2) {
                    System.out.print("");
                }
                else if (contadorPuntosJugador2 >= 4 && contadorPuntosJugador2 - contadorPuntosJugador1 >= 2) {
                    System.out.print("");
                }
                else {
                    System.out.println("Resultado parcial del game: ");
                    System.out.println(jugador1 +": "+ puntosJ1);
                    System.out.println(jugador2 +": "+ puntosJ2);
                }

                // VERIFICA SI EL JUGADOR GANA EL GAME

                if (contadorPuntosJugador1 >= 4 && contadorPuntosJugador1 - contadorPuntosJugador2 >= 2) {
                    contadorGamesJugador1++;
                    contadorPuntosJugador1 = 0;
                    contadorPuntosJugador2 = 0;
                    puntosJ1="0";
                    puntosJ2="0";
                    if(saqueJugador1){
                        saqueJugador1=false;
                    }
                    else{
                        saqueJugador1=true;
                    }
                    System.out.println("¡" + jugador1 + " gana el game!");
                    System.out.println("--------------------");
                    System.out.println("Set "+(setJugado+1));
                    System.out.println(jugador1 +": "+ contadorGamesJugador1);
                    System.out.println(jugador2 +": "+ contadorGamesJugador2);
                    System.out.println("--------------------");
                } else if (contadorPuntosJugador2 >= 4 && contadorPuntosJugador2 - contadorPuntosJugador1 >= 2) {
                    contadorGamesJugador2++;
                    contadorPuntosJugador1 = 0;
                    contadorPuntosJugador2 = 0;
                    puntosJ1="0";
                    puntosJ2="0";
                    if(saqueJugador1){
                        saqueJugador1=false;
                    }
                    else{
                        saqueJugador1=true;
                    }
                    System.out.println("¡" + jugador2 + " gana el game!");
                    System.out.println("--------------------");
                    System.out.println("Set "+(setJugado+1));
                    System.out.println(jugador1 +": "+ contadorGamesJugador1);
                    System.out.println(jugador2 +": "+ contadorGamesJugador2);
                    System.out.println("--------------------");
                }

                // VERIFICA SI EL JUGADOR GANA EL SET

                if (contadorGamesJugador1 == 6 && contadorGamesJugador2 == 6) {
                    juegoTerminado = true;
                    int contadorPuntoTbJugador1 = 0;
                    int contadorPuntoTbJugador2 = 0;
                    System.out.println();
                    System.out.println("Tie Break");
                    System.out.println("--------------------");
                    System.out.println();
                    System.out.println("El jugador "+ (saqueJugador1 ? jugador1 : jugador2) +" esta al saque");
                    System.out.println();
                    while (contadorPuntoTbJugador1 < 7 && contadorPuntoTbJugador2 < 7) {

                        String ganadorPuntoTb = simularPunto(probabilidadJugador1, probabilidadJugador2);

                        if (ganadorPuntoTb.equals(jugador1)) {
                            contadorPuntoTbJugador1++;
                            System.out.println("Ganador del punto: " + ganadorPuntoTb);
                            System.out.println("Parcial TB: "  + contadorPuntoTbJugador1 + " - " + contadorPuntoTbJugador2);
                        } else {
                            contadorPuntoTbJugador2++;
                            System.out.println("Ganador del punto: " + ganadorPuntoTb);
                            System.out.println("Parcial TB: "  + contadorPuntoTbJugador1 + " - " + contadorPuntoTbJugador2);
                        }
                    }

                    if(saqueJugador1){
                        saqueJugador1=false;
                    }
                    else{
                        saqueJugador1=true;
                    }

                    if (contadorPuntoTbJugador1 == 7) {
                        contadorSetsJugador1++;
                        setJugado++;
                        setJugador1.add("7 (" + String.valueOf(contadorPuntoTbJugador1) + ")");
                        setJugador2.add("6 (" + String.valueOf(contadorPuntoTbJugador2) + ")");
                        System.out.println("--- Final del set ---");
                        System.out.println("Ganador del Tie Break: " + jugador1);
                        if (contadorSetsJugador1 < setsParaGanar) {
                            System.out.println("Resultado Parcial Set "+(setJugado+1)+" :");
                            System.out.print(jugador1 + ":");
                            for (int i = 0; i < setJugado; i++) {
                                System.out.print(" " + setJugador1.get(i) + " | ");
                            }
                            System.out.print("\n");
                            System.out.print(jugador2 + ":");
                            for (int i = 0; i < setJugado; i++) {
                                System.out.print(" " + setJugador2.get(i) + " | ");
                            }
                            System.out.println();
                            System.out.println("--------------------");
                            System.out.println();
                        }
                    } else if (contadorPuntoTbJugador2 == 7) {
                        contadorSetsJugador2++;
                        setJugado++;
                        setJugador1.add("6 (" + String.valueOf(contadorPuntoTbJugador1) + ")");
                        setJugador2.add("7 (" + String.valueOf(contadorPuntoTbJugador2) + ")");
                        System.out.println("--- Final del set ---");
                        System.out.println("Ganador del Tie Break: " + jugador2);
                        if (contadorSetsJugador2 < setsParaGanar) {
                            System.out.println("Resultado Parcial Set "+(setJugado+1)+" :");
                            System.out.print(jugador1 + ":");
                            for (int i = 0; i < setJugado; i++) {
                                System.out.print(" " + setJugador1.get(i) + " | ");
                            }
                            System.out.print("\n");
                            System.out.print(jugador2 + ":");
                            for (int i = 0; i < setJugado; i++) {
                                System.out.print(" " + setJugador2.get(i) + " | ");
                            }
                            System.out.println();
                            System.out.println("--------------------");
                            System.out.println();
                        }
                    }
                }


                if (contadorGamesJugador1 >= 6 && contadorGamesJugador1 - contadorGamesJugador2 >= 2) {
                    contadorSetsJugador1++;
                    setJugador1.add(String.valueOf(contadorGamesJugador1));
                    setJugador2.add(String.valueOf(contadorGamesJugador2));
                    setJugado++;
                    juegoTerminado = true;
                    System.out.println("--- Final del set ---");
                    System.out.println("Ganador del set: " + jugador1);
                    if(contadorSetsJugador1 < setsParaGanar) {
                        System.out.println("Resultado del Parcial: ");
                        System.out.print(jugador1 + ":");
                        for (int i = 0; i < setJugado; i++) {
                            System.out.print(" " + setJugador1.get(i) + " | ");
                        }
                        System.out.print("\n");
                        System.out.print(jugador2 + ":");
                        for (int i = 0; i < setJugado; i++) {
                            System.out.print(" " + setJugador2.get(i) + " | ");
                        }
                        System.out.println();
                        System.out.println("--------------------");
                        System.out.println();
                    }
                    else{
                        System.out.println();
                        System.out.println("Partido Terminado !!!");
                    }
                } else if (contadorGamesJugador2 >= 6 && contadorGamesJugador2 - contadorGamesJugador1 >= 2) {
                    contadorSetsJugador2++;
                    setJugador1.add(String.valueOf(contadorGamesJugador1));
                    setJugador2.add(String.valueOf(contadorGamesJugador2));
                    setJugado++;
                    juegoTerminado = true;
                    System.out.println("--- Final del set ---");
                    System.out.println("Ganador del set: " + jugador2);
                    if(contadorSetsJugador2 < setsParaGanar) {
                        System.out.println("Resultado Parcial: ");
                        System.out.print(jugador1 + ":");
                        for (int i = 0; i < setJugado; i++) {
                            System.out.print(" " + setJugador1.get(i) + " | ");
                        }
                        System.out.print("\n");
                        System.out.print(jugador2 + ":");
                        for (int i = 0; i < setJugado; i++) {
                            System.out.print(" " + setJugador2.get(i) + " | ");
                        }
                        System.out.println();
                        System.out.println("--------------------");
                        System.out.println();
                    }
                    else{
                        System.out.println();
                        System.out.println("Partido Terminado !!!");
                    }
                }
            }
        }
        System.out.println();
        System.out.println("Ganador del torneo "+ torneo + ": " + (GanadorDelTorneo()));
        System.out.println("--------------------");
        System.out.println("Resultado final");
        System.out.print(jugador1+":");
        for(int i=0;i<setJugado;i++) {
            System.out.print(" " + setJugador1.get(i) +" | ");
        }
        System.out.print("\n");
        System.out.print(jugador2+":");
        for(int i=0;i<setJugado;i++) {
            System.out.print(" " + setJugador2.get(i) +" | ");
        }
        System.out.println();
        System.out.println("--------------------");
    }

    public String simularPunto(String probabilidadJugador1, String probabilidadJugador2) {
        Random random = new Random();
        int totalProbabilidad = Integer.parseInt(probabilidadJugador1) + Integer.parseInt(probabilidadJugador2);
        int numeroAleatorio = random.nextInt(100) + 1;

        if (numeroAleatorio <= Integer.parseInt(probabilidadJugador1)) {
            return jugador1;
        } else {
            return jugador2;
        }
    }
    public String GanadorDelTorneo() {
        return contadorSetsJugador1 > contadorSetsJugador2 ? jugador1 : jugador2;
    }

}
