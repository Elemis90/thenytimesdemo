package com.elemis.thenytimesdemo.main;

import android.content.Context;

import com.elemis.thenytimesdemo.model.NewsResponse;
import com.elemis.thenytimesdemo.sync.ApiCallback;
import com.elemis.thenytimesdemo.sync.ApiClient;
import com.elemis.thenytimesdemo.sync.ApiInterface;
import com.elemis.thenytimesdemo.util.Network;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by elemis on 2018. 02. 26..
 */

public class LoadNewsInteractorImp implements LoadNewsInteractor {
    private static final int LOAD_COUNT = 20;
    private int offset = 0;
    private boolean endReached = false;

    @Override
    public void findNews(Context context, final OnFinishedListener listener) {
        if (Network.isOnline(context)) {
            final ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
            Call<NewsResponse> call = apiInterface.getNews(offset * LOAD_COUNT);
            call.enqueue(new ApiCallback<NewsResponse>(context) {
                @Override
                public void onSuccess(Response<NewsResponse> response) {
                    super.onSuccess(response);
                    if (response.body().getResults().size() < LOAD_COUNT) {
                        endReached = true;
                    }
                    listener.onFinishedWithData(response.body().getResults());
                    offset++;
                }

                @Override
                public void onFinished() {
                    super.onFinished();
                    listener.onFinished(endReached);
                }
            });
        } else {
            listener.onFinished(endReached);
        }
    }

    @Override
    public void resetInteractor(Context context, OnFinishedListener listener) {
        offset = 0;
        findNews(context, listener);
    }
}
