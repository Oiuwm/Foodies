package orizemanltd.com.foodies.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import orizemanltd.com.foodies.databinding.RecipesRowLayoutBinding
import orizemanltd.com.foodies.models.Result

class RecipesAdapter() : ListAdapter<Result, RecipesAdapter.MyViewModel>(MainAdapterDiff) {

    //private var recipes = emptyList<Result>()

    class MyViewModel(private val binding: RecipesRowLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(result: Result) {
            binding.result = result
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MyViewModel {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecipesRowLayoutBinding.inflate(layoutInflater, parent, false)
                return MyViewModel(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewModel {
        return MyViewModel.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewModel, position: Int) {
        val currentRecipe = getItem(position)
        holder.bind(currentRecipe)
    }

    private object MainAdapterDiff : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
            return oldItem.id == newItem.id
        }

    }


//    private var recipe = emptyList<Result>()
//
//    class MyViewHolder(private val binding: RecipesRowLayoutBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(result: Result) {
//            binding.result = result
//            binding.executePendingBindings()
//        }
//
//        companion object {
//            fun from(parent: ViewGroup): MyViewHolder {
//                val layoutInflater = LayoutInflater.from(parent.context)
//                val binding = RecipesRowLayoutBinding.inflate(layoutInflater, parent, false)
//                return MyViewHolder(binding)
//            }
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        return MyViewHolder.from(parent)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val currentResult = recipe[position]
//    }
//
//    override fun getItemCount(): Int {
//        return recipe.size
//    }
//
//    fun setData(newData: FoodRecipe){
//        recipe = newData.results
//    }
}