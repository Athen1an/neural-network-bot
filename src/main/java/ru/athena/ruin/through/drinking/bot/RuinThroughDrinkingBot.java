package ru.athena.ruin.through.drinking.bot;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.starter.SpringWebhookBot;
import ru.athena.ruin.through.drinking.configuration.properties.BotProperties;
import ru.athena.ruin.through.drinking.handler.TelegramUpdateHandler;

import static java.util.Objects.nonNull;

public class RuinThroughDrinkingBot extends SpringWebhookBot {

    private final String botUsername;
    private final String botToken;
    private final String botPath;
    private final TelegramUpdateHandler telegramUpdateHandler;

    public RuinThroughDrinkingBot(SetWebhook setWebhook,
                                  BotProperties botProperties,
                                  TelegramUpdateHandler telegramUpdateHandler) {
        super(setWebhook);
        this.telegramUpdateHandler = telegramUpdateHandler;
        this.botUsername = botProperties.getBotName();
        this.botToken = botProperties.getBotToken();
        this.botPath = botProperties.getBotWebhookPath();
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (nonNull(message) && message.hasText()) {
            return telegramUpdateHandler.handle(update);
        }
        return null;
    }

    @Override
    public String getBotToken() {
        return this.botToken;
    }

    @Override
    public String getBotPath() {
        return this.botPath;
    }

    @Override
    public String getBotUsername() {
        return this.botUsername;
    }
}
