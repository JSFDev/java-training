package test.com.platzi.anahisalgado.sistematransporte;

import main.com.platzi.anahisalgado.asociatividad.DocumentoAsociatividad;
import main.com.platzi.anahisalgado.conductor.Taxista;
import main.com.platzi.anahisalgado.vehiculo.Taxi;
import org.junit.Test;

public class MainTest {
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
    private void shouldDisplayDocumentosDeTaxista() {
        DocumentoAsociatividad dA = new DocumentoAsociatividad(ti, tA);
        dA.mostrarDatosDocumento();
        DocumentoAsociatividad dA2 = new DocumentoAsociatividad(ti, tA2);
        dA2.mostrarDatosDocumento();
    }

    public static void main(String[] args) {
        new MainTest().runTask();
    }
}
