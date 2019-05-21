package com.example.heroes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import api.APIInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddHeroesActivity extends AppCompatActivity {

    Button btnAdd;
    EditText txtName,txtDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_heroes);
        txtDesc = findViewById(R.id.txtHeroName);
        txtName = findViewById(R.id.txtDesc);
        btnAdd = findViewById(R.id.btnAddHero);
btnAdd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        addHero(txtName.getText().toString(),txtDesc.getText().toString());
    }
});

    }

    private void addHero(String name,String desc){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(APIInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        APIInterface heroapi = retrofit.create(APIInterface.class);
        Call<Void> voidCall = heroapi.addHero(name,desc);

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(AddHeroesActivity.this, "Hero Registered ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(AddHeroesActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}
