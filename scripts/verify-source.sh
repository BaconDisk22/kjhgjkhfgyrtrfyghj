#!/usr/bin/env bash
set -euo pipefail
missing=0
for path in gradlew settings.gradle.kts gradle/wrapper/gradle-wrapper.jar androidApp/build.gradle.kts shared/build.gradle.kts; do
  if [[ ! -f "$path" ]]; then
    printf 'MISSING: %s\n' "$path" >&2
    missing=1
  fi
done
if [[ "$missing" -ne 0 ]]; then
  echo 'Source import is incomplete; no Android build can be verified.' >&2
  exit 1
fi
echo 'Core source files are present. This does not prove that compilation passes.'
