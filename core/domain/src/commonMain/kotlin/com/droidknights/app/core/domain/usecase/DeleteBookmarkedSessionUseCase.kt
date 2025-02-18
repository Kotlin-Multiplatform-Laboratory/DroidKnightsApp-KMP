package com.droidknights.app.core.domain.usecase

import com.droidknights.app.core.data.repository.api.SessionRepository
import org.koin.core.annotation.Factory

@Factory
class DeleteBookmarkedSessionUseCase(
    private val sessionRepository: SessionRepository,
) {
    suspend operator fun invoke(sessionIds: Set<String>) =
        sessionRepository.deleteBookmarkedSessions(sessionIds)
}
