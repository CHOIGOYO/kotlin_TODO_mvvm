package choigoyo.study.todo

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import choigoyo.study.todo.model.TodoItemModel

object MyBindingAdapter {
    @BindingAdapter("items")
    @JvmStatic
    fun setItem(recyclerView: RecyclerView, todoList: List<TodoItemModel>?){
        if(recyclerView.adapter == null){
            val adapter = RecyclerAdapter()
            recyclerView.adapter = adapter
        }

        todoList?.let{
            val myAdapter = recyclerView.adapter as RecyclerAdapter
            myAdapter.submitList(it)
            myAdapter.notifyDataSetChanged()
        }
    }
}