pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ThousandsCourses"
include(":app")
include(":core:ui")
include(":core:navigation")
include(":data")
include(":feature:onboarding")
include(":feature:login")
include(":core:common")
include(":feature:courses")
include(":feature:main")
include(":domain")
include(":feature:favorite")
include(":feature:account")
