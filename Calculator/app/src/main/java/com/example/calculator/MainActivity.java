package com.example.calculator;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private double n1 = 0, n2 = 0, result = 0;
    private char opr = ' ';

    TextView resul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resul = (TextView) findViewById(R.id.op);
    }

    public void bT7(View view) {
        resul.setText( resul.getText() + "7");
    }

    public void bT8(View view) {
        resul.setText( resul.getText() + "8");
    }

    public void bT9(View view) {
        resul.setText( resul.getText() + "9");
    }

    public void bTi(View view) {

        doOperat( '/');

    }

    public void bT4(View view) {
        resul.setText( resul.getText() + "4");
    }

    public void bT5(View view) {
        resul.setText( resul.getText() + "5");
    }

    public void bT6(View view) {
        resul.setText( resul.getText() + "6");
    }

    public void bTp(View view) {

        doOperat('*');
    }

    public void bT1(View view) {
        resul.setText( resul.getText() + "1");
    }

    public void bT2(View view) {
        resul.setText( resul.getText() + "2");
    }

    public void bT3(View view) {
        resul.setText( resul.getText() + "3");
    }

    public void bTs(View view) {

        doOperat('-');
    }

    public void bTd(View view) {
        resul.setText( resul.getText() + ".");
    }

    public void bT0(View view) {
        resul.setText( resul.getText() + "0");
    }

    public void bTe(View view) {
        doAction();
    }

    public void bTa(View view) {

        doOperat('+');
    }

    public void bBcc(View view) {
        try {
            String t = String.valueOf(resul.getText());
            System.out.println(t.substring(0, t.length() - 1 ));
            resul.setText( t.substring(0, t.length() - 1 ) );
        }catch (Exception e) {

        }
    }

    public void bBzz(View view) {

        opr = ' ';
        n1 = 0;
        n2 = 0;
        resul.setText("0");
    }



    private void doOperat(char op){

        String t = String.valueOf(resul.getText());

        if(opr == ' ') {

            opr = op;
            try {
                if(t.charAt(t.length() - 1) == '.')
                    t = t + '0';
                n1 = Double.parseDouble(t);
            }catch (Exception e) {

            }

        }else {


            try {
                if(t.charAt(t.length() - 1) == '.')
                    t = t + '0';
                n2 = Double.parseDouble(t);
            }catch (Exception e) {

            }

            doAction();
            opr = op;

            t = String.valueOf(resul.getText());


            try {
                if(t.charAt(t.length() - 1) == '.')
                    t = t + '0';
                n1 = Double.parseDouble(t);
            }catch (Exception e) {

            }

        }



        resul.setText("");


    }
    private void doAction() {
        String t = String.valueOf(resul.getText());

        try {

            if(t.charAt(t.length() - 1) == '.')
                t = t + '0';
            n2 = Double.parseDouble(t);

        } catch (Exception e) {

        }

        double res = 0;

        switch (opr) {
            case '+':
                res = n1 + n2;
                break;
            case '-':
                res = n1 - n2;
                break;

            case '*':
                res = n1 * n2;
                break;

            case '/':
                res = n1 / n2;
                break;

            default:


        }


        resul.setText(String.valueOf(res));
        opr = ' ';
        n1 = 0;
        n2 = 0;

    }


}
