package ru.athena.ruin.through.drinking.handler;

import com.google.common.base.Stopwatch;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class StopwatchHandler {

    private final Stopwatch stopwatch = Stopwatch.createStarted();

    private static final String SHOW_MESSAGE = "%s без гейских шуток";
    private static final String RESET_MESSAGE = "Таймер сброшен!" + System.lineSeparator() + "Предыдущая попытка без гейских шуток - %s";

    public BotApiMethod<?> showTimer(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setText(String.format(SHOW_MESSAGE, stopwatch));
        sendMessage.disableNotification();

        return sendMessage;
    }

    public BotApiMethod<?> resetTimer(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setText(String.format(RESET_MESSAGE, stopwatch));
        sendMessage.disableNotification();

        stopwatch.reset();
        stopwatch.start();

        return sendMessage;
    }
}
