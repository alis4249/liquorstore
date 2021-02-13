package com.sundar.liquorstore;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.sundar.liquorstore.Adapter.ImageSliderAdapter;
import com.sundar.liquorstore.Adapter.ItemRecyclerAdapter;
import com.sundar.liquorstore.Api.UsersApi;
import com.sundar.liquorstore.Bll.BannerBll;
import com.sundar.liquorstore.Bll.ItemBll;
import com.sundar.liquorstore.Url.url;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import de.hdodenhof.circleimageview.CircleImageView;

public class Dashboard_activity extends AppCompatActivity {
    private RecyclerView item_recyclerview;
    private DrawerLayout DL;
    private ActionBarDrawerToggle T;
    private NavigationView NV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_activity);

        SliderImageLoad();
        PopulateRecyclerViewList();
        circleImageViewClick();
        checkImage();

        navigations();
        Toast.makeText(this, url.base_url, Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(T.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
    public void navigations(){
        DL = findViewById(R.id.activity_dashboard_activity);
        T = new ActionBarDrawerToggle(this, DL,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        T.setDrawerIndicatorEnabled(true);
        DL.addDrawerListener(T);
        T.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        NV = findViewById(R.id.NV);
        NV.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                DL.closeDrawer(GravityCompat.START);
                switch (id)
                {
                    case R.id.Home: startActivity(new Intent(Dashboard_activity.this, Item_List.class));
                        return false;
                    case R.id.Wines: startActivity(new Intent(Dashboard_activity.this, Wine_Activity.class));
                        return false;
                    case R.id.Beers :startActivity(new Intent(Dashboard_activity.this, Beers_activity.class));
                        return false;
                    case R.id.userprofile :startActivity(new Intent(Dashboard_activity.this, UserProfileActivity.class));
                        return false;

                    case R.id.Cart: startActivity(new Intent(Dashboard_activity.this, Cartlist_Activity.class));
                        return false;
                    case R.id.Hard_Drinks: startActivity(new Intent(Dashboard_activity.this, HardDrinks_activity.class));
                        return false;
                    case R.id.Logout :
                        final DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which){
                                    case DialogInterface.BUTTON_POSITIVE:

                                        Intent intent = new Intent(Dashboard_activity.this,MainActivity.class);
                                        startActivity(intent);
                                        finish();

                                        break;
                                        case DialogInterface.BUTTON_NEGATIVE:

                                            break;
                                }
                            }
                        };
                        AlertDialog.Builder builder = new AlertDialog.Builder(Dashboard_activity.this);
                        builder.setMessage("Are you Sure you want to Logout?")
                                .setTitle("Logout")
                                .setPositiveButton("Yes",dialog)
                                .setNegativeButton("No",dialog);
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                        return false;

                    case R.id.Map :startActivity(new Intent(Dashboard_activity.this, MapActivity.class));
                    default:

                        return false;
                }
            }
        });
    }
    public void SliderImageLoad(){

        BannerBll bannerBll = new BannerBll();
        SliderView sliderView =  findViewById(R.id.imageSlider);
        ImageSliderAdapter adapter = new ImageSliderAdapter(this, bannerBll.getAllBanners());

        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

    }

    public void PopulateRecyclerViewList(){
        item_recyclerview= findViewById(R.id.recycleritemlists);
        ItemBll itemBll= new ItemBll();
        ItemRecyclerAdapter itemRecyclerAdapter= new ItemRecyclerAdapter(this, itemBll.getAllItems());
        item_recyclerview.setAdapter(itemRecyclerAdapter);
        item_recyclerview.setLayoutManager(new LinearLayoutManager(this));

    }

    public void circleImageViewClick(){
         CircleImageView logos = findViewById(R.id.logos);
        logos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(Dashboard_activity.this,Item_List.class));
            }
        });

    }

    public void checkImage(){
        UsersApi usersApi = url.getInstance().create(UsersApi.class);
//        Call<Image> userCall = usersApi.getUserimage(url.token);
//        try {
//            Response<Image> imageResponse = userCall.execute();
//            if(!imageResponse.isSuccessful()){
//                Toast.makeText(Dashboard_activity.this, "Please upload a profile picture", Toast.LENGTH_SHORT).show();
//                return;
//            }
//            String imgPath = userCall.imagePath() imageResponse.body().getImage()
//        }
    }
}
