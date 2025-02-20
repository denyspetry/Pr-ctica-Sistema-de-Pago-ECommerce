package org.example.AppEcommerce;

import java.util.Scanner;
/**
 * Clase PayPal heredada de la Clase MetodoPago
 * Cuenta con un constructor no parametrizado que pregunta y guarda los valores como atributos
 * Getters y Setters de los atributos cuenta y saldo
 * Metodo abstracto procesarPago(double importe)
 * Cuenta con un metodo publico validarPaypal que llama a metodos privados para cada validación
 * @see MetodoPago
 */
public class PayPal extends MetodoPago{
    // Constantes estaticas para definir el formato del correo y el saldo por defecto
    private static final String FORMATO_CORREO = "^[A-Za-z0-9+_.]+@[A-Za-z0-9+_.]+.com$";
    private static final double SALDO_DEF = 23;

    Scanner entrada = new Scanner(System.in);

    // Atributos privados de la propia clase
    private String cuenta;
    private double saldo;

    /**
     * Constructor no parametrizado. Pregunta por los datos (Cuenta de Correo e Importe a Pagar), y posteriormente los valida
     * Se define el saldo de la cuenta por defecto en 23, y se pregunta si se quiere añadir más
     * Se comprueba que el importe a pagar no sobrepase el del saldo disponible
     */
    public PayPal(){
        saldo = SALDO_DEF;
        System.out.println("Introduce la cuenta de correo:");
        cuenta = entrada.nextLine();
        preguntarSaldo();
        System.out.println("Introduce el importe a pagar:");
        Double importe = entrada.nextDouble();
        validarPayPal(cuenta, importe);
    }

    /**
     * Metodo abstracto público heredado de la Clase MetodoPago
     * @param importe el importe que se desea pagar
     */
    public void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + " € con PayPal");
    }

    // Llamamos a procesarPago desde aquí y no desde la Clase Tienda ya que preguntamos en el constructor
    // por el importe para proceder a validarlo de la manera correcta. Con lo cual si está correcto automáticamente
    // se procesa el pago desde el validador

    /**
     * Metodo publico de la propia clase para validar el formato de la cuenta de PayPal y del saldo disponible
     * con respecto al pago que se quiere realizar
     * @param cuenta de correo del cliente
     * @param importe importe que se desea validar
     */
    public void validarPayPal(String cuenta, double importe){
        System.out.println("Validando PayPal...");
        if (cuentaValida(cuenta) && importeValido(importe)){
            this.cuenta = cuenta;
            System.out.println("Datos correctos");
            procesarPago(importe);
        } else {
            System.out.println("Los datos de tu PayPal no son correctos");
        }
    }

    /**
     * Metodo publico para preguntar al usuario si quiere añadir más dinero al saldo de la cuenta
     * Si selecciona que si (S) se le preguntará cuanto dinero quiere añadir y se llama al metodo anyadirDinero()
     * Si selecciona que no (N) o cualquier otra letra el saldo de la cuenta se mantendrá por defecto
     */
    public void preguntarSaldo(){
        System.out.println("Tienes " + saldo + "€ en la cuenta. Quieres añadir dinero?[S/N]:");
        String eleccion = entrada.next().toUpperCase();
        if (eleccion.matches("S")){
            System.out.println("¿Cuánto dinero quieres añadir?");
            double dineroAnyadido = entrada.nextDouble();
            anyadirDinero(dineroAnyadido);
        }
    }

    /**
     * Metodo privado para añadir una cantidad de dinero al saldo de la cuenta
     * @param dineroAnyadido cantidad de dinero a añadir
     */
    private void anyadirDinero(double dineroAnyadido){
        saldo = saldo + dineroAnyadido;
    }

    /**
     * Metodo privado de tipo booleano para comprobar que el importe a pagar no sea superior al saldo disponible
     * @param importe a pagar
     * @return True si el importe a pagar es menor o igual al saldo disponible y False en caso contrario
     */
    private boolean importeValido(Double importe){
        if (saldo >= importe){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo privado de tipo booleano para comprobar que el correo de la cuenta introducido cumpla con el formato correcto
     * @param cuenta email de la cuenta
     * @return True si la cuenta cumple con el formato del correo y False en caso contrario
     */
    private boolean cuentaValida(String cuenta){
        if (cuenta.matches(FORMATO_CORREO)){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Getter de la cuenta
     * @return El nombre de la cuenta (email)
     */
    public String getCuenta() {
        return cuenta;
    }

    /**
     * Setter de la cuenta
     * @param cuenta el nombre de la cuenta (email)
     */
    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * Getter del saldo
     * @return El saldo de la cuenta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Setter del saldo de la cuenta
     * @param saldo de la cuenta
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
