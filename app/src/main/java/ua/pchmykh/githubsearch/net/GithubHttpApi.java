package ua.pchmykh.githubsearch.net;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ua.pchmykh.githubsearch.net.pojo.JsonFullUser;
import ua.pchmykh.githubsearch.net.pojo.JsonRepo;

public interface GithubHttpApi {

    @GET("/users/{name}")
    Call<JsonFullUser> getFullInfoUser(@Path("name") String name);

    @GET("/users/{name}/repos")
    Call<List<JsonRepo>> getRepos(@Path("name") String nameRepo);
}
