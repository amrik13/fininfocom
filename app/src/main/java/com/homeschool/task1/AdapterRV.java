package com.homeschool.task1;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AdapterRV extends RecyclerView.Adapter<AdapterRV.RViewHolder> {
    ArrayList<String> list;
    Context context;

    public AdapterRV(Context context){
        this.context = context;
        list = new ArrayList<>();
    }
    public void setData(ArrayList<String> list){
        this.list = list;
    }

    @NonNull
    @Override
    public RViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv, parent, false);
        return new RViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RViewHolder holder, int position) {
        if (list != null && list.size()>0 && holder.itemTextView2 != null){
            String str = list.get(position);
            String items[] = str.split("@-@-@");
            holder.itemTextView1.setText(items[0]);
            holder.itemTextView2.setText(items[1]);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RViewHolder extends RecyclerView.ViewHolder{
        TextView itemTextView1,itemTextView2;
        public RViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTextView1 = itemView.findViewById(R.id.itemText1);
            itemTextView2 = itemView.findViewById(R.id.itemText2);
        }
    }
}
