package kr.ryan.paging_sample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kr.ryan.paging_sample.repository.GitHubPagingSource
import javax.inject.Inject

/**
 * Paging-Sample
 * Class: GitHubViewModel
 * Created by pyg10.
 * Created On 2021-11-22.
 * Description:
 */
@HiltViewModel
class GitHubViewModel @Inject constructor() : ViewModel() {

    fun getSearchResultStream(query: String): Flow<PagingData<String>> {
        return Pager(
            config = PagingConfig(
                pageSize = 50,
                enablePlaceholders = false
            )
        ) {
            GitHubPagingSource()
        }.flow.cachedIn(viewModelScope)
    }

}