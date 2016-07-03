package com.java.platzi.anahisalgado.conductor;

import com.java.platzi.anahisalgado.vehiculo.Bus;

public class ChoferAutobus extends com.java.platzi.anahisalgado.conductor.Conductor {

    private Bus bus;

    public ChoferAutobus(String nombre, String tipoLicencia, Bus bus) {
        super(nombre, tipoLicencia);
        this.bus = bus;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
