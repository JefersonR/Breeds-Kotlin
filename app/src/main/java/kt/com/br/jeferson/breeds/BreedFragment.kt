package kt.com.br.jeferson.breeds


import android.os.Bundle
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kt.com.br.jeferson.breeds.breedsAdapter.BreedsAdapter
import kt.com.br.jeferson.breeds.databinding.BreedFragmentBinding
import kt.com.br.jeferson.breeds.view_model.BreedsItemViewModel
import kt.com.br.jeferson.breeds.view_model.BreedsViewModel
import java.util.*


class BreedFragment : Fragment() {

    lateinit var viewModel: BreedsViewModel


    companion object {
        fun newInstance(viewModel: BreedsViewModel): BreedFragment {
            val fragment = BreedFragment()
            fragment.viewModel = viewModel
            return fragment
        }
    }


    override fun onCreateView(
        @NonNull inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val binding: BreedFragmentBinding = BreedFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.recyclerView.adapter = BreedsAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        viewModel.loadBreeads().observe(this,
            android.arch.lifecycle.Observer<List<BreedsItemViewModel?>>{t ->
                binding.recyclerView.adapter = BreedsAdapter(t as List<BreedsItemViewModel>)
                binding.recyclerView.adapter.notifyDataSetChanged()

        })


        return binding.root
    }


}


