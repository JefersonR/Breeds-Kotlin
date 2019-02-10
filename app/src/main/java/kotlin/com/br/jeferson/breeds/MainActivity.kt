package kotlin.com.br.jeferson.breeds

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.com.br.jeferson.breeds.connection.BreedRepository
import kotlin.com.br.jeferson.breeds.connection.DogCeoApi
import kotlin.com.br.jeferson.breeds.connection.DogCeoDataSource
import kotlin.com.br.jeferson.breeds.view_model.BreedsViewModel
import kotlin.com.br.jeferson.breeds.view_model.BreedsViewModelFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun createViewModel(): BreedsViewModel {
        val retrofit = Retrofit.Builder().baseUrl("http://dog.ceo/api/").addConverterFactory(GsonConverterFactory.create()).build()
        val dogCeoDataSource = DogCeoDataSource(retrofit.create(DogCeoApi::class.java))
        val repository = BreedRepository(dogCeoDataSource)

        val factory = BreedsViewModelFactory(repository, activity?.application!!)

        return ViewModelProviders.of(this, factory).get(BreedsViewModel::class.java)
    }


    fun createFragment() : BreedsFragment {
        return BreedsFragment.newInstance(createViewModel())
    }

    fun AppCompatActivity.addFragmentTo(containerId: Int, fragment: Fragment, tag: String = "") {
        supportFragmentManager.beginTransaction().add(containerId, fragment, tag).commit()
    }


}
