package choigoyo.study.todo.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import choigoyo.study.todo.model.TodoItemModel

class MainViewModel : ViewModel() {
    private var _todoList = MutableLiveData<List<TodoItemModel>>()
    val todoList: LiveData<List<TodoItemModel>>
        get() = _todoList
    private var items = mutableListOf<TodoItemModel>()

    init {
        items = arrayListOf(
            TodoItemModel("Todo 1"),
            TodoItemModel("Todo 2")
        )
        _todoList.postValue(items)
    }

    // TODO: 추가
    fun addTodoItem(content: String) {
        if (content.isEmpty()) {
            items.add(TodoItemModel(content = content))
            _todoList.postValue(items)
        }
    }

    // TODO: 삭제
    fun removeTodoItem(item: TodoItemModel) {
        items.remove(item)
        _todoList.postValue(items)
    }
}