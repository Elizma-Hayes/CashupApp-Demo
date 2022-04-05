package com.example.cashup;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CashUpActivity extends AppCompatActivity {

    public static final String ARG_FROM_MAIN = "arg";

    double cash = 0;

    EditText rwlblFloat;

    TextView rwlblSubTot;
    TextView rwlblTipTot;


    EditText rwlblFCQty;
    TextView rwlblFCSub;
    TextView rwlblFCTake;

    EditText rwlblORQty;
    TextView rwlblORSub;
    TextView rwlblORTake;

    EditText rwlblTRQty;
    TextView rwlblTRSub;
    TextView rwlblTRTake;

    EditText rwlblFRQty;
    TextView rwlblFRSub;
    TextView rwlblFRTake;

    EditText rwlblTeRQty;
    TextView rwlblTeRSub;
    TextView rwlblTeRTake;

    EditText rwlblTwRQty;
    TextView rwlblTwRSub;
    TextView rwlblTwRTake;

    EditText rwlblFfRQty;
    TextView rwlblFfRSub;
    TextView rwlblFfRTake;

    EditText rwlblOhRQty;
    TextView rwlblOhRSub;
    TextView rwlblOhRTake;

    EditText rwlblThRQty;
    TextView rwlblThRSub;
    TextView rwlblThRTake;

    int iCount200 = 0;
    int iCount100 = 0;
    int iCount50 = 0;
    int iCount20 = 0;
    int iCount10 = 0;
    int iCount5 = 0;
    int iCount2 = 0;
    int iCount1 = 0;
    int iCount50c = 0;

    double Qty200 = 0;
    double Qty100 = 0;
    double Qty50 = 0;
    double Qty20 = 0;
    double Qty10 = 0;
    double Qty5 = 0;
    double Qty2 = 0;
    double Qty1 = 0;
    double Qty50c = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_up);

        isImportantDate();


        Button btnCalc = (Button) findViewById(R.id.btnCalc);
        Button btnNext = (Button) findViewById(R.id.btnNext);
        Button btnReset = (Button) findViewById(R.id.btnReset);

        rwlblSubTot= (TextView) findViewById(R.id.rwlblSubTot);
        rwlblTipTot= (TextView) findViewById(R.id.rwlblTipTot);


        rwlblFloat = (EditText) findViewById(R.id.rwlblFloat);

        rwlblFCQty = (EditText) findViewById(R.id.rwlblFCQty);
        rwlblFCSub= (TextView) findViewById(R.id.rwlblFCSub);
        rwlblFCTake = (TextView) findViewById(R.id.rwlblFCTake);

        rwlblORQty= (EditText) findViewById(R.id.rwlblORQty);
        rwlblORSub= (TextView) findViewById(R.id.rwlblORSub);
        rwlblORTake= (TextView) findViewById(R.id.rwlblORTake);

        rwlblTRQty = (EditText) findViewById(R.id.rwlblTRQty);
        rwlblTRSub= (TextView) findViewById(R.id.rwlblTRSub);
        rwlblTRTake = (TextView) findViewById(R.id.rwlblTRTake);

        rwlblFRQty = (EditText) findViewById(R.id.rwlblFRQty);
        rwlblFRSub= (TextView) findViewById(R.id.rwlblFRSub);
        rwlblFRTake = (TextView) findViewById(R.id.rwlblFRTake);

        rwlblTeRQty= (EditText) findViewById(R.id.rwlblTeRQty);
        rwlblTeRSub= (TextView) findViewById(R.id.rwlblTeRSub);
        rwlblTeRTake= (TextView) findViewById(R.id.rwlblTeRTake);

        rwlblTwRQty= (EditText) findViewById(R.id.rwlblTwRQty);
        rwlblTwRSub= (TextView) findViewById(R.id.rwlblTwRSub);
        rwlblTwRTake= (TextView) findViewById(R.id.rwlblTwRTake);

        rwlblFfRQty= (EditText) findViewById(R.id.rwlblFfRQty);
        rwlblFfRSub= (TextView) findViewById(R.id.rwlblFfRSub);
        rwlblFfRTake= (TextView) findViewById(R.id.rwlblFfRTake);

        rwlblOhRQty= (EditText) findViewById(R.id.rwlblOhRQty);
        rwlblOhRSub= (TextView) findViewById(R.id.rwlblOhRSub);
        rwlblOhRTake= (TextView) findViewById(R.id.rwlblOhRTake);

        rwlblThRQty= (EditText) findViewById(R.id.rwlblThRQty);
        rwlblThRSub= (TextView) findViewById(R.id.rwlblThRSub);
        rwlblThRTake= (TextView) findViewById(R.id.rwlblThRTake);


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
              public void onClick(View v) {

                rwlblFloat.setText("");
                rwlblFloat.setTextColor(Color.rgb(0,0,0));

                rwlblFCQty.setText("");
                rwlblFCQty.setTextColor(Color.rgb(0,0,0));
                rwlblFCSub.setText("");
                rwlblFCTake.setText("");

                rwlblORQty.setText("");
                rwlblORQty.setTextColor(Color.rgb(0,0,0));
                rwlblORSub.setText("");
                rwlblORTake.setText("");

                rwlblTRQty.setText("");
                rwlblTRQty.setTextColor(Color.rgb(0,0,0));
                rwlblTRSub.setText("");
                rwlblTRTake.setText("");

                rwlblFRQty.setText("");
                rwlblFRQty.setTextColor(Color.rgb(0,0,0));
                rwlblFRSub.setText("");
                rwlblFRTake.setText("");

                rwlblTeRQty.setText("");
                rwlblTeRQty.setTextColor(Color.rgb(0,0,0));
                rwlblTeRSub.setText("");
                rwlblTeRTake.setText("");

                rwlblTwRQty.setText("");
                rwlblTwRQty.setTextColor(Color.rgb(0,0,0));
                rwlblTwRSub.setText("");
                rwlblTwRTake.setText("");

                rwlblFfRQty.setText("");
                rwlblFfRQty.setTextColor(Color.rgb(0,0,0));
                rwlblFfRSub.setText("");
                rwlblFfRTake.setText("");

                rwlblOhRQty.setText("");
                rwlblOhRQty.setTextColor(Color.rgb(0,0,0));
                rwlblOhRSub.setText("");
                rwlblOhRTake.setText("");

                rwlblThRQty.setText("");
                rwlblThRQty.setTextColor(Color.rgb(0,0,0));
                rwlblThRSub.setText("");
                rwlblThRTake.setText("");

                rwlblTipTot.setText("");
                rwlblSubTot.setText("");






            }
        });

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                String error = "nul";

                    int Qty;
                    double overallTotal = 0;

                    int breakMe = 0;
                    String temp = "";

                    try { //overall Adding up

                        try {//individual adding up

                            temp = String.valueOf(rwlblFloat.getText());
                            cash = Double.parseDouble(temp);

                        } catch (Exception e) {

                            if (temp.length() == 0) {
                                rwlblFloat.setText(error);
                            }

                            rwlblFloat.setTextColor(Color.rgb(255,0,0));
                            breakMe++;


                        }


                        try {
                            Qty = Integer.parseInt(String.valueOf(rwlblFCQty.getText()));
                            Qty50c = Qty;
                            overallTotal = overallTotal + (Qty50c * 0.5);
                            rwlblFCSub.setText("R" + (Qty50c * 0.5));
                        } catch (Exception e) {

                            if (rwlblFCQty.getText().length() == 0) {
                                rwlblFCQty.setText(error);
                            }
                            rwlblFCQty.setTextColor(Color.rgb(255,0,0));
                            breakMe++;
                            rwlblFCSub.setText(error);

                        }


                        try {

                            Qty = Integer.parseInt(String.valueOf(rwlblORQty.getText()));
                            Qty1 = Qty;
                            overallTotal = overallTotal + Qty1;
                            rwlblORSub.setText("R" + Qty1);


                        } catch (Exception e) {

                            if (rwlblORQty.getText().length() == 0) {
                                rwlblORQty.setText(error);
                            }
                            rwlblORQty.setTextColor(Color.rgb(255,0,0));
                            breakMe++;
                            rwlblORSub.setText(error);
                        }

                        try {

                            Qty = Integer.parseInt(String.valueOf(rwlblTRQty.getText()));
                            Qty2 = Qty;
                            overallTotal = overallTotal + (Qty2 * 2);
                            rwlblTRSub.setText("R" + (Qty2 * 2));


                        } catch (Exception e) {

                            if (rwlblTRQty.getText().length() == 0) {
                                rwlblTRQty.setText(error);
                            }
                            rwlblTRQty.setTextColor(Color.rgb(255,0,0));
                            breakMe++;
                            rwlblTRSub.setText(error);

                        }

                        try {


                            Qty = Integer.parseInt(String.valueOf(rwlblFRQty.getText()));
                            Qty5 = Qty;
                            overallTotal = overallTotal + (Qty5 * 5);
                            rwlblFRSub.setText("R" + (Qty5 * 5));


                        } catch (Exception e) {

                            if (rwlblFRQty.getText().length() == 0) {
                                rwlblFRQty.setText(error);
                            }
                            rwlblFRQty.setTextColor(Color.rgb(255,0,0));
                            breakMe++;
                            rwlblFRSub.setText(error);
                        }

                        try {

                            Qty = Integer.parseInt(String.valueOf(rwlblTeRQty.getText()));
                            Qty10 = Qty;
                            overallTotal = overallTotal + (Qty10 * 10);
                            rwlblTeRSub.setText("R" + (Qty10 * 10));


                        } catch (Exception e) {

                            if (rwlblTeRQty.getText().length() == 0) {
                                rwlblTeRQty.setText(error);
                            }
                            rwlblTeRQty.setTextColor(Color.rgb(255,0,0));
                            breakMe++;
                            rwlblTeRSub.setText(error);
                        }

                        try {


                            Qty = Integer.parseInt(String.valueOf(rwlblTwRQty.getText()));
                            Qty20 = Qty;
                            overallTotal = overallTotal + (Qty20 * 20);
                            rwlblTwRSub.setText("R" + (Qty20 * 20));


                        } catch (Exception e) {

                            if (rwlblTwRQty.getText().length() == 0) {
                                rwlblTwRQty.setText(error);
                            }
                            rwlblTwRQty.setTextColor(Color.rgb(255,0,0));
                            breakMe++;
                            rwlblTwRSub.setText(error);
                        }

                        try {


                            Qty = Integer.parseInt(String.valueOf(rwlblFfRQty.getText()));
                            Qty50 = Qty;
                            overallTotal = overallTotal + (Qty50 * 50);
                            rwlblFfRSub.setText("R" + (Qty50 * 50));

                        } catch (Exception e) {

                            if (rwlblFfRQty.getText().length() == 0) {
                                rwlblFfRQty.setText(error);
                            }
                            rwlblFfRQty.setTextColor(Color.rgb(255,0,0));
                            breakMe++;
                            rwlblFfRSub.setText(error);

                        }

                        try {

                            Qty = Integer.parseInt(String.valueOf(rwlblOhRQty.getText()));
                            Qty100 = Qty;
                            overallTotal = overallTotal + (Qty100 * 100);
                            rwlblOhRSub.setText("R" + (Qty100 * 100));


                        } catch (Exception e) {

                            if (rwlblOhRQty.getText().length() == 0) {
                                rwlblOhRQty.setText(error);
                            }
                            rwlblOhRQty.setTextColor(Color.rgb(255,0,0));
                            breakMe++;
                            rwlblOhRSub.setText(error);
                        }

                        try {

                            Qty = Integer.parseInt(String.valueOf(rwlblThRQty.getText()));
                            Qty200 = Qty;
                            overallTotal = overallTotal + (Qty200 * 200);
                            rwlblThRSub.setText("R" + (Qty200 * 200));


                        } catch (Exception e) {

                            if (rwlblThRQty.getText().length() == 0) {
                                rwlblThRQty.setText(error);
                            }
                            rwlblThRQty.setTextColor(Color.rgb(255,0,0));
                            breakMe++;
                            rwlblThRSub.setText(error);

                        }

                        if (breakMe > 0) {

                            breakMe = 1/0;
                        }

                    }catch(Exception e){

                        Context context = getApplicationContext();
                        CharSequence text = "Incorrect Input: Input fields only accepts Number [0..9] values";
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }


                    rwlblSubTot.setText(String.valueOf(overallTotal));

                    double tipTotal = ((Math.round((overallTotal - cash) * 100))/100) ;
                    temp = String.valueOf(tipTotal);

                    rwlblTipTot.setText(temp);

                    calctip(tipTotal);






                   // Log.w("Incomplete Input", "Make sure You Filled in all of the Fields");








            }

            private void calctip(double tipTotal) {

                int iCount200 = 0;
                int iCount100 = 0;
                int iCount50 = 0;
                int iCount20 = 0;
                int iCount10 = 0;
                int iCount5 = 0;
                int iCount2 = 0;
                int iCount1 = 0;
                int iCount50c = 0;

                double cash = 0;


               /* while(((tipTotal - 200) >= 0)){
                    tipTotal -= 200;
                    iCount200++;
                }*/

                while(((tipTotal - 100) >= 0) && (Qty100 > iCount100)){
                    tipTotal -= 100;
                    iCount100++;
                }

                while(((tipTotal - 50) >= 0) && (Qty50 > iCount50)){
                    tipTotal -= 50;
                    iCount50++;
                }

                while(((tipTotal - 20) >= 0) && (Qty20 > iCount20)){
                    tipTotal -= 20;
                    iCount20++;
                }

                while(((tipTotal - 10) >= 0)&& (Qty10 > iCount10)){
                    tipTotal -= 10;
                    iCount10++;
                }

                while(((tipTotal - 5) >= 0)&& (Qty5 > iCount5)){
                    tipTotal -= 5;
                    iCount5++;
                }

                while(((tipTotal - 2) >= 0)&& (Qty2 > iCount2)){
                    tipTotal -= 2;
                    iCount2++;
                }

                while(((tipTotal - 1) >= 0)&& (Qty1 > iCount1)){
                    tipTotal -= 1;
                    iCount1++;
                }

                while(((tipTotal - 0.5) >= 0)&& (Qty50c > iCount50c)){
                    tipTotal -= 0.5;
                    iCount50c++;
                }


                rwlblThRTake.setText("-");
                rwlblOhRTake.setText("x" + String.valueOf(iCount100));
                rwlblFfRTake.setText("x" + String.valueOf(iCount50));
                rwlblTwRTake.setText("x" + String.valueOf(iCount20));
                rwlblTeRTake.setText("x" + String.valueOf(iCount10));
                rwlblFRTake.setText("x" + String.valueOf(iCount5));
                rwlblTRTake.setText("x" + String.valueOf(iCount2));
                rwlblORTake.setText("x" + String.valueOf(iCount1));
                rwlblFCTake.setText("x" + String.valueOf(iCount50c));



            }


        });


        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startSlip = new Intent(getApplicationContext(), CashUpSlips.class);
                startSlip.putExtra("cash", getCash());

                startSlip.putExtra("iCount50c", String.valueOf(Qty50c - iCount50c));
                startSlip.putExtra("iCount1", String.valueOf(Qty1 - iCount1));
                startSlip.putExtra("iCount2", String.valueOf(Qty2 - iCount2));
                startSlip.putExtra("iCount5", String.valueOf(Qty5 - iCount5));
                startSlip.putExtra("iCount10", String.valueOf(Qty10 - iCount10));
                startSlip.putExtra("iCount20", String.valueOf(Qty20 - iCount20));
                startSlip.putExtra("iCount50", String.valueOf(Qty50 - iCount50));
                startSlip.putExtra("iCount100", String.valueOf(Qty100 - iCount100));
                startSlip.putExtra("iCount200", String.valueOf(Qty200 - iCount200));


                startActivity(startSlip);
            }
        });

    }

    private String getCash() {
    return String.valueOf(cash);
    }

    private void isImportantDate() {

        Log.d("Dates", "Entered");
        Calendar c1 =  Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM");

        try {
            Date Anneversary = sdf1.parse("23-12");

            if (c1.getTime().equals(Anneversary)) {

                Context context = getApplicationContext();
                CharSequence text = "Happy Anniversary, Baby";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                rwlblTeRQty.setTextColor(Color.rgb(255,0,0));



            }


        } catch (ParseException e) {
            e.printStackTrace();
        }




    }

}
