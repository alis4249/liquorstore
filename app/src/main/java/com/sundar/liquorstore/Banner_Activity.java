package com.sundar.liquorstore;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.sundar.liquorstore.PermissionAndApi.LinkPermisson;
import com.sundar.liquorstore.PermissionAndApi.StoragePath;

public class Banner_Activity extends AppCompatActivity {
    private ImageView imageView;
    private String imagepath="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_);

        imageView = findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BrowseImage();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(Banner_Activity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void BrowseImage() throws Exception {
        // checkPermissionForReadExtertalStorage();
        LinkPermisson linkPermisson= new LinkPermisson(this);
        linkPermisson.requestPermissionForReadExtertalStorage();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri = data.getData();
        imageView.setImageURI(uri);
        StoragePath storagePath= new StoragePath(this);
        imagepath = storagePath.getRealPathFromUri(uri);
    }


}
