package ua.pchmykh.githubsearch.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.pchmykh.githubsearch.R;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        githubLogin = getIntent().getStringExtra("login");

        repoAdapter = new RepoAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(repoAdapter);
        if (repoPresentor.isUpdate())
            repoPresentor.loadRepos(githubLogin);

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
