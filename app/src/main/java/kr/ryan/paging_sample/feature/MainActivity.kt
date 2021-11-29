package kr.ryan.paging_sample.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.whenCreated
import androidx.paging.map
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kr.ryan.paging_sample.R
import kr.ryan.paging_sample.databinding.ActivityMainBinding
import kr.ryan.paging_sample.viewmodel.GitHubViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val viewModel by viewModels<GitHubViewModel>()

    private lateinit var binding: ActivityMainBinding

    init {
        lifecycleScope.launch {
            whenCreated {
                //initView()
            }
            repeatOnLifecycle(Lifecycle.State.STARTED){
                launch {
//                    viewModel.searchResult.collectLatest {paging ->
//                        Log.e("Init", "$paging")
//                        paging?.map {
//                            Log.e("data", "$it")
//                        }
//                    }
                }

                launch {
                    viewModel.test.collectLatest {
                        Log.e("Main", "$it")
                    }
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

//    private fun initView(){
//        binding.tvTest.setOnClickListener {
//            Log.e("onClick", "Click")
//            viewModel.getSearchResultStream(binding.tvTest.text.toString())
//        }
//    }

}