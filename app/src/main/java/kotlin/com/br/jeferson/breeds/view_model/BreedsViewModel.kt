package kotlin.com.br.jeferson.breeds.view_model

import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import kotlin.com.br.jeferson.breeds.R
import kotlin.com.br.jeferson.breeds.connection.BreedDataSource
import kotlin.com.br.jeferson.breeds.model.Breed

class BreedsViewModel (val repository: BreedDataSource, val context: Context)  {
    val breeds = ObservableArrayList<Breed>()
    val loadingVisibility = ObservableBoolean(false)
    val message = ObservableField<String>()

    fun load() {
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
    }
}

