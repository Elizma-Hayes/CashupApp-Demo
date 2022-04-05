package com.example.cashup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CashUp_Tip extends AppCompatActivity {


    private double totalTip;
    int iCount200 = 0;
    int iCount100 = 0;
    int iCount50 = 0;
    int iCount20 = 0;
    int iCount10 = 0;
    int iCount5 = 0;
    int iCount2 = 0;
    int iCount1 = 0;
    int iCount50c = 0;

    double newTotal = 0;
    double cash = 0;

    int Qty200 = 0;
    int Qty100 = 0;
    int Qty50 = 0;
    int Qty20 = 0;
    int Qty10 = 0;
    int Qty5 = 0;
    int Qty2 = 0;
    int Qty1 = 0;
    int Qty50c = 0;

    private Button btnNext;

    private TextView rwlblTipTot;

    private TextView rwlblSubTot;



    private EditText rwlblFCQty;
    private TextView rwlblFCSub;


    private EditText rwlblORQty;
    private TextView rwlblORSub;


    private EditText rwlblTRQty;
    private TextView rwlblTRSub;


    private EditText rwlblFRQty;
    private TextView rwlblFRSub;

    private Switch swEdit;
    private EditText rwlblTeRQty;
    private TextView rwlblTeRSub;


    private EditText rwlblTwRQty;
    private TextView rwlblTwRSub;


    private EditText rwlblFfRQty;
    private TextView rwlblFfRSub;


    private EditText rwlblOhRQty;
    private TextView rwlblOhRSub;


    private EditText rwlblThRQty;
    private TextView rwlblThRSub;

    private TableRow rwLoss;
    private TextView rwlblLoss;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_up__tip);

        Double passedArgD;
        int passedArgI;

        passedArgD = getIntent().getExtras().getDouble("tipTot");
        totalTip= passedArgD;

        passedArgD = getIntent().getExtras().getDouble("cash");
        cash= passedArgD;

        passedArgI = getIntent().getExtras().getInt("Qty50c");
        Qty50c = passedArgI;

        passedArgI = getIntent().getExtras().getInt("Qty1");
        Qty1= passedArgI;

        passedArgI = getIntent().getExtras().getInt("Qty2");
        Qty2 = passedArgI;

        passedArgI = getIntent().getExtras().getInt("Qty5");
        Qty5 = passedArgI;

        passedArgI = getIntent().getExtras().getInt("Qty10");
        Qty10 = passedArgI;

        passedArgI = getIntent().getExtras().getInt("Qty20");
        Qty20 = passedArgI;

        passedArgI = getIntent().getExtras().getInt("Qty50");
        Qty50 = passedArgI;

        passedArgI = getIntent().getExtras().getInt("Qty100");
        Qty100 = passedArgI;

        passedArgI = getIntent().getExtras().getInt("Qty200");
        Qty200 = passedArgI;

        rwLoss = (TableRow) findViewById(R.id.rwLoss);
        rwlblLoss = (TextView) findViewById(R.id.rwlblLoss);

        rwLoss.setVisibility(View.INVISIBLE);

        swEdit = (Switch) findViewById(R.id.swEdit);
        swEdit.setChecked(false);

        rwlblSubTot= (TextView) findViewById(R.id.rwlblSubTot);

        rwlblTipTot = (TextView) findViewById(R.id.rwlblTipTot);

        rwlblFCQty = (EditText) findViewById(R.id.rwlblFCQty);
        rwlblFCQty.setEnabled(false);
        rwlblFCSub= (TextView) findViewById(R.id.rwlblFCSub);


        rwlblORQty= (EditText) findViewById(R.id.rwlblORQty);
        rwlblORQty.setEnabled(false);
        rwlblORSub= (TextView) findViewById(R.id.rwlblORSub);

        rwlblTRQty = (EditText) findViewById(R.id.rwlblTRQty);
        rwlblTRQty.setEnabled(false);
        rwlblTRSub= (TextView) findViewById(R.id.rwlblTRSub);

        rwlblFRQty = (EditText) findViewById(R.id.rwlblFRQty);
        rwlblFRQty.setEnabled(false);
        rwlblFRSub= (TextView) findViewById(R.id.rwlblFRSub);

        rwlblTeRQty= (EditText) findViewById(R.id.rwlblTeRQty);
        rwlblTeRQty.setEnabled(false);
        rwlblTeRSub= (TextView) findViewById(R.id.rwlblTeRSub);

        rwlblTwRQty= (EditText) findViewById(R.id.rwlblTwRQty);
        rwlblTwRQty.setEnabled(false);
        rwlblTwRSub= (TextView) findViewById(R.id.rwlblTwRSub);

        rwlblFfRQty= (EditText) findViewById(R.id.rwlblFfRQty);
        rwlblFfRQty.setEnabled(false);
        rwlblFfRSub= (TextView) findViewById(R.id.rwlblFfRSub);

        rwlblOhRQty= (EditText) findViewById(R.id.rwlblOhRQty);
        rwlblOhRQty.setEnabled(false);
        rwlblOhRSub= (TextView) findViewById(R.id.rwlblOhRSub);

        rwlblThRQty= (EditText) findViewById(R.id.rwlblThRQty);
        rwlblThRQty.setEnabled(false);
        rwlblThRSub= (TextView) findViewById(R.id.rwlblThRSub);

        Button btnNext = (Button) findViewById(R.id.btnNext);

        rwlblTipTot.setText(String.valueOf(totalTip));



        calcSub(totalTip, true);

        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startSlip = new Intent(getApplicationContext(), CashUpSlips.class);

                startSlip.putExtra("cash", cash);

                int temp = Qty50c - iCount50c;
                startSlip.putExtra("iCount50c", String.valueOf(temp));

                temp = Qty1 - iCount1;
                startSlip.putExtra("iCount1", String.valueOf(temp));

                temp = Qty2 - iCount2;
                startSlip.putExtra("iCount2", String.valueOf(temp));

                temp = Qty5 - iCount5;
                startSlip.putExtra("iCount5", String.valueOf(temp));

                temp = Qty10 - iCount10;
                startSlip.putExtra("iCount10", String.valueOf(temp));

                temp = Qty20 - iCount20;
                startSlip.putExtra("iCount20", String.valueOf(temp));

                temp = Qty50 - iCount50;
                startSlip.putExtra("iCount50", String.valueOf(temp));

                temp = Qty100 - iCount100;
                startSlip.putExtra("iCount100", String.valueOf(temp));

                temp = Qty200 - iCount200;
                startSlip.putExtra("iCount200", String.valueOf(temp));

                startActivity(startSlip);
            }
        });

            swEdit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    rwlblFCQty.setEnabled(true);
                    rwlblORQty.setEnabled(true);
                    rwlblTRQty.setEnabled(true);
                    rwlblFRQty.setEnabled(true);
                    rwlblTeRQty.setEnabled(true);
                    rwlblTwRQty.setEnabled(true);
                    rwlblFfRQty.setEnabled(true);
                    rwlblOhRQty.setEnabled(true);
                    rwlblThRQty.setEnabled(true);

        }
    });

            rwlblFCQty.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    // When focus is lost check that the text field has valid values.
                    int breakMe = 0;
                    if (!hasFocus) {
                        // Validate youredittex
                        int saveState = iCount50c;
                        try {
                            iCount50c = Integer.parseInt(String.valueOf(rwlblFCQty.getText()));

                            if (iCount50c > 0) {

                                iCount1 = 0;
                                iCount2 = 0;
                                iCount5 = 0;
                                iCount10 = 0;
                                iCount20 = 0;
                                iCount50 = 0;
                                iCount100 = 0;
                                iCount200 = 0;

                                calcSub(totalTip, false);
                            }else {
                                breakMe = 1/0;
                            }

                        } catch (Exception e){
                            try{
                                iCount50c = Integer.parseInt(String.valueOf(rwlblFCQty.getText().subSequence(1, rwlblFCQty.getText().length())));
                                if (iCount50c > 0) {
                                    iCount1 = 0;
                                    iCount2 = 0;
                                    iCount5 = 0;
                                    iCount10 = 0;
                                    iCount20 = 0;
                                    iCount50 = 0;
                                    iCount100 = 0;
                                    iCount200 = 0;
                                    calcSub(totalTip, false);
                                }else {
                                    breakMe = 1/0;
                                }
                            }
                            catch(Exception exep){

                                Context context = getApplicationContext();
                                CharSequence text = "Incorrect Input: Input fields only accepts positive number values [0..9]";
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(context, text, duration);
                                toast.show();
                                iCount50c = saveState;
                                rwlblFCQty.setText("x" + String.valueOf(iCount50c));

                            }
                        }
                    }

                }
                });

        rwlblORQty.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // When focus is lost check that the text field has valid values.
                int breakMe = 0;
                if (!hasFocus) {
                    // Validate youredittex
                    int saveState = iCount1;
                    try {
                        iCount1 = Integer.parseInt(String.valueOf(rwlblORQty.getText()));

                        if (iCount1 > 0) {

                            iCount50c = 0;
                            iCount2 = 0;
                            iCount5 = 0;
                            iCount10 = 0;
                            iCount20 = 0;
                            iCount50 = 0;
                            iCount100 = 0;
                            iCount200 = 0;

                            calcSub(totalTip, false);
                        }else {
                            breakMe = 1/0;
                        }

                    } catch (Exception e){
                        try{
                            iCount1 = Integer.parseInt(String.valueOf(rwlblORQty.getText().subSequence(1, rwlblORQty.getText().length())));
                            if (iCount1 > 0) {
                                iCount50c = 0;
                                iCount2 = 0;
                                iCount5 = 0;
                                iCount10 = 0;
                                iCount20 = 0;
                                iCount50 = 0;
                                iCount100 = 0;
                                iCount200 = 0;
                                calcSub(totalTip, false);
                            }else {
                                breakMe = 1/0;
                            }
                        }
                        catch(Exception exep){

                            Context context = getApplicationContext();
                            CharSequence text = "Incorrect Input: Input fields only accepts positive number values [0..9]";
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            iCount1 = saveState;
                            rwlblORQty.setText("x" + String.valueOf(iCount1));

                        }
                    }
                }

            }
        }); rwlblTRQty.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // When focus is lost check that the text field has valid values.
                int breakMe = 0;
                if (!hasFocus) {
                    // Validate youredittex
                    int saveState = iCount2;
                    try {
                        iCount2 = Integer.parseInt(String.valueOf(rwlblTRQty.getText()));

                        if (iCount2 > 0) {

                            iCount50c = 0;
                            iCount1 = 0;
                            iCount5 = 0;
                            iCount10 = 0;
                            iCount20 = 0;
                            iCount50 = 0;
                            iCount100 = 0;
                            iCount200 = 0;

                            calcSub(totalTip, false);
                        }else {
                            breakMe = 1/0;
                        }

                    } catch (Exception e){
                        try{
                            iCount2 = Integer.parseInt(String.valueOf(rwlblTRQty.getText().subSequence(1, rwlblTRQty.getText().length())));
                            if (iCount2 > 0) {
                                iCount50c = 0;
                                iCount1 = 0;
                                iCount5 = 0;
                                iCount10 = 0;
                                iCount20 = 0;
                                iCount50 = 0;
                                iCount100 = 0;
                                iCount200 = 0;
                                calcSub(totalTip, false);
                            }else {
                                breakMe = 1/0;
                            }
                        }
                        catch(Exception exep){

                            Context context = getApplicationContext();
                            CharSequence text = "Incorrect Input: Input fields only accepts positive number values [0..9]";
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            iCount2 = saveState;
                            rwlblTRQty.setText("x" + String.valueOf(iCount2));

                        }
                    }
                }

            }
        }); rwlblFRQty.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // When focus is lost check that the text field has valid values.
                int breakMe = 0;
                if (!hasFocus) {
                    // Validate youredittex
                    int saveState = iCount5;
                    try {
                        iCount5 = Integer.parseInt(String.valueOf(rwlblFRQty.getText()));

                        if (iCount5 > 0) {

                            iCount50c = 0;
                            iCount1 = 0;
                            iCount2 = 0;
                            iCount10 = 0;
                            iCount20 = 0;
                            iCount50 = 0;
                            iCount100 = 0;
                            iCount200 = 0;

                            calcSub(totalTip, false);
                        }else {
                            breakMe = 1/0;
                        }

                    } catch (Exception e){
                        try{
                            iCount5 = Integer.parseInt(String.valueOf(rwlblFRQty.getText().subSequence(1, rwlblFRQty.getText().length())));
                            if (iCount5 > 0) {
                                iCount1 = 0;
                                iCount2 = 0;
                                iCount50c = 0;
                                iCount10 = 0;
                                iCount20 = 0;
                                iCount50 = 0;
                                iCount100 = 0;
                                iCount200 = 0;
                                calcSub(totalTip, false);
                            }else {
                                breakMe = 1/0;
                            }
                        }
                        catch(Exception exep){

                            Context context = getApplicationContext();
                            CharSequence text = "Incorrect Input: Input fields only accepts positive number values [0..9]";
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            iCount5 = saveState;
                            rwlblFRQty.setText("x" + String.valueOf(iCount5));

                        }
                    }
                }

            }
        });

        rwlblTeRQty.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // When focus is lost check that the text field has valid values.
                int breakMe = 0;
                if (!hasFocus) {
                    // Validate youredittex
                    int saveState = iCount10;
                    try {
                        iCount10 = Integer.parseInt(String.valueOf(rwlblTeRQty.getText()));

                        if (iCount10 > 0) {

                            iCount1 = 0;
                            iCount2 = 0;
                            iCount5 = 0;
                            iCount50c = 0;
                            iCount20 = 0;
                            iCount50 = 0;
                            iCount100 = 0;
                            iCount200 = 0;

                            calcSub(totalTip, false);
                        }else {
                            breakMe = 1/0;
                        }

                    } catch (Exception e){
                        try{
                            iCount10 = Integer.parseInt(String.valueOf(rwlblTeRQty.getText().subSequence(1, rwlblTeRQty.getText().length())));
                            if (iCount10 > 0) {
                                iCount1 = 0;
                                iCount2 = 0;
                                iCount5 = 0;
                                iCount50c = 0;
                                iCount20 = 0;
                                iCount50 = 0;
                                iCount100 = 0;
                                iCount200 = 0;
                                calcSub(totalTip, false);
                            }else {
                                breakMe = 1/0;
                            }
                        }
                        catch(Exception exep){

                            Context context = getApplicationContext();
                            CharSequence text = "Incorrect Input: Input fields only accepts positive number values [0..9]";
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            iCount10 = saveState;
                            rwlblTeRQty.setText("x" + String.valueOf(iCount10));

                        }
                    }
                }

            }
        }); rwlblTwRQty.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // When focus is lost check that the text field has valid values.
                int breakMe = 0;
                if (!hasFocus) {
                    // Validate youredittex
                    int saveState = iCount20;
                    try {
                        iCount20 = Integer.parseInt(String.valueOf(rwlblTwRQty.getText()));

                        if (iCount20 > 0) {

                            iCount1 = 0;
                            iCount2 = 0;
                            iCount5 = 0;
                            iCount10 = 0;
                            iCount50c = 0;
                            iCount50 = 0;
                            iCount100 = 0;
                            iCount200 = 0;

                            calcSub(totalTip, false);
                        }else {
                            breakMe = 1/0;
                        }

                    } catch (Exception e){
                        try{
                            iCount20 = Integer.parseInt(String.valueOf(rwlblTwRQty.getText().subSequence(1, rwlblTwRQty.getText().length())));
                            if (iCount20 > 0) {
                                iCount1 = 0;
                                iCount2 = 0;
                                iCount5 = 0;
                                iCount10 = 0;
                                iCount50c = 0;
                                iCount50 = 0;
                                iCount100 = 0;
                                iCount200 = 0;
                                calcSub(totalTip, false);
                            }else {
                                breakMe = 1/0;
                            }
                        }
                        catch(Exception exep){

                            Context context = getApplicationContext();
                            CharSequence text = "Incorrect Input: Input fields only accepts positive number values [0..9]";
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            iCount20 = saveState;
                            rwlblTwRQty.setText("x" + String.valueOf(iCount20));

                        }
                    }
                }

            }
        }); rwlblFfRQty.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // When focus is lost check that the text field has valid values.
                int breakMe = 0;
                if (!hasFocus) {
                    // Validate youredittex
                    int saveState = iCount50;
                    try {
                        iCount50 = Integer.parseInt(String.valueOf(rwlblFfRQty.getText()));

                        if (iCount50 > 0) {

                            iCount1 = 0;
                            iCount2 = 0;
                            iCount5 = 0;
                            iCount10 = 0;
                            iCount20 = 0;
                            iCount50c = 0;
                            iCount100 = 0;
                            iCount200 = 0;

                            calcSub(totalTip, false);
                        }else {
                            breakMe = 1/0;
                        }

                    } catch (Exception e){
                        try{
                            iCount50 = Integer.parseInt(String.valueOf(rwlblFfRQty.getText().subSequence(1, rwlblFfRQty.getText().length())));
                            if (iCount50 > 0) {
                                iCount1 = 0;
                                iCount2 = 0;
                                iCount5 = 0;
                                iCount10 = 0;
                                iCount20 = 0;
                                iCount50c = 0;
                                iCount100 = 0;
                                iCount200 = 0;
                                calcSub(totalTip, false);
                            }else {
                                breakMe = 1/0;
                            }
                        }
                        catch(Exception exep){

                            Context context = getApplicationContext();
                            CharSequence text = "Incorrect Input: Input fields only accepts positive number values [0..9]";
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            iCount50 = saveState;
                            rwlblFfRQty.setText("x" + String.valueOf(iCount50));

                        }
                    }
                }

            }
        }); rwlblOhRQty.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // When focus is lost check that the text field has valid values.
                int breakMe = 0;
                if (!hasFocus) {
                    // Validate youredittex
                    int saveState = iCount100;
                    try {
                        iCount100 = Integer.parseInt(String.valueOf(rwlblOhRQty.getText()));

                        if (iCount100 > 0) {

                            iCount1 = 0;
                            iCount2 = 0;
                            iCount5 = 0;
                            iCount10 = 0;
                            iCount20 = 0;
                            iCount50 = 0;
                            iCount50c = 0;
                            iCount200 = 0;

                            calcSub(totalTip, false);
                        }else {
                            breakMe = 1/0;
                        }

                    } catch (Exception e){
                        try{
                            iCount100 = Integer.parseInt(String.valueOf(rwlblOhRQty.getText().subSequence(1, rwlblOhRQty.getText().length())));
                            if (iCount100 > 0) {
                                iCount1 = 0;
                                iCount2 = 0;
                                iCount5 = 0;
                                iCount10 = 0;
                                iCount20 = 0;
                                iCount50 = 0;
                                iCount50c = 0;
                                iCount200 = 0;
                                calcSub(totalTip, false);
                            }else {
                                breakMe = 1/0;
                            }
                        }
                        catch(Exception exep){

                            Context context = getApplicationContext();
                            CharSequence text = "Incorrect Input: Input fields only accepts positive number values [0..9]";
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            iCount100 = saveState;
                            rwlblOhRQty.setText("x" + String.valueOf(iCount100));

                        }
                    }
                }

            }
        }); rwlblThRQty.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // When focus is lost check that the text field has valid values.
                int breakMe = 0;
                if (!hasFocus) {
                    // Validate youredittex
                    int saveState = iCount200;
                    try {
                        iCount200 = Integer.parseInt(String.valueOf(rwlblThRQty.getText()));

                        if (iCount200 > 0) {

                            iCount1 = 0;
                            iCount2 = 0;
                            iCount5 = 0;
                            iCount10 = 0;
                            iCount20 = 0;
                            iCount50 = 0;
                            iCount100 = 0;
                            iCount50c = 0;

                            calcSub(totalTip, false);
                        }else {
                            breakMe = 1/0;
                        }

                    } catch (Exception e){
                        try{
                            iCount200 = Integer.parseInt(String.valueOf(rwlblThRQty.getText().subSequence(1, rwlblThRQty.getText().length())));
                            if (iCount200 > 0) {
                                iCount1 = 0;
                                iCount2 = 0;
                                iCount5 = 0;
                                iCount10 = 0;
                                iCount20 = 0;
                                iCount50 = 0;
                                iCount100 = 0;
                                iCount50c = 0;
                                calcSub(totalTip, false);
                            }else {
                                breakMe = 1/0;
                            }
                        }
                        catch(Exception exep){

                            Context context = getApplicationContext();
                            CharSequence text = "Incorrect Input: Input fields only accepts positive number values [0..9]";
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            iCount200 = saveState;
                            rwlblThRQty.setText("x" + String.valueOf(iCount200));

                        }
                    }
                }

            }
        });

    }


    private void calcSub(double totalTip, boolean first) {
        double staticTip = totalTip;

        if (first) {

            while (((totalTip - 100) >= 0) && (Qty100 > iCount100)) {
                totalTip -= 100;
                iCount100++;
            }

            while (((totalTip - 50) >= 0) && (Qty50 > iCount50)) {
                totalTip -= 50;
                iCount50++;
            }

            while (((totalTip - 20) >= 0) && (Qty20 > iCount20)) {
                totalTip -= 20;
                iCount20++;
            }

            while (((totalTip - 10) >= 0) && (Qty10 > iCount10)) {
                totalTip -= 10;
                iCount10++;
            }

            while (((totalTip - 5) >= 0) && (Qty5 > iCount5)) {
                totalTip -= 5;
                iCount5++;
            }

            while (((totalTip - 2) >= 0) && (Qty2 > iCount2)) {
                totalTip -= 2;
                iCount2++;
            }

            while (((totalTip - 1) >= 0) && (Qty1 > iCount1)) {
                totalTip -= 1;
                iCount1++;
            }

            while (((totalTip - 0.5) >= 0) && (Qty50c > iCount50c)) {
                totalTip -= 0.5;
                iCount50c++;
            }


            rwlblThRQty.setText("   -");
            rwlblOhRQty.setText("x" + String.valueOf(iCount100));
            rwlblFfRQty.setText("x" + String.valueOf(iCount50));
            rwlblTwRQty.setText("x" + String.valueOf(iCount20));
            rwlblTeRQty.setText("x" + String.valueOf(iCount10));
            rwlblFRQty.setText("x" + String.valueOf(iCount5));
            rwlblTRQty.setText("x" + String.valueOf(iCount2));
            rwlblORQty.setText("x" + String.valueOf(iCount1));
            rwlblFCQty.setText("x" + String.valueOf(iCount50c));
        }

        rwlblThRSub.setText("   -");



        if (iCount100 > 0) {

            rwlblOhRSub.setText(String.valueOf(iCount100 * 100));
            newTotal = newTotal + iCount100 * 100;
        }else {

            rwlblOhRSub.setText("   -");
        }


        if (iCount50 > 0) {

            rwlblFfRSub.setText(String.valueOf(iCount50 * 50));
            newTotal = newTotal + iCount50 * 50;
        }else {

            rwlblFfRSub.setText("   -");
        }

        if (iCount20 > 0) {

            rwlblTwRSub.setText(String.valueOf(iCount20 * 20));
            newTotal = newTotal + iCount20 * 20;
        }else {

            rwlblTwRSub.setText("   -");
        }

        if (iCount10 > 0) {

            rwlblTeRSub.setText(String.valueOf(iCount10 * 10));
            newTotal = newTotal + iCount10 * 10;
        }else {

            rwlblTeRSub.setText("   -");
        }

        if (iCount5 > 0) {

            rwlblFRSub.setText(String.valueOf(iCount5 * 5));
            newTotal = newTotal + iCount5 * 5;
        }else {

            rwlblFRSub.setText("    -");
        }

        if (iCount2 > 0) {

            rwlblTRSub.setText(String.valueOf(iCount2 * 2));
            newTotal = newTotal + iCount2 * 2;
        }else {

            rwlblTRSub.setText("    -");
        }

        if (iCount1 > 0) {

            rwlblORSub.setText(String.valueOf(iCount1));
            newTotal = newTotal + iCount1 * 1;
        }else {

            rwlblORSub.setText("    -");
        }


        if (iCount50c > 0) {

            rwlblFCSub.setText(String.valueOf(iCount50c * 0.5));
            newTotal = newTotal + iCount50c * 0.5;
        }else {

            rwlblFCSub.setText("    -");
        }

        rwlblSubTot.setText(String.valueOf(newTotal));

        double loss = staticTip - newTotal;

        if (loss > 0.9) {

            rwLoss.setVisibility(View.VISIBLE);
            rwlblLoss.setText(String.valueOf(loss));


        }




    }


}
