pluginManagement {
    repositories {
        google()
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

rootProject.name = "BookeSearcher"
include(":app")
include(":data")
include(":core")
include(":core:data")
include(":core:domain")
include(":feature")
include(":feature:search")
