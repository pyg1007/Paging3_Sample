package kr.ryan.paging_sample.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import javax.inject.Inject

/**
 * Paging-Sample
 * Class: TestPagingSource
 * Created by pyg10.
 * Created On 2021-12-02.
 * Description:
 */
class TestPagingSource @Inject constructor(
    private val repository: PagingTestRepository
) : PagingSource<Int, String>(){

    override fun getRefreshKey(state: PagingState<Int, String>): Int? {
        return state.anchorPosition?.let { position->
            val statePosition = state.closestPageToPosition(position)
            statePosition?.prevKey?.plus(1) ?: statePosition?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, String> {
        return runCatching {
            val nextKey = params.key ?: 1
            val response = repository.createMockData(nextKey)
            LoadResult.Page(
                data = response.first,
                prevKey = null,
                nextKey = response.second
            )
        }.getOrElse {
            LoadResult.Error(it)
        }
    }
}