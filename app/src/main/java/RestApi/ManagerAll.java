package RestApi;

import java.util.List;

import Model.LoginResult;
import Model.Petresult;
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
    public Call<LoginResult>getlognresult(String email, String password){
        Call<LoginResult>loginResultCall=getRestApiClient().getloginresultt(email,password);
        return  loginResultCall;
    }

    public Call<List<Petresult>>getpetresult(String custid){
        Call<List<Petresult>> listCall =getRestApiClient().getpets(custid);
        return listCall;
    }


}
