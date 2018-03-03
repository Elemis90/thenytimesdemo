package com.elemis.thenytimesdemo.main;

import com.elemis.thenytimesdemo.model.News;

/**
 * Created by elemis on 2018. 02. 24..
 */

public interface MainView {

    NewsRecyclerViewAdapter getAdapter();

    void loadDetail(News news);

    void setLoading(boolean loading);
}
