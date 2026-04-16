package com.uam.models;

public class EnvioAereo extends Envio {
    private String aerolinea;
    private int numeroVuelo;

    public EnvioAereo(int numeroGuia, double pesoKg, String aerolinea, int numeroVuelo) {
        super(numeroGuia, pesoKg);
        this.aerolinea = aerolinea;
        this.numeroVuelo = numeroVuelo;
    }

    @Override
    public void procesarDespacho() {
        generarEtiquetaSeguridad();
        System.out.println("Iniciando ruta aérea...");
        System.out.println("Aerolínea: " + aerolinea + " | Vuelo #: " + numeroVuelo);
        System.out.println("Estado: En aduana aeroportuaria.\n");
    }
}
