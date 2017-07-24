package com.bankrest7.bankrest7.service;

import com.bankrest7.bankrest7.model.Account;
import com.bankrest7.bankrest7.model.Customer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class BankService {

    private final ArrayList<Customer> customers = new ArrayList<>();

    public void initialiseCustomers() {
        Customer customer1 = new Customer("J", "E", "1111", new Account());
        Customer customer2 = new Customer("H", "K", "2222", new Account());
        Customer customer3 = new Customer("JNA Edmund", "E", "2222", new Account());
        Customer customer4 = new Customer("JN", "E", "3333", new Account());
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
    }

    public void addCustomerToList(Customer customer) {

        if (accountExists(customer.getAccount().getAccountNumber())) {
            customer.getAccount().setAccountNumber(findValidAccountNumber());

        } else {

        }
        customers.add(customer);
    }

    public void depositToCustomerAccount(int accountNumber,int depositAmount) {
        Customer customer=getCustomerByAccountNumber(accountNumber);
        customer.getAccount().deposit(depositAmount);  
    }
    
    public void withdrawFromCustomerAccount(int accountNumber,int depositAmount) {
        Customer customer=getCustomerByAccountNumber(accountNumber);
        customer.getAccount().withdraw(depositAmount);  
    }
    
    Customer getCustomerByAccountNumber(int accountNumber) {
        Customer customer = null;
        for (Customer c : customers) {
            if (c.getAccount().getAccountNumber() == accountNumber) {
                customer = c;
                break;
            }
        }
        return customer;
    }

    private int findValidAccountNumber() {
        int accountNumber = 0;
        do {
            accountNumber = Account.getNextAccountNumber();
        } while (accountExists(accountNumber));
        return accountNumber;
    }

    public boolean accountExists(int accountNumber) {
        for (Customer c : customers) {
            if (c.getAccount().getAccountNumber() == accountNumber) {
                return true;
            }
        }
        return false;
    }

    public Customer getCustomer(int account) {
        return customers.get(account);
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void removeCustomer(Customer customer) {

        customers.remove(customer);
    }

    public static double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.FLOOR);
        return bd.doubleValue();
    }

}
