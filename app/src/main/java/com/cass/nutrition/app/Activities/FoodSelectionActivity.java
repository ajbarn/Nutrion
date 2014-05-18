package com.cass.nutrition.app.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cass.nutrition.app.Adapters.StableArrayAdapter;
import com.cass.nutrition.app.Constants;
import com.cass.nutrition.app.Models.Food;
import com.cass.nutrition.app.R;

import java.util.ArrayList;

/**
 * Created by Soph on 5/17/2014.
 */
public class FoodSelectionActivity extends Activity {

    public static final String FOODNAME = "FOOD_NAME";

    private final String[] tempFood = {"Apple", "Banana", "Cheese", "Dog Food", "Elephant Steak", "Fish", "Granola", "Hockey Tape",
            "Indian Butter Chicken", "Jube- jubes","Kilograms", "Kilos", "Kill", "kites", "kangaroos" };
    private final String[] tempCalorie = {"10", "20", "30", "40", "Elephant Steak", "Fish", "Granola", "Hockey Tape",
            "Indian Butter Chicken", "Jube- jubes","Kilograms", "Kilos", "Kill", "kites", "kangaroos"};
    private final ArrayList<Food> tempFoodList = new ArrayList<Food>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_food_selection);
        ListView listView = (ListView) findViewById(R.id.food_list_view);
        for(int i = 0; i < tempFood.length; i++) {
            Food food = new Food(tempFood[i], tempCalorie[i]);
            tempFoodList.add(food);
        }
        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, tempFoodList);
        listView.setAdapter(adapter);

        ArrayList<String> dropDownList = new ArrayList<String>();
        for (String s : tempFood) {
            dropDownList.add(s);
        }

        ArrayAdapter<String> textAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, dropDownList);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.search_bar);
        textView.setAdapter(textAdapter);

        String name = "Shane";
        getActionBar().setTitle(name + " Meal Plan");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                TextView mView = (TextView)view.findViewById(R.id.food_name);
                String text = mView.getText().toString();
                Log.d("ASDF", "you have clicked " + text);
                TextView mQiew = (TextView)view.findViewById(R.id.calorie_count);
                String text2 = mQiew.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString(Constants.FOOD_NAME, text);
                bundle.putString(Constants.CALORIE_AMOUNT, text2);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                setResult(90, intent);
                finish();
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_food_selection, menu);
            return true;
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.settings:
                Log.d("ASDF", "settings clicked");
                Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
                break;
            default:
                Log.d("ASDF", "Don't know how you ended up here");
        }

        return super.onOptionsItemSelected(item);
    }
}
