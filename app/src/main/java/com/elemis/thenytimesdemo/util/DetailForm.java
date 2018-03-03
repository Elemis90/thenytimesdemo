package com.elemis.thenytimesdemo.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.elemis.thenytimesdemo.R;
import com.elemis.thenytimesdemo.model.News;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by elemis on 2018. 03. 03..
 */

@EViewGroup(R.layout.news_detail)
public class DetailForm extends LinearLayout {

    @ViewById
    TextView title, type, abstractText, source, section, publishedDate, url;


    public DetailForm(Context context) {
        super(context);
    }

    public DetailForm(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DetailForm(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DetailForm(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void loadFormData(final News news) {
        title.setText(news.getTitle());
        type.setText(news.getType());
        abstractText.setText(news.getAbstractText());
        source.setText(news.getSource());
        section.setText(news.getSection());
        publishedDate.setText(news.getPublishedDate());
        url.setText(news.getUrl());

        url.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(news.getUrl()));
                getContext().startActivity(i);
            }
        });
    }
}
