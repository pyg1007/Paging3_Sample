package kr.ryan.paging_sample.data

import com.google.gson.annotations.SerializedName

/**
 * Paging-Sample
 * Class: GitHubLicense
 * Created by pyg10.
 * Created On 2021-11-22.
 * Description:
 */
data class GitHubLicense(
    @SerializedName("key") val key : String,
    @SerializedName("name") val name : String,
    @SerializedName("spdx_id") val spdx_id : String,
    @SerializedName("url") val url : String,
    @SerializedName("node_id") val node_id : String
)
