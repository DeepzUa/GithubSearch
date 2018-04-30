package ua.pchmykh.githubsearch;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Util {

    public static boolean checkInetConnect(Context context){
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public static int getSubStringToProtocol(String url){
        if (url.contains("http"))
            return 8;
        else if (url.contains("https"))
            return 9;
        else
            return 0;
    }

    public static String changeFirstChar(String name){
        char custom[] = name.toCharArray();
        custom[0] = name.toUpperCase().charAt(0);
        return new String(custom);

    }
}
