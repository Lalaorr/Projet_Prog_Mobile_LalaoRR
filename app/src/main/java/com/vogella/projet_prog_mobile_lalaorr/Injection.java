package com.vogella.projet_prog_mobile_lalaorr;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injection {
    private static AmiiboAPI amiiboAPI;

    public static AmiiboAPI getAPI() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://amiiboapi.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        amiiboAPI = retrofit.create(AmiiboAPI.class);

        return amiiboAPI;

    }
}
