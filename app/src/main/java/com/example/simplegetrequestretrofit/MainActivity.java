package com.example.simplegetrequestretrofit;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textview);

        //Retrofit Builder

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://run.mocky.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //instance for interface
        MyAPICall myAPICall = retrofit.create(MyAPICall.class);

        Call<DataModel> call = myAPICall.getData();

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response)
            {
                //Checking for the response
                if(response.code() != 200)
                {
                    textView.setText("Check the connection");
                    return;
                }

                //Get the data into textview
                String jsony = "";

                jsony = "ID= " + response.body().getId() +
                        "\n userId= " +response.body().getUserId() +
                        "\n title= " +response.body().getTitle() +
                        "\n Completed= " +response.body().isCompleted();

                textView.append(jsony);

            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {

            }
        });
    }
}