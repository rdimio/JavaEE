package ru.geekbrains.services.interfaces;

import ru.geekbrains.entity.Product;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/v1/product")
public interface RestIntService {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    List<Product> findAll();

    @GET
    @Path("/{id}/id")
    @Produces(MediaType.APPLICATION_JSON)
    Product findById(@PathParam("id") long id);

    @PUT
    @Path("/new")
    @Consumes(MediaType.APPLICATION_JSON)
    void insert(Product product);

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    void update(Product product);

    @DELETE
    @Path("/{id}/id")
    void delete(@PathParam("id") long id);
}
