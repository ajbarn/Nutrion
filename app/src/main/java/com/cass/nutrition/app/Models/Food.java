package com.cass.nutrition.app.Models;

/**
 * Created by Soph on 5/17/2014.
 */
public class Food {
    private String mName;
    private String mCalories;

    public Food(String name, String calories) {
        mName = name;
        mCalories = calories;
    }

    public String getName() {
        return mName;
    }

    public String getCalories() {
        return mCalories;
    }
}
