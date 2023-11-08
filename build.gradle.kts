plugins {
    // 1.9.10 works fine.
    kotlin("multiplatform") version "1.9.20" apply false
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

subprojects {
    repositories {
        mavenCentral()
        google()
    }
}
