plugins {
    id("java")
    id("application")
}

group = "org.example"
version = "0.1"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

application {
    mainClass.set("org.example.Main") //
}

tasks.test {
    useJUnitPlatform()
}
