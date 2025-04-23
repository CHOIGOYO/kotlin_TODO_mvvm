package choigoyo.study.todo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import choigoyo.study.todo.databinding.RecyclerItemBinding
import choigoyo.study.todo.model.TodoItemModel

class RecyclerAdapter: ListAdapter<TodoItemModel, RecyclerAdapter.MyViewHolder>(diffUtil) {
    inner class MyViewHolder(private val binding: RecyclerItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(todo : TodoItemModel){
            binding.model = todo
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RecyclerItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    companion object{
        val diffUtil = object: DiffUtil.ItemCallback<TodoItemModel>(){
            override fun areItemsTheSame(oldItem: TodoItemModel, newItem: TodoItemModel): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: TodoItemModel, newItem: TodoItemModel): Boolean {
                return oldItem == newItem
            }

        }
    }

}