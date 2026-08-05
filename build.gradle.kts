plugins {
    kotlin("jvm") version "2.3.10"
}

group = "org.nwolfhub.lib"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.squareup.okhttp3:okhttp:5.4.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.17.2")

    testImplementation(kotlin("test"))
    testImplementation("org.wiremock:wiremock:3.13.2")
}

val demo by sourceSets.creating {
    compileClasspath += sourceSets.main.get().output
    runtimeClasspath += sourceSets.main.get().output
}

configurations[demo.implementationConfigurationName].extendsFrom(configurations.implementation.get())

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}