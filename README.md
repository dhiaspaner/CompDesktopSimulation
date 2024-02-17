Kotlin Multiplatform Starter Project By Softylines

- [X] Convention Plugins (Mohamed)
- [X] Dependency Injection (Dhia)
- [X] Networking (Mohamed)
- [ ] Database (Dhia)
- [ ] Konsist (Mohamed)
- [ ] Detekt/Spotless (Dhia)
- [ ] Auth feature (Dhia)
- [ ] Design System (Mohamed)
- [ ] Localisation (Arabic/English...) (Dhia)
- [ ] CRUD feature (User) (Mohamed)
- [ ] Logging
- [ ] Rebugger
- [ ] Build Flavors
- [ ] Crash Reporting (Sentry)
- [ ] CI/CD
- [ ] FCM Push Notifications
- [ ] Documentation
- [ ] Test

## Introduction

This project is a Kotlin Multiplatform project that aims to provide a starter project for Kotlin Multiplatform projects. It is a work in progress and will be updated regularly.

## Code Style

Make sure you are following the [Kotlin Coding conventions](https://kotlinlang.org/docs/coding-conventions.html).

## Guidelines

### Architecture

The project follows the multi-module clean architecture with some modifications to fit the nature of the project.
Each feature is a module and has its own domain, data, and ui layers.

[Read more](guide/architecture/1-architecture-overview.md)

### Adding new data module

For adding new data modules, we will follow these guidelines:
1. [Create new data module](guide/new-data-module/1-create-data-module.md)
2. [Data domain layer](guide/new-data-module/2-domain-layer.md)
3. [Data data layer](guide/new-data-module/3-data-layer.md)
4. [Data dependency injection](guide/new-data-module/4-dependency-injection.md)

### Adding new feature module

For adding new feature modules, we will follow these guidelines:
1. [Create new feature module](guide/new-feature-module/1-create-feature-module.md)
2. [Feature ui layer](guide/new-feature-module/2-feature-ui-layer.md)

### Naming Conventions

### Detekt

Run `./gradlew detekt` to run detekt checks.

You can also run `./gradlew detekt --auto-correct` to auto correct some issues automatically.