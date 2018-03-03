package com.elemis.thenytimesdemo.util;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by elemis on 2018. 02. 25..
 */

public class ViewWrapper<D, V extends View & ViewWrapper.Binder<D>> extends RecyclerView.ViewHolder {

    private V view;

    ViewWrapper(V itemView) {
        super(itemView);
        view = itemView;
    }

    public V getView() {
        return view;
    }

    public interface Binder<D> {
        void bind(D data);
    }

}