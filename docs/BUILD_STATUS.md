# Build status

The full Kotlin Multiplatform source has not yet been pushed to this repository. The Android CI workflow is intentionally a source-presence gate until import completes.

The uploaded source archive includes Android, iOS and shared modules. The archive's `.gitmodules` also references multiple upstream repositories, including a self-hosted SSH dependency (`references/operator`), which must be reviewed before attempting a fully reproducible build.

Do not claim an APK or iOS build has passed until the CI run or local build is verified. The initial CI configuration is provisional and may need task adjustments after source import.
