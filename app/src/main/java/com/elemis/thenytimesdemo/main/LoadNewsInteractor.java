package com.elemis.thenytimesdemo.main;

import android.content.Context;

import com.elemis.thenytimesdemo.model.News;

import java.util.List;

/**
 * Created by elemis on 2018. 02. 26..
 */

public interface LoadNewsInteractor {
    void findNews(Context context, OnFinishedListener listener);

    void resetInteractor(Context context, OnFinishedListener listener);

    interface OnFinishedListener {
        void onFinishedWithData(List<News> items);
        void onFinished(boolean endReached);
    }
}
