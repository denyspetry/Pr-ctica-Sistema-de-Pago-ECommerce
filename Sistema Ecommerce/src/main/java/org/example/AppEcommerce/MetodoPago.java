package org.example.AppEcommerce;

/**
 * Clase abstracta MetodoPago con únicamente un metodo abstracto procesarPago
 * @see Bizum Clase que hereda de esta
 * @see PayPal Clase que hereda de esta
 * @see TarjetaCredito Clase que hereda de esta
 */
public abstract class MetodoPago {
    /**
     * Matodo abstracto para procesar el pago en función del tipo de Metodo de Pago escogido
     * @param importe a procesar
     */
    public abstract void procesarPago(double importe);
}
