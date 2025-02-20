package org.example.AppEcommerce;

import java.util.Scanner;
/**
 * Clase TarjetaCredito heredada de la Clase MetodoPago
 * Cuenta con un constructor no parametrizado que pregunta y guarda los valores como atributos
 * Getters y Setters de los atributos nro_tarjeta y tipo
 * Metodo abstracto procesarPago(double importe)
 * Cuenta con un metodo publico validarTarjeta que llama a metodos privados para cada validación
 * @see MetodoPago
 */
public class TarjetaCredito extends MetodoPago{
    // Constantes estaticas para el Tipo de Tarjeta y para el Formato de la Tarjeta
    private static final String[] TIPOS_DEF = {"VISA","MASTERCARD","MAESTRO"};
    private static final String FORMATO_NUMERO_TARJETA = "\\d{16}";

    Scanner entrada = new Scanner(System.in);

    // Atributos privados de la clase
    private String nro_tarjeta;
    private String tipo;

    /**
     * Constructor no parametrizado. Pregunta por los datos de la tarjeta, y posteriormente los valida
     */
    public TarjetaCredito(){
        System.out.println("Introduce los datos de tu tarjeta:");
        System.out.println("Número (16 dígitos):");
        nro_tarjeta = entrada.nextLine();
        System.out.println("Tipo (VISA, MASTERCARD o MAESTRO):");
        tipo = entrada.nextLine().toUpperCase();
        validarTajeta(nro_tarjeta,tipo);
    }

    /**
     * Metodo abstracto público heredado de la Clase MetodoPago
     * @param importe el importe que se desea pagar
     */
    public void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + " € con tarjeta de crédito " + tipo);
    }

    /**
     * Metodo publico de la propia clase para validar el formato de la tarjeta (Tipo y Numero)
     * @param numero el numero de la tarjeta tomado como parámetro en el constructor
     * @param tipo el tipo de la tarjeta tomado como parámetro en el constructor
     */
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

    /**
     * Metodo privado para validar el numero de la tarjeta introducido en el constructor
     * @param numero numero de la tarjeta introducido en el constructor
     * @return devuelve True si el formato del numero de la tarjeta es correcto, y False si no lo es
     */
    private boolean numeroValido(String numero){
        if (numero.matches(FORMATO_NUMERO_TARJETA)){
            return true;
        } else{
            return false;
        }
    }

    /**
     * Metodo privado para validar el tipo (VISA, MASTERCARD, MAESTRO) de la tarjeta introducido en el constructor
     * @param tipo el tipo (VISA, MASTERCARD, MAESTRO) de la tarjeta introducido en el constructor
     * @return devuelve True si el formato del tipo de la tarjeta es correcto, y False si no lo es
     */
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

    /**
     * Getter del tipo de la tarjeta
     * @return El tipo de la tarjeta
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Setter del tipo de la tarjeta
     * @param tipo de la tarjeta
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Getter del número de la tarjeta
     * @return El número de la tarjeta
     */
    public String getNro_tarjeta() {
        return nro_tarjeta;
    }

    /**
     * Setter del número de la tarjeta
     * @param nro_tarjeta = número de la tarjeta
     */
    public void setNro_tarjeta(String nro_tarjeta) {
        this.nro_tarjeta = nro_tarjeta;
    }
}
