# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [2.2.0] - 2026-05-07 _(versionCode 15)_

### Added
- New vector drawable icons: `ic_cross`, `ic_book`, `ic_christmas_star`,
  `ic_arrow_back`, `ic_arrow_forward`, `ic_chevron_right`, `ic_close`,
  `ic_simple_prayer`, `ic_star`, `ic_rosary`, `ic_settings`.
- Reusable card background drawable (`card_clickable_bg`).
- New navigation include layouts: `include_nav_buttons_begin/end/next/pray`,
  `include_btn_home`, `include_btn_prev_only`, `include_body_our_father`.
- Centralized navigation model via `PrayerScreen` and shared `Counter` model.
- Abstract base activities: `AbstractNinthActivity`, `AbstractRosaryActivity`,
  `AbstractSimplePrayerActivity` to reduce boilerplate across prayer screens.
- New row layout `joy_row.xml` for the Ninth's joys list.
- Spanish (`values-b+es`) and default string resources for new UI labels.

### Changed
- Complete UI/UX redesign across Main, Settings, Special Prayers, Rosary,
  Novena and Simple Prayers activities (portrait and landscape).
- Refactored `NinthJoysAdapter` and prayer activities to leverage the new
  abstract bases and shared includes — large reduction in duplicated XML/Java.
- Updated `colors.xml`, `dimens.xml` and `styles.xml` for the new design
  language (cards, typography, spacing).
- Bumped `compileSdk` / `targetSdk` to **37**.
- Upgraded Gradle, AGP and project dependencies to their latest stable versions.

### Removed
- Legacy per-activity layouts replaced by shared includes
  (`ninth_our_father_activity`, `ninth_consideration_activity`,
  `ninth_paragraph_activity`, `rosary_our_father_activity`,
  `simple_our_father_activity` and their land variants — consolidated).
- Obsolete `.idea/` files and unused Gradle caches.

### Fixed
- Inconsistent navigation button behavior between prayer screens.
- Layout mismatches between portrait and landscape variants.

---

## Commit history (rework branch)

- `bf8ed05` — More UI improvements
- `8b648fc` — Improved UI/UX
- `c0309d0` — Big refactor on code structure
- `b4e9cc6` — Updated dependencies
- `dc9f173` / `7f64607` — Updated API level to 35
