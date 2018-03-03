package com.elemis.thenytimesdemo.sync;

import com.elemis.thenytimesdemo.model.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by elemis on 2018. 02. 24..
 */

public interface ApiInterface {

    String API_KEY = "2dc13ecad8da44c185ec2e2054bced25";

    @GET("1.json?api-key=" + API_KEY)
    Call<NewsResponse> getNews(@Query("offset") int offset);
}
