package com.example.cashup;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CashUpSlips extends AppCompatActivity {


    double cash = 0.0;

    int iCount200;
    int iCount100;
    int iCount50;
    int iCount20;
    int iCount10;
    int iCount5;
    int iCount2;
    int iCount1;
    int iCount50c;
    double newTotal = 0;

    double iAdd200 = 0;
    double iAdd100 = 0;
    double iAdd50 = 0;
    double iAdd20 = 0;
    double iAdd10 = 0;
    double iAdd5 = 0;
    double iAdd2 = 0;
    double iAdd1 = 0;
    double iAdd50c = 0;


    TextView rwlblFloat;

    Button btnSave;
  //  DatabaseReference reff;
    TextView rwlblDm41;

    TextView rwlblSubTot;

    TextView rwlblFCQty;
    TextView rwlblFCSub;

    TextView rwlblORQty;
    TextView rwlblORSub;

    TextView rwlblTRQty;
    TextView rwlblTRSub;

    TextView rwlblFRQty;
    TextView rwlblFRSub;

    TextView rwlblTeRQty;
    TextView rwlblTeRSub;

    TextView rwlblTwRQty;
    TextView rwlblTwRSub;

    TextView rwlblFfRQty;
    TextView rwlblFfRSub;

    TextView rwlblOhRQty;
    TextView rwlblOhRSub;

    TextView rwlblThRQty;
    TextView rwlblThRSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_up_slips);


        double passedArgD;
        String passedArgS;

        passedArgD = getIntent().getExtras().getDouble("cash");
        cash = passedArgD;

        passedArgD = getIntent().getExtras().getDouble("newTotal");
        newTotal = passedArgD;

        passedArgS = getIntent().getExtras().getString("iCount50c");
        iCount50c = convString(passedArgS);

        passedArgS = getIntent().getExtras().getString("iCount1");
        iCount1 = convString(passedArgS);

        passedArgS = getIntent().getExtras().getString("iCount2");
        iCount2 = convString(passedArgS);

        passedArgS = getIntent().getExtras().getString("iCount5");
        iCount5 = convString(passedArgS);

        passedArgS = getIntent().getExtras().getString("iCount10");
        iCount10 = convString(passedArgS);

        passedArgS = getIntent().getExtras().getString("iCount20");
        iCount20 = convString(passedArgS);

        passedArgS = getIntent().getExtras().getString("iCount50");
        iCount50 = convString(passedArgS);

        passedArgS = getIntent().getExtras().getString("iCount100");
        iCount100 = convString(passedArgS);

        passedArgS = getIntent().getExtras().getString("iCount200");
        iCount200 = convString(passedArgS);





        btnSave = (Button) findViewById(R.id.btnSave);

        rwlblSubTot= (TextView) findViewById(R.id.rwlblSubTot);

        rwlblFloat = (TextView) findViewById(R.id.rwlblFloat);

        rwlblDm41 = (TextView) findViewById(R.id.rwlblDm41);

        rwlblFCQty = (TextView) findViewById(R.id.rwlblFCQty);
        rwlblFCSub= (TextView) findViewById(R.id.rwlblFCSub);

        rwlblORQty= (TextView) findViewById(R.id.rwlblORQty);
        rwlblORSub= (TextView) findViewById(R.id.rwlblORSub);

        rwlblTRQty = (TextView) findViewById(R.id.rwlblTRQty);
        rwlblTRSub= (TextView) findViewById(R.id.rwlblTRSub);

        rwlblFRQty = (TextView) findViewById(R.id.rwlblFRQty);
        rwlblFRSub= (TextView) findViewById(R.id.rwlblFRSub);

        rwlblTeRQty= (TextView) findViewById(R.id.rwlblTeRQty);
        rwlblTeRSub= (TextView) findViewById(R.id.rwlblTeRSub);

        rwlblTwRQty= (TextView) findViewById(R.id.rwlblTwRQty);
        rwlblTwRSub= (TextView) findViewById(R.id.rwlblTwRSub);

        rwlblFfRQty= (TextView) findViewById(R.id.rwlblFfRQty);
        rwlblFfRSub= (TextView) findViewById(R.id.rwlblFfRSub);

        rwlblOhRQty= (TextView) findViewById(R.id.rwlblOhRQty);
        rwlblOhRSub= (TextView) findViewById(R.id.rwlblOhRSub);

        rwlblThRQty= (TextView) findViewById(R.id.rwlblThRQty);
        rwlblThRSub= (TextView) findViewById(R.id.rwlblThRSub);

        rwlblFloat.setText(String.valueOf(cash));

        rwlblDm41.setText(String.valueOf(newTotal));

        calcSub();

        btnSave.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {



            }
        });

    }

    private int convString(String passedArgS) {
        return Integer.parseInt(passedArgS);
    }

    private void calcSub() {

        double iAdd200 = iCount200 * 200;
        double iAdd100 = iCount100 * 100;
        double iAdd50 = iCount50 * 50;
        double iAdd20 = iCount20 * 20;
        double iAdd10 = iCount10 *10;
        double iAdd5 = iCount5 * 5;
        double iAdd2 = iCount2 * 2;
        double iAdd1 = iCount1 * 1;
        double iAdd50c = iCount50c * 0.5;


        rwlblThRQty.setText("x" + iCount200);
        rwlblOhRQty.setText("x" + iCount100);
        rwlblFfRQty.setText("x" + iCount50);
        rwlblTwRQty.setText("x" + iCount20);
        rwlblTeRQty.setText("x" + iCount10);
        rwlblFRQty.setText("x" + iCount5);
        rwlblTRQty.setText("x" + iCount2);
        rwlblORQty.setText("x" + iCount1);
        rwlblFCQty.setText("x" + iCount50c);

        rwlblThRSub.setText("R" + String.valueOf(iAdd200));
        rwlblOhRSub.setText("R" + String.valueOf(iAdd100));
        rwlblFfRSub.setText("R" + String.valueOf(iAdd50));
        rwlblTwRSub.setText("R" + String.valueOf(iAdd20));
        rwlblTeRSub.setText("R" + String.valueOf(iAdd10));
        rwlblFRSub.setText("R" + String.valueOf(iAdd5));
        rwlblTRSub.setText("R" + String.valueOf(iAdd2));
        rwlblORSub.setText("R" + String.valueOf(iAdd1));
        rwlblFCSub.setText("R" + String.valueOf(iAdd50c));







    }

}

