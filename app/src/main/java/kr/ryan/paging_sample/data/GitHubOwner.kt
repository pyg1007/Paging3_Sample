package kr.ryan.paging_sample.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Paging-Sample
 * Class: GitHubOwner
 * Created by pyg10.
 * Created On 2021-11-22.
 * Description:
 */
data class GitHubOwner(
    @SerializedName("login")
    @Expose
    val login: String,
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("node_id")
    @Expose
    val nodeId: String,
    @SerializedName("avatar_url")
    @Expose
    val avatarUrl: String,
    @SerializedName("gravatar_id")
    @Expose
    val gravatarId: String,
    @SerializedName("url")
    @Expose
    val url: String,
    @SerializedName("html_url")
    @Expose
    val htmlUrl: String,
    @SerializedName("followers_url")
    @Expose
    val followersUrl: String,
    @SerializedName("following_url")
    @Expose
    val followingUrl: String,
    @SerializedName("gists_url")
    @Expose
    val gistsUrl: String,
    @SerializedName("starred_url")
    @Expose
    val starredUrl: String,
    @SerializedName("subscriptions_url")
    @Expose
    val subscriptionsUrl: String,
    @SerializedName("organizations_url")
    @Expose
    val organizationsUrl: String,
    @SerializedName("repos_url")
    @Expose
    val reposUrl: String,
    @SerializedName("events_url")
    @Expose
    val eventsUrl: String,
    @SerializedName("received_events_url")
    @Expose
    val receivedEventsUrl: String,
    @SerializedName("type")
    @Expose
    val type: String,
    @SerializedName("site_admin")
    @Expose
    val siteAdmin: Boolean
)
