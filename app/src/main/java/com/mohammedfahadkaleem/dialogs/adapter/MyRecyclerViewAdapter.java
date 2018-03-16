package com.mohammedfahadkaleem.dialogs.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mohammedfahadkaleem.dialogs.R;
import java.util.List;

/**
 * Created by fahadkaleem on 3/16/18.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

  private List<String> mDialogType;
  private LayoutInflater mInflater;
  private ItemClickListener mClickListener;

  // data is passed into the constructor
  public MyRecyclerViewAdapter(Context context, List<String> data) {
    this.mInflater = LayoutInflater.from(context);
    this.mDialogType = data;
  }

  // inflates the row layout from xml when needed
  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
    return new ViewHolder(view);
  }

  // binds the data to the TextView in each row
  @Override
  public void onBindViewHolder(ViewHolder holder, int position) {
    String animal = mDialogType.get(position);
    holder.myDialogType.setText(animal);
  }

  // total number of rows
  @Override
  public int getItemCount() {
    return mDialogType.size();
  }

  // convenience method for getting data at click position
  public String getItem(int id) {
    return mDialogType.get(id);
  }

  // allows clicks events to be caught
  public void setClickListener(ItemClickListener itemClickListener) {
    this.mClickListener = itemClickListener;
  }

  // parent activity will implement this method to respond to click events
  public interface ItemClickListener {

    void onItemClick(View view, int position);
  }

  // stores and recycles views as they are scrolled off screen
  public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView myDialogType;

    ViewHolder(View itemView) {
      super(itemView);
      myDialogType = itemView.findViewById(R.id.tv_dialog_type);
      itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
      if (mClickListener != null) {
        mClickListener.onItemClick(view, getAdapterPosition());
      }
    }
  }
}
