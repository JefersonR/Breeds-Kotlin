package kotlin.com.br.jeferson.breeds

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlin.com.br.jeferson.breeds.breedsAdapter.BreedsAdapter
import kotlin.com.br.jeferson.breeds.view_model.BreedsViewModel


class BreedFragment : Fragment() {

    companion object {
        fun newInstance(viewModel: BreedsViewModel) : BreedFragment{
            val fragment = BreedFragment()

            fragment.viewModel = viewModel
            return fragment
        }
    }

    private lateinit var viewModel: BreedsViewModel


    override fun onStart() {
        super.onStart()
        viewModel.load()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View?
    {
        val binding : BreedsFragmentBinding = BreedsFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.recyclerView.adapter = BreedsAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        return binding.root
    }



}
