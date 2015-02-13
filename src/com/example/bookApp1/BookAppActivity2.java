package com.example.bookApp1;

/**
 * Created by Sav on 2/2/15.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.app.ListActivity;
import android.widget.ListView;
import android.widget.TextView;


public class BookAppActivity2 extends ListActivity{
    private TextView selection;
    private static final String[] items= {"Find Location", "Academic", "Residence", "Sports", "Fountain Run"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen2);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
        selection = (TextView)findViewById(R.id.selection);

        Button buttonBack = (Button) findViewById(R.id.back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BookAppActivity1.class));
            }
        });
    }

    public void onListItemClick(ListView parent, View v, int position, long id)
    {
        selection.setText(items[position]);
    }
}
