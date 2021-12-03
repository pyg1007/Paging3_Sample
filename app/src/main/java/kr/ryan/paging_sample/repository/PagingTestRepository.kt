package kr.ryan.paging_sample.repository

import javax.inject.Inject

/**
 * Paging-Sample
 * Class: PagingTestRepository
 * Created by pyg10.
 * Created On 2021-12-02.
 * Description:
 */
class PagingTestRepository @Inject constructor() {

    fun createMockData(page: Int): Pair<List<String>, Int?> {
        return if (page < 50) Pair(listOf("A $page", "B $page", "C $page"), page +1)
        else Pair(listOf(), null)
    }

}