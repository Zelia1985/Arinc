/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rws;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 */

@Path("dir")
public class DirResource  {

    @Context
    private UriInfo context;   

    public DirResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public ReturnData getXml() throws IOException {
        return new ReturnData();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
        public void putXml(String content) {
   }
   
}
