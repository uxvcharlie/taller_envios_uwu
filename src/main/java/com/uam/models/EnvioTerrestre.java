package com.uam.models;

public class EnvioTerrestre extends Envio {
    private double distanciaKm;

    public EnvioTerrestre(String numeroGuia, Cliente cliente, double distanciaKm) {
        super(numeroGuia, cliente);
        this.distanciaKm = distanciaKm;
    }

    @Override
    public void procesarDespacho() {
        System.out.println("Iniciando ruta terrestre...");
        this.estadoActual = "En transito por carretera";
    }

    @Override
    public double calcularCostoDespacho() {
        return distanciaKm * 1.5;
    }

    @Override
    public void rastrearUbicacion() {
        System.out.println("Rastreando camion por GPS...");
        this.estadoActual = "En carretera";
    }
}