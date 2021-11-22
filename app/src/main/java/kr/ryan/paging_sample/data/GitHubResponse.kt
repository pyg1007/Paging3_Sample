package kr.ryan.paging_sample.data

import com.google.gson.annotations.SerializedName

/**
 * Paging-Sample
 * Class: GitHubResponse
 * Created by pyg10.
 * Created On 2021-11-22.
 * Description:
 */
data class GitHubResponse(
    @SerializedName("total_count") val total: Long,
    @SerializedName("incomplete_results") val incompleteResult : Boolean,
    @SerializedName("item") val gitHubItem: List<GitHubItem>
)
