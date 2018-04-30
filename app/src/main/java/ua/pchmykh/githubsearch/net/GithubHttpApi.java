package ua.pchmykh.githubsearch.net;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ua.pchmykh.githubsearch.net.pojo.user.JsonFullUser;

public interface GithubHttpApi {

    @GET("/users/{name}")
    Call<JsonFullUser> getFullInfoUser(@Path("name") String name);
}
