package kotlin.com.br.jeferson.breeds

import android.app.Application
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.persistence.room.Room
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.com.br.jeferson.breeds.breedsAdapter.BindingAdapters
import kotlin.com.br.jeferson.breeds.breedsAdapter.BreedsAdapter
import kotlin.com.br.jeferson.breeds.connection.BreedRepository
import kotlin.com.br.jeferson.breeds.connection.DogCeoApi
import kotlin.com.br.jeferson.breeds.connection.DogCeoDataSource
import kotlin.com.br.jeferson.breeds.database.AppDatabase
import kotlin.com.br.jeferson.breeds.database.BreedDao
import kotlin.com.br.jeferson.breeds.databinding.BreedFragmentBinding
import kotlin.com.br.jeferson.breeds.model.Breed
import kotlin.com.br.jeferson.breeds.view_model.BreedsViewModel
import kotlin.com.br.jeferson.breeds.view_model.BreedsViewModelFactory
import org.koin.android.viewmodel.ext.android.viewModel

class BreedFragment : Fragment() {
    val vm: BreedsViewModel by viewModel()

    companion object {
        fun newInstance(): BreedFragment {
            return BreedFragment()
        }
    }

    override fun onStart() {
        super.onStart()
        vm.load()
    }

    override fun onCreateView(@NonNull inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : BreedFragmentBinding = BreedFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = vm
        binding.recyclerView.adapter = BreedsAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        val observer =  object : Observer<MutableList<Breed>> {
            override fun onChanged(t: MutableList<Breed>?) {
                BindingAdapters.setItems(binding.recyclerView, t!!.toMutableList())
            }

        }
        vm.breeds.observe(this, observer)

        return binding.root
    }

}