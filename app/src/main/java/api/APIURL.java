package api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIURL {
    public static Retrofit getInstance(){
        Retrofit retrofit=
                new Retrofit.Builder()
                        .baseUrl(APIInterface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit;
    }

    public static void strictMode(){
        android.os.StrictMode.ThreadPolicy policy = new android.os.StrictMode.ThreadPolicy.Builder().permitAll().build();
        android.os.StrictMode.setThreadPolicy(policy);
    }


}
