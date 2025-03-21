package com.droidknights.app.feature.home.stub

import com.droidknights.app.core.data.repository.api.SponsorRepository
import com.droidknights.app.core.model.Sponsor

class StubSponsorRepository(
    private val sponsors: List<Sponsor>
) : SponsorRepository {
    override suspend fun getSponsors(): List<Sponsor> {
        return sponsors
    }
}