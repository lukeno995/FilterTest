package com.example.luca.filtertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.luca.filtertest.DataStorage.SharedClass;
import com.example.luca.filtertest.Model.FilterPassenger;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements ItemListDialogFragment.Listener{
    private ArrayList<FilterPassenger> filterList = new ArrayList<>();
    private ArrayList<FilterPassenger> passengerData() {

        FilterPassenger passenger = new FilterPassenger("Cod1",false);
        filterList.add(passenger);
        FilterPassenger passenger2 = new FilterPassenger("Cod2",true);
        filterList.add(passenger2);
        FilterPassenger passenger3 = new FilterPassenger("Cod3",false);
        filterList.add(passenger3);
        return filterList;
    }
    private ArrayList<FilterPassenger> adapter = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = SharedClass.getPassenger(getApplicationContext());
        if(adapter.size() == 0){
            for(FilterPassenger fp:passengerData()){
                SharedClass.savePassenger(fp,getApplicationContext());
            }
                adapter = SharedClass.getPassenger(getApplicationContext());
        }

    }
    public void Filter(View view) {
        ItemListDialogFragment bottomSheetFragment = new ItemListDialogFragment();
        Bundle x = new Bundle();
        x.putSerializable("adapter" , adapter);
        bottomSheetFragment.setArguments(x);
        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
    }




}
