package com.uam;

import com.uam.models.EnvioAereo;
import com.uam.models.EnvioTerrestre;
import com.uam.service.CentroDistribucion;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // 1. Instanciamos nuestro servicio (El Centro de Distribución)
        CentroDistribucion centro = new CentroDistribucion();

        // 2. Creamos un par de envíos usando polimorfismo
        // Fíjate que instanciamos clases hijas
        EnvioTerrestre paquete1 = new EnvioTerrestre(1001, 45.5, "MT-5050", "Carlos Perez");
        EnvioAereo paquete2 = new EnvioAereo(2005, 12.0, "Copa Airlines", 405);
        centro.despacharPaquete(paquete1);
        centro.despacharPaquete(paquete2);
    }
}
