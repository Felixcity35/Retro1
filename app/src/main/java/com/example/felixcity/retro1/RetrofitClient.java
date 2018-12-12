package com.example.felixcity.retro1;

import android.util.Base64;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private   static   final String   Base_url = "http://survey.topjoymultiglobal.com/";
  //  private  static  final String Auth = "Basic "+ Base64.encodeToString( ("Felix:12345").getBytes(),Base64.NO_WRAP);
    private   static RetrofitClient mInstance ;
    private Retrofit retrofit ;

    private RetrofitClient(){

        retrofit = new Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static  synchronized RetrofitClient getInstance(){
        if (mInstance == null){
            mInstance = new RetrofitClient();
        }
        return  mInstance;
    }

    public Api getApi(){
        return  retrofit.create(Api.class);
    }

}
