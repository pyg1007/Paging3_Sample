package kr.ryan.paging_sample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.map
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kr.ryan.paging_sample.data.TestIngMockData
import kr.ryan.paging_sample.repository.PagingTestRepository
import kr.ryan.paging_sample.repository.TestPagingSource
import javax.inject.Inject

/**
 * Paging-Sample
 * Class: TestViewModel
 * Created by pyg10.
 * Created On 2021-12-02.
 * Description:
 */
@HiltViewModel
class TestViewModel @Inject constructor(
    private val pagingTestRepository: PagingTestRepository
) : ViewModel() {

    val flow = Pager(
        PagingConfig(pageSize = 10)
    ) {
        TestPagingSource(pagingTestRepository)
    }.flow.map {
        it.map { value->
            TestIngMockData.Item(value)
        }
    }.cachedIn(viewModelScope)
}