package com.uam.models;

import com.uam.interfaces.IAsegurable;

public class EnvioMaritimo extends Envio implements IAsegurable {
    private int numeroContenedores;

    public EnvioMaritimo(String numeroGuia, Cliente cliente, int numeroContenedores) {
        super(numeroGuia, cliente);
        this.numeroContenedores = numeroContenedores;
    }

    @Override
    public void procesarDespacho() {
        System.out.println("Procesando despacho maritimo...");
        this.estadoActual = "En proceso de carga en puerto";
    }

    @Override
    public double calcularCostoDespacho() {
        return numeroContenedores * 500.0;
    }

    @Override
    public void rastrearUbicacion() {
        System.out.println("Rastreando buque por satelite maritimo...");
        this.estadoActual = "En aguas internacionales";
    }

    @Override
    public double calcularCostoSeguro(double valorCarga) {
        return valorCarga * 0.05;
    }
}