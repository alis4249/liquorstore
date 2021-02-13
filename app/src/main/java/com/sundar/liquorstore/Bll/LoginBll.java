package com.sundar.liquorstore.Bll;

import com.sundar.liquorstore.Api.UsersApi;
import com.sundar.liquorstore.ServerResponse.SignUpResponse;
import com.sundar.liquorstore.Url.url;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class LoginBll {
    Boolean isSuccess = false;


    public boolean checkUser(String username, String password){

        UsersApi usersApi = url.getInstance().create(UsersApi.class);
        Call<SignUpResponse> usersCall = usersApi.CheckUser(username, password);

        try{
            Response<SignUpResponse> loginResponse = usersCall.execute();
            if (loginResponse.isSuccessful() &&
            loginResponse.body().getStatus().equals("Login success!")) {

                url.token += loginResponse.body().getToken();

                isSuccess = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
