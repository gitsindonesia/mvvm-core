package id.gits.mvvmsample.api;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ibun on 11/05/16.
 */
public class ApiClient {
    ApiInterface mApiInterface;

    public ApiClient(String baseUrl) {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .addNetworkInterceptor(new MyInterceptor())
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(baseUrl)
                .build();
        mApiInterface = retrofit.create(ApiInterface.class);
    }

    private class MyInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            System.out.println("CALL API: " + request.url());
            Response response = chain.proceed(request);
            //TODO disable if published
            System.out.println(request.url() + ": " + response.body().string());

            return response;
        }
    }

    public ApiInterface getInterface() {
        return mApiInterface;
    }
}
