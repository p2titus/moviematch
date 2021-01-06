
name := "moviematch"

version := "pre-release"

scalaVersion := "2.13.4"

libraryDependencies ++= Seq(
  // https://mvnrepository.com/artifact/com.typesafe.play/play
  "com.typesafe.play" %% "play" % "2.8.7",
  // https://mvnrepository.com/artifact/io.circe/circe-core
  "io.circe" %% "circe-core" % "0.14.0-M3",
  // https://mvnrepository.com/artifact/io.circe/circe-parser
  "io.circe" %% "circe-parser" % "0.14.0-M3",
  // https://mvnrepository.com/artifact/io.circe/circe-generic
  "io.circe" %% "circe-generic" % "0.14.0-M3"

)

