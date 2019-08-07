buildscript {
    repositories{
        google()
        jcenter()
        maven(url = Plugins.fabricMavenUrl)
    }

    dependencies {
        classpath(Plugins.androidGradlePlugin)
        classpath(Plugins.googleVersionGradlePlugin)
        classpath(Plugins.fabricGradlePlugin)
        classpath(Plugins.kotlinGradlePlugin)
        classpath(Plugins.mavenGradlePlugin)
    }
}

allprojects{
    repositories{
        google()
        jcenter()
        maven(url = Plugins.fabricMavenUrl)
        maven(url = Plugins.jitpackUrl)
    }
}

task("clean"){
    delete(rootProject.buildDir)
}