package ru.athena.ruin.through.drinking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.athena.ruin.through.drinking.configuration.properties.BotProperties;

@SpringBootApplication
@EnableConfigurationProperties(BotProperties.class)
public class RuinThroughDrinkingBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(RuinThroughDrinkingBotApplication.class, args);
	}

}

