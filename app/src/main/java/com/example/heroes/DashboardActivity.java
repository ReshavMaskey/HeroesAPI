package com.example.heroes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

Button btnAdd,btnDisplay,btnUpdate,btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnDisplay = findViewById(R.id.btnDisplay);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDisplay.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnAdd:
                Intent i = new Intent(DashboardActivity.this,AddHeroesActivity.class);
                        startActivity(i);
                break;
            case R.id.btnUpdate:
                Intent ii = new Intent(DashboardActivity.this,AddHeroesActivity.class);
                startActivity(ii);
                break;
            case R.id.btnDelete:
                Intent iii = new Intent(DashboardActivity.this,AddHeroesActivity.class);
                startActivity(iii);
                break;
            case R.id.btnDisplay:
                Intent iiii = new Intent(DashboardActivity.this,GetHeroesActivity.class);
                startActivity(iiii);
                break;
                default:
                    System.out.println("error button");
                    break;
        }

    }
}
