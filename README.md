# Appointment Booking App

An Android application built for **MAD Quiz 1** that allows users to book appointments through a simple multi-screen form.

## Screens

| Screen | Description |
|---|---|
| Splash | 3-second branded intro screen before navigating to Home |
| Home | Landing screen with a "Book Appointment" button |
| Book Appointment | Form to fill in patient/appointment details |
| Confirmation | Summary of the booked appointment |

## Features

- Splash screen with auto-navigation
- Booking form with full validation:
  - Full name, phone number, email
  - Appointment type (Spinner dropdown)
  - Date & time pickers
  - Gender selection (Radio buttons)
  - Terms & Conditions checkbox
- Confirmation screen displaying all submitted details
- "Go Home" button to return to the main screen

## Tech Stack

- **Language:** Kotlin
- **Platform:** Android (Min SDK 24, Target SDK 36)
- **UI:** XML layouts with Material Design components
- **Build:** Gradle with Kotlin DSL

## Project Structure

```
app/src/main/java/com/example/appointmentbookingapp/
├── SplashActivity.kt
├── MainActivity.kt
├── BookAppointmentActivity.kt
└── ConfirmationActivity.kt
```

## How to Run

1. Open the project in **Android Studio**
2. Let Gradle sync complete
3. Run on an emulator or physical device (Android 7.0+)
