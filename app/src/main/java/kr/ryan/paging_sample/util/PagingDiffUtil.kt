package kr.ryan.paging_sample.util

import androidx.recyclerview.widget.DiffUtil
import kr.ryan.paging_sample.data.TestIngMockData

/**
 * Paging-Sample
 * Class: PagingDiffUtil
 * Created by pyg10.
 * Created On 2021-12-03.
 * Description:
 */
object PagingDiffUtil : DiffUtil.ItemCallback<TestIngMockData.Item>() {

    override fun areContentsTheSame(oldItem: TestIngMockData.Item, newItem: TestIngMockData.Item): Boolean =
        oldItem.hashCode() == newItem.hashCode()

    override fun areItemsTheSame(oldItem: TestIngMockData.Item, newItem: TestIngMockData.Item): Boolean =
        oldItem == newItem
}