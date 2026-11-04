# Upstream submodule audit

The provided Ramble 0.2.0 source archive declares these submodules:

| Path | Upstream URL | Import concern |
| --- | --- | --- |
| references/meshcore-firmware | https://github.com/meshcore-dev/MeshCore.git | External source |
| references/meshtastic-firmware | https://github.com/meshtastic/firmware.git | External source |
| references/meshtastic-protobufs | https://github.com/meshtastic/protobufs.git | External source |
| references/operator | git@catbriar.dev:yaymesh/operator.git | Private or SSH-only host; availability and license unknown |
| references/MeshMapper_Flutter_App | https://github.com/MeshMapper/MeshMapper_Flutter_App.git | External source |
| references/Meshtastic-Android | https://github.com/meshtastic/Meshtastic-Android.git | External source |
| references/Meshtastic-Apple | https://github.com/meshtastic/Meshtastic-Apple.git | External source |
| references/MeshCoreOne | https://github.com/Avi0n/MeshCoreOne.git | External source |

Do not embed private keys, replace private sources with guessed substitutes, or claim that external code is licensed for redistribution without checking. Determine which references are documentation-only and which are build-time dependencies before enabling recursive submodule checkout.
