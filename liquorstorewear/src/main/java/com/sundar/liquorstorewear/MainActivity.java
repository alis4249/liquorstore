package com.sundar.liquorstorewear;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends WearableActivity {

    private EditText user, pass;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.eduser);
        pass = findViewById(R.id.edpassword);
        Login = findViewById(R.id.btnlog);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(user.getText()))
                {
                    Toast.makeText(MainActivity.this, "Empty Field", Toast.LENGTH_SHORT).show();
                    user.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(pass.getText()))
                {
                    Toast.makeText(MainActivity.this, "Empty Field", Toast.LENGTH_SHORT).show();
                    pass.requestFocus();
                    return;
                }
                if (user.getText().toString().equals("admin")&&pass.getText().toString().equals("admin"))
                {
                    Intent intent = new Intent(MainActivity.this,dashboard_activity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(MainActivity.this, "Either username or password is incorrect", Toast.LENGTH_SHORT).show();
                    pass.setText(" ");
                    pass.requestFocus();
                }
            }
        });

        //Enables Always-on
        setAmbientEnabled();


    }
}
