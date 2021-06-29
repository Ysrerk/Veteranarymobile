package RestApi;

import Model.LoginResult;
import Model.Result;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RestApi {

    @FormUrlEncoded
    @POST("/register.php")
    Call<Result>getResultt(@Field("username") String username,@Field("email") String email,@Field("password") String password);


    @FormUrlEncoded
    @POST("/beactiveregister.php")
    Call<Result>makeactive(@Field("code") String code,@Field("email") String email);

    @FormUrlEncoded
    @POST("/login.php")
    Call<LoginResult>getloginresultt(@Field("email") String email,@Field("password") String password);

}
