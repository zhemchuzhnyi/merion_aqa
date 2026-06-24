package ru.merion.aqa.ext;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import ru.merion.aqa.lesson15.XClientsWebClient;

public class ClientProvider implements ParameterResolver {

    private static final String BASE_URL = "http://51.250.26.13:8083";

    @Override
    public boolean supportsParameter(ParameterContext parameterContext,
                                     ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType()
                .equals(XClientsWebClient.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext,
                                   ExtensionContext extensionContext) {
        return new XClientsWebClient(BASE_URL);
    }
}
