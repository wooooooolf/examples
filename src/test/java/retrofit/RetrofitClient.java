package retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

import java.util.concurrent.TimeUnit;

public class RetrofitClient {
  private static Retrofit retrofit;

  public static Retrofit getClient() {

      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      OkHttpClient.Builder client = (new OkHttpClient.Builder())
              .addInterceptor(interceptor)
              .connectTimeout(30L, TimeUnit.SECONDS)
              .readTimeout(60L, TimeUnit.SECONDS);
      retrofit = new Retrofit.Builder()
              .baseUrl("https://api.github.com/").client(client.build()).build();
      return retrofit;

    }
  }

