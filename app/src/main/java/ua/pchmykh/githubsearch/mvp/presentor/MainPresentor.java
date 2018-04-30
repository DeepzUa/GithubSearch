package ua.pchmykh.githubsearch.mvp.presentor;

import android.os.Build;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.pchmykh.githubsearch.BuildConfig;
import ua.pchmykh.githubsearch.GitHubSearchApp;
import ua.pchmykh.githubsearch.Util;
import ua.pchmykh.githubsearch.mvp.view.MainView;
import ua.pchmykh.githubsearch.net.pojo.user.JsonFullUser;

@InjectViewState
public class MainPresentor extends MvpPresenter<MainView> {

    final public static String TAG = "MainPresentor";
    private int sizeText;
    private boolean update;


    public void setUpdate(boolean update) {
        this.update = update;
    }

    public void loadNewItem(String q,boolean inet){

        if (inet){
            GitHubSearchApp.getApi().getFullInfoUser(q).enqueue(new Callback<JsonFullUser>() {
            @Override
            public void onResponse(Call<JsonFullUser> call, Response<JsonFullUser> response) {
                if (response.body()!=null) {
                    if (update) {
                        getViewState().setItemToList(customiseResponse(response.body()));
                        }
                    }
                    else if (response.errorBody()!=null) {

                        try {
                            getViewState().showError(new JSONObject(response.errorBody().string()).getString("message"));
                        } catch (IOException|JSONException e) {
                            if (BuildConfig.DEBUG)
                                Log.d(TAG,e.getMessage());
                        }

                }
            }

            @Override
            public void onFailure(Call<JsonFullUser> call, Throwable t) {
                getViewState().showError(t.getMessage());
                if (BuildConfig.DEBUG)
                    Log.e(TAG,t.getMessage());
            }
        });
        }else {
            getViewState().showError("No Internet connection");
        }
    }

    public void cleanItems(){
        getViewState().cleanItems();

    }

    public void closeError(){
        getViewState().closeError();
    }

    public void setSizeText(int sizeText) {
        this.sizeText = sizeText;
    }

    public int getSizeText() {
        return sizeText;
    }

    public void intentRepository(JsonFullUser user){
        getViewState().intentRepo(user.getLogin());
    }


    private JsonFullUser customiseResponse(JsonFullUser user){
        user.setLogin(Util.changeFirstChar(user.getLogin()));

        user.setBlog(user.getBlog().substring(Util.getSubStringToProtocol(user.getBlog())));
        return user;
    }



}
