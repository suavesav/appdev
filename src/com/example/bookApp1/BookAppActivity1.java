package com.example.bookApp1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class BookAppActivity1 extends Activity implements CompoundButton.OnCheckedChangeListener{
    /**
     * Called when the activity is first created.
     */

    CheckBox cb;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        cb = (CheckBox)findViewById(R.id.checkBox);
        cb.setOnCheckedChangeListener(this);
    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
    {
        if(isChecked)
        {
            cb.setText("The box is checked");
        }
        else
        {
            cb.setText("The box is unchecked");
        }

    }
}
