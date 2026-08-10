package ru.merion.aqa.ext;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolver;
import ru.merion.aqa.lesson15.XClientsWebClient;

import java.io.IOException;

/**
 * Внедряет токен X-Clients в параметр теста.
 * Переиспользует клиента из store, если он уже создан ClientProvider,
 * чтобы не плодить соединения.
 */
public class TokenProvider implements ParameterResolver {

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
        String login = annotation.login().isBlank() ? TestConfig.LOGIN : annotation.login();
        String pass = annotation.pass().isBlank() ? TestConfig.PASSWORD : annotation.pass();

        XClientsWebClient client = extensionContext.getStore(ExtensionContext.Namespace.GLOBAL)
                .get("x_client", XClientsWebClient.class);
        if (client == null) {
            client = new XClientsWebClient(TestConfig.BASE_URL);
        }

        try {
            return client.getToken(login, pass);
        } catch (IOException e) {
            throw new RuntimeException("Не удалось получить токен: " + e.getMessage(), e);
        }
    }
}