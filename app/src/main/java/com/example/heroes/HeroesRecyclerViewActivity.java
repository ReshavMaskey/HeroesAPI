package com.example.heroes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import adapter.HeroAdapter;
import api.APIInterface;
import api.APIURL;
import model.HeroModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HeroesRecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerViewHeroes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_recycler_view);

        recyclerViewHeroes = findViewById(R.id.heroesListView);
        getallheroes();
    }

    private void getallheroes() {
        APIInterface apiInterface = APIURL.getInstance().create(APIInterface.class);
        Call<List<HeroModel>> listCall = apiInterface.getHeroes();
        listCall.enqueue(new Callback<List<HeroModel>>() {
            @Override
            public void onResponse(Call<List<HeroModel>> call, Response<List<HeroModel>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(HeroesRecyclerViewActivity.this, "reponse ", Toast.LENGTH_SHORT).show();

                }
                List<HeroModel> listHero = response.body();
                HeroAdapter heroAdapter = new HeroAdapter(listHero,HeroesRecyclerViewActivity.this);
                recyclerViewHeroes.setAdapter(heroAdapter);
                recyclerViewHeroes.setLayoutManager(new LinearLayoutManager(HeroesRecyclerViewActivity.this));
            }

            @Override
            public void onFailure(Call<List<HeroModel>> call, Throwable t) {
                Toast.makeText(HeroesRecyclerViewActivity.this, "DEtail error ", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
