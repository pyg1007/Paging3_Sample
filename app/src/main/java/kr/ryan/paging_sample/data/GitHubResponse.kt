package kr.ryan.paging_sample.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Paging-Sample
 * Class: GitHubResponse
 * Created by pyg10.
 * Created On 2021-11-22.
 * Description:
 */
data class GitHubResponse(
    @SerializedName("total_count")
    @Expose
    val totalCount: Int,
    @SerializedName("incomplete_results")
    @Expose
    val incompleteResults: Boolean,
    @SerializedName("items")
    @Expose
    val items: List<GitHubItem>?
){
    companion object{
        val EMPTY = GitHubResponse(0, false, null)
    }
}
