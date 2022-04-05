package com.example.cashup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCashUp = (Button) findViewById(R.id.btnCashUp);
        Button btnWages= (Button) findViewById(R.id.btnWages);
        Button btnSchedule = (Button) findViewById(R.id.btnSchedule);

        btnCashUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startCashUp = new Intent(getApplicationContext(), CashUp_Qty.class);
                startActivity(startCashUp);
            }
        });

        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSchedule = new Intent (getApplicationContext(), Schedule.class);
                startActivity(startSchedule);
            }
        });

        btnWages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startWagesMenu = new Intent (getApplicationContext(), WagesMenu.class);
                startActivity(startWagesMenu);

            }
        });





    }
}
