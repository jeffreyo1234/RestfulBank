package com.bankrest7.bankrest7.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Jeffrey Odametey
 */
public class Customer  implements Serializable{

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        return Objects.equals(this.idNumber, other.idNumber);
    }
    private final String firstName;
    private final String lastName;
    private final String idNumber;
    private final Account account;

    public Customer(String firstName, String lastName, String ssn, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = ssn;
        this.account = account;
    }
    
    @Override
    public String toString(){
        return "\nCustomer Information\n" +
                "First Name: " + getFirstName() + "\n" + 
                "Last Name: " + getLastName() +  "\n" + 
                "id: " + getIdNumber() +  "\n" + 
                account.toString()  ;
    }
    
    public String basicInfo(){
        return " Account Number: " + account.getAccountNumber() + " - Name: " + getFirstName() + " " + getLastName();
    }
    
    public Account getAccount(){
        return account;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the idNumber
     */
    public String getIdNumber() {
        return idNumber;
    }
    
}