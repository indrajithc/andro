package com.example.readnddisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        input = (TextView) findViewById(R.id.input);
    }

    public void readMe(View view) {
        String inputString = String.valueOf(input.getText());

        Toast.makeText(this, inputString, Toast.LENGTH_SHORT).show();

    }
}
