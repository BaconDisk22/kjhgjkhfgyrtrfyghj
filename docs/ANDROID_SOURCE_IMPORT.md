# Android source import inventory

Source archive: Ramble 0.2.0 (`0448cfb5`).

## Application entry points

The upstream archive contains:
- `androidApp/src/androidMain/AndroidManifest.xml`
- `androidApp/src/androidMain/kotlin/chat/ramble/android/MainActivity.kt`
- `androidApp/src/androidMain/kotlin/chat/ramble/android/RambleApplication.kt`
- `androidApp/src/androidMain/kotlin/chat/ramble/android/CrashRecorder.kt`
- `androidApp/src/androidMain/kotlin/chat/ramble/android/notification/ReactionReceiver.kt`

These must be imported with their referenced Kotlin classes and resources. Copying a manifest or activity alone will not produce a working APK.

## Acceptance criteria
- [ ] Import the full Android source and resource directories
- [ ] Import the shared Kotlin source and generated database schemas
- [ ] Import executable Gradle wrapper script and binary wrapper JAR
- [ ] Preserve original copyright and license notices
- [ ] Verify app ID, launcher label and runtime permissions
- [ ] Compile Android debug APK and inspect GitHub Actions artifact
- [ ] Install and test on an actual Android device

**Status:** partial import; no Android compilation verified.
