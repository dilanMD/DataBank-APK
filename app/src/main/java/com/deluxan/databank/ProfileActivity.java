package com.deluxan.databank;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfileActivity extends Activity {

    private Button notify_btn;
    private TextView hidden;
    String[] listItems;
    boolean[] checkedItems;
    ArrayList<Integer> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        notify_btn = findViewById(R.id.notify);

        listItems = getResources().getStringArray(R.array.sharing_data);
        checkedItems = new boolean[listItems.length];


        notify_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                builder.setTitle("Data to be shared");
                builder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if(isChecked) {
                            if(!arrayList.contains(position)) {
                                arrayList.add(position);
                            } else {
                                arrayList.remove(position);
                            }
                        }
                    }
                });

                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
//                        String item = "";
//                        for (int i=0; i<arrayList.size(); i++) {
//                            item = item + listItems[arrayList.get(i)];
//                            if(i != arrayList.size() -1) {
//                                item = item + ", ";
//                            }
//                        }
//
//                        if(item.contains(",")) {
//                            hidden.setText(item + " are shared");
//                        } else {
//                            hidden.setText(item + " is shared");
//                        }
                        startActivity( new Intent( ProfileActivity.this, DataSharingActivity.class ) );
                    }
                });
                builder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }
}
