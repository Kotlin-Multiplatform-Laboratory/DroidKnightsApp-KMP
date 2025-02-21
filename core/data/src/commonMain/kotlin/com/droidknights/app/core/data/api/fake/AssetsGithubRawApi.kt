package com.droidknights.app.core.data.api.fake

import com.droidknights.app.core.data.api.GithubRawApi
import com.droidknights.app.core.data.api.model.ContributionYearResponse
import com.droidknights.app.core.data.api.model.SessionResponse
import com.droidknights.app.core.data.api.model.SponsorResponse
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.okio.decodeFromBufferedSource
import okio.BufferedSource

@OptIn(ExperimentalSerializationApi::class)
class AssetsGithubRawApi(
    private val json: Json,
    private val sponsors: BufferedSource,
    private val sessions: BufferedSource,
    private val contributors: BufferedSource,
) : GithubRawApi {

    override suspend fun getSponsors(): List<SponsorResponse> {
        return json.decodeFromBufferedSource(sponsors)
    }

    override suspend fun getSessions(): List<SessionResponse> {
        return json.decodeFromBufferedSource(sessions)
    }

    override suspend fun getContributorWithYears(): List<ContributionYearResponse> {
        return json.decodeFromBufferedSource(contributors)
    }
}
