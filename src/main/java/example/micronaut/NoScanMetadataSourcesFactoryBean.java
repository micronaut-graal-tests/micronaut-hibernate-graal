package example.micronaut;

import io.micronaut.configuration.hibernate.jpa.EntityManagerFactoryBean;
import io.micronaut.configuration.hibernate.jpa.JpaConfiguration;
import io.micronaut.context.annotation.EachBean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Parameter;
import io.micronaut.context.annotation.Replaces;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;

@Factory
public class NoScanMetadataSourcesFactoryBean {

    @EachBean(StandardServiceRegistry.class)
    @Replaces(value = MetadataSources.class, factory = EntityManagerFactoryBean.class)
    protected MetadataSources hibernateMetadataSources(
        @Parameter JpaConfiguration jpaConfiguration,
        StandardServiceRegistry standardServiceRegistry) {

        // It seems we can't scan @Entity with native-image
        MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
        metadataSources.addAnnotatedClass(User.class);
        return metadataSources;
    }
}
