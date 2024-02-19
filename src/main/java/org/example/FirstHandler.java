package org.example;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

public class FirstHandler extends Handler {

    private String response;

    @Override
    public void  check(Update update) {

        if (update.message() != null) {
            // Process the message
            long chatId = update.message().chat().id();
            SendMessage request = new SendMessage(chatId, response != null ? response : "sorry");
            SendResponse response = telegramBot.execute(request);
            if (!response.isOk()) {
                // Handle failure
                System.err.println("Failed to send message: " + response.errorCode() + " - " + response.description());
            }
        }
        new SomeClass();


    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
