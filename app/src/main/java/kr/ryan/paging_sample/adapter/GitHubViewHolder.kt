package kr.ryan.paging_sample.adapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import kr.ryan.paging_sample.data.GitHubResponse
import kr.ryan.paging_sample.databinding.RecyclerGithubItemBinding

/**
 * Paging-Sample
 * Class: GitHubViewHolder
 * Created by pyg10.
 * Created On 2021-11-22.
 * Description:
 */
class GitHubViewHolder constructor(private val binding: RecyclerGithubItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(gitHubResponse: GitHubResponse?){
        gitHubResponse?.items?.get(bindingAdapterPosition)?.let {
            binding.item = it
        }
        Log.e("GitHubViewHolder", "${gitHubResponse?.totalCount}")
    }

}