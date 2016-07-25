package com.platzi.simple;

import com.platzi.anahisalgado.asociatividad.DocumentoAsociatividad;
import com.platzi.anahisalgado.conductor.Taxista;
import com.platzi.anahisalgado.vehiculo.Taxi;
import org.junit.Test;

public class TaxistaTest {
    private Thread thread = null;
    private Runnable task = () -> {
        System.out.println(this.thread.getName());
        this.shouldDisplayDocumentosDeTaxista();
    };
    Taxi ti = new Taxi("AAA123", "fadf", "i7");
    Taxista tA = new Taxista("ann", "B", ti);
    Taxista tA2 = new Taxista("leo", "C", ti);

    public void runTask() {
        thread = new Thread(this.task, "Thread-documentosTaxistas");
        thread.start();
    }

    @Test
    public void shouldDisplayDocumentosDeTaxista() {
        DocumentoAsociatividad dA = new DocumentoAsociatividad(ti, tA);
        dA.mostrarDatosDocumento();
        DocumentoAsociatividad dA2 = new DocumentoAsociatividad(ti, tA2);
        dA2.mostrarDatosDocumento();
    }
}
