package kt.com.br.jeferson.breeds.connection

import kt.com.br.jeferson.breeds.view_model.BreedsItemViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DogCeoDataSource(val dogCeoApi: DogCeoApi) :
    BreedDataSource {


    override fun listAll(success: (List<BreedsItemViewModel>) -> Unit, failure: () -> Unit) {
        val call = dogCeoApi.listBreeds()
        call.enqueue(object : Callback<DogCeoResponse> {

            override fun onResponse(call: Call<DogCeoResponse>, response: Response<DogCeoResponse>) {
                if (response.isSuccessful) {
                    val breeds = mutableListOf<BreedsItemViewModel>()
                    response.body()?.message?.forEach {
                        breeds.add(BreedsItemViewModel(it))
                    }
                    success(breeds)
                } else {
                    failure()
                }
            }

            override fun onFailure(call: Call<DogCeoResponse>, t: Throwable?) {
                failure()
            }
        })

    }
}