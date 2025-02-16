package com.droidknights.app.core.data.di

import com.droidknights.app.core.data.api.GithubApi
import com.droidknights.app.core.data.api.GithubRawApi
import com.droidknights.app.core.data.api.createGithubApi
import com.droidknights.app.core.data.api.createGithubRawApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object ApiModule {

    @Provides
    @Singleton
    fun provideHttpClient(
        json: Json,
    ): HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(json = json)
        }
    }

    @Provides
    @Singleton
    fun provideGithubApi(
        httpClient: HttpClient
    ): GithubApi = Ktorfit.Builder()
        .baseUrl("https://api.github.com/")
        .httpClient(client = httpClient)
        .build()
        .createGithubApi()

    @Provides
    @Singleton
    fun provideGitRawApi(
        httpClient: HttpClient
    ): GithubRawApi = Ktorfit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .httpClient(client = httpClient)
        .build()
        .createGithubRawApi()

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }
}
