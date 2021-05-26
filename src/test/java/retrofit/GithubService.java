package retrofit;



import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface GithubService {

  @GET("users/wooooooolf/repos")
  Call<ResponseBody> listRepos();

}

