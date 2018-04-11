package com.example.registration.validator;

import android.widget.TextView;

import java.util.regex.Pattern;

/**
 * Created by stud on 13/3/18.
 */


public class Rules {


    public static boolean validate(TextView editText, String type){
        boolean  status =  false ;

        if (!isSomething( editText))
            return !status;

        switch (type){

            case "mobile" :
                status = isMobile(editText);
                break;

            case "email" :
                status = isEmail(editText);
                break;

            case "pin" :
                status = isPin(editText);
                break;

            case "aadhar" :
                status = isAadhar(editText);
                break;


            default:

                break;
        }





        return status ;
    }








    private static boolean isMobile(TextView editText){
        boolean  status =  false ;

        String phone = editText.getText().toString().trim();
        if (phone.length() == 10) {
            status = android.util.Patterns.PHONE.matcher(phone).matches();
        }

        if(!status)
            editText.setError("invalid mobile number");

        return !status ;

    }

    private static boolean isPin(TextView editText){
        boolean  status =  false ;

        String phone = editText.getText().toString().trim();
        if (phone.length() == 6) {
            status = true;
        }

        if(!status)
            editText.setError("invalid pin code");

        return !status ;

    }
    private static boolean isEmail(TextView editText){
        boolean  status =  false ;

        String email = editText.getText().toString().trim();

        status = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        if(!status)
            editText.setError("invalid email id");

        return !status ;

    }


    private static boolean isAadhar(TextView editText){
        boolean  status =  false ;

        String aadharNumber = editText.getText().toString().trim();

        Pattern aadharPatterns = Pattern.compile("\\d{12}");
        status = aadharPatterns.matcher(aadharNumber).matches();
        if(status){
            status = VerhoeffAlgorithm.validateVerhoeff(aadharNumber);
        }

        if(!status)
            editText.setError("invalid aadhar number");



        return !status ;

    }

    private static  boolean isSomething(TextView editText) {
        boolean  status =  false ;
        String text =  null;
        try {
            text = editText.getText().toString().trim();


        } catch (Exception e){
            editText.setError("invalid data");
            return status;
        }


        if (text != null && !text.isEmpty()) {
            status =  true ;
        }

        if(!status)
            editText.setError("this field is required");


        return status;

    }



}


class VerhoeffAlgorithm{
    static int[][] d  = new int[][]
            {
                    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                    {1, 2, 3, 4, 0, 6, 7, 8, 9, 5},
                    {2, 3, 4, 0, 1, 7, 8, 9, 5, 6},
                    {3, 4, 0, 1, 2, 8, 9, 5, 6, 7},
                    {4, 0, 1, 2, 3, 9, 5, 6, 7, 8},
                    {5, 9, 8, 7, 6, 0, 4, 3, 2, 1},
                    {6, 5, 9, 8, 7, 1, 0, 4, 3, 2},
                    {7, 6, 5, 9, 8, 2, 1, 0, 4, 3},
                    {8, 7, 6, 5, 9, 3, 2, 1, 0, 4},
                    {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}
            };
    static int[][] p = new int[][]
            {
                    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9},
                    {1, 5, 7, 6, 2, 8, 3, 0, 9, 4},
                    {5, 8, 0, 3, 7, 9, 6, 1, 4, 2},
                    {8, 9, 1, 6, 0, 4, 3, 5, 2, 7},
                    {9, 4, 5, 3, 1, 2, 6, 8, 7, 0},
                    {4, 2, 8, 6, 5, 7, 3, 9, 0, 1},
                    {2, 7, 9, 3, 8, 0, 6, 4, 1, 5},
                    {7, 0, 4, 6, 9, 1, 3, 2, 5, 8}
            };
    static int[] inv = {0, 4, 3, 2, 1, 5, 6, 7, 8, 9};

    public static boolean validateVerhoeff(String num){
        int c = 0;
        int[] myArray = StringToReversedIntArray(num);
        for (int i = 0; i < myArray.length; i++){
            c = d[c][p[(i % 8)][myArray[i]]];
        }

        return (c == 0);
    }
    private static int[] StringToReversedIntArray(String num){
        int[] myArray = new int[num.length()];
        for(int i = 0; i < num.length(); i++){
            myArray[i] = Integer.parseInt(num.substring(i, i + 1));
        }
        myArray = Reverse(myArray);
        return myArray;
    }
    private static int[] Reverse(int[] myArray){
        int[] reversed = new int[myArray.length];
        for(int i = 0; i < myArray.length ; i++){
            reversed[i] = myArray[myArray.length - (i + 1)];
        }
        return reversed;
    }
}