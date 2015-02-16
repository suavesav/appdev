package com.example.bookApp1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

import java.text.MessageFormat;

public class BookAppActivity1 extends Activity implements RadioGroup.OnCheckedChangeListener{
    RadioGroup orientation;
    RadioGroup gravity;
    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        orientation = (RadioGroup)findViewById(R.id.orientation);
        orientation.setOnCheckedChangeListener(this);
        gravity = (RadioGroup)findViewById(R.id.gravity);
        gravity.setOnCheckedChangeListener(this);
        Button buttonNext = (Button) findViewById(R.id.next);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BookAppActivity2.class));
                finish();
            }
        });
    }

    public void onCheckedChanged(RadioGroup group, int checkedId)
    {
        switch (checkedId)
        {
            case(R.id.grp1h):
                orientation.setOrientation(LinearLayout.HORIZONTAL);
                break;
            case(R.id.grp1v):
                orientation.setOrientation(LinearLayout.VERTICAL);
                break;
            case(R.id.grp2l):
                gravity.setGravity(Gravity.LEFT);
                break;
            case(R.id.grp2c):
                gravity.setGravity(Gravity.CENTER);
                break;
            case(R.id.grp2r):
                gravity.setGravity(Gravity.RIGHT);
                break;
        }
    }

    public void showAlert(View v)
    {
        new AlertDialog.Builder(this)
                .setTitle("Connect")
                .setMessage("Connect to Laziest Boy via Bluetooth?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), ConnectionActivity.class));
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), BookAppActivity2.class));
                    }
                })
                .show();
    }
}
