/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entity.Scribespecializaiton;
import entity.ScribespecializaitonPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Marie
 */
@Stateless
@Path("entity.scribespecializaiton")
public class ScribespecializaitonFacadeREST extends AbstractFacade<Scribespecializaiton> {

    @PersistenceContext(unitName = "ScribeManagementPU")
    private EntityManager em;

    private ScribespecializaitonPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;specializationId=specializationIdValue;scribeId=scribeIdValue;locationId=locationIdValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        entity.ScribespecializaitonPK key = new entity.ScribespecializaitonPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> specializationId = map.get("specializationId");
        if (specializationId != null && !specializationId.isEmpty()) {
            key.setSpecializationId(new java.lang.Integer(specializationId.get(0)));
        }
        java.util.List<String> scribeId = map.get("scribeId");
        if (scribeId != null && !scribeId.isEmpty()) {
            key.setScribeId(new java.lang.Integer(scribeId.get(0)));
        }
        java.util.List<String> locationId = map.get("locationId");
        if (locationId != null && !locationId.isEmpty()) {
            key.setLocationId(new java.lang.Integer(locationId.get(0)));
        }
        return key;
    }

    public ScribespecializaitonFacadeREST() {
        super(Scribespecializaiton.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Scribespecializaiton entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Scribespecializaiton entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        entity.ScribespecializaitonPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Scribespecializaiton find(@PathParam("id") PathSegment id) {
        entity.ScribespecializaitonPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Scribespecializaiton> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Scribespecializaiton> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
