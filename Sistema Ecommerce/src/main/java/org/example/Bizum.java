package org.example;

import java.util.Random;

public class Bizum extends MetodoPago{
    Random random = new Random();

    private String telefono;
    private int pin;



    public void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + " € con Bizum");
    }

    private void validarBizum(){

    }
}
