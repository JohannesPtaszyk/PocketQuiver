plugins {
    `kotlin-dsl`
}

group = "dev.pott.buildlogic"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.detekt.plugin)
    compileOnly(libs.kotlin.composeCompilerPlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.kover.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.spotless.gradlePlugin)
    compileOnly(libs.sonar.gradlePlugin)

    implementation(libs.versioncompare)
}

gradlePlugin {
    plugins {

    }
}
