package com.parity.assignment.webservice;


import com.parity.assignment.Utils.Const;
import com.parity.assignment.model.DealsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Megha on 10/10/2019.
 */

public interface ApiInterface {
    /*Deals APIs*/
    @Headers("X-Desidime-Client: 68045fd226ab32029c98bf4533bfa98b3c50423094d292d70ca2702e61a9679b")
    @GET(Const.BASE_URL + "top.json")
    Call<DealsResponse> getTopDeals(@Query("per_page") int perPage, @Query("page") int pageNumber);

    @Headers("X-Desidime-Client: 68045fd226ab32029c98bf4533bfa98b3c50423094d292d70ca2702e61a9679b")
    @GET(Const.BASE_URL + "popular.json")
    Call<DealsResponse> getPopularDeals();

    @Headers("X-Desidime-Client: 68045fd226ab32029c98bf4533bfa98b3c50423094d292d70ca2702e61a9679b")
    @GET(Const.BASE_URL + "featured.json")
    Call<DealsResponse> getFeaturedDeals(@Query("per_page") int perPage, @Query("page") int pageNumber);
}
