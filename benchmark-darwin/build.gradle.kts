import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformType

plugins {
    kotlin("multiplatform")
}

kotlin {
    iosX64()
    iosSimulatorArm64()
    iosArm64()
    sourceSets {
        val darwinMain by creating
        val darwinTest by creating {
        }
        val iosMain by creating {
            dependsOn(darwinMain)
            dependencies {
                api(project(":benchmark-darwin-core"))
            }
        }
        val iosArm64Main by getting {
            dependsOn(iosMain)
        }
        val iosSimulatorArm64Main  by getting {
            dependsOn(iosMain)
        }
        val iosX64Main by getting {
            dependsOn(iosMain)
        }
        targets.configureEach {
            if (platformType == KotlinPlatformType.native) {
                compilations["main"].defaultSourceSet {
                    dependsOn(darwinMain)
                }
                compilations["test"].defaultSourceSet {
                    dependsOn(darwinTest)
                }
                compilations.configureEach {
                    compilerOptions.options.optIn.add("kotlinx.cinterop.ExperimentalForeignApi")
                }
            }
        }
    }
}