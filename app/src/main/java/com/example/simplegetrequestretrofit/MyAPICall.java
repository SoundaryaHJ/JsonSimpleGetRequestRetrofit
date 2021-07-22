package com.example.simplegetrequestretrofit;

import retrofit2.Call;
import retrofit2.http.GET;

    public interface MyAPICall
    {
        // https://run.mocky.io/         v3/6676c430-7d9e-4583-a4f0-a11283757ff2

        @GET("v3/6676c430-7d9e-4583-a4f0-a11283757ff2")
        Call<DataModel> getData();
    }


