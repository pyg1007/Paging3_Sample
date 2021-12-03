package kr.ryan.paging_sample.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import kr.ryan.paging_sample.data.TestIngMockData
import kr.ryan.paging_sample.databinding.ItemPagingTestBinding

/**
 * Paging-Sample
 * Class: PagingViewHolder
 * Created by pyg10.
 * Created On 2021-12-02.
 * Description:
 */
class PagingViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: TestIngMockData.Item) = with(binding as ItemPagingTestBinding){
        binding.item = item
    }
}