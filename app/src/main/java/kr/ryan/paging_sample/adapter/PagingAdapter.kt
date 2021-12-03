package kr.ryan.paging_sample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kr.ryan.paging_sample.R
import kr.ryan.paging_sample.data.TestIngMockData
import kr.ryan.paging_sample.databinding.ItemPagingTestBinding
import kr.ryan.paging_sample.repository.TestPagingSource
import javax.inject.Inject

/**
 * Paging-Sample
 * Class: PagingAdapter
 * Created by pyg10.
 * Created On 2021-12-02.
 * Description:
 */
class PagingAdapter constructor(diffUtil: DiffUtil.ItemCallback<TestIngMockData.Item>) : PagingDataAdapter<TestIngMockData.Item, PagingViewHolder>(diffUtil){
    override fun onBindViewHolder(holder: PagingViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagingViewHolder {
        val binding = DataBindingUtil.inflate<ItemPagingTestBinding>(LayoutInflater.from(parent.context), R.layout.item_paging_test, parent, false)
        return PagingViewHolder(binding)
    }
}