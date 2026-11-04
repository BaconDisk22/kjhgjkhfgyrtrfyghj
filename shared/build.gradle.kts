import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.skie)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.sqldelight.runtime)
            implementation(libs.sqldelight.coroutines)
            implementation(libs.sqldelight.primitive.adapters)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.network)
            implementation(libs.koin.core)
        }
        commonTest.dependencies {
            implementation(kotlin("test"))
            // Virtual time for protocol handlers that tick on delay().
            implementation(libs.kotlinx.coroutines.test)
        }
        androidMain.dependencies {
            implementation(libs.sqldelight.android.driver)
            implementation(libs.ktor.client.okhttp)
            implementation(libs.kotlinx.coroutines.android)
            implementation(libs.koin.android)
            implementation(libs.usb.serial)
        }
        iosMain.dependencies {
            implementation(libs.sqldelight.native.driver)
            implementation(libs.ktor.client.darwin)
        }
    }
}

android {
    namespace = "chat.ramble.shared"
    compileSdk = 35
    defaultConfig {
        minSdk = 26
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

sqldelight {
    databases {
        create("RambleDatabase") {
            packageName.set("chat.ramble.db")
            srcDirs.setFrom("src/commonMain/sqldelight")
        }
    }
}

val gitShaProvider: Provider<String> = providers.exec {
    commandLine("git", "rev-parse", "--short", "HEAD")
}.standardOutput.asText.map { it.trim() }

val generateBuildInfo by tasks.registering {
    val outputDir = layout.buildDirectory.dir("generated/buildinfo")
    outputs.dir(outputDir)
    val gitSha = gitShaProvider
    inputs.property("gitSha", gitSha)

    doLast {
        val sha = gitSha.get()
        val file = outputDir.get().file("chat/ramble/BuildInfo.kt").asFile
        file.parentFile.mkdirs()
        file.writeText(
            """
            |package chat.ramble
            |
            |object BuildInfo {
            |    const val GIT_SHA: String = "$sha"
            |}
            """.trimMargin()
        )
    }
}

kotlin.sourceSets.commonMain {
    kotlin.srcDir(generateBuildInfo.map { it.outputs.files.singleFile })
}
