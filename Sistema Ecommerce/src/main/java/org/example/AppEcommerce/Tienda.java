package org.example.AppEcommerce;

import java.util.Scanner;

/**
 * Clase Tienda con atributos y métodos estáticos
 * Consta de un metodo público estático para seleccionar el metodo de pago
 * Consta de un metodo público estático para realizar el pago
 * Consta de un metodo privado estático para seleccionar el importe que deseamos pagar
 * @see MetodoPago
 */
public class Tienda {

    // Atributos privados y estáticos de la Clase Tienda
    private static Scanner entrada = new Scanner(System.in);
    private static MetodoPago metodo;
    private static double importe;

    /**
     * Metodo publico estático de la clase Tienda. Llama al metodo procesarPago en funcion del metodo de pago
     * y del importe a procesar
     * @param metodo puede ser Bizum, Tarjeta o PayPal
     * @param importe cantidad a procesar
     */
    public static void realizarPago(MetodoPago metodo, double importe){
        metodo.procesarPago(importe);
    }

    /**
     * Metodo público estático de la Clase Tienda que se encarga de Preguntar al usuario qué metodo de pago
     * quiere utilizar, y en función del metodo que eliga llamar a cada respectivo metodo de pago
     */
    public static void iniciarPago(){
        System.out.println("¿Qué método de pago quieres usar? [Bizum, PayPal, Tarjeta]:");
        String metodoEscogido = entrada.nextLine().toUpperCase();
        switch (metodoEscogido){
            case "BIZUM":
                metodo = new Bizum();
                introducirImporte();
                break;
            case "PAYPAL":
                metodo = new PayPal();
                break;
            case "TARJETA":
                metodo = new TarjetaCredito();
                introducirImporte();
                break;
            default:
                System.out.println("La opción que has escogido no es válida");
                return;
        }
    }

    /**
     * Metodo público estático de la Clase Tienda que se encarga de preguntar por el importe a pagar.
     * Es llamado desde el metodo IniciarPago() de esta misma Clase y se encarga de llamar a su vez al metodo
     * realizarPago() de esta misma clase
     */
    private static void introducirImporte(){
        System.out.println("Introduce el importe a pagar");
        importe = entrada.nextDouble();
        realizarPago(metodo, importe);
    }
}
