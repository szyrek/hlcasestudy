package edu.szyrek.hlcase.rest;

import edu.szyrek.hlcase.dao.UserAccountRepository;
import edu.szyrek.hlcase.model.UserAccount;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import java.util.List;


@Path("useraccounts")
@ApplicationScoped
@Produces("application/json")
@Consumes("application/json")
public class UserAccountEndpoint {

    @Inject
    UserAccountRepository userAccountRepository;

    @GET
    public List<UserAccount> getAll(
            @QueryParam("pageSize") Integer pageSize,
            @QueryParam("page") Integer page
            ){
        if (page != null && pageSize != null) {
            return userAccountRepository.findAll(pageSize, page);
        }
        return userAccountRepository.findAll();
    }

    @GET
    @Path("/{id}")
    public UserAccount get(@PathParam("id") Long id) {
        return userAccountRepository.findUserAccountById(id);
    }

    @POST
    public Response create(UserAccount userAccount) {
        userAccountRepository.createUserAccount(userAccount);
        return Response.status(201).build();
    }

    @PUT
    public Response update(UserAccount userAccount) {
        userAccountRepository.updateUserAccount(userAccount);
        return Response.status(204).build();
    }
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        userAccountRepository.deleteUserAccount(id);
        return Response.status(204).build();
    }

}