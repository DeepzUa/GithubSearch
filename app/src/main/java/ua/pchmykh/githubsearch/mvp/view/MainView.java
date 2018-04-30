package ua.pchmykh.githubsearch.mvp.view;

import com.arellomobile.mvp.MvpView;

import java.util.Collection;

import ua.pchmykh.githubsearch.net.pojo.user.JsonFullUser;

public interface MainView extends MvpView {

    void setItemToList(JsonFullUser item);
    void cleanItems();

    void showError(String textError);
    void closeError();

    void intentRepo(String login);
}
