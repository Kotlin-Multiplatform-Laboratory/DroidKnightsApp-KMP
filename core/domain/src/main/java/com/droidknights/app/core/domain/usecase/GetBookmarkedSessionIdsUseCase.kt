package com.droidknights.app.core.domain.usecase

import com.droidknights.app.core.data.repository.api.SessionRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Factory

@Factory
class GetBookmarkedSessionIdsUseCase(
    private val sessionRepository: SessionRepository,
) {

    operator fun invoke(): Flow<Set<String>> =
        sessionRepository.getBookmarkedSessionIds()
}
