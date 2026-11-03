# REDACTED Roadmap

Source baseline: Ramble 0.2.0 (`0448cfb5`). This is a planning document, not a claim of completed features.

## Phase 0 — Source import (in progress)
- [x] Initialize repository and draft import PR
- [x] Verify uploaded source archive and preserve original license
- [ ] Push complete source tree to the import branch
- [ ] Confirm submodule dependencies and public accessibility
- [ ] Verify source matches uploaded archive

## Phase 1 — Branding
- [x] Prepare Android and iOS display-name changes in local source archive
- [ ] Commit complete branded source
- [ ] Replace icons and splash assets
- [ ] Review internal identifiers and release naming

## Phase 2 — Build and quality
- [ ] Android debug APK on CI
- [ ] Shared Kotlin unit tests
- [ ] iOS build on macOS runner
- [ ] Dependency and secret scans
- [ ] Publish test artifacts

## Phase 3 — Connectivity and reliability
- [ ] Meshtastic Bluetooth and TCP smoke tests
- [ ] MeshCore transport smoke tests
- [ ] Disconnect/reconnect behavior
- [ ] Message delivery, deduplication, and history

## Phase 4 — Release
- [ ] Manual device validation
- [ ] Document limitations and credits
- [ ] Tagged prerelease

Do not merge the source import PR before the source and tests are reviewed.
