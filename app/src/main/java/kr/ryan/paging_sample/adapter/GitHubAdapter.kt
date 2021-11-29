package kr.ryan.paging_sample.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import kr.ryan.paging_sample.data.GitHubResponse

/**
 * Paging-Sample
 * Class: GitHubAdapter
 * Created by pyg10.
 * Created On 2021-11-22.
 * Description:
 */
//class GitHubAdapter(diffCallback: DiffUtil.ItemCallback<List<GitHubResponse>>):
//    PagingDataAdapter<List<GitHubResponse>, GitHubViewHolder>(diffCallback) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubViewHolder {
//        return GitHubViewHolder.create(parent)
//    }
//
//    override fun onBindViewHolder(holder: GitHubViewHolder, position: Int) {
//        val item = getItem(position)
//        holder.bind(item)
//    }
//}