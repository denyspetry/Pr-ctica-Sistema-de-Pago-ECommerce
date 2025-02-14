package org.example;

public class PayPal extends MetodoPago{
    private static final double SALDO_DEF = 23;

    private String cuenta;
    private double saldo;

    public PayPal(){
        saldo = SALDO_DEF;
    }

    public PayPal(String cuenta, double saldo){
        this.cuenta = cuenta;
        this.saldo = saldo;
    }

    public void procesarPago(double importe) {
        System.out.println("Procesando pago de " + importe + " € con PayPal");
    }

    private void validarPayPal(){}
}
