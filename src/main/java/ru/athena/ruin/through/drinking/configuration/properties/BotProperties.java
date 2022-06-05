package ru.athena.ruin.through.drinking.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "telegrambot", ignoreUnknownFields = false)
public class BotProperties {

    @NotBlank
    private String botToken;

    @NotBlank
    private String botName;

    @NotBlank
    private String botWebhookPath;
}
