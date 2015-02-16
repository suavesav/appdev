package com.example.bookApp1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;

/**
 * Created by Sav on 2/16/15.
 */
public class ConnectionActivity extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connection);


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
}
