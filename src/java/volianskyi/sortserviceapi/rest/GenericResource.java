/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package volianskyi.sortserviceapi.rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;
import volianskyi.sortserviceapi.service.SortServiceHelper;

/**
 * REST Web Service
 *
 * @author tarasvolianskyi
 */
@Path("/{json_array}")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of
     * volianskyi.sortserviceapi.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@PathParam("json_array") String jsonArrayString) {
        System.out.println("Incoming request - " + jsonArrayString);
        SortServiceHelper sortServiceHelper = new SortServiceHelper();
        JSONObject result = sortServiceHelper.startService(jsonArrayString);
        System.out.println("Prepared result - " + result);
        return "" + result;
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }

}
