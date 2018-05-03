package ua.pchmykh.githubsearch.mvp.view;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import ua.pchmykh.githubsearch.net.pojo.JsonRepo;

public interface RepoView extends MvpView {
    void setItemToList(List<JsonRepo> item);

    void showError(String textError);
    void closeError();
}