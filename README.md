# Remote Device Manager

GitHub-ready Android project containing:
- `user-app`: managed-device client
- `admin-app`: admin controller

Features:
- Per-device pairing code
- Remote lock/unlock command architecture
- Android Device Owner / Lock Task kiosk support
- Persistent locked state after reboot
- Admin-side device list and status
- No hidden surveillance, credential harvesting, or permission bypass

## Build
Open the root folder in Android Studio and build each Gradle project.

## Device-owner provisioning
For a dedicated device you control, provision the User app as Device Owner using Android Enterprise/ADB during development. Do not use this to lock someone else's device without authorization.
