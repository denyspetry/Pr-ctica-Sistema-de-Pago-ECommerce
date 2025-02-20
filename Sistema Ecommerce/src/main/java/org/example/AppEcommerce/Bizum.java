package org.example.AppEcommerce;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase Bizum heredada de la Clase MetodoPago
 * Cuenta con un constructor no parametrizado que pregunta y guarda los valores como atributos
 * Getters y Setters de los atributos telefono y pin
 * Metodo abstracto procesarPago(double importe)
 * Cuenta con un metodo publico validarBizum que llama a metodos privados para cada validación
 * @see MetodoPago
 */
public class Bizum extends MetodoPago{
    // Constante estática de tipo String para el formato del telefono
    private static final String FORMATO_TELEFONO = "\\d{9}";

    Random random = new Random();
    Scanner entrada = new Scanner(System.in);

    // Atributos de la Clase Bizum
    private String telefono;
    private int pin;

    /**
     * Constructor no parametrizado. Pregunta por los datos (Numero de Teléfono y PIN), y posteriormente los valida
     */
    public Bizum(){
        System.out.println("Introduce tu número de teléfono:");
        telefono = entrada.nextLine();
        pin = generarPin();
        System.out.println("Tu PIN es: " + pin);
        System.out.println("Introduce el PIN: ");
        int pinUsuario = entrada.nextInt();
        validarBizum(telefono, pinUsuario);
    }

    /**
     * Metodo abstracto público heredado de la Clase MetodoPago
     * @param importe el importe que se desea pagar
     */
    public void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + " € con Bizum");
    }

    /**
     * Metodo publico de la propia clase para validar el formato de la cuenta Bizum (Telefono y Pin)
     * @param telefono el numero de telefono tomado como parámetro en el constructor
     * @param pinUsuario el pin que ha introducido el usuario tomado como parámetro en el constructor
     */
    public void validarBizum(String telefono, int pinUsuario){
        System.out.println("Validando Bizum...");
        if (telefonoValido(telefono) && pinValido(pinUsuario)){
            this.telefono = telefono;
            pin = pinUsuario;
            System.out.println("Datos correctos");
        } else {
            System.out.println("Los datos de tu Bizum no son correctos");
        }
    }

    /**
     * Metodo privado de tipo boolean para validar el  formato del telefono
     * @param telefono el telefono que introduce el usuario
     * @return True si coincide el formato del telefono y False en caso contrario
     */
    private boolean telefonoValido(String telefono){
        if (telefono.matches(FORMATO_TELEFONO)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo privado de tipo boolean para validar el pin de la cuenta Bizum
     * @param pinUsuario el Pin que introduce el usuario
     * @return True si coincide el pin del usuario con el pin de la cuenta y False en caso contrario
     */
    private boolean pinValido(int pinUsuario){
        if (pinUsuario == pin){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo privado para generar el pin de la cuenta de Bizum
     * @return Un valor aleatorio entre 100000 y 999999
     */
    private int generarPin(){
        return random.nextInt(100000,1000000);
    }

    /**
     * Getter del pin de la cuenta de Bizum
     * @return El pin de la cuenta de Bizum
     */
    public int getPin() {
        return pin;
    }

    /**
     * Setter del pin de la cuenta de Bizum
     * @param pin de la cuenta de Bizum
     */
    public void setPin(int pin) {
        this.pin = pin;
    }

    /**
     * Getter del telefono de la cuenta de Bizum
     * @return El telefono de la cuenta de Bizum
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Setter del telefono de la cuenta de Bizum
     * @param telefono de la cuenta de Bizum
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


}
