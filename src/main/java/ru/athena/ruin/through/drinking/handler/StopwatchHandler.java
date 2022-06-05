package ru.athena.ruin.through.drinking.handler;

import com.google.common.base.Stopwatch;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

@Component
public class StopwatchHandler {

    private final Stopwatch stopwatch = Stopwatch.createStarted();

    public BotApiMethod<?> showTimer(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setText(stopwatch + " без гейских шуток");
        return sendMessage;
    }

    public BotApiMethod<?> resetTimer(Message message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setText("Таймер сброшен!" + System.lineSeparator() + "Предыдущая попытка без гейских шуток - " + stopwatch);
        stopwatch.reset();
        stopwatch.start();
        return sendMessage;
    }
}
