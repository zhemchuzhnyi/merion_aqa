package ru.merion.aqa.lesson22;

import org.junit.jupiter.api.extension.*;

public class JdbcRepositoryResolver implements ParameterResolver, AfterAllCallback {
    private CompanyRepository repository;
    public static final String CONNECTION_STRING = System.getProperty("db.url", "");
    public static final String USERNAME = "x_clients_user";
    public static final String PASSWORD = System.getProperty("db.password", "");

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(CompanyRepository.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        if (repository == null) {
            repository = new CompanyRepositoryJdbc(CONNECTION_STRING, USERNAME, PASSWORD);
        }
        return repository;
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        repository.closeConnection();
    }
}
