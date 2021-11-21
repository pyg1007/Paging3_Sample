package kr.ryan.paging_sample.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import java.lang.Exception

/**
 * Paging-Sample
 * Class: GitHubPagingSource
 * Created by pyg10.
 * Created On 2021-11-22.
 * Description:
 */
class GitHubPagingSource() : PagingSource<Int, String>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
        return try {
            LoadResult.Page(
                data = listOf("A"),
                prevKey = null,
                nextKey = 1
            )
        }catch(e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, String>): Int? {
        return state.anchorPosition?.let { anchorPosition->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}