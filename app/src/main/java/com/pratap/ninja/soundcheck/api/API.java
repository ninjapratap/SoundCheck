package com.pratap.ninja.soundcheck.api;


import com.pratap.ninja.soundcheck.models.Sound;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by darsh on 6/12/17.
 */

public interface API {

    @GET("tracks?client_id=iq13rThQx5jx9KWaOY8oGgg1PUm9vp3J")
    Call<ArrayList<Sound>> getTracks();
}
