package ua.pchmykh.githubsearch.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ua.pchmykh.githubsearch.GitHubSearchApp;
import ua.pchmykh.githubsearch.R;
import ua.pchmykh.githubsearch.net.GithubHttpApi;
import ua.pchmykh.githubsearch.net.pojo.user.Item;
import ua.pchmykh.githubsearch.net.pojo.user.JsonUser;
import ua.pchmykh.githubsearch.ui.adapter.UsersAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edit_user_repo)
    EditText editeUserRepo;

    @BindView(R.id.list_user_repo)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final UsersAdapter usersAdapter = new UsersAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(usersAdapter);


        TextWatcher passwordWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length()>= 3) {
                    GitHubSearchApp.getApi().getGithubRepo(editeUserRepo.getText().toString()).enqueue(new Callback<JsonUser>() {

                        @Override
                        public void onResponse(Call<JsonUser> call, Response<JsonUser> response) {
                            if (response.body()!=null)
                            usersAdapter.setItems(response.body().getItems());
                        }

                        @Override
                        public void onFailure(Call<JsonUser> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });
                }else {
                    usersAdapter.clearItems();
                }
            }

        };
        editeUserRepo.addTextChangedListener(passwordWatcher);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
