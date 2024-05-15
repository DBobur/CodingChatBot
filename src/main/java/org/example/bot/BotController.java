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
import org.example.Base64EnDe;

import java.util.concurrent.ConcurrentHashMap;

public class BotController {
    private static final Main main = new Main();
    private static final TelegramBot bot =new TelegramBot("6569229687:AAFrmidOBpO0yTsahn5lO2QNoRf6OefyidM");
    private static final ConcurrentHashMap<Long,State> userState = new ConcurrentHashMap<>();
    public void handle(Update update){
        InlineKeyboardMarkup inline = new InlineKeyboardMarkup();
        InlineKeyboardButton button1 = new InlineKeyboardButton("Encode");
        button1.callbackData("encode");

        InlineKeyboardButton button2 = new InlineKeyboardButton("Decode");
        button2.callbackData("decode");
        inline.addRow(button1).addRow(button2);


        Message message = update.message();
        CallbackQuery callbackQuery = update.callbackQuery();
        Chat chat = message.chat();
        Long chatId = chat.id();
        if(message != null){
            System.out.println(message.text());
            var text = message.text();
            if(text.equals("/start")) {
                SendMessage sendMessage = new SendMessage(chatId, "Welcome to @coding_chat_bot\n\n"
                      + chat.firstName() + " are you ok!");
                bot.execute(sendMessage);
                bot.execute(new SendMessage(chatId,"Encoding or Decoding").replyMarkup(inline));
            } else if (message.text().equals("encode")) {
                System.out.println("m");
            } else {
                var deleteMessage = new DeleteMessage(chatId, message.messageId());
                bot.execute(deleteMessage);
            }
        } else {
            System.out.println(callbackQuery.data());
        }
    }

    enum State{
        ENCODING,DECODING
    }
}
