plugins {
    kotlin("jvm")
}

java {
    sourceCompatibility = AppVersions.javaVersion
    targetCompatibility = AppVersions.javaVersion
}

dependencies {
    implementation(libs.bundles.layer.domain)

    testImplementation(libs.bundles.test.unit)
}
