package api;

import java.util.List;

import model.HeroModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {

    String BASE_URL = "http://dummy.restapiexample.com/api/v1/";

    @GET("heroes")
    Call<List<HeroModel>> getHeroes();

    @GET("heroes/{empId}")
    Call<HeroModel> getHerosById(@Path("empId") int id);

    @POST("heroes")
    Call<HeroModel> registerHero(@Body HeroModel heroModel);


}
