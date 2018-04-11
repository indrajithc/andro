package com.example.navigation;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ip = (EditText) findViewById(R.id.ip);
    }

    public void toNextPage(View view) {
        if( TextUtils.isEmpty(ip.getText())){
            ip.setError( "field is required!" );

        }else{

            Intent intent = new Intent( MainActivity.this, ShowData.class);
            intent.putExtra("message", ip.getText().toString());
            startActivity(intent);
        }

    }
}
