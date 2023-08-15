import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del Jugador 1: ");
        String jugador1 = scanner.nextLine();
        while(jugador1.length()<2 || jugador1.matches(".*[0-9].*") || jugador1.trim().isEmpty()){
            System.out.println("Nombre no válido, por favor intente nuevamente.");
            System.out.print("Ingrese el nombre del Jugador 1: ");
            jugador1 = scanner.nextLine();
        }

        System.out.print("Ingrese el nombre del Jugador 2: ");
        String jugador2 = scanner.nextLine();
        while(jugador2.length()<2 || jugador2.matches(".*[0-9].*") || jugador2.trim().isEmpty()) {
            System.out.println("Nombre no válido, por favor intente nuevamente.");
            System.out.print("Ingrese el nombre del Jugador 2: ");
            jugador2 = scanner.nextLine();
        }

        System.out.print("Ingrese el nombre del torneo: ");
        String torneo = scanner.nextLine();
        while(torneo.length()<3|| torneo.trim().isEmpty()){
            System.out.println("Nombre de torneo no válido, por favor intente nuevamente.");
            System.out.print("Ingrese el nombre del torneo: ");
            torneo = scanner.nextLine();
        }

        System.out.print("Ingrese la cantidad de sets (3 o 5): ");
        String sets = scanner.nextLine();
        while(!sets.equalsIgnoreCase("3") && !sets.equalsIgnoreCase("5")) {
            System.out.println("La cantidad de sets debe ser solo 3 o 5, por favor intente nuevamente.");
            System.out.print("Ingrese la cantidad de sets (3 o 5): ");
            sets = scanner.nextLine();
        }

        System.out.print("Ingrese la probabilidad de ganar el partido para " + jugador1 + " (%): ");
        String probabilidadJugador1 = scanner.nextLine();
        while(probabilidadJugador1.trim().isEmpty() || probabilidadJugador1.matches(".*[a-zA-Z].*") || Integer.parseInt(probabilidadJugador1)<1 || Integer.parseInt(probabilidadJugador1) > 100) {
            System.out.println("La probabilidad debe ser entre 1 y 100, por favor intente nuevamente.");
            System.out.print("Ingrese la probabilidad de ganar el partido para " + jugador1 + " (%): ");
            probabilidadJugador1 = scanner.nextLine();
        }
        String probabilidadJugador2 = String.valueOf(100-Integer.parseInt(probabilidadJugador1));

        System.out.println();
        System.out.println("--- Información del partido ---");
        System.out.println();
        System.out.println("Torneo: " + torneo);
        System.out.println("Jugador 1: " + jugador1);
        System.out.println("Jugador 2: " + jugador2);
        System.out.println("Probabilidad de triunfo de "+jugador1+": "+ probabilidadJugador1+"%");
        System.out.println("Probabilidad de triunfo de "+jugador2+": "+ probabilidadJugador2+"%");
        System.out.println("Modalidad: El mejor de " + sets +" sets");
        System.out.println();
        System.out.println("--------------------");
        System.out.println("Comienza el partido");
        System.out.println("--------------------");
        SimuladorTenis partido = new SimuladorTenis(jugador1, jugador2, torneo, sets, probabilidadJugador1, probabilidadJugador2);
        partido.simularPartido();


        System.out.print("\n¿Desea jugar la revancha? (si/no): ");
        String revancha = scanner.next();
        while(!revancha.equalsIgnoreCase("si") && !revancha.equalsIgnoreCase("no"))
        {
            System.out.println("Respuesta incorrecta. Por favor intente nuevamente.");
            System.out.print("\n¿Desea jugar la revancha? (si/no): ");
            revancha = scanner.next();
        }
        if (revancha.equalsIgnoreCase("si")) {
            System.out.println("--------------------");
            System.out.println();
            System.out.println("¡Inicia la revancha!");
            System.out.println();
            System.out.println("--------------------");
            SimuladorTenis partidoRevancha = new SimuladorTenis(jugador1, jugador2, torneo, sets, probabilidadJugador1, probabilidadJugador2);
            partidoRevancha.simularPartido();
            System.out.println();
        } else {
            System.out.println("¡Gracias Por Jugar!");
            System.out.println();
            System.out.println("----------------------------------------");
            System.out.println("Simulador Creado Por Alexis Massari");
            System.out.println("----------------------------------------");
            System.out.println();
        }
        scanner.close();
    }
}

