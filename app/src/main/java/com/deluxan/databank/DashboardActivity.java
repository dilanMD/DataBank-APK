package com.deluxan.databank;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {

    CardView dashboard;
    PieChart pieChart;
    RadarChart radarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // DASHBOARD CARD START ACTIVITY

        dashboard = findViewById( R.id.dashboard_card );
        dashboard.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText( DashboardActivity.this, "Dashboard clicked", Toast.LENGTH_SHORT ).show();
                startActivity( new Intent( getApplicationContext(), ProfileActivity.class ) );
            }
        } );

        // PIE CHART

        pieChart = findViewById( R.id.usageChart );
        pieChart.setUsePercentValues( true );
        pieChart.getDescription().setEnabled( false );
        pieChart.setExtraOffsets( 5,10,5,5 );

        pieChart.setDragDecelerationFrictionCoef( 0.95f );
        pieChart.setDrawHoleEnabled( true );
        pieChart.setHoleColor( Color.TRANSPARENT );
        pieChart.setTransparentCircleRadius( 61f );

        ArrayList<PieEntry> yValues = new ArrayList<>();
        yValues.add( new PieEntry( 34f, "Daraz" ) );
        yValues.add( new PieEntry( 23f, "Buymore" ) );
        yValues.add( new PieEntry( 35f, "Kapruka" ) );
        yValues.add( new PieEntry( 45f, "Takas" ) );
        yValues.add( new PieEntry( 32f, "Wow" ) );
        yValues.add( new PieEntry( 37f, "E-Bay" ) );
        yValues.add( new PieEntry( 30f, "Amazon" ) );

        PieDataSet dataSet = new PieDataSet( yValues, "" );
        dataSet.setSliceSpace( 3f );
        dataSet.setSelectionShift( 5f );
        dataSet.setColors( ColorTemplate.COLORFUL_COLORS );

        PieData data = new PieData( dataSet );
        data.setValueTextSize( 10f );
        data.setValueTextColor( Color.YELLOW );

        pieChart.setData( data );


        // RADAR CHART

        radarChart = findViewById( R.id.preference );
        radarChart.getDescription().setEnabled( false );
        radarChart.setDrawMarkers( true );

        RadarDataSet radarDataSetOne = new RadarDataSet( dataValues1(), "January" );
        RadarDataSet radarDataSetTwo = new RadarDataSet( dataValues2(), "February" );
        RadarDataSet radarDataSetThree = new RadarDataSet( dataValues3(), "March" );

        radarDataSetOne.setColor( Color.RED );
        radarDataSetTwo.setColor( Color.BLUE );
        radarDataSetThree.setColor( Color.YELLOW );

        radarDataSetOne.setDrawFilled( true );
        radarDataSetTwo.setDrawFilled( true );
        radarDataSetThree.setDrawFilled( true );

        RadarData radarData = new RadarData();
        radarData.addDataSet( radarDataSetOne );
        radarData.addDataSet( radarDataSetTwo );
        radarData.addDataSet( radarDataSetThree );

        String[] labels = {"Mobile Phone", "Shoes", "Clothes", "Vehicles", "Tech Related"};

        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter( new IndexAxisValueFormatter( labels ) );

        radarChart.setData( radarData );
        radarChart.invalidate();




    }

    private  ArrayList<RadarEntry> dataValues1() {
        ArrayList<RadarEntry> radar = new ArrayList<>();
        radar.add( new RadarEntry( 4 ) );
        radar.add( new RadarEntry( 5 ) );
        radar.add( new RadarEntry( 4 ) );
        radar.add( new RadarEntry( 4 ) );
        radar.add( new RadarEntry( 3 ) );
        return radar;
    }

    private  ArrayList<RadarEntry> dataValues2() {
        ArrayList<RadarEntry> radar = new ArrayList<>();
        radar.add( new RadarEntry( 3 ) );
        radar.add( new RadarEntry( 5 ) );
        radar.add( new RadarEntry( 4 ) );
        radar.add( new RadarEntry( 5 ) );
        radar.add( new RadarEntry( 3 ) );
        return radar;
    }

    private  ArrayList<RadarEntry> dataValues3() {
        ArrayList<RadarEntry> radar = new ArrayList<>();
        radar.add( new RadarEntry( 4 ) );
        radar.add( new RadarEntry( 2 ) );
        radar.add( new RadarEntry( 5 ) );
        radar.add( new RadarEntry( 3 ) );
        radar.add( new RadarEntry( 2 ) );
        return radar;
    }
}
