package com.deluxan.databank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DataSharingActivity extends AppCompatActivity {

    Button goHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_data_sharing );

        goHome = findViewById( R.id.go_home );
        goHome.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent( getApplicationContext(), DashboardActivity.class ) );
            }
        } );
    }
}
