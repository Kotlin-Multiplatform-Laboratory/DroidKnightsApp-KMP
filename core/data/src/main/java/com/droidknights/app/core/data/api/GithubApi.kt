package com.droidknights.app.core.data.api

import com.droidknights.app.core.data.api.model.ContributorResponse
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path

internal interface GithubApi {

    @GET("repos/{owner}/{name}/contributors")
    suspend fun getContributors(
        @Path("owner") owner: String,
        @Path("name") name: String,
    ): List<ContributorResponse>
}
