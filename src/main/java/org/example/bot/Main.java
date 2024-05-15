package org.example.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final ThreadLocal<BotController> botController = ThreadLocal.withInitial(BotController::new);
    private static final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    public static void main(String[] args) {
        TelegramBot bot = new TelegramBot("6569229687:AAFrmidOBpO0yTsahn5lO2QNoRf6OefyidM");
        bot.setUpdatesListener((updates) -> {
            for (Update update : updates)
                CompletableFuture.runAsync(()->{
                    botController.get().handle(update);
                },executorService);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        },Throwable::printStackTrace);
    }
}
