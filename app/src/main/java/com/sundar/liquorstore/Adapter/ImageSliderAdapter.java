package com.sundar.liquorstore.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.smarteist.autoimageslider.SliderViewAdapter;
import com.sundar.liquorstore.model.BannerItem;
import com.sundar.liquorstore.R;
import com.sundar.liquorstore.Url.url;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageSliderAdapter extends  SliderViewAdapter<ImageSliderAdapter.SliderImageViewHolder>{
    private Context mContext;
    private List<BannerItem> imagesLists;

    public ImageSliderAdapter(Context mContext, List<BannerItem> imagesLists) {
        this.mContext = mContext;
        this.imagesLists = imagesLists;
    }

    @Override
    public SliderImageViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_layout, parent, false);
        return new SliderImageViewHolder(view);
    }


    @Override
    public void onBindViewHolder(SliderImageViewHolder viewHolder, int position) {
        BannerItem bannerItem = imagesLists.get(position);
        viewHolder.imageDescriptions.setText(bannerItem.getDescriptions() + "");
        viewHolder.tv1_auto_image_slider.setText(bannerItem.getBannerName());
        Picasso.get().load(url.base_url + "/uploads/" + bannerItem.getImages()).into(viewHolder.images);

    }

    @Override
    public int getCount() {
        return imagesLists.size();
    }



    class SliderImageViewHolder extends SliderViewAdapter.ViewHolder  {
        ImageView images;
        TextView imageDescriptions, tv1_auto_image_slider;

        public SliderImageViewHolder(View itemView) {
            super(itemView);
            images = itemView.findViewById(R.id.iv_auto_image_slider);
            imageDescriptions = itemView.findViewById(R.id.tv_auto_image_slider);
            tv1_auto_image_slider = itemView.findViewById(R.id.tv1_auto_image_slider);

        }

    }






}
