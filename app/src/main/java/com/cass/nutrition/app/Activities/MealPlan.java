package com.cass.nutrition.app.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.cass.nutrition.app.Adapters.StableArrayAdapter;
import com.cass.nutrition.app.Constants;
import com.cass.nutrition.app.Models.Food;
import com.cass.nutrition.app.R;

import java.util.ArrayList;

/**
 * Created by Cass on 17/05/2014.
 */
public class MealPlan extends Activity{

    private ArrayList<Food> MFoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MFoods = new ArrayList<Food>();
        setContentView(R.layout.activity_mealplan);
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
            startActivityForResult(new Intent(MealPlan.this, FoodSelectionActivity.class), 90);
                break;
            default:
            Toast.makeText(getBaseContext(), "Baaaaah says the sheep", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("ASDF", "you are here");
        if (resultCode == 90 && data != null) {
            Bundle bundle = data.getExtras();
            String foodName = bundle.getString(Constants.FOOD_NAME);
            String CALs = bundle.getString(Constants.CALORIE_AMOUNT);

            Toast.makeText(MealPlan.this, foodName, Toast.LENGTH_SHORT).show();
            Toast.makeText(MealPlan.this, CALs, Toast.LENGTH_SHORT).show();

            MFoods.add(new Food(foodName,CALs));
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView listView = (ListView) findViewById(R.id.food_list_view);

        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, MFoods);
        listView.setAdapter(adapter);

    }
}
