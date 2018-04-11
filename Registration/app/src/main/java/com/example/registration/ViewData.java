package com.example.registration;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.Calendar;

public class ViewData extends AppCompatActivity {

    TextView fname, lname, mname,  email, dob, occupation, sex, mobile;



    TextView house_name, location, street, post, district, state, pin ;



    final Calendar myCalendar = Calendar.getInstance();

    final String PREFS_NAME = "UserFile";


    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);


        inIt();




        Bundle resp = getIntent().getExtras();

        Log.d("NNNNNNNNNNNNNNNNNNNNNNNnnn", resp.getString("valueFname"));

      try {


          fname.setText(resp.getString("valueFname"));
          lname.setText(resp.getString("valueLname"));
          mname.setText(resp.getString("valueMname"));
          dob.setText(resp.getString("valueDob"));
          email.setText(resp.getString("valueEmail"));
          mobile.setText(resp.getString("mobile"));



          String valueAddress = "";
          valueAddress =  valueAddress + resp.getString("house_name") + ", " + System.getProperty("line.separator");

          try {
              String temp = resp.getString("location");
              if (temp != null && !temp.isEmpty()) {
                  valueAddress =  valueAddress + resp.getString("location") + ", " + System.getProperty("line.separator");
              }
          } catch (Exception e){}




          house_name.setText(resp.getString("valuehouse_name") );
          location.setText(resp.getString("valuelocation") );
          street.setText(resp.getString("valuestreet") );
          post.setText(resp.getString("valuepost") );
          district.setText(resp.getString("valuedistrict") );
          state.setText(resp.getString("valuestate") );
          pin.setText(resp.getString("valuepin") );





          occupation.setText(resp.getString("valueOccupation"));
          sex.setText(resp.getString("valueSex"));

      } catch (Exception e){}


    }



    @SuppressLint("WrongViewCast")
    private void inIt() {


        fname = (TextView) findViewById(R.id.fname);
        lname = (TextView) findViewById(R.id.lname);
        mname = (TextView) findViewById(R.id.mname);
        dob = (TextView) findViewById(R.id.dob);
        email = (TextView) findViewById(R.id.email);
        mobile = (TextView) findViewById(R.id.mobile);

        house_name = (TextView) findViewById(R.id.house_name);
        location = (TextView) findViewById(R.id.location);
        street = (TextView) findViewById(R.id.street);
        post = (TextView) findViewById(R.id.post);
        district = (TextView) findViewById(R.id.district);
        state = (TextView) findViewById(R.id.state);
        pin = (TextView) findViewById(R.id.pin);




        occupation = (TextView) findViewById(R.id.occupation);
        sex = (TextView) findViewById(R.id.sex);





    }





    public static String insertPeriodically(
            String text, String insert, int period)
    {
        StringBuilder builder = new StringBuilder(
                text.length() + insert.length() * (text.length()/period)+1);

        int index = 0;
        String prefix = "";
        while (index < text.length())
        {
            // Don't put the insert in the very first iteration.
            // This is easier than appending it *after* each substring
            builder.append(prefix);
            prefix = insert;
            builder.append(text.substring(index,
                    Math.min(index + period, text.length())));
            index += period;
        }
        return builder.toString();
    }

}
