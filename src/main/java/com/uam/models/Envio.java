package com.uam.models;

import com.uam.interfaces.IRastreable;

public abstract class Envio implements IRastreable {
    protected String numeroGuia;
    protected Cliente cliente;
    protected String estadoActual;

    public Envio(String numeroGuia, Cliente cliente) {
        this.numeroGuia = numeroGuia;
        this.cliente = cliente;
        this.estadoActual = "En Bodega Central";
    }

    public String getNumeroGuia() { return numeroGuia; }

    public Cliente getCliente() { return cliente; }

    public abstract void procesarDespacho();

    public abstract double calcularCostoDespacho();

    @Override
    public String obtenerEstado() {
        return "Guia: " + numeroGuia + " | Cliente: " + cliente.getNombre() + " | Estado: " + estadoActual;
    }
}