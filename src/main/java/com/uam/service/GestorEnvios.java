package com.uam.service;

import com.uam.interfaces.IAsegurable;
import com.uam.models.Envio;

import java.util.ArrayList;
import java.util.List;

public class GestorEnvios {
    private List<Envio> inventario;

    public GestorEnvios() {
        this.inventario = new ArrayList<>();
    }

    public void agregarEnvio(Envio envio) {
        inventario.add(envio);
        System.out.println("Paquete " + envio.getNumeroGuia() + " ingresado al sistema.");
    }

    public void generarReporteGeneral() {
        System.out.println("\n--- REPORTE DE LOGISTICA ---");
        for (Envio envio : inventario) {
            envio.rastrearUbicacion();
            System.out.println(envio.obtenerEstado());
            System.out.println("Costo Base: $" + envio.calcularCostoDespacho());
            System.out.println("----------------------------");
        }
    }

    public void calcularSeguros(double valorCarga) {
        System.out.println("\n--- PROCESAMIENTO DE POLIZAS DE SEGURO ---");
        for (Envio envio : inventario) {
            if (envio instanceof IAsegurable) {
                IAsegurable asegurado = (IAsegurable) envio;
                double costoPoliza = asegurado.calcularCostoSeguro(valorCarga);
                System.out.println("El envio " + envio.getNumeroGuia() +
                        " califica para seguro. Costo poliza: $" + costoPoliza);
            } else {
                System.out.println("El envio " + envio.getNumeroGuia() +
                        " es terrestre y NO requiere seguro internacional.");
            }
        }
    }
}