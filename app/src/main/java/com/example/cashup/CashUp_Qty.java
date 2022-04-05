package com.example.cashup;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CashUp_Qty extends AppCompatActivity {




    public static final String ARG_FROM_MAIN = "arg";

    double cash = 0;
    double overallTotal;

    EditText rwlblFloat;

    TextView rwlblSubTot;

    EditText rwlblFCQty;
    TextView rwlblFCSub;


    EditText rwlblORQty;
    TextView rwlblORSub;


    EditText rwlblTRQty;
    TextView rwlblTRSub;


    EditText rwlblFRQty;
    TextView rwlblFRSub;


    EditText rwlblTeRQty;
    TextView rwlblTeRSub;


    EditText rwlblTwRQty;
    TextView rwlblTwRSub;


    EditText rwlblFfRQty;
    TextView rwlblFfRSub;


    EditText rwlblOhRQty;
    TextView rwlblOhRSub;


    EditText rwlblThRQty;
    TextView rwlblThRSub;

    int Qty200 = 0;
    int Qty100 = 0;
    int Qty50 = 0;
    int Qty20 = 0;
    int Qty10 = 0;
    int Qty5 = 0;
    int Qty2 = 0;
    int Qty1 = 0;
    int Qty50c = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_up__qty);


        Button btnCalc = (Button) findViewById(R.id.btnCalc);
        Button btnReset = (Button) findViewById(R.id.btnReset);
        final Button btnNext= (Button) findViewById(R.id.btnNext);

        btnNext.setEnabled(false);
        btnNext.setVisibility(View.INVISIBLE);

        rwlblSubTot= (TextView) findViewById(R.id.rwlblSubTot);

        rwlblFCQty = (EditText) findViewById(R.id.rwlblFCQty);
        rwlblFCSub= (TextView) findViewById(R.id.rwlblFCSub);


        rwlblORQty= (EditText) findViewById(R.id.rwlblORQty);
        rwlblORSub= (TextView) findViewById(R.id.rwlblORSub);


        rwlblTRQty = (EditText) findViewById(R.id.rwlblTRQty);
        rwlblTRSub= (TextView) findViewById(R.id.rwlblTRSub);


        rwlblFRQty = (EditText) findViewById(R.id.rwlblFRQty);
        rwlblFRSub= (TextView) findViewById(R.id.rwlblFRSub);


        rwlblTeRQty= (EditText) findViewById(R.id.rwlblTeRQty);
        rwlblTeRSub= (TextView) findViewById(R.id.rwlblTeRSub);


        rwlblTwRQty= (EditText) findViewById(R.id.rwlblTwRQty);
        rwlblTwRSub= (TextView) findViewById(R.id.rwlblTwRSub);


        rwlblFfRQty= (EditText) findViewById(R.id.rwlblFfRQty);
        rwlblFfRSub= (TextView) findViewById(R.id.rwlblFfRSub);


        rwlblOhRQty= (EditText) findViewById(R.id.rwlblOhRQty);
        rwlblOhRSub= (TextView) findViewById(R.id.rwlblOhRSub);


        rwlblThRQty= (EditText) findViewById(R.id.rwlblThRQty);
        rwlblThRSub= (TextView) findViewById(R.id.rwlblThRSub);

        rwlblFloat = (EditText) findViewById(R.id.rwlblFloat);



        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                resetColour();
                resetText();
                btnNext.setVisibility(View.INVISIBLE);
                btnNext.setEnabled(false);




            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                    double temp = cash;
                    double tipTotal = ((Math.round((getOverallTotal() - cash) * 100))/100) ;

                    Intent startTip = new Intent(getApplicationContext(), CashUp_Tip.class);

                    startTip.putExtra("tipTot", tipTotal);

                    startTip.putExtra("cash", cash);

                    startTip.putExtra("Qty50c", Qty50c);
                    startTip.putExtra("Qty1", Qty1);
                    startTip.putExtra("Qty2", Qty2);
                    startTip.putExtra("Qty5", Qty5);
                    startTip.putExtra("Qty10", Qty10);
                    startTip.putExtra("Qty20", Qty20);
                    startTip.putExtra("Qty50", Qty50);
                    startTip.putExtra("Qty100", Qty100);
                    startTip.putExtra("Qty200", Qty200);


                    startActivity(startTip);


                }



               /* Intent startSlip = new Intent(getApplicationContext(), CashUpSlip.class);
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
            }*/
        });

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String error = "nul";

                btnNext.setEnabled(false);
                btnNext.setVisibility(View.INVISIBLE);

                int Qty;
                overallTotal = 0;

                int breakMe = 0;
                String temp = "";

                resetColour();

                try { //overall Adding up

                    try {//individual adding up

                        temp = String.valueOf(rwlblFloat.getText());
                        cash = Double.parseDouble(temp);

                        if (cash < 0) {
                            breakMe = 1/0;
                        }

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
                        if (Qty50c < 0) {
                            breakMe = 1/0;
                        }
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
                        if (Qty1 < 0) {
                            breakMe = 1/0;
                        }
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
                        if (Qty2 < 0) {
                            breakMe = 1/0;
                        }
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
                        if (Qty5 < 0) {
                            breakMe = 1/0;
                        }
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
                        if (Qty10 < 0) {
                            breakMe = 1/0;
                        }
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
                        if (Qty20 < 0) {
                            breakMe = 1/0;
                        }
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
                        if (Qty50 < 0) {
                            breakMe = 1/0;
                        }
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
                        if (Qty100 < 0) {
                            breakMe = 1/0;
                        }
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
                        if (Qty200 < 0) {
                            breakMe = 1/0;
                        }
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
                    } else {

                    }

                }catch(Exception e){

                    Context context = getApplicationContext();
                    CharSequence text = "Incorrect Input: Input fields only accepts positive number values [0..9]";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

                rwlblSubTot.setText(String.valueOf(overallTotal));
                setOverallTotal(overallTotal);


                if (breakMe == 0) {

                    btnNext.setEnabled(true);
                    btnNext.setVisibility(View.VISIBLE);

                }

            }



        });

    }

    private double getOverallTotal() {

        return overallTotal;
    }

    private void setOverallTotal(double ot) {
        overallTotal = ot;
    }

    private void resetText() {
        rwlblFloat.setText("");
        rwlblFCQty.setText("");
        rwlblFCSub.setText("");
        rwlblORQty.setText("");
        rwlblORSub.setText("");
        rwlblTRQty.setText("");
        rwlblTRSub.setText("");
        rwlblFRQty.setText("");
        rwlblFRSub.setText("");
        rwlblTeRQty.setText("");
        rwlblTeRSub.setText("");
        rwlblTwRQty.setText("");
        rwlblTwRSub.setText("");
        rwlblFfRQty.setText("");
        rwlblFfRSub.setText("");
        rwlblOhRQty.setText("");
        rwlblOhRSub.setText("");
        rwlblThRQty.setText("");
        rwlblThRSub.setText("");
        rwlblSubTot.setText("");

    }

    private void resetColour() {


        rwlblFloat.setTextColor(Color.rgb(0,0,0));
        rwlblFCQty.setTextColor(Color.rgb(0,0,0));
        rwlblORQty.setTextColor(Color.rgb(0,0,0));
        rwlblTRQty.setTextColor(Color.rgb(0,0,0));
        rwlblFRQty.setTextColor(Color.rgb(0,0,0));
        rwlblTeRQty.setTextColor(Color.rgb(0,0,0));
        rwlblTwRQty.setTextColor(Color.rgb(0,0,0));
        rwlblFfRQty.setTextColor(Color.rgb(0,0,0));
        rwlblOhRQty.setTextColor(Color.rgb(0,0,0));
        rwlblThRQty.setTextColor(Color.rgb(0,0,0));




    }

    private String getCash() {
        return String.valueOf(cash);
    }


}

