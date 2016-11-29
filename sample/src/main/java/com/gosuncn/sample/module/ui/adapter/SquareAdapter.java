package com.gosuncn.sample.module.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gosuncn.core.ui.adapter.BaseRecyclerViewAdapter;
import com.gosuncn.sample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Tong
 * @time 2016/11/24
 * @apiNote
 */
public class SquareAdapter extends BaseRecyclerViewAdapter<SquareAdapter.ViewHolder> {


    private String[] itemTitle;

    public SquareAdapter(String[] title){
        itemTitle = title;
    }

    @Override
    public SquareAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_square, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SquareAdapter.ViewHolder holder, int position) {
        holder.tvItem.setText(itemTitle[position]);
    }

    @Override
    public int getItemCount() {
        return itemTitle.length;
    }

    class ViewHolder extends BaseRecyclerViewAdapter.ViewHolder{

        @BindView(R.id.tv_item)
        TextView tvItem;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
