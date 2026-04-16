package com.uam.models;

public class EnvioTerrestre extends Envio {
    private String placaCamion;
    private String nombreChofer;

    // Constructor que recibe los datos y manda al padre la guía y el peso
    public EnvioTerrestre(int numeroGuia, double pesoKg, String placaCamion, String nombreChofer) {
        super(numeroGuia, pesoKg);
        this.placaCamion = placaCamion;
        this.nombreChofer = nombreChofer;
    }

    // Sobreescritura obligatoria del método abstracto
    @Override
    public void procesarDespacho() {
        generarEtiquetaSeguridad(); // Llamamos al método compartido del padre
        System.out.println("Iniciando ruta terrestre...");
        System.out.println("Camión asignado: " + placaCamion + " | Chofer: " + nombreChofer);
        System.out.println("Estado: En tránsito por carretera.\n");
    }
}