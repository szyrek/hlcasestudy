package com.mastertheboss.jaxrs;

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
    public List<UserAccount> getAll() {
        return userAccountRepository.findAll();
    }

    @GET
    public UserAccount get(Long id) {
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
    public Response delete(@QueryParam("id") Long id) {
        userAccountRepository.deleteUserAccount(id);
        return Response.status(204).build();
    }

}