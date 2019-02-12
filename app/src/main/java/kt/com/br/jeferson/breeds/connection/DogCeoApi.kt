package kt.com.br.jeferson.breeds.connection

import retrofit2.Call
import retrofit2.http.GET


/**
 * Created by tsouto on 28/03/18.
 */

interface DogCeoApi{

    @GET("breeds/list")
    fun listBreeds(): Call<DogCeoResponse>

}