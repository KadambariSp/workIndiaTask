package com.example.workindiatask.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.workindiatask.MainActivity;
import com.example.workindiatask.Model.itemModel;
import com.example.workindiatask.R;

import java.util.List;

public class itemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//    private Context itemContext;
    public static final int TYPE=1;
    private final Context mContext;
    private final List<Object> listrecyclerItem;
    itemModel data[];

    public itemAdapter(Context itemContext, List<Object> listrecyclerItem) {
        this.mContext = itemContext;
        this.listrecyclerItem = listrecyclerItem;

    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      switch(viewType)
      {
          case TYPE:
          default:
              View layoutView=LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recycler_view,parent,false);
              return new ViewHolder((layoutView));
      }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType=getItemViewType(position);
        switch (viewType)
        {
            case TYPE:
            default:
                ViewHolder viewHolder=(ViewHolder) holder;
                itemModel model=(com.example.workindiatask.Model.itemModel)listrecyclerItem.get(position);
                viewHolder.name.setText(model.getName());
                viewHolder.price.setText(model.getPrice());
                viewHolder.extra.setText(model.getExtra());
        }
    }



    @Override
    public int getItemCount() {
        return listrecyclerItem.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView price;
        TextView extra;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.itemName);
            price = itemView.findViewById(R.id.itemPrice);
            extra = itemView.findViewById(R.id.extra);
        }
    }

}
