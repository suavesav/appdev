package com.example.bookApp1;

import android.app.Activity;
import android.app.AlertDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class BookAppActivity1 extends Activity{
    private static final int REQUEST_ENABLE_BT = 3;
    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(mBluetoothAdapter == null)
        {
            startActivity(new Intent(getApplicationContext(), BookAppActivity2.class));
            finish();
        }

        if(!mBluetoothAdapter.isEnabled())
        {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }

        Button buttonNext = (Button) findViewById(R.id.next);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BookAppActivity2.class));
                finish();
            }
        });
        showAlert();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == REQUEST_ENABLE_BT)
        {
            if(resultCode == RESULT_OK)
                showAlert();
            else if(resultCode == RESULT_CANCELED)
            {
                startActivity(new Intent(getApplicationContext(), BookAppActivity2.class));
                finish();
            }
        }
    }
    public void showAlert()
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
