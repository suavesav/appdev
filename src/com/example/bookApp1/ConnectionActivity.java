package com.example.bookApp1;

import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.app.Activity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Sav on 2/16/15.
 */
public class ConnectionActivity extends Activity {



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connection);

        //Getting the bluetooth adapter and starting discovery
        BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        final ArrayList<String> discoveredDevices = new ArrayList<String>();
        ListView lv = (ListView) findViewById(R.id.btList);


        //Getting the broadcast receiver
        final BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            //What to do when you receive a bcast
            public void onReceive(Context context, Intent intent) {
                //if new bt device found
                String action = intent.getAction();
//                if(BluetoothAdapter.ACTION_DISCOVERY_STARTED.equals(action))
//                {}
//                else if(BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action))
//                {}
                if(BluetoothDevice.ACTION_FOUND.equals(action))
                {
                    //get the device information and store it in an arrayAdapter to display
                    BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                    discoveredDevices.add(device.getName());
                    showToast(device);
                }
            }
        };
        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothDevice.ACTION_FOUND);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);


        registerReceiver(mBroadcastReceiver, filter);

        mBluetoothAdapter.startDiscovery();
        final ArrayAdapter<String> btDevs = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, discoveredDevices);
        lv.setAdapter(btDevs);

        //Temporary
        Button buttonContinue = (Button) findViewById(R.id.proceed);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BookAppActivity2.class));
            }
        });
        //CHECK IF CONNECTION ESTABLISHED and if so GO TO LIST
    }

    public void showToast(BluetoothDevice dev)
    {
        Toast
                .makeText(this, dev.getName(), Toast.LENGTH_SHORT)
                .show();
    }
}
