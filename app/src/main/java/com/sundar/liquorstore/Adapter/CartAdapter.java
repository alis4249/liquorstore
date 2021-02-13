package com.sundar.liquorstore.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sundar.liquorstore.R;
import com.sundar.liquorstore.model.Cart;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyHolder> {

    public CartAdapter(List<Cart> carts, Context contexts) {
        this.carts = carts;
        this.contexts = contexts;
    }

    List<Cart> carts;
    Context contexts;

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_recycler, parent, false);
        MyHolder myholder = new MyHolder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Cart cart = carts.get(position);
        if(cart.getItem()!=null){
            holder.cartprice.setText(cart.getItem().getPrice());
            holder.cartspecification.setText(cart.getItem().getDetail());
            holder.cartname.setText(cart.getItem().getItemName());
        }else{
            holder.cartprice.setText("Not Available");
            holder.cartspecification.setText("Not Available");
            holder.cartname.setText("Not Available");
        }

    }

    @Override
    public int getItemCount() {
        if(carts==null){
            return 0;
        }else {
            return carts.size();
        }
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView cartprice,cartspecification,cartname;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            cartname=itemView.findViewById(R.id.cartname);
            cartprice=itemView.findViewById(R.id.cartprice);
            cartspecification=itemView.findViewById(R.id.cartspecification);
        }
    }
}