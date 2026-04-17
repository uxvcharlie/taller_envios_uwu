package com.uam.models;

import com.uam.interfaces.IAsegurable;

public class EnvioAereo extends Envio implements IAsegurable {
    private double pesoKg;

    public EnvioAereo(String numeroGuia, Cliente cliente, double pesoKg) {
        super(numeroGuia, cliente);
        this.pesoKg = pesoKg;
    }

    @Override
    public void procesarDespacho() {
        System.out.println("Procesando despacho aereo...");
        this.estadoActual = "En proceso de carga en aeropuerto";
    }

    @Override
    public double calcularCostoDespacho() {
        return pesoKg * 50.0;
    }

    @Override
    public void rastrearUbicacion() {
        System.out.println("Rastreando vuelo por radar...");
        this.estadoActual = "En vuelo internacional";
    }

    @Override
    public double calcularCostoSeguro(double valorCarga) {
        return valorCarga * 0.10;
    }
}