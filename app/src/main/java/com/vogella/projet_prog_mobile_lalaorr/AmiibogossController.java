package com.vogella.projet_prog_mobile_lalaorr;

import com.vogella.projet_prog_mobile_lalaorr.AmiiboAPI;
import com.vogella.projet_prog_mobile_lalaorr.Amiibogoss;
import com.vogella.projet_prog_mobile_lalaorr.apiResponse;
import com.vogella.projet_prog_mobile_lalaorr.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AmiibogossController {
    public MainActivity view;
    private AmiiboAPI amiiboAPI;


    public AmiibogossController(MainActivity view, AmiiboAPI amiiboAPI) {
        this.view = view;
        this.amiiboAPI = amiiboAPI;
    }
    public void onCreate()
    {
        Call<apiResponse> call = amiiboAPI.getAmiiboList();
        call.enqueue(new Callback<apiResponse>()
        {

            @Override
            public void onResponse(Call<apiResponse> call, Response<apiResponse> response) {
                apiResponse apiresponse =response.body();
                List<Amiibogoss> amiibogossList = apiresponse.getAmiiboList();
                view.showList(amiibogossList);
            }

            @Override
            public void onFailure(Call<apiResponse> call, Throwable t) {

            }
        });
    }
}
