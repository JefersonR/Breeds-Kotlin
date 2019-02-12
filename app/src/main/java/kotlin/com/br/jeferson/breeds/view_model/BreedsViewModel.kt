package kotlin.com.br.jeferson.breeds.view_model

import android.app.Application
import android.arch.lifecycle.*
import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import kotlin.com.br.jeferson.breeds.R
import kotlin.com.br.jeferson.breeds.connection.BreedDataSource
import kotlin.com.br.jeferson.breeds.model.Breed

class BreedsViewModel(private val repository: BreedDataSource, private val application: Application)  : ViewModel() {

    var breeds = MutableLiveData<MutableList<Breed>>()
    val loadingVisibility = ObservableBoolean(false)
    val message = ObservableField<String>()

    fun load() {
        loadingVisibility.set(true)
        message.set("")
        repository.listAll({ items ->
            breeds.postValue(items.toMutableList())
            if (items.isEmpty()) {
                message.set(application.getString(R.string.breed_empty))
            }
            loadingVisibility.set(false)
        }, {
            message.set(application.getString(R.string.breed_failed))
            loadingVisibility.set(false)
        })
    }



}

