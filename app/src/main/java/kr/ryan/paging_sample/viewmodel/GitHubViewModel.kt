package kr.ryan.paging_sample.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kr.ryan.paging_sample.data.GitHubResponse
import kr.ryan.paging_sample.repository.GitHubPagingSource
import kr.ryan.paging_sample.usecase.LoadGitHubSearchDataUseCase
import javax.inject.Inject

/**
 * Paging-Sample
 * Class: GitHubViewModel
 * Created by pyg10.
 * Created On 2021-11-22.
 * Description:
 */
@HiltViewModel
class GitHubViewModel @Inject constructor(
    private val useCase: LoadGitHubSearchDataUseCase
) : ViewModel() {

    private val _searchResult = MutableStateFlow<PagingData<GitHubResponse>?>(null)
    val searchResult = _searchResult.asStateFlow()

    fun getSearchResultStream(query: String) = viewModelScope.launch {
        Pager(
            config = PagingConfig(
                pageSize = 50,
                enablePlaceholders = false
            )
        ) {
            GitHubPagingSource(useCase, query, 5, 10)
        }.flow.collect {
            _searchResult.emit(it)
            Log.e("ViewModel", "$it")
        }
    }

}