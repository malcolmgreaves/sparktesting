organization := "com.gonitro.research"

name := "sdptesting"

version := "0.2.0"

lazy val jvmVer = com.nitro.build.Runtime.Jvm7

com.nitro.build.Compile.baseSettings(
  jvmVer,
  fatalWarnings = true,
  formatOnCompile = false
)

scalaVersion := "2.11.7"

crossScalaVersions := Seq(scalaVersion.toString, "2.10.5")

javaOptions := com.nitro.build.Runtime.javaSettings(jvmVer)

resolvers ++= Seq(
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/",
  "Nitro Nexus Releases" at "https://nexus.nitroplatform.com/nexus/content/repositories/releases/"
)

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.4.0",
  "org.apache.kafka" %% "kafka"      % "0.8.2.1",
  "org.scalatest"    %% "scalatest"  % "2.2.4" 
)

lazy val devs = Seq(
  com.nitro.build.Publish.Developer("mgreaves", "Malcolm Greaves")
)

com.nitro.build.Publish.settings("Nitro", "sdp_testing", devs)

testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")

testOptions in Test += Tests.Argument("-oF")

