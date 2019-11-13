package com.deluxan.databank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username, password;
    private Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login_button = findViewById(R.id.login_btn);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            if(user.isEmpty()) {
                Toast.makeText(MainActivity.this, "Username should not be empty", Toast.LENGTH_SHORT).show();
            } else {
                startActivity(new Intent(getApplicationContext(), DashboardActivity.class));
            }
            }
        });
    }
}
