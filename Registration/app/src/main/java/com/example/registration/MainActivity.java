package com.example.registration;


import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.registration.validator.Rules;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText fname, lname, mname,   email, dob, occupation, mobilen ;
    RadioGroup sex;

    RelativeLayout next_button;
    TextView loginText;


    String mobile = "";
    String key = "";



    EditText house_name, location, street, post, district, state, pin ;

    final Calendar myCalendar = Calendar.getInstance();

    final String PREFS_NAME = "UserFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inIt();
    }



    private void  inIt(){



        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        mname = (EditText) findViewById(R.id.mname);
        dob = (EditText) findViewById(R.id.dob);
        email = (EditText) findViewById(R.id.email);
        mobilen = (EditText) findViewById(R.id.mobiles);



        house_name = (EditText) findViewById(R.id.house_name);
        location = (EditText) findViewById(R.id.location);
        street = (EditText) findViewById(R.id.street);
        post = (EditText) findViewById(R.id.post);
        district = (EditText) findViewById(R.id.district);
        state = (EditText) findViewById(R.id.state);
        pin = (EditText) findViewById(R.id.pin);


        occupation = (EditText) findViewById(R.id.occupation);

        sex = (RadioGroup) findViewById(R.id.sex);


        next_button = (RelativeLayout) findViewById(R.id.verf);
        loginText = (TextView) findViewById(R.id.otp_text);


        EditText edittext= (EditText) findViewById(R.id.dob);
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        edittext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });













    }

    private void updateLabel() {
        String myFormat = "dd-MM-yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.getDefault());

        dob.setText(sdf.format(myCalendar.getTime()));
    }


    public void saveBasicData(View view) {




        int selectedId = sex.getCheckedRadioButtonId();
// find the radiobutton by returned id
        RadioButton xsex = (RadioButton) findViewById(selectedId);
        String valueSex = (String) xsex.getText();

        final String valueFname = fname.getText().toString().trim();
        final String valueLname = lname.getText().toString().trim();
        final String valueEmail = email.getText().toString().trim();
        final String valueDob = dob.getText().toString().trim();

        final String valuehouse_name = house_name.getText().toString().trim();
        final String valuelocation = location.getText().toString().trim();
        final String valuestreet = street.getText().toString().trim();
        final String valuepost = post.getText().toString().trim();
        final String valuedistrict = district.getText().toString().trim();
        final String valuestate = state.getText().toString().trim();
        final String valuepin = pin.getText().toString().trim();


        mobile = mobilen.getText().toString().trim();






        final String valueOccupation = occupation.getText().toString().trim();
        final String valueMname = mname.getText().toString().trim();




        Log.d("DATAS", mobile);
        Log.d("DATAS", key);

//        Log.d("DATAS", valueAddress);






        Log.d("DATAS", valueDob);
        Log.d("DATAS", valueEmail);
        Log.d("DATAS", valueFname);
        Log.d("DATAS", valueLname);
        Log.d("DATAS", valueMname);
        Log.d("DATAS", valueOccupation);
        Log.d("DATAS", valueSex);



        Log.d("DATAS", valuehouse_name);
        Log.d("DATAS", valuelocation);
        Log.d("DATAS", valuestreet);
        Log.d("DATAS", valuepost);
        Log.d("DATAS", valuedistrict);
        Log.d("DATAS", valuestate);
        Log.d("DATAS", valuepin);
        Log.d("DATAS", mobile);
        Log.d("DATAS", key);

        boolean isgo = true;


        if(Rules.validate(email, "email")){
            isgo = false;
        }
        if(Rules.validate(mobilen, "mobile")){
            isgo = false;
        }

        if(Rules.validate(dob, "")){
            isgo = false;
        }

        if(Rules.validate(fname, "")){
            isgo = false;
        }

        if(valueSex.length() <4){
            Toast.makeText(this, "Select Sex", Toast.LENGTH_SHORT).show();
            isgo = false;
        }

        if(Rules.validate(lname, "")){
            isgo = false;
        }

        if(Rules.validate(occupation, "")){
            isgo = false;
        }






        if(Rules.validate(house_name, "")){
            isgo = false;
        }

        if(Rules.validate(street, "")){
            isgo = false;
        }
        if(Rules.validate(post, "")){
            isgo = false;
        }
        if(Rules.validate(district, "")){
            isgo = false;
        }
        if(Rules.validate(state, "")){
            isgo = false;
        }
        if(Rules.validate(pin, "")){
            isgo = false;
        }

        if(Rules.validate(pin, "pin")){
            isgo = false;
        }


        if(!isgo){

            Toast.makeText(this, "Invalid data", Toast.LENGTH_SHORT).show();
            return;
        }


        loginText.setText("Saving..");
        final ProgressBar progressBar = new ProgressBar(MainActivity.this, null, android.R.attr.progressBarStyleLarge);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(View.VISIBLE);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(50,50);
        params.setMargins(30, 0, 30, 0);
        params.addRule(RelativeLayout.RIGHT_OF, loginText.getId());
        next_button.addView(progressBar,params);

        next_button.setClickable(false);




        Intent intent = new Intent( MainActivity.this, ViewData.class);

        intent.putExtra("mobile",  mobile.toString());
        intent.putExtra("valuehouse_name",  valuehouse_name.toString());
        intent.putExtra("valuelocation",  valuelocation.toString());
        intent.putExtra("valuestreet",  valuestreet.toString());
        intent.putExtra("valuepost",  valuepost.toString());
        intent.putExtra("valuedistrict",  valuedistrict.toString());
        intent.putExtra("valuestate",  valuestate.toString());
        intent.putExtra("valuepin",  valuepin.toString());
        intent.putExtra("valueDob",  valueDob.toString());
        intent.putExtra("valueEmail",  valueEmail.toString());
        intent.putExtra("valueFname",  valueFname.toString());
        intent.putExtra("valueLname",  valueLname.toString());
        intent.putExtra("valueMname",  valueMname.toString());
        intent.putExtra("valueOccupation",  valueOccupation.toString());
        intent.putExtra("valueSex",  valueSex.toString());


        startActivity(intent);





    }
}
