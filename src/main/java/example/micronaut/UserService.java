package example.micronaut;

import io.micronaut.configuration.hibernate.jpa.scope.CurrentSession;
import io.micronaut.spring.tx.annotation.Transactional;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.Optional;

@Singleton
public class UserService {

    @PersistenceContext
    private final EntityManager entityManager;

    public UserService(@CurrentSession EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public User save(@Valid User user) {
        entityManager.persist(user);
        return user;
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

}
