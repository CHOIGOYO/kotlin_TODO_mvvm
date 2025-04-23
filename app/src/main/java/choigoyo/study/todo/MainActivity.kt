package choigoyo.study.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import choigoyo.study.todo.databinding.ActivityMainBinding
import choigoyo.study.todo.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val mainVM : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 레이아웃 파일을 데이터 바인딩 객체(binding)와 연결
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        // 데이터 바인딩에서 LiveData를 사용하기 위해 생명주기 소유자를 설정
        binding.lifecycleOwner = this
        // 레이아웃을 화면에 표시
        binding.viewModel = mainVM
    }
}