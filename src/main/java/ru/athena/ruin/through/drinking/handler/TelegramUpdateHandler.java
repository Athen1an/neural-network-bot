package ru.athena.ruin.through.drinking.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class TelegramUpdateHandler {

    private final StopwatchHandler stopwatchHandler;

    public BotApiMethod<?> handle(Update update) {
        Message message = update.getMessage();
        return switch (message.getText()) {
            case "/help" -> message.isGroupMessage() ?  help(message) : null;
            case "/show" -> message.isGroupMessage() ? stopwatchHandler.showTimer(message) : null;
            case "/reset" -> message.isGroupMessage() ?  stopwatchHandler.resetTimer(message) : null;
            default -> null;
        };
    }

    private BotApiMethod<?> help(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setText(
                "/show - показать таймер гейских шуток" +
                System.lineSeparator() +
                "/reset - сбросить таймер гейских шуток");
        sendMessage.disableNotification();
        return sendMessage;
    }
}
