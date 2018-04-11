package com.example.openaurl;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
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

        try {

            if( TextUtils.isEmpty(ip.getText())){
                ip.setError( "field is required!" );
            }else{
                String potentialUrl = String.valueOf(ip.getText());

                if( Patterns.WEB_URL.matcher(potentialUrl).matches()){



                    Uri uri = Uri.parse(potentialUrl); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);


                } else {
                    ip.setError( "invalid url" );
                }
            }
        } catch (Exception e){
            Log.e("ERROR", e.getMessage());
            ip.setError( "invalid url add http:// as prefix" );
        }



    }
}
