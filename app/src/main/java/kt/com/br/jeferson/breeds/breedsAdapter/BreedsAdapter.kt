package kt.com.br.jeferson.breeds.breedsAdapter

import kt.com.br.jeferson.breeds.model.Breed
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kt.com.br.jeferson.breeds.R
import kt.com.br.jeferson.breeds.databinding.BreedItemBinding
import kt.com.br.jeferson.breeds.view_model.BreedsItemViewModel


class BreedsAdapter(var items: List<BreedsItemViewModel>) : RecyclerView.Adapter<BreedsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BreedItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])


    inner class ViewHolder(val binding: BreedItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BreedsItemViewModel) {
            binding.item = item
            binding.executePendingBindings()
        }
    }
}



