package ru.athena.ruin.through.drinking.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.athena.ruin.through.drinking.bot.RuinThroughDrinkingBot;

@RestController
@RequiredArgsConstructor
public class WebhookController {

    private final RuinThroughDrinkingBot ruinThroughDrinkingBot;

    @PostMapping
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
        return ruinThroughDrinkingBot.onWebhookUpdateReceived(update);
    }

    @GetMapping
    public ResponseEntity<?> get() {
        return ResponseEntity.ok().build();
    }
}
