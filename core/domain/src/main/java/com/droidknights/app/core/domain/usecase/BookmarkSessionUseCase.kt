package com.droidknights.app.core.domain.usecase

import com.droidknights.app.core.data.repository.api.SessionRepository
import org.koin.core.annotation.Factory

@Factory
class BookmarkSessionUseCase(
    private val sessionRepository: SessionRepository,
) {
    suspend operator fun invoke(sessionId: String, bookmark: Boolean) =
        sessionRepository.bookmarkSession(sessionId, bookmark)
}
