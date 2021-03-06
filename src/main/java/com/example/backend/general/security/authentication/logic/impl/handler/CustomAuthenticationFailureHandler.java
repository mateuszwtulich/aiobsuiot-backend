package com.example.backend.general.security.authentication.logic.impl.handler;

import org.springframework.context.MessageSource;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

  @Named("messageSource")
  @Inject
  private MessageSource messages;

  private LocaleResolver localeResolver;

  @Override
  public void onAuthenticationFailure(HttpServletRequest request,
                                      HttpServletResponse response, AuthenticationException exception)
      throws IOException, ServletException {

    super.onAuthenticationFailure(request, response, exception);

    Locale locale = localeResolver.resolveLocale(request);

    String errorMessage = messages.getMessage("message.badCredentials", null, locale);

    if (exception.getMessage().equalsIgnoreCase("User is disabled")) {
      errorMessage = messages.getMessage("auth.message.disabled", null, locale);
    } else if (exception.getMessage().equalsIgnoreCase("User account has expired")) {
      errorMessage = messages.getMessage("auth.message.expired", null, locale);
    }

    request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, errorMessage);
  }
}
