package com.ana.PrivateInsurancePortfolio.repositories;

import com.ana.PrivateInsurancePortfolio.exceptions.InsAuthException;
import com.ana.PrivateInsurancePortfolio.model.SystemUser;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class UserRepositoryImpl extends ORMRepository implements CustomSystemUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createSystemUser(SystemUser user) {
        session().save(user);
    }

    @Override
    public Optional<SystemUser> findByLoginAndPassword(String login,
                                                       String password) {
        String query = "from system_user where login = :login and password = :password";
        SystemUser systemUser = (SystemUser) session().createQuery(query)
                .setParameter("login", login)
                .setParameter("password", password)
                .uniqueResult();
        return Optional.ofNullable(systemUser);
    }

    @Override
    public Integer getCountbyLogin(String login) {
        return null;
    }
}
