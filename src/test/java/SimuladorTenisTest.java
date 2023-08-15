import org.junit.Test;
import static org.junit.Assert.*;

public class SimuladorTenisTest {

    // Se prueba el funcionamiento de las probabilidades para determinar el ganador de cada punto.
    @Test
    public void testGanadorTorneo(){
        String jugador1 = "Marcos";
        String jugador2 = "Alexis";
        String torneo = "Wimbledon";
        String sets = "3";
        String probabilidadJugador1 = "99";
        String probabilidadJugador2 = "1";
        SimuladorTenis simulador = new SimuladorTenis(jugador1, jugador2, torneo, sets, probabilidadJugador1, probabilidadJugador2);
        simulador.simularPartido();
        assertEquals(jugador1, simulador.GanadorDelTorneo());
    }

    // Se prueba el funcionamiento del método que genera el ganador del punto.
    @Test
    public void testSimularPunto() {
        SimuladorTenis simuladorTenis = new SimuladorTenis("Juan", "Pedro", "US Open", "3", "70", "30");
        String ganadorPunto = simuladorTenis.simularPunto("70", "30");
        assertTrue(ganadorPunto.equals("Juan") || ganadorPunto.equals("Pedro"));
    }

    // Se prueba que el programa no siga corriendo si se ingresa un dato incorrecto (probabilidadJugador1 letra)
    @Test(expected = NumberFormatException.class)
    public void excepcionDatoIncorrecto() {
        String jugador1 = "Matias";
        String jugador2 = "Juan";
        String torneo = "Cordoba Open";
        String sets = "3";
        String probabilidadJugador1 = "A";
        String probabilidadJugador2 = "B";

        SimuladorTenis simulador = new SimuladorTenis(jugador1, jugador2, torneo, sets, probabilidadJugador1, probabilidadJugador2);
        simulador.simularPartido();
    }
}
