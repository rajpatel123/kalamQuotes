package com.mycomputer.kalamnew;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class Notification extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {


    private Button startNotification, changeNotification, stopNotification, back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        startNotification = findViewById(R.id.button1);
        changeNotification = findViewById(R.id.buttton2);
        stopNotification = findViewById(R.id.button3);
        back = findViewById(R.id.button4);

        startNotification.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");

            }
        });
        changeNotification.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");

            }
        });
        stopNotification.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Notification.this, NavigationActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {

    }
}


