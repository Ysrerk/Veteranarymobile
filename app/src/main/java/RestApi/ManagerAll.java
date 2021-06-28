package RestApi;

import Model.Result;
import retrofit2.Call;

public class ManagerAll  extends  BaseManager{


    public Call<Result> alsonuc(String username,String email, String password){

        Call<Result> resultCall=getRestApiClient().getResultt(username,email,password);
        return resultCall;
    }
    public Call<Result>makeactivev(String code,String email){
        Call<Result>resultCall= getRestApiClient().makeactive(code,email);
        return resultCall;
    }


}
