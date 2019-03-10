package com.example.recyclerviewclicklistenerexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Tarek on 10-Mar-19.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
    private List<TestItem> mTestItemList;
    private View.OnClickListener mOnItemClickListener;

    public MyRecyclerAdapter(List<TestItem> testItemList) {
        this.mTestItemList = testItemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(mTestItemList.get(position).getTitle());
        holder.description.setText(mTestItemList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mTestItemList.size();
    }

    //TODO: Step 2 of 4: Assign itemClickListener to your local View.OnClickListener variable
    public void setOnItemClickListener(View.OnClickListener itemClickListener) {
        mOnItemClickListener = itemClickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);

            //TODO: Step 3 of 4: setTag() as current view holder along with
            // setOnClickListener() as your local View.OnClickListener variable.
            // You can set the same mOnItemClickListener on multiple views if required
            // and later differentiate those clicks using view's id.
            itemView.setTag(this);
            itemView.setOnClickListener(mOnItemClickListener);
        }
    }

}
