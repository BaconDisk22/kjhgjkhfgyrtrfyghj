# REDACTED source import checklist

Baseline: Ramble 0.2.0, revision `0448cfb5`. This repository is not yet a verified complete import.

- [ ] Import all source files from the supplied archive into the import branch
- [ ] Retain upstream license, copyright and attribution
- [ ] Inspect submodules and inaccessible SSH dependencies
- [ ] Confirm no tokens, credentials or build outputs are committed
- [ ] Run `bash scripts/verify-source.sh`
- [ ] Run Gradle Android debug compilation and applicable tests
- [ ] Check actual output artifact and branding
- [ ] Verify Meshtastic and MeshCore connections on physical hardware
- [ ] Only then mark source-import PR ready to merge

A successful checklist script only confirms expected files exist; it does not establish that the application works.
