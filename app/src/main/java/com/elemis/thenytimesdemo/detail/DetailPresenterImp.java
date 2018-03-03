package com.elemis.thenytimesdemo.detail;

import com.elemis.thenytimesdemo.model.News;

/**
 * Created by elemis on 2018. 02. 25..
 */

public class DetailPresenterImp implements DetailPresenter {
    private DetailView detailView;

    public DetailPresenterImp(DetailView detailView) {
        this.detailView = detailView;
    }

    @Override
    public News getNews() {
        return detailView.getIntent().getParcelableExtra("news");
    }
}
