package kr.ryan.paging_sample.adapter

import androidx.databinding.ViewDataBinding
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import kr.ryan.paging_sample.databinding.ItemLoadStateBinding

/**
 * Paging-Sample
 * Class: LoadStateViewHolder
 * Created by pyg10.
 * Created On 2021-12-02.
 * Description:
 */
class LoadStateViewHolder (private val binding: ViewDataBinding, private val retry: () -> Unit) : RecyclerView.ViewHolder(binding.root) {

    fun bind(loadState: LoadState) = with(binding as ItemLoadStateBinding){
        binding.retryButton.setOnClickListener { retry() }
        binding.isLoading = loadState is LoadState.Loading
        binding.isError = loadState is LoadState.Error
        binding.errorMessage = (loadState as? LoadState.Error)?.error?.message ?: ""
        binding.executePendingBindings()
    }

}