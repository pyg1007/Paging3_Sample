package kr.ryan.paging_sample.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Paging-Sample
 * Class: GitHubLicense
 * Created by pyg10.
 * Created On 2021-11-22.
 * Description:
 */
data class GitHubLicense(
    @SerializedName("key")
    @Expose
    val key: String,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("spdx_id")
    @Expose
    val spdxId: String,
    @SerializedName("url")
    @Expose
    val url: Any,
    @SerializedName("node_id")
    @Expose
    val nodeId: String
)
