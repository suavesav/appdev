package com.example.bookApp1;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Date;

public class BookAppActivity1 extends Activity{
    /**
     * Called when the activity is first created.
     */

    ImageButton btn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn = (ImageButton)findViewById(R.id.imageButton);
        updateTime();

    }

    public void clicked(View view)
    {
        updateTime();
    }

    private void updateTime()
    {
        btn.setImageDrawable(Drawable.createFromPath("other_robot"));
    }
}
