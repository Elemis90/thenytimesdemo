package com.elemis.thenytimesdemo.main;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.elemis.thenytimesdemo.R;
import com.elemis.thenytimesdemo.model.News;
import com.elemis.thenytimesdemo.util.ViewWrapper;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by elemis on 2018. 02. 25..
 */

@EViewGroup(R.layout.news_item)
public class NewsItemView extends LinearLayout implements ViewWrapper.Binder<News> {
    @ViewById
    View rootLayout;
    @ViewById
    TextView title, byline, publishedDate;
    @ViewById
    ImageView image;

    private Context context;

    public NewsItemView(Context context) {
        super(context);
        this.context = context;
        setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
    }

    public void bind(News model) {
        title.setText(model.getTitle());
        if (model.isSelected()) {
            rootLayout.setBackgroundResource(R.color.colorAccent);
        } else {
            rootLayout.setBackgroundResource(R.color.colorWhite);
        }

        byline.setText(model.getByline());
        publishedDate.setText(model.getPublishedDate());

        Picasso.with(context)
                .load(model.getMedia().get(0).getMediaMetaData().get(1).getUrl())
                .placeholder(R.drawable.ic_launcher_background).into(image);
    }
}