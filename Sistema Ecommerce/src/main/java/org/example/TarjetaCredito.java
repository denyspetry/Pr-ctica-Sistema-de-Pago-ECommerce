package org.example;

import java.util.Scanner;

public class TarjetaCredito extends MetodoPago{

    private static final String[] TIPOS_DEF = {"VISA","MASTERCARD","MAESTRO"};

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
        System.out.println("Tipo (VISA, MASTERCARD o MAESTRO):");
        tipo = entrada.nextLine().toUpperCase();
        validarTajeta(nro_tarjeta,tipo);
    }


    public void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + " € con tarjeta de crédito " + tipo);
    }

    public void validarTajeta(String numero, String tipo){

        System.out.println("Validando tarjeta...");

        if (numeroValido(numero) && tipoValido(tipo)){
            nro_tarjeta = numero;
            this.tipo = tipo;
            System.out.println("Datos correctos");
        } else {
            System.out.println("Los datos de tu tarjeta no son correctos");
        }
    }

    private boolean numeroValido(String numero){
        if (numero.matches("\\d{16}")){
            return true;
        } else{
            return false;
        }
    }

    private boolean tipoValido(String tipo){
        boolean tipovalido = false;
        for (int i = 0; i < TIPOS_DEF.length; i++){
            if (TIPOS_DEF[i].equals(tipo)){
                tipovalido = true;
                break;
            }
        }
        return tipovalido;
    }
}
