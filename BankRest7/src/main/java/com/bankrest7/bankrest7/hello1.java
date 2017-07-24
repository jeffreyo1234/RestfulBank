/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bankrest7.bankrest7;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jeffr
 */
@XmlRootElement
@Path("/abcd")
public class hello1 {
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getIt22() {
        return "Got it! hello1234";
    }
}
