package api;

import java.util.List;

import model.UserModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {

    String BASE_URL = "http://dummy.restapiexample.com/api/v1/";

    @GET("employees")
    Call<List<UserModel>> getAllEmployee();

    @GET("employee/{empId}")
    Call<UserModel> getEmployeeId(@Path("empId") int id);


}
