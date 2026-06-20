# FastTripPlanner

Android app for quick trip planning, developed as a hands-on exercise for the Mobile Device Programming course.

## Demo video

[Watch on Google Drive](https://drive.google.com/file/d/1Ln9c7igSUpf0UYHbLZs_rK4wFnoq5ump/view?usp=sharing)

## Objective

Integrate the main Android development concepts covered in the course: multiple screens, navigation with explicit Intents, and state management.

## Features

### Screen 1 — Trip Details
- Input fields: destination, number of days, and daily budget
- Data validation before proceeding
- Navigation to the next screen via an explicit Intent

### Screen 2 — Trip Options
- Accommodation type selection (Economy, Comfort, or Luxury) via RadioButtons
- Additional services selection via Checkboxes: Transportation, Food, and Tours
- **Calculate** (proceeds to the summary) and **Back** buttons

### Screen 3 — Trip Summary
- Full display of all entered data
- Automatic calculation of the total trip cost
- **Restart Planning** button to start over

## Calculation Rules

```
baseCost = days × dailyBudget

Accommodation multiplier:
  Economy  → ×1.0
  Comfort  → ×1.5
  Luxury   → ×2.2

Extras (added to the cost after the multiplier):
  Transportation → +R$ 300.00 (fixed)
  Food           → +R$ 50.00/day
  Tours          → +R$ 120.00/day

totalCost = (baseCost × multiplier) + extras
```

## Requirements Met

### Functional
| ID | Description | Status |
|----|-----------|--------|
| RF01 | Enter trip data | Implemented |
| RF02 | Select additional options | Implemented |
| RF03 | Display full summary | Implemented |
| RF04 | Navigation via explicit Intents | Implemented |
| RF05 | Correctly calculate the total cost | Implemented |

### Non-Functional
| ID | Description | Status |
|----|-----------|--------|
| RNF01 | Compatible with Android 8.0+ (minSdk 26) | Implemented |
| RNF02 | Organized and commented code | Implemented |
| RNF03 | Best practices (Kotlin, Material3, Compose) | Implemented |
| RNF04 | Delivered with README and video | Implemented |
| RNF05 | State preserved on screen rotation (`rememberSaveable`) | Implemented |

## Technologies

- **Language:** Kotlin
- **UI:** Jetpack Compose + Material3
- **Build:** Gradle with Version Catalog (`libs.versions.toml`)
- **minSdk:** 26 (Android 8.0)
- **targetSdk / compileSdk:** 36 (Android 15)

## Project Structure

```
app/src/main/java/br/edu/ifsp/scl/sc3045366/fasttripplanner/
├── TripDetailsActivity.kt       # Screen 1: data entry
├── TripOptionsActivity.kt       # Screen 2: accommodation and service options
├── TripSummaryActivity.kt       # Screen 3: summary and total cost
└── ui/
    ├── screens/
    │   ├── TripDetailsScreen.kt  # Screen 1 Composable
    │   ├── TripOptionsScreen.kt  # Screen 2 Composable
    │   └── TripSummaryScreen.kt  # Screen 3 Composable (includes calculation logic)
    └── theme/
        └── Theme.kt              # Material3 theme (light/dark)
```
