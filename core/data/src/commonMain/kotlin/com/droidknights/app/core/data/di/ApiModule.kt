package com.droidknights.app.core.data.di

import com.droidknights.app.core.data.api.GithubApi
import com.droidknights.app.core.data.api.GithubRawApi
import com.droidknights.app.core.data.api.createGithubApi
import com.droidknights.app.core.data.api.createGithubRawApi
import kotlinx.serialization.json.Json
import de.jensklingenberg.ktorfit.Ktorfit
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Named
import org.koin.core.annotation.Single

@Module
@ComponentScan
class ApiModule {

    @Single
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    @Single
    fun provideHttpClient(
        json: Json,
    ): HttpClient = HttpClient {
        install(ContentNegotiation) {
            json(json = json)
        }
    }

    @Single
    @Named("github")
    fun provideGithubKtrofit(
        httpClient: HttpClient
    ): Ktorfit = Ktorfit.Builder()
        .baseUrl("https://api.github.com/")
        .httpClient(client = httpClient)
        .build()

    @Single
    @Named("gitraw")
    fun provideGitRawKtorfit(
        httpClient: HttpClient
    ): Ktorfit = Ktorfit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .httpClient(client = httpClient)
        .build()

    @Single
    fun provideGithubApi(
        @Named("github") ktorfit: Ktorfit
    ): GithubApi = ktorfit.createGithubApi()

    @Single
    fun provideGitRawApi(
        @Named("gitraw") ktorfit: Ktorfit
    ): GithubRawApi = ktorfit.createGithubRawApi()
}
