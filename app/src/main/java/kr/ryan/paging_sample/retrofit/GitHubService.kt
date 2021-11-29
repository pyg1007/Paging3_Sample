package kr.ryan.paging_sample.retrofit

import kr.ryan.paging_sample.data.GitHubResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Paging-Sample
 * Class: GitHubService
 * Created by pyg10.
 * Created On 2021-11-22.
 * Description:
 */
interface GitHubService {

    @GET("repositories?sort=stars")
    suspend fun getGitHubSearchResult(
        @Query("q") query: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): GitHubResponse

}