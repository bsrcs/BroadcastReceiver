package com.bsr.broadcastreciever;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextTime;
    //sure bittiginde zaman tukendi deyip 2sn boyunca telefonu titret
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTime = (EditText) findViewById(R.id.editTextTime);
    }

    public void buttonStart(View view) {
        //get the input from user as an int
        int inputTime = Integer.parseInt(editTextTime.getText().toString()); //3

        //depends on system time broadcast will happen.
        // intent will take us to intent class.
        Intent intent = new Intent(this, MyBroadcastRecieer.class);
        //pendingintent will run the intent
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent,0);

        //get the system time
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        // After 3 sec it will go to pendingintent
        alarmManager.set(AlarmManager.RTC_WAKEUP, java.lang.System.currentTimeMillis()+(inputTime*1000),pendingIntent);

        Toast.makeText(this, "Alarm is set to "+ inputTime+ " sec", Toast.LENGTH_SHORT).show();
    }
}
