package kr.ryan.paging_sample.usecase

import kr.ryan.paging_sample.repository.PagingTestRepository
import javax.inject.Inject

/**
 * Paging-Sample
 * Class: PagingDataUseCase
 * Created by pyg10.
 * Created On 2021-12-02.
 * Description:
 */
class PagingDataUseCase @Inject constructor(
    private val repository: PagingTestRepository
) {

    fun createMockData(page: Int) : Pair<List<String>, Int?>{
        return repository.createMockData(page)
    }
}