package com.droidknights.app.core.data.di

import com.droidknights.app.core.data.api.GithubApi
import com.droidknights.app.core.data.api.GithubRawApi
import com.droidknights.app.core.data.api.fake.AssetsGithubRawApi
import com.droidknights.app.core.data.file.defaultAssetFileProvider
import com.droidknights.app.core.data.repository.DefaultContributorRepository
import com.droidknights.app.core.data.repository.DefaultSessionRepository
import com.droidknights.app.core.data.repository.DefaultSponsorRepository
import com.droidknights.app.core.data.repository.api.ContributorRepository
import com.droidknights.app.core.data.repository.api.SessionRepository
import com.droidknights.app.core.data.repository.api.SponsorRepository
import com.droidknights.app.core.datastore.datasource.SessionPreferencesDataSource
import kotlinx.serialization.json.Json
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan
class FakeModule {
    @Single
    fun provideSponsorRepository(
        githubRawApi: GithubRawApi,
    ): SponsorRepository =
        DefaultSponsorRepository(githubRawApi)

    @Single
    fun provideSessionRepository(
        githubRawApi: GithubRawApi,
        sessionDataSource: SessionPreferencesDataSource,
    ): SessionRepository =
        DefaultSessionRepository(githubRawApi, sessionDataSource)

    @Single
    fun provideContributorRepository(
        githubApi: GithubApi,
        githubRawApi: AssetsGithubRawApi,
    ): ContributorRepository =
        DefaultContributorRepository(githubApi, githubRawApi)

    @Single
    fun provideGithubRawApi(
        json: Json,
    ): AssetsGithubRawApi =
        AssetsGithubRawApi(
            json = json,
            sponsors = defaultAssetFileProvider.get("sponsors.json"),
            sessions = defaultAssetFileProvider.get("sessions.json"),
            contributors = defaultAssetFileProvider.get("contributors.json"),
        )
}
