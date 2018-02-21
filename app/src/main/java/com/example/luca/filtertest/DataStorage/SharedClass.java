package com.example.luca.filtertest.DataStorage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.luca.filtertest.Model.FilterPassenger;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by Luca on 20/02/2018.
 */

public class SharedClass {
    public static void savePassengers(ArrayList<FilterPassenger> passengers, Context ctx){
        SharedPreferences pref = ctx.getSharedPreferences("LISTA",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        Gson gson = new Gson();
        String json = gson.toJson(passengers);
        edit.putString("jsonString", json);
        edit.commit();
    }
    public static ArrayList<FilterPassenger> getPassenger(Context ctx){
        ArrayList<FilterPassenger> filterPassengers = null;
        SharedPreferences pref = ctx.getSharedPreferences("LISTA",Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = pref.getString("jsonString",null);
        if(json != null){
            Type type = new TypeToken<ArrayList<FilterPassenger>>(){}.getType();
            filterPassengers = gson.fromJson(json,type);
            return  filterPassengers;
        }
        return filterPassengers;
    }
}
