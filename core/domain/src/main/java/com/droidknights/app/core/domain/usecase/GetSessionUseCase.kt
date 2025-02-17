package com.droidknights.app.core.domain.usecase

import com.droidknights.app.core.data.repository.api.SessionRepository
import com.droidknights.app.core.model.Session
import org.koin.core.annotation.Factory

@Factory
class GetSessionUseCase(
    private val sessionRepository: SessionRepository,
) {

    suspend operator fun invoke(sessionId: String): Session =
        sessionRepository.getSession(sessionId)
}
