package org.example;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import java.util.List;

public class BotCore {

    //  ArrayList<Update> updates = new ArrayList<>();
    private  TelegramBot telegramBot ;
    private  Handler handler;

    public BotCore(TelegramBot telegramBot, Handler handler){
        this.telegramBot = telegramBot;
        this.handler = handler;
        handler.setTelegramBot(telegramBot);
        telegramBot.setUpdatesListener(this::lambdaReplacement,
                e -> {
                    if (e.response() != null) {
                        // got a bad response from Telegram
                        e.response().errorCode();
                        e.response().description();
                    } else {
                        // probably a network error
                        e.printStackTrace();
                    }
                });
    }


    public int lambdaReplacement(List<Update> updates){

        for (Update update : updates){
            handler.check(update);
        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL;

    }

    public Handler getHandler() {
        return handler;
    }

}


//Создать класс BotCore, в котором написать конструктор, принимающий обьект TelegramBot и абстрактный обработчик ++
//Создать абстрактный обработчик, для обработки update ++
//Создать класс, реализующий работу абстрактного обработчика +-
//Передать лямба-выражение к setUpdatesListener как метод у BotCore --
//В этом методе вызывается абстрактны обработчик  --


//Происходит какое-то обновление в тг -> его ловит FirstHandler, реализующий абстрактный Handler ->