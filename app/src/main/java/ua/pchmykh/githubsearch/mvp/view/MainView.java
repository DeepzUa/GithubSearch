package ua.pchmykh.githubsearch.mvp.view;

import com.arellomobile.mvp.MvpView;

import ua.pchmykh.githubsearch.net.pojo.JsonFullUser;

public interface MainView extends MvpView {

    void setItemToList(JsonFullUser item);
    void cleanItems();

    void showError(String textError);
    void closeError();

   // void intentRepo(JsonFullUser login);
}
