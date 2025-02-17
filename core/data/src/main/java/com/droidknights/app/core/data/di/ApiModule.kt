package com.droidknights.app.core.data.di

import com.droidknights.app.core.data.api.GithubApi
import com.droidknights.app.core.data.api.GithubRawApi
import com.droidknights.app.core.data.api.createGithubApi
import com.droidknights.app.core.data.api.createGithubRawApi
import com.droidknights.app.core.data.di.qualifier.GitRaw
import com.droidknights.app.core.data.di.qualifier.Github
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
    @Github
    fun provideGithubKtrofit(
        httpClient: HttpClient
    ): Ktorfit = Ktorfit.Builder()
        .baseUrl("https://api.github.com/")
        .httpClient(client = httpClient)
        .build()

    @Provides
    @Singleton
    @GitRaw
    fun provideGitRawKtorfit(
        httpClient: HttpClient
    ): Ktorfit = Ktorfit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .httpClient(client = httpClient)
        .build()

    @Provides
    @Singleton
    fun provideGithubApi(
        @Github ktorfit: Ktorfit
    ): GithubApi = ktorfit.createGithubApi()

    @Provides
    @Singleton
    fun provideGitRawApi(
        @GitRaw ktorfit: Ktorfit
    ): GithubRawApi = ktorfit.createGithubRawApi()

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }
}
