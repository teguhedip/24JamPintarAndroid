package com.teguhediprasetyo.www.a24jampintarandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPicker;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPicker = (Button) findViewById(R.id.btn_picker);

        btnPicker.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_picker :

                Toast.makeText(MainActivity.this, "App Picker", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
