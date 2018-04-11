package com.example.simplecalculator;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText n1, n2;
    TextView op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = (EditText) findViewById(R.id.number1);
        n2 = (EditText) findViewById(R.id.number2);
        op = (TextView) findViewById(R.id.op);
    }

    public void bS(View view) {
        String temp = String.valueOf(n1.getText());
        long nu1 = Long.parseLong(temp);
        temp = String.valueOf(n2.getText());
        long nu2 = Long.parseLong(temp);
        long result = nu1 + nu2;
        op.setText( String.valueOf(result));
    }

    public void bD(View view) {


        String temp = String.valueOf(n1.getText());
        long nu1 = Long.parseLong(temp);
        temp = String.valueOf(n2.getText());
        long nu2 = Long.parseLong(temp);
        long result = nu1 - nu2;
        op.setText( String.valueOf(result));


    }

    public void bP(View view) {


        String temp = String.valueOf(n1.getText());
        long nu1 = Long.parseLong(temp);
        temp = String.valueOf(n2.getText());
        long nu2 = Long.parseLong(temp);
        long result = nu1 * nu2;
        op.setText( String.valueOf(result));
    }
}
