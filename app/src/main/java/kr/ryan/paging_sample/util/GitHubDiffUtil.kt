package kr.ryan.paging_sample.util

import androidx.recyclerview.widget.DiffUtil
import kr.ryan.paging_sample.data.GitHubResponse

/**
 * Paging-Sample
 * Class: GitHubDiffUtil
 * Created by pyg10.
 * Created On 2021-11-22.
 * Description:
 */
object GitHubDiffUtil : DiffUtil.ItemCallback<GitHubResponse>(){
    override fun areItemsTheSame(oldItem: GitHubResponse, newItem: GitHubResponse): Boolean
    = oldItem == newItem

    override fun areContentsTheSame(oldItem: GitHubResponse, newItem: GitHubResponse): Boolean
    = oldItem.hashCode() == newItem.hashCode()
}