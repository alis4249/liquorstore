package com.sundar.liquorstore;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.sundar.liquorstore.Bll.LoginBll;
import com.sundar.liquorstore.model.Channel;
import com.sundar.liquorstore.model.notification;
import com.sundar.liquorstore.strictmode.strictmodeclass;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        Channel channel = new Channel(this);
        channel.createChannel();


        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvSignup = findViewById(R.id.tvSignup);

        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Register here", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, Register_activity.class);
                startActivity(intent);


            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();

            }
        });

    }

    private void login() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        LoginBll loginBLL = new LoginBll();

        strictmodeclass.StrictMode();
        if (loginBLL.checkUser(username, password)) {
            Toast.makeText(getApplicationContext(), "Welcome to dashboard", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Dashboard_activity.class);
            intent.putExtra("user", username);
            startActivity(intent);
            finish();
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            DisplayNotification2();

        } else {
            Toast.makeText(this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
            etUsername.requestFocus();

            notification.giveNotification(MainActivity.this,"Enter Valid Login Credentials");
            Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            long[] mVibratePattern = new long[]{0, 400, 200,400};
            if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.O){
                v.vibrate(mVibratePattern,-1);

            }
            else{
                v.vibrate(mVibratePattern,-1);
            }


            return;
        }

    }
    private void DisplayNotification2() {
        Notification notification = new NotificationCompat.Builder(this, Channel.Channel_2)
                .setSmallIcon(R.drawable.ic_arrow_downward_black_24dp)
                .setContentTitle("Login HERE")
                .setContentText("Use your Proper UserName Aad password..Thank YOU!!!")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(1, notification);
    }

}
