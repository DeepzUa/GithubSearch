package ua.pchmykh.githubsearch.mvp.presentor;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.pchmykh.githubsearch.GitHubSearchApp;
import ua.pchmykh.githubsearch.mvp.view.RepoView;
import ua.pchmykh.githubsearch.net.pojo.JsonRepo;

@InjectViewState
public class RepoPresentor extends MvpPresenter<RepoView> {

    final public static String TAG = "RepoPresentor";
    private boolean update = true;

    public void loadRepos(String login,int page){

        GitHubSearchApp.getApi().getRepos(login,100,page).enqueue(new Callback<List<JsonRepo>>() {
            @Override
            public void onResponse(Call<List<JsonRepo>> call, Response<List<JsonRepo>> response) {
                if (response.body()!=null){
                    update = false;
                    getViewState().setItemToList(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<JsonRepo>> call, Throwable t) {

            }
        });
    }

    public boolean isUpdate() {
        return update;
    }
}
