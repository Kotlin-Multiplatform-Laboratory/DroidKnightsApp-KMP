package com.droidknights.app.core.domain.usecase

import com.droidknights.app.core.data.repository.api.SponsorRepository
import com.droidknights.app.core.model.Sponsor
import org.koin.core.annotation.Factory

@Factory
open class GetSponsorsUseCase(
    private val sponsorRepository: SponsorRepository,
) {

    open suspend operator fun invoke(): List<Sponsor> =
        sponsorRepository
            .getSponsors()
            .sortedBy { it.grade.priority }
}
