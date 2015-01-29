package com.example.bookApp1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
}
