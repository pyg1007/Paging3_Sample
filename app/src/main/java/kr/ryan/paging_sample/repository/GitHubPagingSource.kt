package kr.ryan.paging_sample.repository

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import kr.ryan.paging_sample.data.GitHubResponse
import kr.ryan.paging_sample.usecase.LoadGitHubSearchDataUseCase

/**
 * Paging-Sample
 * Class: GitHubPagingSource
 * Created by pyg10.
 * Created On 2021-11-22.
 * Description:
 */
class GitHubPagingSource(
    private val useCase: LoadGitHubSearchDataUseCase,
    private val query: String,
    private val page: Int?,
    private val per_page: Int?
) : PagingSource<Int, GitHubResponse>() {
    override fun getRefreshKey(state: PagingState<Int, GitHubResponse>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GitHubResponse> {
        return try {
            Log.e("Paging Source", "${params.key}")
            val response = useCase.provideLoadData(query, page, per_page)
            LoadResult.Page(
                data = listOf(response),
                prevKey = null,
                nextKey = (params.key ?: 0) +1
            )

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}