package com.droidknights.app.feature.home

import com.droidknights.app.core.model.Sponsor
import com.droidknights.app.feature.home.model.SponsorsUiState
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class SponsorUiStateTest : BehaviorSpec({
    given("다음과 같은 후원사 목록이 주어졌을 때") {
        val sponsors = listOf(
            Sponsor(
                name = "당근",
                imageUrl = "https://raw.githubusercontent.com/droidknights/DroidKnightsApp/main/feature/home/src/main/res/drawable/img_sponsor_daangn.png",
                homepage = "https://about.daangn.com/",
                grade = Sponsor.Grade.PLATINUM
            ),
            Sponsor(
                name = "젯브레인",
                imageUrl = "https://raw.githubusercontent.com/droidknights/DroidKnightsApp/main/feature/home/src/main/res/drawable/img_sponsor_jetbrains.png",
                homepage = "http://www.jetbrains.com/ko-kr/",
                grade = Sponsor.Grade.GOLD
            ),
            Sponsor(
                name = "카카오뱅크",
                imageUrl = "https://raw.githubusercontent.com/droidknights/DroidKnightsApp/main/feature/home/src/main/res/drawable/img_sponsor_kakaobank.png",
                homepage = "https://recruit.kakaobank.com/",
                grade = Sponsor.Grade.PLATINUM
            ),
            Sponsor(
                name = "레진 엔터테인먼트",
                imageUrl = "https://raw.githubusercontent.com/droidknights/DroidKnightsApp/main/feature/home/src/main/res/drawable/img_sponsor_lezhin.png",
                homepage = "https://kstd-lezhin.career.greetinghr.com/career",
                grade = Sponsor.Grade.SILVER
            ),
            Sponsor(
                name = "점핏",
                imageUrl = "https://raw.githubusercontent.com/droidknights/DroidKnightsApp/main/feature/home/src/main/res/drawable/img_sponsor_jumpit.png",
                homepage = "https://www.jumpit.co.kr/?utm_source=jumpit&utm_medium=offline&utm_campaign=droidknights",
                grade = Sponsor.Grade.GOLD
            ),
            Sponsor(
                name = "헤이딜러",
                imageUrl = "https://raw.githubusercontent.com/droidknights/DroidKnightsApp/main/feature/home/src/main/res/drawable/img_sponsor_prnd_company.png",
                homepage = "https://www.prnd.co.kr/",
                grade = Sponsor.Grade.SILVER
            )
        )

        `when`("SponsorsUiState.Sponsors 이면") {
            val state = SponsorsUiState.Sponsors(sponsors)

            then("Grade의 priority 별로 정렬이 될 것이다") {
                val grouped = state.groupedSponsorsByGrade

                grouped.size shouldBe 3

                grouped[0].map { it.name } shouldContainExactly listOf("당근", "카카오뱅크")

                grouped[1].map { it.name } shouldContainExactly listOf("젯브레인", "점핏")

                grouped[2].map { it.name } shouldContainExactly listOf("레진 엔터테인먼트", "헤이딜러")
            }
        }
    }
})