package ru.merion.aqa.lesson23.ext;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.spi.PersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import ru.merion.aqa.lesson23.db.CompanyRepository;
import ru.merion.aqa.lesson23.db.jpa.CompanyRepositoryJpa;
import ru.merion.aqa.lesson23.db.jpa.MyPersistenceUnitInfo;

import java.util.Properties;

public class JpaRepositoryResolver implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(CompanyRepository.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {

        Properties properties = new Properties();
        properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.put("hibernate.connection.url", System.getProperty("db.url", ""));
        properties.put("hibernate.connection.username", System.getProperty("db.username", ""));
        properties.put("hibernate.connection.password", System.getProperty("db.password", ""));
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.connection.autocommit", "true");

        PersistenceUnitInfo info = new MyPersistenceUnitInfo(properties);
        HibernatePersistenceProvider hibernatePersistenceProvider = new HibernatePersistenceProvider();
        EntityManagerFactory factory = hibernatePersistenceProvider.createContainerEntityManagerFactory(info, info.getProperties());
        EntityManager entityManager = factory.createEntityManager();

        return new CompanyRepositoryJpa(entityManager);

    }
}
