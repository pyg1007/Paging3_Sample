package kr.ryan.paging_sample.data

/**
 * Paging-Sample
 * Class: TestIngMockData
 * Created by pyg10.
 * Created On 2021-12-02.
 * Description:
 */
sealed class TestIngMockData{
    data class Item(val title: String) : TestIngMockData()
}
