package kr.ryan.paging_sample.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import kr.ryan.paging_sample.R
import kr.ryan.paging_sample.data.GitHubResponse

/**
 * Paging-Sample
 * Class: GitHubAdapter
 * Created by pyg10.
 * Created On 2021-11-22.
 * Description:
 */
class GitHubAdapter(diffCallback: DiffUtil.ItemCallback<GitHubResponse>) :
    PagingDataAdapter<GitHubResponse, GitHubViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitHubViewHolder {
        return GitHubViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.recycler_github_item, parent, false))
    }

    override fun onBindViewHolder(holder: GitHubViewHolder, position: Int) {
        val item = getItem(position)
        Log.e("onBindViewHolder", item?.totalCount.toString())
        holder.bind(item)
    }
}