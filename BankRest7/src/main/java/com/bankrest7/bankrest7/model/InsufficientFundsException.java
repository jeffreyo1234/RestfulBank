package com.bankrest6.model;

/**
 *
 * @author Jeffrey Odametey
 */
class InsufficientFundsException extends Exception {

    public InsufficientFundsException() {
        super("You have insufficient funds to complete the transaction.");
    }
    
}