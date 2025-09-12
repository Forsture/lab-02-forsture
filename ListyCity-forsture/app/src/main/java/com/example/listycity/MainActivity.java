package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;





import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList; // for list
    ArrayAdapter<String> cityAdapter;  // for list
    ArrayList<String > dataList;  // for list

    EditText cityInput;  // for text box

    // buttons
    Button addCityButton, removeCityButton, confirmButton;

    // list interaction
    String selectedCity = null;
    View selectedView = null;

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

        addCityButton.setOnClickListener(new View.OnClickListener() { // add button
            @Override
            public void onClick(View v) {
                cityInput.setText("");
                //Toast.makeText(MainActivity.this, "Add City", Toast.LENGTH_SHORT).show();;
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {  // confirm button
            @Override
            public void onClick(View v) {
                addCity();
            }
        });

        removeCityButton.setOnClickListener(new View.OnClickListener() {  // remove button
            @Override
            public void onClick(View v) {
                removeCity();
            }
        });

        cityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {  // list interaction stuff
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                clearSelection();
                selectedCity = dataList.get(position);
                selectedView = view;
                view.setBackgroundColor(0xffffff00);
                //Toast.makeText(MainActivity.this, "Selected: " + selectedCity, Toast.LENGTH_SHORT).show();
            }
        });

        }

    private void addCity(){
        String city = cityInput.getText().toString();  // get text from input make it a string ig
        if (dataList.contains(city)){
            Toast.makeText(this, "City already in list", Toast.LENGTH_SHORT).show();
            return;
        }

        dataList.add(city);
        cityAdapter.notifyDataSetChanged();
        cityInput.setText("");
        Toast.makeText(this, "Added: " + city, Toast.LENGTH_SHORT).show();

    }

    private void removeCity(){
        if (dataList.contains(selectedCity)){
            dataList.remove(selectedCity);
            cityAdapter.notifyDataSetChanged();
            clearSelection();
            Toast.makeText(this, "Removed:" + selectedCity, Toast.LENGTH_SHORT).show();
        }

    }
    //clear city selected
    private void clearSelection() {
        if (selectedView != null) {
            selectedView.setBackgroundColor(0);
        }
        selectedCity = null;
        selectedView = null;
    }

}
