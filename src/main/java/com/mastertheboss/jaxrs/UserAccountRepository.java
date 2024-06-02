package com.mastertheboss.jaxrs;


import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;


@ApplicationScoped
public class UserAccountRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<UserAccount> findAll() {
        return entityManager.createNamedQuery("UserAccounts.findAll", UserAccount.class)
                .getResultList();
    }

    public UserAccount findUserAccountById(Long id) {

        UserAccount userAccount = entityManager.find(UserAccount.class, id);

        if (userAccount == null) {
            throw new WebApplicationException("User with id of " + id + " does not exist.", 404);
        }
        return userAccount;
    }
    @Transactional
    public void updateUserAccount(UserAccount userAccount) {

        UserAccount userAccountToUpdate = findUserAccountById(userAccount.getId());
        userAccountToUpdate.setUsername(userAccount.getUsername());
    }
    @Transactional
    public void createUserAccount(UserAccount userAccount) {

        entityManager.persist(userAccount);

    }
    @Transactional
    public void deleteUserAccount(Long userAccountId) {

        UserAccount c = findUserAccountById(userAccountId);
        entityManager.remove(c);
    }


}
