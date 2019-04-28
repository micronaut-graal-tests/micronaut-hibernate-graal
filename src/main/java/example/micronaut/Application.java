package example.micronaut;

import io.micronaut.core.annotation.TypeHint;
import io.micronaut.runtime.Micronaut;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.dialect.PostgreSQL95Dialect;
import org.hibernate.id.IdentityGenerator;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.hibernate.tuple.entity.EntityMetamodel;
import org.hibernate.tuple.entity.PojoEntityTuplizer;
import org.springframework.orm.hibernate5.SpringSessionContext;

@TypeHint({
    ImplicitNamingStrategyJpaCompliantImpl.class,
    PostgreSQL95Dialect.class,
    IdentityGenerator.class,
    SingleTableEntityPersister.class,
    EntityMetamodel.class,
    PojoEntityTuplizer.class,
    SpringSessionContext.class
})
public class Application {

    public static void main(String[] args) {
        Micronaut.run(Application.class);
    }
}