package com.droidknights.app.feature.home.test

import app.cash.turbine.test
import com.droidknights.app.core.domain.usecase.GetSponsorsUseCase
import com.droidknights.app.core.model.Sponsor
import com.droidknights.app.feature.home.HomeViewModel
import com.droidknights.app.feature.home.model.SponsorsUiState
import com.droidknights.app.feature.home.stub.StubSponsorRepository
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
class HomeViewModelTest : BehaviorSpec({

    val mainThreadSurrogate = newSingleThreadContext("UI thread")

    beforeSpec {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    afterSpec {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    lateinit var viewModel: HomeViewModel

    given("후원사 리스트가 비어있다면") {
        beforeTest {
            val stubSponsorRepository = StubSponsorRepository(sponsors = emptyList())
            viewModel = HomeViewModel(GetSponsorsUseCase(stubSponsorRepository))
        }

        then("후원사 데이터를 확인할 수 없다") {
            runTest {
                viewModel.sponsorsUiState.test {
                    awaitItem()
                    val actual = awaitItem()
                    actual.shouldBeInstanceOf<SponsorsUiState.Empty>()
                }
            }
        }
    }

    given("후원사 리스트가 존재한다면") {
        beforeTest {
            val stubSponsorRepository = StubSponsorRepository(sponsors = fakeSponsors)
            viewModel = HomeViewModel(GetSponsorsUseCase(stubSponsorRepository))
        }

        then("후원사 데이터를 확인할 수 있다") {
            runTest {
                viewModel.sponsorsUiState.test {
                    awaitItem()
                    val actual = awaitItem()
                    val sponsorsList = actual.shouldBeInstanceOf<SponsorsUiState.Sponsors>()

                    sponsorsList.sponsors.size shouldBe 2

                    sponsorsList.sponsors.map { it.name } shouldBe listOf("Sponsor2", "Sponsor1")

                    sponsorsList.sponsors.map { it.grade } shouldBe listOf(
                        Sponsor.Grade.PLATINUM, Sponsor.Grade.GOLD
                    )
                }
            }
        }
    }
}) {
    companion object {
        private val fakeSponsors = listOf(
            Sponsor(
                name = "Sponsor1",
                homepage = "https://www.instagram.com/droid_knights",
                grade = Sponsor.Grade.GOLD,
                imageUrl = "https://avatars.githubusercontent.com/u/25101514",
            ),
            Sponsor(
                name = "Sponsor2",
                homepage = "https://www.instagram.com/droid_knights",
                grade = Sponsor.Grade.PLATINUM,
                imageUrl = "https://avatars.githubusercontent.com/u/25101514",
            ),
        )
    }
}
