package choigoyo.study.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import choigoyo.study.todo.databinding.ActivityMainBinding
import choigoyo.study.todo.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val adapter = RecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.recyclerView.adapter = adapter

        viewModel.todoList.observe(this) {
            adapter.submitList(it.toList()) // 새 리스트로 갱신
        }

        binding.addButton.setOnClickListener {
            val content = binding.editText.text.toString()
            viewModel.addTodo(content)
            binding.editText.text.clear()
        }
    }
}
