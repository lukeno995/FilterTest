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

    public static void savePassenger(FilterPassenger passenger, Context ctx){
        ArrayList<FilterPassenger> filterPassengers;
        SharedPreferences pref = ctx.getSharedPreferences("LISTA",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        filterPassengers = getPassenger(ctx);
        filterPassengers.add(passenger);
        Gson gson = new Gson();
        String json = gson.toJson(filterPassengers);
        edit.putString("jsonString", json);
        edit.commit();
    }
    public static void savePassengers(ArrayList<FilterPassenger> passengers, Context ctx){
        SharedPreferences pref = ctx.getSharedPreferences("LISTA",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        Gson gson = new Gson();
        String json = gson.toJson(passengers);
        edit.putString("jsonString", json);
        edit.commit();
    }

    public static void changeCheck(FilterPassenger passenger, Context ctx){
        ArrayList<FilterPassenger> filterPassengers = getPassenger(ctx);
        ArrayList<FilterPassenger> filter2 = new ArrayList<>();
        for(FilterPassenger fp:filterPassengers){
            if(!fp.equals(passenger)){
                filter2.add(fp);
            }else{
                filter2.add(passenger);
            }
        }
        savePassengers(filter2,ctx);
    }

    public static ArrayList<FilterPassenger> getPassenger(Context ctx){
        ArrayList<FilterPassenger> filterPassengers;
        SharedPreferences pref = ctx.getSharedPreferences("LISTA",Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = pref.getString("jsonString",null);
        if(json == null){
            filterPassengers = new ArrayList<>();
        }else{
            Type type = new TypeToken<ArrayList<FilterPassenger>>(){}.getType();
            filterPassengers = gson.fromJson(json,type);

        }
        return filterPassengers;
    }
}
