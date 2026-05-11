package org.pruebatecnica.paymentservice.exception;

public class PaymentAlreadyMadeException extends RuntimeException {
    public PaymentAlreadyMadeException(String message) {
        super(message);
    }
}
