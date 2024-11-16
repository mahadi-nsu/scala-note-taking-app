ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.13"

lazy val root = (project in file("."))
  .settings(
    name := "note-taking-app",
    idePackagePrefix := Some("com.mahadi"),

    // Adding dependencies
    libraryDependencies ++= Seq(
      // Akka HTTP for REST API
      "com.typesafe.akka" %% "akka-http" % "10.2.10",
      "com.typesafe.akka" %% "akka-stream" % "2.6.20",

      // Akka HTTP JSON Support
      "de.heikoseeberger" %% "akka-http-circe" % "1.39.2",
      "io.circe" %% "circe-generic" % "0.14.3",
      "io.circe" %% "circe-parser" % "0.14.3",

      // Testing
      "org.scalatest" %% "scalatest" % "3.2.17" % Test
    )
  )
