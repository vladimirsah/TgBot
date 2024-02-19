package org.example;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;
import com.pengrad.telegrambot.UpdatesListener;

public class TgBots{

    public static BotCore BOT_CORE;

    public static void main(String[] args) {
        // Create your bot passing the token received from @BotFather
        TelegramBot bot = new TelegramBot("6895152846:AAF6Lo93-g8U-eZ47wl3pMiU7B945hzz6e4");
        BotCore botCore = new BotCore(bot,new FirstHandler());
        BOT_CORE = botCore;

    }

}

