import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
}

kotlin {
    iosX64()
    iosSimulatorArm64()
    iosArm64()
    sourceSets {
        val darwinMain by creating
    }
    targets.configureEach {
        if(this is KotlinNativeTarget) {
            compilations["main"].apply {
                cinterops.register(
                    "xcTestInterop"
                ) {
                    defFile(project.file("src/nativeInterop/cinterop/xcTestInterop.def"))
                    // https://youtrack.jetbrains.com/issue/KT-48807#focus=Comments-27-5210791.0-0
                    compilerOpts("-DNS_FORMAT_ARGUMENT(A)=")
                }
                defaultSourceSet.dependsOn(
                    sourceSets.getByName("darwinMain")
                )
            }
        }

    }
}