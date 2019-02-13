package kt.com.br.jeferson.breeds.view_model

import android.app.Application
import android.arch.lifecycle.*
import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import kt.com.br.jeferson.breeds.R
import kt.com.br.jeferson.breeds.connection.BreedDataSource
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.LiveData


class BreedsViewModel(val repository: BreedDataSource, val context: Context)  {



    val loadingVisibility = ObservableBoolean(false)
    val message = ObservableField<String>()

    val breeds = MutableLiveData<List<BreedsItemViewModel?>>()


     fun loadBreeads() : LiveData<List<BreedsItemViewModel?>>{
        loadingVisibility.set(true)
        message.set("")
        repository.listAll({ items ->
            breeds.value = items
            if (items.isEmpty()) {
                message.set(context.getString(R.string.breed_empty))
            }
            loadingVisibility.set(false)
        }, {
            message.set(context.getString(R.string.breed_failed))
            loadingVisibility.set(false)
        })

      return breeds
    }


}

