package com.elemis.thenytimesdemo.main;

import android.content.Context;
import android.content.Intent;

import com.elemis.thenytimesdemo.detail.DetailActivity_;
import com.elemis.thenytimesdemo.model.News;

import java.util.List;

/**
 * Created by elemis on 2018. 02. 24..
 */

public class MainPresenterImp implements MainPresenter, LoadNewsInteractor.OnFinishedListener {
    protected Context context;
    private MainView mainView;
    private LoadNewsInteractor loadNewsInteractor;

    public MainPresenterImp(final Context context, final MainView mainView, LoadNewsInteractor loadNewsInteractor, final Boolean tabletMode) {
        this.context = context;
        this.mainView = mainView;
        this.loadNewsInteractor = loadNewsInteractor;

        mainView.getAdapter().setOnItemSelectListener(new NewsRecyclerViewAdapter.OnItemSelectListener<News, NewsItemView>() {
            @Override
            public void onItemSelected(int position, NewsItemView view, News data) {
                if (tabletMode) {
                    mainView.getAdapter().selectItem(position);
                    mainView.loadDetail(data);
                } else {
                    Intent intent = new Intent(context, DetailActivity_.class);
                    intent.putExtra("news", data);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public void loadData() {
        mainView.setLoading(true);
        loadNewsInteractor.findNews(context, this);
    }

    @Override
    public void reloadData() {
        loadNewsInteractor.resetInteractor(context, this);
        mainView.getAdapter().clear();
    }

    @Override
    public void endReached() {
        loadData();
    }

    @Override
    public void onFinishedWithData(List<News> items) {
        mainView.getAdapter().addAll(items);
    }

    @Override
    public void onFinished(boolean endReached) {
        mainView.setLoading(false);

    }
}
