package ua.pchmykh.githubsearch.net;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ua.pchmykh.githubsearch.net.pojo.user.JsonUser;

public interface GithubHttpApi {

    @GET("/search/users")
    Call<JsonUser> getGithubRepo(@Query("q") String githubRepository);

}
