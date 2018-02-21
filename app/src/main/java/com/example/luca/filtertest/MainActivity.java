package com.example.luca.filtertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.luca.filtertest.DataStorage.SharedClass;
import com.example.luca.filtertest.Model.FilterPassenger;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements ItemListDialogFragment.Listener{
    private ArrayList<FilterPassenger> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = SharedClass.getPassenger(getApplicationContext());
        if(adapter == null){
            passengerData();
        }
    }
    private void  passengerData() {
        adapter = new ArrayList<>();
        FilterPassenger passenger = new FilterPassenger("Cod1",false);
        adapter.add(passenger);
        FilterPassenger passenger2 = new FilterPassenger("Cod2",true);
        adapter.add(passenger2);
        FilterPassenger passenger3 = new FilterPassenger("Cod3",false);
        adapter.add(passenger3);

    }
    public void Filter(View view) {
        ItemListDialogFragment bottomSheetFragment = new ItemListDialogFragment();
        Bundle x = new Bundle();
        x.putSerializable("adapter" , adapter);
        bottomSheetFragment.setArguments(x);
        bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());
    }
    @Override
    public void check(int position) {
        adapter.get(position).setCheck(true);
        SharedClass.savePassengers(adapter,getApplicationContext());
    }
    @Override
    public void unCheck(int position) {
        adapter.get(position).setCheck(false);
        SharedClass.savePassengers(adapter,getApplicationContext());
    }
}
