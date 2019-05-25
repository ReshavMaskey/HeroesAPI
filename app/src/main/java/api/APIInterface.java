package api;

import java.util.List;
import java.util.Map;

import model.HeroModel;
import model.ImageResponses;
import model.LoginResponses;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface APIInterface {

    public static final String BASE_URL = "http://10.0.2.2:3000/";

//    http://10.0.2.2:3000/heroes
    @GET("heroes")
    Call<List<HeroModel>> getHeroes();

    @GET("heroes/{empId}")
    Call<HeroModel> getHerosById(@Path("empId") int id);

    @POST("heroes")
    Call<HeroModel> registerHero(@Body HeroModel heroModel);

    @FormUrlEncoded
    @POST("heroes")
    Call<Void> addHero(@Field("name") String name,@Field("desc") String desc);

    @FormUrlEncoded
    @POST("heroes")
    Call<Void> addHeroe(@FieldMap Map<String,String> heroMap);

    @Multipart
    @POST("upload")
    Call<ImageResponses> uploadImage(@Part MultipartBody.Part img);

    @FormUrlEncoded
    @POST("users/login")
    Call<LoginResponses> checkUser(@Field("username")String username,@Field("password") String password);
    @FormUrlEncoded
    @POST("users/signup")
    Call<LoginResponses> signUp(@Field("username")String username,@Field("password") String password);

}
