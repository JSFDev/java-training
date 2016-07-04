package com.test.platzi.anahisalgado.sistematransporte;

import com.java.platzi.anahisalgado.asociatividad.DocumentoAsociatividad;
import com.java.platzi.anahisalgado.conductor.Taxista;
import com.java.platzi.anahisalgado.vehiculo.Taxi;

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
