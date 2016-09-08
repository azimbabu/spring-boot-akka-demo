name := "spring-boot-akka-demo"

version := "1.0"

scalaVersion := "2.11.8"

lazy val springBootVersion = "1.4.0.RELEASE"

lazy val akkaVersion = "2.4.10"

libraryDependencies ++= Seq(
  "org.springframework.boot" % "spring-boot-starter" % springBootVersion,
  "org.springframework.boot" % "spring-boot-starter-jetty" % springBootVersion,
  "org.springframework.boot" % "spring-boot-starter-web" % springBootVersion,
  "com.typesafe.akka" % "akka-actor_2.11" % akkaVersion,
  "com.typesafe.akka" % "akka-slf4j_2.11" % akkaVersion,
  "org.projectlombok" % "lombok" % "1.16.10"
)

unmanagedClasspath in Runtime += baseDirectory.value / "conf"

unmanagedClasspath in Test += baseDirectory.value / "conf"

    