package com.cass.nutrition.app.Activities;

import android.app.Activity;
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
import com.cass.nutrition.app.R;

import java.util.ArrayList;

/**
 * Created by Soph on 5/17/2014.
 */
public class FoodSelectionActivity extends Activity {

    private final String[] tempFood = {"Apple", "Banana", "Cheese", "Dog Food", "Elephant Steak", "Fish", "Granola", "Hockey Tape", "Indian Butter Chicken", "Jube- jubes","Kilograms", "Kilos", "Kill", "kites", "kangaroos" };
    private final ArrayList<String> tempFoodList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_food_selection);
        ListView listView = (ListView) findViewById(R.id.food_list_view);
        for(String s : tempFood) {
            tempFoodList.add(s);
        }
        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, tempFoodList);
        listView.setAdapter(adapter);

        ArrayAdapter<String> textAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, tempFoodList);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.search_bar);
        textView.setAdapter(textAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                TextView mView = (TextView)view.findViewById(R.id.secondLine);
                String text = mView.getText().toString();
                Log.d("ASDF", "you have clicked " + text);
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
