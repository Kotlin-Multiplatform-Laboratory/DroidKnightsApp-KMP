package com.droidknights.app.feature.contributor.model.convert

import com.droidknights.app.core.model.ContributorGroup
import com.droidknights.app.feature.contributor.model.ContributorsUiState
import kotlinx.collections.immutable.toPersistentList

internal fun List<ContributorGroup>.toContributorsUiState(): ContributorsUiState =
    ContributorsUiState.Contributors(
        contributors = flatMap { (year, contributors) ->
            listOf(ContributorsUiState.Contributors.Item.Section(title = year.toString())) + contributors.map { contributor ->
                ContributorsUiState.Contributors.Item.User(
                    id = contributor.id,
                    imageUrl = contributor.imageUrl,
                    githubUrl = contributor.githubUrl,
                    name = contributor.name
                )
            }
        }.toPersistentList(),
    )