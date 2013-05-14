name := "zippers-and-comonads"

scalaVersion := "2.10.1"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.0.0",
  "org.specs2" %% "specs2" % "1.14" % "test",
  "org.scalacheck" %% "scalacheck" % "1.10.0" % "test"
)

resolvers ++= Seq(
  "oss snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "oss releases" at "http://oss.sonatype.org/content/repositories/releases"
)

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-feature",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:postfixOps"
)
