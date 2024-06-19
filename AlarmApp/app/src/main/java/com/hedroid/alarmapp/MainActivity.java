package com.hedroid.alarmapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    static final int ALARM_REQ_CODE =100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.editTime);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        findViewById(R.id.btnSet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int time=Integer.parseInt(((EditText) (findViewById(R.id.editTime))).getText().toString());
                long triggerTime=System.currentTimeMillis()+(time*1000);
                Intent iBroadCast= new Intent(MainActivity.this, MyReceiver.class);
                PendingIntent pi= PendingIntent.getBroadcast(MainActivity.this,ALARM_REQ_CODE,iBroadCast,PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime,pi);
            }
        });

    }
}