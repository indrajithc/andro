package com.example.menu;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.intent1:

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);

                return true;

            case R.id.intent2:

                Uri i  = Uri.parse("https://google.co.in");
                Intent ik = new Intent(Intent.ACTION_VIEW, i);

                startActivity(ik);


                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

