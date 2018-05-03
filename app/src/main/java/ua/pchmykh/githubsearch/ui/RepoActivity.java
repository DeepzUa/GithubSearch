package ua.pchmykh.githubsearch.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.pchmykh.githubsearch.R;
import ua.pchmykh.githubsearch.Util;
import ua.pchmykh.githubsearch.mvp.presentor.RepoPresentor;
import ua.pchmykh.githubsearch.mvp.view.RepoView;
import ua.pchmykh.githubsearch.net.pojo.JsonRepo;
import ua.pchmykh.githubsearch.ui.adapter.RepoAdapter;

public class RepoActivity extends MvpAppCompatActivity implements RepoView {

    final public static String TAG = "RepoActivity";

    @BindView(R.id.repos_list)
    RecyclerView recyclerView;

    @InjectPresenter
    RepoPresentor repoPresentor;

    private RepoAdapter repoAdapter;
    private String githubLogin;
    private int publicRepos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        githubLogin = getIntent().getStringExtra("login");
        publicRepos = getIntent().getIntExtra("public_repo",0);

        toolbar.setTitle(githubLogin+" Repositories ("+publicRepos+")");

        setSupportActionBar(toolbar);
        ButterKnife.bind(this);



        repoAdapter = new RepoAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(repoAdapter);

        Log.d(TAG, Util.getPages(publicRepos)+"");

        if (repoPresentor.isUpdate()) {
            for (int i=1;i<=Util.getPages(publicRepos);i++)
            repoPresentor.loadRepos(githubLogin, i);

        }


    }

    @Override
    public void setItemToList(List<JsonRepo> item) {
        repoAdapter.setItems(item);
    }

    @Override
    public void cleanItems() {

    }

    @Override
    public void showError(String textError) {

    }

    @Override
    public void closeError() {

    }



}
