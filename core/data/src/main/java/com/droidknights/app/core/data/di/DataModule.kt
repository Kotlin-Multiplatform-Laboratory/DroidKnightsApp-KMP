package com.droidknights.app.core.data.di

import android.content.Context
import com.droidknights.app.core.data.api.GithubApi
import com.droidknights.app.core.data.api.GithubRawApi
import com.droidknights.app.core.data.api.fake.AssetsGithubRawApi
import com.droidknights.app.core.data.repository.DefaultContributorRepository
import com.droidknights.app.core.data.repository.DefaultSessionRepository
import com.droidknights.app.core.data.repository.DefaultSettingsRepository
import com.droidknights.app.core.data.repository.DefaultSponsorRepository
import com.droidknights.app.core.data.repository.api.ContributorRepository
import com.droidknights.app.core.data.repository.api.SessionRepository
import com.droidknights.app.core.data.repository.api.SettingsRepository
import com.droidknights.app.core.data.repository.api.SponsorRepository
import com.droidknights.app.core.datastore.datasource.DefaultSessionPreferencesDataSource
import com.droidknights.app.core.datastore.datasource.SessionPreferencesDataSource
import kotlinx.serialization.json.Json
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan
class DataModule {

    @Single(binds = [SettingsRepository::class])
    fun bindsSettingsRepository(
        repository: DefaultSettingsRepository
    ): SettingsRepository = repository

    @Single(binds = [SessionPreferencesDataSource::class])
    fun bindSessionLocalDataSource(
        dataSource: DefaultSessionPreferencesDataSource,
    ): SessionPreferencesDataSource = dataSource
}

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
        context: Context,
        json: Json,
    ): AssetsGithubRawApi =
        AssetsGithubRawApi(
            json = json,
            sponsors = context.assets.open("sponsors.json"),
            sessions = context.assets.open("sessions.json"),
            contributors = context.assets.open("contributors.json"),
        )
}
