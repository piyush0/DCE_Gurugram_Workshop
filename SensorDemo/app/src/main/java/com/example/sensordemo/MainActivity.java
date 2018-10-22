package com.example.sensordemo;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.LocationManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout cl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cl = findViewById(R.id.layout);

        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);

        SensorEventListener sel = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float x = sensorEvent.values[0];
                float y = sensorEvent.values[1];
                float z = sensorEvent.values[2];

                int r = scale(x);
                int g = scale(y);
                int b = scale(z);

                cl.setBackgroundColor(Color.rgb(r,g,b));


            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };

        sm.registerListener(sel, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), 100);

    }

    public int scale(float inp){
//        22y = 255x + 255*11;

        float temp = inp*255;
        temp= temp + 255*11;

        temp = temp/22;

        return (int)temp;
    }
}
