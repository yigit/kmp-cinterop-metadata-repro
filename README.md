repro project for KMP cinterop bug introduced in 1.9.20

To reproduce, run:

`./gradlew :benchmark-darwin:compileIosMainKotlinMetadata`

It will fail with:

```
> Task :benchmark-darwin:compileIosMainKotlinMetadata FAILED
e: file:///Users/yboyar/src/kmp-cinterop-metadata-repro/benchmark-darwin/src/iosMain/kotlin/androidx/benchmark/darwin/MeasureOptions.kt:19:44 Unresolved reference: XCTest
e: file:///Users/yboyar/src/kmp-cinterop-metadata-repro/benchmark-darwin/src/iosMain/kotlin/androidx/benchmark/darwin/TestCaseContextWrapper.kt:19:17 Unresolved reference: XCTest
e: file:///Users/yboyar/src/kmp-cinterop-metadata-repro/benchmark-darwin/src/iosMain/kotlin/androidx/benchmark/darwin/TestCaseContextWrapper.kt:20:17 Unresolved reference: XCTest
e: file:///Users/yboyar/src/kmp-cinterop-metadata-repro/benchmark-darwin/src/iosMain/kotlin/androidx/benchmark/darwin/TestCaseContextWrapper.kt:21:17 Unresolved reference: XCTest
e: file:///Users/yboyar/src/kmp-cinterop-metadata-repro/benchmark-darwin/src/iosMain/kotlin/androidx/benchmark/darwin/TestCaseContextWrapper.kt:23:51 Unresolved reference: XCTestCase
e: file:///Users/yboyar/src/kmp-cinterop-metadata-repro/benchmark-darwin/src/iosMain/kotlin/androidx/benchmark/darwin/TestCaseContextWrapper.kt:30:18 Unresolved reference: XCTMeasureOptions
```

Those classes are from the cinterop config in the dependency.

The problem goes away if KMP plugin is downgraded to 1.9.10