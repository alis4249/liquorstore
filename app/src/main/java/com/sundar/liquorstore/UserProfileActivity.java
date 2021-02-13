package com.sundar.liquorstore;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import com.sundar.liquorstore.Api.UsersApi;
import com.sundar.liquorstore.ServerResponse.ImageResponse;
import com.sundar.liquorstore.Url.url;
import com.sundar.liquorstore.model.User;
import com.sundar.liquorstore.strictmode.strictmodeclass;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserProfileActivity extends AppCompatActivity {
    private ImageView profileimg;
    private EditText etfname, etlname, etusername;;
    private TextView btnupdate;
    private String imagePath ="";
    private String imageName="";

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        profileimg = findViewById(R.id.UpdateImage);
        etfname = findViewById(R.id.etFirstName);
        etlname = findViewById(R.id.etLastName);
        etusername = findViewById(R.id.etSignUpUsername);
        btnupdate = findViewById(R.id.btnUpdate);

        ShowDetails();

        profileimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browseimage();
            }
        });

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveImageOnly();
                ShowDetails();
                profileupdate();
            }
        });

    }
    private  void ShowDetails() {

        final String fName = etfname.getText().toString();
        final String lname = etlname.getText().toString();
        final String username = etusername.getText().toString();

        User user = new User(fName, lname, username, imageName);

        UsersApi userapi = url.getInstance().create(UsersApi.class);
        retrofit2.Call<User> userDetails = userapi.getUserDetails(url.token);
        userDetails.enqueue(new Callback<User>() {
            @Override
            public void onResponse(retrofit2.Call<User> call, Response<User> response) {
                etfname.setText(response.body().getFirstName());
                etlname.setText(response.body().getLastName());
                etusername.setText(response.body().getUsername());
                imageName = response.body().getImage();
                Picasso.get().load(url.imagePath + response.body().getImage()).into(profileimg);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(UserProfileActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                Log.d("EditProfileActivity", "failur cause " + t.getLocalizedMessage());
            }
        });
    }
    private void profileupdate() {
        final String fname1 = etfname.getText().toString();
        final String lname1 = etlname.getText().toString();
        final String username1 = etusername.getText().toString();

        User user = new User(fname1, lname1, username1, imageName);

        UsersApi userapi = url.getInstance().create(UsersApi.class);
        Call<User> userDetails = userapi.updateUserDetails(url.token, fname1, lname1, username1, imagePath);
        userDetails.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                etfname.setText(response.body().getFirstName());
                etlname.setText(response.body().getLastName());
                etusername.setText(response.body().getUsername());
                Picasso.get().load(url.imagePath + response.body().getImage()).into(profileimg);
                Toast.makeText(UserProfileActivity.this, "Successful", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(UserProfileActivity.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                Log.d("EditProfileActivity", "failur cause " + t.getLocalizedMessage());
            }
        });
    }
    private void saveImageOnly() {
        if (!imagePath.isEmpty()) {
            File file = new File(imagePath);
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            MultipartBody.Part body = MultipartBody.Part.createFormData("imageFile",
                    file.getName(), requestBody);

            UsersApi userapi = url.getInstance().create(UsersApi.class);
            Call<ImageResponse> responseBodyCall = userapi.uploadImage(body);

            strictmodeclass.StrictMode();
            //Synchronomus method

            try {
                Response<ImageResponse> imageResponseResponse = responseBodyCall.execute();
                imageName = imageResponseResponse.body().getFilename();
                Toast.makeText(this, "Image Inserted", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                Toast.makeText(this, "Error" + e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }
    }
    private void browseimage() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,0);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(data == null)
            {
                Toast.makeText(this, "Please select an image", Toast.LENGTH_LONG).show();
            }
        }

        Uri uri = data.getData();
        profileimg.setImageURI(uri);
        imagePath = getRealPathFromUri(uri);
    }

    private String getRealPathFromUri(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        CursorLoader loader = new CursorLoader(getApplicationContext(),uri,projection, null
                ,null,null);
        Cursor cursor = loader.loadInBackground();
        int colIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result = cursor.getString(colIndex);
        cursor.close();
        return result;
    }

}