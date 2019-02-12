package kotlin.com.br.jeferson.breeds.breedsAdapter

import android.databinding.DataBindingUtil
import kotlin.com.br.jeferson.breeds.model.Breed
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup


class BreedsAdapter(var items : List<Breed>) : RecyclerView.Adapter<BreedsAdapter.ViewHolder>(), AdapterItemsContract{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: BreedsItemBinding = BreedsItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun replaceItems(items: List<*>) {
        this.items = items as List<Breed>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(val binding: BreedsItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(breed: Breed) {
            binding.breed = breed
            binding.executePendingBindings()
        }
    }

}