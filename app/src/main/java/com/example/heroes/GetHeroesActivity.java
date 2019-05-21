package com.example.heroes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import api.APIInterface;
import model.HeroModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetHeroesActivity extends AppCompatActivity {

    TextView lstEmployee;
    TextView txtTotal;
    //    ListView listView;
    Button showBtn;
//    ArrayList<String> stringsArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_heroes);
        lstEmployee = findViewById(R.id.lstEmployee);
        txtTotal = findViewById(R.id.txtTotalEmp);
//        listView = findViewById(R.id.lstEmployee);

        showBtn = findViewById(R.id.showBtn);
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadData();
            }
        });
    }

    private void loadData() {
        System.out.println("load data");
//        stringsArray = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIInterface.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        APIInterface heroAPI = retrofit.create(APIInterface.class);

        Call<List<HeroModel>> call = heroAPI.getHeroes();
        call.enqueue(new Callback<List<HeroModel>>() {
            @Override
            public void onResponse(Call<List<HeroModel>> call, Response<List<HeroModel>> response) {
                if (!response.isSuccessful()) {
                    lstEmployee.setText("CODE: " + response.code());
                    return;
                }
                List<HeroModel> employeeList = response.body();
                txtTotal.setText("[ Total Employee: " + employeeList.size() + " ]");
                lstEmployee.setText("");
                for (HeroModel hero : employeeList) {
                    String content = "";
                    content += "ID: " + hero.getId() + "\n";
                    content += "Hero Name: " + hero.getName()+ "\n";
                    content += "Hero Description: " + hero.getDesc() + "\n";
                    content += "-------------------------------------\n";
                    lstEmployee.append(content);
//                    stringsArray.add("Emp Id: "+employee.getEmpId()+"\n"+"Name: "+
//                            employee.getEmployee_name()+"\n"+
//                            "Salary: "+employee.getEmployee_salary()+"\n"+"Age: "+
//                            employee.getEmployee_age()+"\n"+"Image: "+employee.getProfile_image());

                }
            }

            @Override
            public void onFailure(Call<List<HeroModel>> call, Throwable t) {
                System.out.println("Error :"+t.getLocalizedMessage());
            }
        });
    }
}
