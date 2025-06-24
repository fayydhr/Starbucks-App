pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
    // Ini adalah blok plugins yang saya tambahkan sebelumnya untuk membantu resolusi
    plugins {
        id("com.android.application") version "8.8.0" // Ambil versi AGP dari libs.versions.toml
        id("org.jetbrains.kotlin.android") version "2.0.0" // Ambil versi Kotlin dari libs.versions.toml
        id("org.jetbrains.kotlin.plugin.compose") version "2.0.0" // Ambil versi Kotlin Compose dari libs.versions.toml
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "stk"
include(":app")