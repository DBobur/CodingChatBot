package org.example.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.request.DeleteMessage;
import com.pengrad.telegrambot.request.SendMessage;
import org.example.enums.UserState;
import org.example.sevice.UserService;

import java.util.concurrent.ConcurrentHashMap;

public class BotController {
    private static final Main main = new Main();
    private static final TelegramBot bot =new TelegramBot("6569229687:AAFrmidOBpO0yTsahn5lO2QNoRf6OefyidM");
    UserService userService = UserService.getInstance();
    public void handle(Update update){
        Message message = update.message();
        CallbackQuery callbackQuery = update.callbackQuery();
    }

}
