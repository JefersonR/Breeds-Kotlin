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

class BreedsViewModel (val repository: BreedDataSource, application: Application) : AndroidViewModel(application),
    LifecycleObserver {
    val breeds = MutableLiveData<List<Breed>>().apply { value = emptyList() }
    val loadingVisibility = MutableLiveData<Boolean>().apply { value = false }
    val message = MutableLiveData<String>().apply { value = "" }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun load() {
        loadingVisibility.postValue(true)
        message.postValue("")
        repository.listAll({ items ->
            breeds.postValue(items)
            if (items.isEmpty()) {
                message.postValue(getApplication<Application>().getString(R.string.breed_empty))
            }
            loadingVisibility.postValue(false)
        }, {
            message.postValue(getApplication<Application>().getString(R.string.breed_failed))
            loadingVisibility.postValue(false)
        })
    }
}

