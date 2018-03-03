package com.elemis.thenytimesdemo.sync;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by elemis on 2018. 02. 24..
 */

public class ApiClient {
    private static final String BASE_URL = "http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//        logging.setLevel(HttpLoggingInterceptor.Level.NONE);

        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.addInterceptor(logging);

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().create()))
                    .client(client.build())
                    .build();
        }
        return retrofit;
    }
}