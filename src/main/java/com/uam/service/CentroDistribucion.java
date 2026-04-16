package com.uam.service;

import com.uam.models.Envio;

public class CentroDistribucion {

    public void despacharPaquete(Envio envio) {
        System.out.println("---NUEVO PAQUETE RECIBIDO EN CENTRO DE DISTRIBUCIÓN---");
        // En tiempo de ejecución (Run-time), Java decidirá si es terrestre o aéreo.
        envio.procesarDespacho();
    }
}
