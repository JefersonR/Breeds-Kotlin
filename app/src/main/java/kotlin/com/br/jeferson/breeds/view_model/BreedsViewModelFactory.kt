package kotlin.com.br.jeferson.breeds.view_model

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import kotlin.com.br.jeferson.breeds.connection.BreedDataSource

class BreedsViewModelFactory constructor(private val repository: BreedDataSource,
                                         private val application: Application): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(BreedsViewModel::class.java) ->
                    BreedsViewModel(repository, application)
                else ->
                    throw IllegalArgumentException("Classe desconhecida.")
            }
        } as T
}