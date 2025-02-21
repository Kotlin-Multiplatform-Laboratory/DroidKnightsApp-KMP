import com.droidknights.app.setNamespace

plugins {
    id("droidknights.kotlin.multiplatform")
    id("droidknights.kotlin.koin")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.core.dataApi)
            // TODO: data 모듈 의존성 삭제가 필요하다
            implementation(projects.core.data)
            implementation(projects.core.model)
        }
    }
}

android {
    setNamespace("core.domain")
}
