package kr.ryan.paging_sample.usecase

import kr.ryan.paging_sample.repository.LoadGitHubRepository
import javax.inject.Inject

/**
 * Paging-Sample
 * Class: GitHubLoadSearchData
 * Created by pyg10.
 * Created On 2021-11-22.
 * Description:
 */
class LoadGitHubSearchDataUseCase @Inject constructor(
    private val loadGitHubRepository: LoadGitHubRepository
) {

    suspend fun provideLoadData(
        query: String, page: Int?, per_page: Int?
    ) = loadGitHubRepository.loadData(query, page, per_page)

}