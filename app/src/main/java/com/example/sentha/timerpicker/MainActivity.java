package com.example.sentha.timerpicker;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompactivity {

        EditText editTextDate, editTextTime;
         Button buttonDate, buttonTime;

       DatePickerDialog datePickerDialog;
       TimePickerDialog timePickerDialog;

           @Override
           protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);

           editTextDate = (EditText) findViewById(R.id.editTextDate);
           editTextTime = (EditText) findViewById(R.id.editTextTime);

            buttonDate = (Button) findViewById(R.id.buttonDatePicker);
             buttonTime = (Button) findViewById(R.id.buttonTimePicker);

             buttonDate.setOnClickListener((View.OnClickListener) this);
              buttonTime.setOnClickListener((View.OnClickListener) this);

               }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonDatePicker :
                Calendar calendar=Calendar.getInstance();
                int _year =calendar.get(Calendar.YEAR);
                int _month =calendar.get(Calendar.MONTH);
                int _day= calendar.get(Calendar.DAY_OF_MONTH);

                 datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        editTextDate.setText(dayOfMonth + ":" + month + ":" + year);
                    }
                }, _year, _month, _day);

                    datePickerDialog.show();

                break;
            case R.id.buttonTimePicker :

                 Calendar calendar1=Calendar.getInstance();
                 int _hour = calendar1.get(Calendar.HOUR);
                 int _minute = calendar1.get(Calendar.MINUTE);

                 timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                     @Override
                     public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                         editTextTime.setText(hourOfDay + ":" +minute);
                     }
                 },_hour, _minute,false);
                    timePickerDialog.show();
                    break;
        };


        }
    }
