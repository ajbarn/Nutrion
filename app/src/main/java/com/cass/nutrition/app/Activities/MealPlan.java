package com.cass.nutrition.app.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.cass.nutrition.app.R;

/**
 * Created by Cass on 17/05/2014.
 */
public class MealPlan extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mealplan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int ID = item.getItemId();
        switch(ID){
            case R.id.addMealPlan:
            startActivity(new Intent(MealPlan.this, FoodSelectionActivity.class));
                break;
            default:
            Toast.makeText(getBaseContext(), "Baaaaah says the sheep", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
