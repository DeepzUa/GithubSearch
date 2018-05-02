package ua.pchmykh.githubsearch.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import ua.pchmykh.githubsearch.R;
import ua.pchmykh.githubsearch.Util;
import ua.pchmykh.githubsearch.mvp.presentor.MainPresentor;
import ua.pchmykh.githubsearch.mvp.view.MainView;
import ua.pchmykh.githubsearch.net.pojo.user.JsonFullUser;
import ua.pchmykh.githubsearch.ui.adapter.CustomItemClickListener;
import ua.pchmykh.githubsearch.ui.adapter.UsersAdapter;

public class MainActivity extends MvpAppCompatActivity implements MainView{

    final public static String TAG = "MainActivity";

    @BindView(R.id.edit_user_repo)
    EditText editeUserRepo;

    @BindView(R.id.list_user_repo)
    RecyclerView recyclerView;

    @InjectPresenter
    MainPresentor mainPresentor;

    private UsersAdapter usersAdapter;

    private AlertDialog error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        usersAdapter = new UsersAdapter(new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                mainPresentor.intentRepository(usersAdapter.getUser(position));
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(usersAdapter);


        TextWatcher passwordWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length()>= 3 && mainPresentor.getSizeText()!=s.length()) {
                    mainPresentor.setUpdate(true);
                    mainPresentor.setSizeText(s.length());
                    mainPresentor.loadNewItem(editeUserRepo.getText().toString(), Util.checkInetConnect(getApplicationContext()));
                }else if (editeUserRepo.length()==0){
                    mainPresentor.setUpdate(false);
                    mainPresentor.cleanItems();
                }
            }

        };
        editeUserRepo.addTextChangedListener(passwordWatcher);
    }



    @Override
    public void setItemToList(JsonFullUser items) {

            usersAdapter.setItems(items);
    }

    @Override
    public void cleanItems() {
        usersAdapter.clearItems();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresentor.closeError();
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
                mainPresentor.closeError();
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

    @Override
    public void intentRepo(JsonFullUser login) {
        Intent intent = new Intent(MainActivity.this,RepoActivity.class);
        intent.putExtra("login",login.getLogin());
        intent.putExtra("public_repo",login.getPublicRepos());
        intent.putExtra("repos",login.getReposUrl());
        startActivity(intent);

    }
}
