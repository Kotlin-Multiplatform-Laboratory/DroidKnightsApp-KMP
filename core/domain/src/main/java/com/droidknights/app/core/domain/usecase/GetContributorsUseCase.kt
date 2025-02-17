package com.droidknights.app.core.domain.usecase

import com.droidknights.app.core.data.repository.api.ContributorRepository
import com.droidknights.app.core.model.ContributorGroup
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
class GetContributorsUseCase (
    private val repository: ContributorRepository,
) {

    operator fun invoke(): Flow<List<ContributorGroup>> =
        repository.flowContributors(
            owner = OWNER,
            name = NAME,
        )

    companion object {

        private const val OWNER = "droidknights"

        private const val NAME = "DroidKnightsApp"
    }
}
