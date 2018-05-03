package ua.pchmykh.githubsearch.mvp.presentor;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.pchmykh.githubsearch.BuildConfig;
import ua.pchmykh.githubsearch.GitHubSearchApp;
import ua.pchmykh.githubsearch.mvp.view.RepoView;
import ua.pchmykh.githubsearch.net.pojo.JsonRepo;

@InjectViewState
public class RepoPresentor extends MvpPresenter<RepoView> {

    final public static String TAG = "RepoPresentor";
    private boolean update = true;

    public void loadRepos(String login,int page,boolean inet){
        if (inet){
        GitHubSearchApp.getApi().getRepos(login,100,page).enqueue(new Callback<List<JsonRepo>>() {
            @Override
            public void onResponse(Call<List<JsonRepo>> call, Response<List<JsonRepo>> response) {
                if (response.body()!=null){
                    update = false;
                    getViewState().setItemToList(response.body());
                }else if (response.errorBody()!=null) {
                    try {
                        getViewState().showError(new JSONObject(response.errorBody().string()).getString("message"));
                    } catch (IOException |JSONException e) {
                        if (BuildConfig.DEBUG)
                            Log.d(TAG,e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<JsonRepo>> call, Throwable t) {
                getViewState().showError(t.getMessage());
                if (BuildConfig.DEBUG)
                    Log.e(TAG,t.getMessage());
            }
        });}else {
        getViewState().showError("No Internet connection");
    }
    }


    public void closeError(){
        getViewState().closeError();
    }

    public boolean isUpdate() {
        return update;
    }
}
