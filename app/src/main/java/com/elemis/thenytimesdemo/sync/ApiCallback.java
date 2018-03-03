package com.elemis.thenytimesdemo.sync;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.elemis.thenytimesdemo.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by elemis on 2018. 02. 25..
 */

public abstract class ApiCallback<T> implements Callback<T> {
    private Context context;
    private Boolean hasError = false;

    protected ApiCallback(Context context) {
        this.context = context;
    }

    @Override
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(response);
        } else {
            onError();
        }
        onFinished();
    }

    public void onSuccess(Response<T> response) {
    }

    @Override
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        onError();
        onFinished();
    }

    private void onError() {
        Toast.makeText(context, R.string.error, Toast.LENGTH_SHORT).show();
        hasError = true;
    }

    public void onFinished() {
    }

    public Boolean getHasError() {
        return hasError;
    }
}
