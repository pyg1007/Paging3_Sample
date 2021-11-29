package kr.ryan.paging_sample.repository

import androidx.annotation.WorkerThread
import kr.ryan.paging_sample.retrofit.GitHubService
import javax.inject.Inject

/**
 * Paging-Sample
 * Class: LoadGitHub
 * Created by pyg10.
 * Created On 2021-11-22.
 * Description:
 */
class LoadGitHubRepository @Inject constructor(
    private val githubService: GitHubService
) {

    @WorkerThread
    suspend fun loadData(
        query: String, page: Int?, per_page: Int?
    ) = githubService.getGitHubSearchResult(query, page ?: 1, per_page ?: 30)

}