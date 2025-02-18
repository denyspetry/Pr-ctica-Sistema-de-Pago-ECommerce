package org.example;

import java.util.Scanner;

public class TarjetaCredito extends MetodoPago{

    Scanner entrada = new Scanner(System.in);
    private String nro_tarjeta;
    private String tipo;

    public TarjetaCredito(String nro_tarjeta, String tipo){
        this.nro_tarjeta = nro_tarjeta;
        this.tipo = tipo;
    }

    public TarjetaCredito(){
        System.out.println("Introduce los datos de tu tarjeta:");
        System.out.println("Número (16 dígitos):");
        nro_tarjeta = entrada.nextLine();
        System.out.println("Tipo (VISA o MASTERCARD):");
        tipo = entrada.nextLine().toUpperCase();
    }


    public void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + " € con tarjeta de crédito " + tipo);
    }

    public void validarTajeta(String numero, String tipo){
        System.out.println("Validando tarjeta...");
        if (numero.matches("\\d{16}") && (tipo.matches("VISA") || tipo.matches("MASTERCARD"))){
            
        }
    }
}
