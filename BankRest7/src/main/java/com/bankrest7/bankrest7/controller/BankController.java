package com.bankrest7.bankrest7.controller;

import com.bankrest7.bankrest7.model.Customer;
import com.bankrest7.bankrest7.service.BankService;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/bank")
public class BankController {

    BankService bankService = new BankService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String sayhello(){

        return "hello";
    }
    
    @Path("/addCustomer")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void addCustomer(Customer customer){
        bankService.addCustomerToList(customer);
    }
    
    @Path("/addToCustomerAccount")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void deposit(@PathParam("accountNumber") int accountNumber,@PathParam("amount") int amount){
        bankService.depositToCustomerAccount(accountNumber, amount);
    }
    
    @Path("/withdrawFromCustomerAccount")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public void withdraw(@PathParam("accountNumber") int accountNumber,@PathParam("amount") int amount){
        bankService.withdrawFromCustomerAccount(accountNumber, amount);
    }
    
    @Path("/getCustomers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Customer> getAllCustomer(Customer customer){
        return bankService.getCustomers();
    } 
    
    @Path("/getSpecificCustomer")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getSpecificCustomer(Customer customer,int id){
        return bankService.getCustomer(id);
    }    
    
    @Path("/removeCustomer")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void removeCustomer(Customer customer,@PathParam("accountNumber") int accountNumber) {       
      if(bankService.accountExists(accountNumber)){
      bankService.removeCustomer(customer);    
      }  
   }   
}
