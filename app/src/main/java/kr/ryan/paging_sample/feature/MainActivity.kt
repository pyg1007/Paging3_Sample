package kr.ryan.paging_sample.feature

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kr.ryan.paging_sample.R
import kr.ryan.paging_sample.adapter.LoadStatePagingAdapter
import kr.ryan.paging_sample.adapter.PagingAdapter
import kr.ryan.paging_sample.databinding.ActivityMainBinding
import kr.ryan.paging_sample.util.PagingDiffUtil
import kr.ryan.paging_sample.viewmodel.TestViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val viewModel by viewModels<TestViewModel>()

    private val pagingAdapter = PagingAdapter(PagingDiffUtil)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initRecycler()

        lifecycleScope.launch {
            viewModel.flow.collectLatest {
                pagingAdapter.submitData(it)
            }
        }
    }

    private fun initRecycler() {
        binding.recyclerGithub.adapter = pagingAdapter.withLoadStateFooter(LoadStatePagingAdapter { pagingAdapter.retry() })
        pagingAdapter.addLoadStateListener {
            if (it.refresh is LoadState.Error){
                pagingAdapter.retry()
            }
        }
    }

}