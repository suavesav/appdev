package com.example.bookApp1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class BookAppActivity1 extends Activity{
    /**
     * Called when the activity is first created.
     */

    Button btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btn = (Button)findViewById(R.id.button);
//        btn.setOnClickListener(this);
        updateTime();
    }

    public void update(View view)
    {
        updateTime();
    }

    private void updateTime()
    {
        btn.setText(new Date().toString());
    }

}
