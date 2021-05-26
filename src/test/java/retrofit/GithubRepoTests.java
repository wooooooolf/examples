package retrofit;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import okhttp3.ResponseBody;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static retrofit.RetrofitClient.getClient;

public class GithubRepoTests {

  @Test
  public void shouldGetRepositories() throws IOException {

    GithubService gitHubService = getClient().create(GithubService.class);
    ResponseBody responseBody = gitHubService.listRepos().execute().body();
    JsonArray repos = JsonParser.parseString(responseBody.string()).getAsJsonArray();

    assertEquals(12, repos.size());
    System.out.println(repos.size());
  }
}
