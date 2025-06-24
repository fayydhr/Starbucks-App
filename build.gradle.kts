// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Explicitly set versions based on libs.versions.toml to resolve 'Unresolved reference: libs' at this level
    // AGP version from libs.versions.toml is "8.8.0"
    id("com.android.application") version "8.8.0" apply false
    // Kotlin Android plugin version from libs.versions.toml is "2.0.0"
    id("org.jetbrains.kotlin.android") version "2.0.0" apply false
}