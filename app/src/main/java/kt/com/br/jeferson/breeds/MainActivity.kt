package kt.com.br.jeferson.breeds

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kt.com.br.jeferson.breeds.connection.BreedRepository
import kt.com.br.jeferson.breeds.connection.DogCeoApi
import kt.com.br.jeferson.breeds.connection.DogCeoDataSource
import kt.com.br.jeferson.breeds.view_model.BreedsViewModel
import kt.com.br.jeferson.breeds.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addFragmentTo(R.id.content_frame, createFragment())

    }


    fun createViewModel(): BreedsViewModel {
        val retrofit = Retrofit.Builder().baseUrl("http://dog.ceo/api/").addConverterFactory(GsonConverterFactory.create()).build()
        val dogCeoDataSource =
            DogCeoDataSource(retrofit.create(DogCeoApi::class.java))
        val repository = BreedRepository(dogCeoDataSource)
        return BreedsViewModel(repository, applicationContext)
    }

    fun createFragment(): BreedFragment {
        return BreedFragment.newInstance(createViewModel())
    }

    fun AppCompatActivity.addFragmentTo(containerId: Int, fragment: Fragment, tag: String = "") {
        supportFragmentManager.beginTransaction().add(containerId, fragment, tag).commit()
    }


}
