package com.vogella.projet_prog_mobile_lalaorr;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AmiiboAPI {
    @GET("api/amiibo")
    Call<apiResponse> getAmiiboList();
}
