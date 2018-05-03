package ua.pchmykh.githubsearch.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

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

    private AlertDialog error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        githubLogin = getIntent().getStringExtra("login");
        publicRepos = getIntent().getIntExtra("public_repo",0);

        toolbar.setTitle(githubLogin+" Repositories ("+publicRepos+")");

        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back_black_36dp);
        toolbar.setNavigationIcon(drawable);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        repoAdapter = new RepoAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(repoAdapter);

        DividerItemDecoration divider = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getBaseContext(), R.drawable.custom_divider));
        recyclerView.addItemDecoration(divider);
        initLoad();
    }

    public void initLoad(){
        if (repoPresentor.isUpdate()) {
            for (int i=1;i<=Util.getPages(publicRepos);i++)
                repoPresentor.loadRepos(githubLogin, i,Util.checkInetConnect(this));

        }
    }

    @Override
    public void setItemToList(List<JsonRepo> item) {
        repoAdapter.setItems(item);
    }



    @Override
    protected void onStop() {
        super.onStop();
        repoPresentor.closeError();
    }



    @Override
    public void showError(String textError) {
        if (error!=null)
            error.cancel();

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Опаньки...");
        builder.setMessage(textError);
        builder.setCancelable(false);
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                repoPresentor.closeError();
            }
        });
        error = builder.create();
        error.show();

    }

    @Override
    public void closeError() {
        if (error!=null)
            error.cancel();
    }



}
