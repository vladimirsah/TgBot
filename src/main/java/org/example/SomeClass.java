package org.example;

public class SomeClass {

    static {
        Handler actualHandler = TgBots.BOT_CORE.getHandler();
        if(actualHandler instanceof FirstHandler firstHandler){
            firstHandler.setResponse("Ff");
        }
    }

}
