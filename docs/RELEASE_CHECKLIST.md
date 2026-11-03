# REDACTED release checklist

This is an acceptance checklist, not a record of completed tests.

## Source and licensing
- [ ] Full Ramble 0.2.0 source imported
- [ ] GPL-3.0 license and original notices retained
- [ ] External dependencies/submodules reviewed
- [ ] No credentials or signing keys committed

## Branding
- [ ] REDACTED visible on Android launcher and settings
- [ ] REDACTED visible on iOS home screen
- [ ] App icons and splash assets reviewed
- [ ] Package IDs and update behavior documented

## Android
- [ ] Gradle debug build passes in CI
- [ ] APK uploaded as GitHub Actions artifact
- [ ] Install and launch on a physical phone
- [ ] App permissions and background behavior tested

## Connectivity
- [ ] Meshtastic send/receive and reconnect
- [ ] MeshCore send/receive and reconnect
- [ ] Offline states and error messages tested
- [ ] No unintended transmissions during testing

## Release
- [ ] Changelog updated
- [ ] License and upstream attribution included
- [ ] Known issues documented
- [ ] Version tagged and artifacts verified
