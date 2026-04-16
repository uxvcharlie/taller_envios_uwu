package com.uam.models;

public abstract class Envio {
    // Atributos protected para que las clases hijas tengan acceso directo
    protected int numeroGuia;
    protected double pesoKg;

    // Constructor
    public Envio(int numeroGuia, double pesoKg) {
        this.numeroGuia = numeroGuia;
        this.pesoKg = pesoKg;
    }

    // Método Abstracto: Obliga a cada transporte a definir su propia logística
    public abstract void procesarDespacho();

    // Método Concreto (DRY): Reutilizamos la lógica de impresión para todos
    public void generarEtiquetaSeguridad() {
        System.out.println("=====================================");
        System.out.println("[ETIQUETA] GUÍA #: " + numeroGuia);
        System.out.println("[ETIQUETA] PESO  : " + pesoKg + " Kg");
        System.out.println("=====================================");
    }
}