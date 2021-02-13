package com.sundar.liquorstore.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sundar.liquorstore.itemDetail_activity;

import com.sundar.liquorstore.model.Item;
import com.sundar.liquorstore.R;
import com.sundar.liquorstore.Url.url;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemRecyclerAdapter extends  RecyclerView.Adapter<ItemRecyclerAdapter.ItemViewHolder> {

    private Context mContext;
    private List<Item> itemList;

    public ItemRecyclerAdapter(Context mContext, List<Item> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemrecycler_layout,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final Item item = itemList.get(position);
       Picasso.get().load(url.base_url+"/uploads/"+item.getImage()).into(holder.imageView);

        holder.Price.setText("Rs. "+item.getPrice());
        holder.detail.setText(item.getDetail());
        holder.ProductName.setText(item.getItemName());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, itemDetail_activity.class);
                intent.putExtra("image",item.getImage());
                intent.putExtra("ProductName", item.getItemName());
                intent.putExtra("price", String.valueOf(item.getPrice()));
                intent.putExtra("detail", item.getDetail());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        if(itemList==null){
            return 0;
        }else {
            return itemList.size();
        }
    }

    public class  ItemViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView Price, detail, ProductName;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ProductName = itemView.findViewById(R.id.ProductName);
           imageView= itemView.findViewById(R.id.imageView);
            Price=itemView.findViewById(R.id.Price);
            detail=itemView.findViewById(R.id.detail);



        }
    }
}
