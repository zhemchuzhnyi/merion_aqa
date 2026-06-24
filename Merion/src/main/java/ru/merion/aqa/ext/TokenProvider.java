package ru.merion.aqa.ext;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import ru.merion.aqa.lesson15.XClientsWebClient;

import java.io.IOException;

public class TokenProvider implements ParameterResolver {

    private static final String BASE_URL = "http://51.250.26.13:8083";

    @Override
    public boolean supportsParameter(ParameterContext parameterContext,
                                     ExtensionContext extensionContext) {
        return parameterContext.getParameter().getType().equals(String.class)
                && parameterContext.getParameter().isAnnotationPresent(Token.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext,
                                   ExtensionContext extensionContext) {
        Token annotation = parameterContext.getParameter().getAnnotation(Token.class);
        try {
            return new XClientsWebClient(BASE_URL).getToken(annotation.login(), annotation.pass());
        } catch (IOException e) {
            throw new RuntimeException("Не удалось получить токен: " + e.getMessage(), e);
        }
    }
}
