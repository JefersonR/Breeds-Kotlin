package kt.com.br.jeferson.breeds.view_model

import android.app.Application
import android.arch.lifecycle.*
import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import kt.com.br.jeferson.breeds.R
import kt.com.br.jeferson.breeds.connection.BreedDataSource


class BreedsViewModel(val repository: BreedDataSource, val context: Context)  {


    val breeds = ObservableArrayList<BreedsItemViewModel>()
    val loadingVisibility = ObservableBoolean(false)
    val message = ObservableField<String>()

    fun load() : ObservableArrayList<BreedsItemViewModel>{
        loadingVisibility.set(true)
        message.set("")
        repository.listAll({ items ->
            breeds.clear()
            breeds.addAll(items)
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

