package com.uam;

import com.uam.models.Cliente;
import com.uam.models.EnvioAereo;
import com.uam.models.EnvioMaritimo;
import com.uam.models.EnvioTerrestre;
import com.uam.service.GestorEnvios;

public class Main {
    public static void main(String[] args) {
        Cliente cli1 = new Cliente("Erving Miranda", "erving@email.com");
        Cliente cli2 = new Cliente("Carlos Dev", "carlos@email.com");

        GestorEnvios gestor = new GestorEnvios();

        EnvioTerrestre paqueteLocal = new EnvioTerrestre("TER-001", cli1, 50.0);
        EnvioAereo paqueteExpress = new EnvioAereo("AER-002", cli2, 10.0);
        EnvioMaritimo cargamento = new EnvioMaritimo("MAR-003", cli1, 2);

        gestor.agregarEnvio(paqueteLocal);
        gestor.agregarEnvio(paqueteExpress);
        gestor.agregarEnvio(cargamento);

        gestor.generarReporteGeneral();

        gestor.calcularSeguros(1000.0);
    }
}