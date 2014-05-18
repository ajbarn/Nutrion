package com.cass.nutrition.app.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.cass.nutrition.app.R;


public class MainActivity extends Activity {

    boolean doesAlexSuck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View mView = findViewById(R.id.whole_home_screen);
        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = (TextView) findViewById(R.id.home_text_view);
                if (doesAlexSuck) {
                    tv.setText(R.string.hello_world);
                    doesAlexSuck = false;
                    findViewById(R.id.spinner).setVisibility(View.GONE);
                } else {
                    tv.setText(R.string.yes);
                    doesAlexSuck = true;
                    findViewById(R.id.spinner).setVisibility(View.VISIBLE);
                }
            }
        });

        mView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                startActivity(new Intent(MainActivity.this, MealPlan.class));

                return true;
            }
        });
        Log.d("CASS", "this app rocks!!");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Log.d("FIRE", "selected settings");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
