package test.com.platzi.anahisalgado.sistematransporte;

import main.com.platzi.anahisalgado.asociatividad.DocumentoAsociatividad;
import main.com.platzi.anahisalgado.conductor.Taxista;
import main.com.platzi.anahisalgado.vehiculo.Taxi;

public class MainTest {

    public static void main(String[] args) {
        Taxi ti = new Taxi("AAA123", "fadf", "i7");
        Taxista tA = new Taxista("ann", "B", ti);
        Taxista tA2 = new Taxista("leo", "C", ti);

        DocumentoAsociatividad dA = new DocumentoAsociatividad(ti, tA);
        dA.mostrarDatosDocumento();

        DocumentoAsociatividad dA2 = new DocumentoAsociatividad(ti, tA2);
        dA2.mostrarDatosDocumento();
    }
}
