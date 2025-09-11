package com.example.listycity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList; // for list
    ArrayAdapter<String> cityAdapter;  // for list
    ArrayList<String > dataList;  // for list

    EditText cityInput;  // for text box

    // buttons
    Button addCityButton;
    Button removeCityButton;
    Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        cityInput = findViewById(R.id.city_input);
        addCityButton = findViewById(R.id.add_city);
        removeCityButton = findViewById(R.id.del_city);
        confirmButton = findViewById(R.id.confirm_button);

        String []cities = {"Edmonton", "Vancouver", "Moscow", "Sydney", "Berlin", "Vienna", "Beijing", "Osaka", "New Delhi", "London", "Tokyo", "Paris"};

        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);
    }

    private void addCity(){

    }

    private void removeCity(){

    }

    private void confirm(){

    }
}