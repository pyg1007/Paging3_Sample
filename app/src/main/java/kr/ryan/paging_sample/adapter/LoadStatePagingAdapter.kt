package kr.ryan.paging_sample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import kr.ryan.paging_sample.R
import kr.ryan.paging_sample.databinding.ItemLoadStateBinding

/**
 * Paging-Sample
 * Class: LoadStatePagingAdapter
 * Created by pyg10.
 * Created On 2021-12-02.
 * Description:
 */
class LoadStatePagingAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<LoadStateViewHolder>(){
    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val binding = DataBindingUtil.inflate<ItemLoadStateBinding>(LayoutInflater.from(parent.context), R.layout.item_load_state, parent, false)
        return LoadStateViewHolder(binding, retry)
    }
}