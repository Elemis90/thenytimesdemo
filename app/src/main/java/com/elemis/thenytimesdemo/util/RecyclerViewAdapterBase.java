package com.elemis.thenytimesdemo.util;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by elemis on 2018. 02. 25..
 */

public abstract class RecyclerViewAdapterBase<D, V extends View & ViewWrapper.Binder<D>> extends RecyclerView.Adapter<ViewWrapper<D, V>> {

    protected List<D> items = new ArrayList<>();
    private OnItemSelectListener<D, V> onItemSelectListener;

    public void setOnItemSelectListener(OnItemSelectListener<D, V> onItemSelectListener) {
        this.onItemSelectListener = onItemSelectListener;
    }


    @Override
    public final ViewWrapper<D, V> onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewWrapper<>(onCreateItemView(parent, viewType));
    }

    protected abstract V onCreateItemView(ViewGroup parent, int viewType);

    @Override
    public final void onBindViewHolder(final ViewWrapper<D, V> viewHolder, int position) {
        final V view = viewHolder.getView();
        final D data = items.get(position);
        view.bind(data);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick(viewHolder.getAdapterPosition(), view, data);
            }
        });
    }

    private void onItemClick(int position, V view, D data) {
        if (onItemSelectListener != null)
            onItemSelectListener.onItemSelected(position, view, data);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addAll(Collection<D> collection) {
        items.addAll(collection);
        notifyItemInserted(collection.size());
    }

    public void clear() {
     items.clear();
     notifyDataSetChanged();
    }

    public interface OnItemSelectListener<D, V> {
        void onItemSelected(int position, V view, D data);
    }
}
