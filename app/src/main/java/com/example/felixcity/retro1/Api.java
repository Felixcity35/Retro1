package com.example.felixcity.retro1;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {
    @POST ("api/register")
    @Headers({
            "Accept: application/json",
            "Content-type: application/json"
    })
    Call<Users>createAccount(@Body Users user);

}
