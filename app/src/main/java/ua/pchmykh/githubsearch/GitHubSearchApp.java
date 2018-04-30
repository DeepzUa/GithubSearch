package ua.pchmykh.githubsearch;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.pchmykh.githubsearch.net.GithubHttpApi;

public class GitHubSearchApp extends Application {

    private Retrofit retrofit;
    private static GithubHttpApi githubHttpApi;


    @Override
    public void onCreate() {
        super.onCreate();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        githubHttpApi = retrofit.create(GithubHttpApi.class);
    }

    public static GithubHttpApi getApi() {
        return githubHttpApi;
    }
}
