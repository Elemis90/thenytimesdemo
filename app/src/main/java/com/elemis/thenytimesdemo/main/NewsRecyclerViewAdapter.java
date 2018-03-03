package com.elemis.thenytimesdemo.main;

import android.content.Context;
import android.view.ViewGroup;

import com.elemis.thenytimesdemo.model.News;
import com.elemis.thenytimesdemo.util.RecyclerViewAdapterBase;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

/**
 * Created by elemis on 2018. 02. 25..
 */

@EBean
class NewsRecyclerViewAdapter extends RecyclerViewAdapterBase<News, NewsItemView> {
    @RootContext
    Context context;

    @Override
    protected NewsItemView onCreateItemView(ViewGroup parent, int viewType) {
        return NewsItemView_.build(context);
    }

    void selectItem(int position) {
        if (!items.get(position).isSelected()) {
            for (News item : items) {
                if (item.isSelected()) {
                    item.setSelected(false);
                    notifyItemChanged(items.indexOf(item));
                    break;
                }
            }
        }
        items.get(position).setSelected(true);
        notifyItemChanged(position);
    }
}