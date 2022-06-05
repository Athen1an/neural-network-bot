package ru.athena.ruin.through.drinking.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import ru.athena.ruin.through.drinking.bot.RuinThroughDrinkingBot;
import ru.athena.ruin.through.drinking.configuration.properties.BotProperties;

@Configuration
public class BotConfiguration {

    @Bean
    public SetWebhook setWebhook(BotProperties botProperties) {
        return SetWebhook.builder().url(botProperties.getBotWebhookPath()).build();
    }

    @Bean
    public RuinThroughDrinkingBot ruinThroughDrinkingBot(SetWebhook setWebhook, BotProperties botProperties) {
        return new RuinThroughDrinkingBot(setWebhook, botProperties);
    }
}
