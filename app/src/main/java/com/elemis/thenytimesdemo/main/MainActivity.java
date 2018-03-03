package com.elemis.thenytimesdemo.main;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.elemis.thenytimesdemo.R;
import com.elemis.thenytimesdemo.model.News;
import com.elemis.thenytimesdemo.util.DetailForm;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements MainView {
    private static final int VISIBLE_THRESHOLD = 4;
    @ViewById
    protected RecyclerView recyclerView;
    @ViewById
    protected ProgressBar progressBar;
    @ViewById
    protected TextView emptyDetail;
    @ViewById
    protected DetailForm detailForm;
    @Bean
    protected NewsRecyclerViewAdapter newsRecyclerViewAdapter;
    @ViewById
    SwipeRefreshLayout swipeRefreshLayout;
    private MainPresenter mainPresenter;
    private int lastVisibleItem, totalItemCount;
    private boolean loading;

    @AfterViews
    protected void init() {
        mainPresenter = new MainPresenterImp(this, this, new LoadNewsInteractorImp(), detailForm != null);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager((this));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mainPresenter.reloadData();
            }
        });
        recyclerView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                totalItemCount = getAdapter().getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!loading && totalItemCount <= (lastVisibleItem + VISIBLE_THRESHOLD)) {
                    // the end is near
                    mainPresenter.endReached();
                }
            }
        });
        mainPresenter.loadData();
        recyclerView.setAdapter(newsRecyclerViewAdapter);
    }

    @Override
    public NewsRecyclerViewAdapter getAdapter() {
        return newsRecyclerViewAdapter;
    }

    @Override
    public void loadDetail(News news) {
        detailForm.setVisibility(View.VISIBLE);
        emptyDetail.setVisibility(View.GONE);
        detailForm.loadFormData(news);
    }

    @Override
    public void setLoading(boolean loading) {
        this.loading = loading;
        if (loading) {
            progressBar.setVisibility(View.VISIBLE);
        } else {
            progressBar.setVisibility(View.GONE);
            swipeRefreshLayout.setRefreshing(loading);
        }
    }
}
