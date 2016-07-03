package com.java.platzi.anahisalgado.asociatividad;

import com.java.platzi.anahisalgado.conductor.Conductor;
import com.java.platzi.anahisalgado.vehiculo.Vehiculo;

public class DocumentoAsociatividad {

    private Vehiculo vehiculo;
    private Conductor conductor;

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public DocumentoAsociatividad(Vehiculo vehiculo, Conductor conductor) {
        this.vehiculo = vehiculo;
        this.conductor = conductor;
    }

    public void mostrarDatosDocumento() {
        System.out.println("Documento");
        System.out.println(getConductor().getNombre());
        System.out.println(getVehiculo().getMarca());
        getConductor().mostrarVehiculo();
        System.out.println(getConductor().getId());
    }
}
