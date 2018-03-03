package com.elemis.thenytimesdemo.detail;

import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.elemis.thenytimesdemo.R;
import com.elemis.thenytimesdemo.util.DetailForm_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by elemis on 2018. 02. 25..
 */

@EActivity(R.layout.activity_news_detail)
public class DetailActivity extends AppCompatActivity implements DetailView {

    @ViewById
    protected DetailForm_ detailForm;
    private DetailPresenter detailPresenter;

    @AfterViews
    protected void init() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        detailPresenter = new DetailPresenterImp(this);
        detailForm.loadFormData(detailPresenter.getNews());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
