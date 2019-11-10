import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	repositories {
		jcenter()    // Bintray's repository - a fast Maven Central mirror & more
		mavenCentral()
	}
	dependencies {
		classpath("com.google.cloud.tools:appengine-gradle-plugin:1.+")
	}
}

plugins {
	application
	id("org.springframework.boot") version "2.2.1.RELEASE"
	id("io.spring.dependency-management") version "1.0.8.RELEASE"
	war
	kotlin("jvm") version "1.3.50"
	kotlin("plugin.spring") version "1.3.50"
}

application {
	mainClassName = "com.aaamarkin.birmo.Main"
}

group = "com.aaamarkin"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	jcenter()
	maven { url = uri("https://repo.spring.io/milestone") }
}

extra["springCloudVersion"] = "Hoxton.RC1"


dependencies {
	compile ("com.google.appengine:appengine-api-1.0-sdk:+")
	providedCompile("javax.servlet:javax.servlet-api:3.1.0")
	compile ("jstl:jstl:1.2")
	implementation ("com.google.firebase:firebase-admin:6.11.0")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}

}

apply(plugin = "com.google.cloud.tools.appengine")
apply(plugin = "war")
apply(plugin = "java")

