# 🎮 Brick Breaker Refactored

This repository contains a refactored version of the classic **Brick Breaker game**, developed as part of an assignment for the *Software Re-Engineering* course at FAST-NU Lahore.

---

## 👤 Author

- **Name:** Noor Fatima  
- **Roll Number:** L21-6085  
- **Course:** BS(SE)-8A  
- **University:** FAST-NU, Lahore

---

## 📌 Project Objective

To re-engineer the Brick Breaker game by:

- Improving code maintainability
- Applying object-oriented design principles
- Introducing design patterns for better extensibility
- Refactoring legacy components into modular classes

---

## 🔨 Refactorings Applied

| Class                  | Refactorings Applied                                                                 |
|------------------------|--------------------------------------------------------------------------------------|
| `Brick`                | Moved `isCollisionWithBall()` from `GamePanel`                                      |
| `Ball`                 | Extracted methods: `loadBallImage()`, `moveBall()`, `checkWallCollisions()`, `updateBallPosition()` |
| `BackgroundImageLabel`| Introduced constants `WIDTH`, `HEIGHT`; extracted `setBackgroundImage()`             |
| `GamePanel`            | Replaced level variable with `LevelManager` (state), added `GameStateManager`, `CollisionManager`, and `BrickPatternFactory`; used Strategy Pattern for level behavior |
| `Base`                 | Extracted `canMoveLeft()`, `canMoveRight()` from `move()`, separated `loadBaseImage()` from constructor |
| `AudioPlayback`        | Extracted reusable method `playSound()`                                             |
| Other Classes          | General cleanup and separation of concerns                                          |

---

## 🧠 Design Patterns Used

- **Strategy Pattern**:  
  Separate classes for each level (`LevelOneBrickPattern`, `LevelTwoBrickPattern`, etc.), implementing a shared strategy interface.

- **Factory Pattern**:  
  `BrickPatternFactory` creates appropriate brick patterns based on the level number.

---

## 📁 Folder Structure

