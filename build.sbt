name          := "htwg-scala-kakuro"
organization  := "de.htwg.se"
version       := "0.0.2"
scalaVersion  := "2.11.8"
scalacOptions := Seq("-unchecked", "-feature", "-deprecation", "-encoding", "utf8","-Dlog4j.configurationFile=log4j2.xml")

resolvers += Resolver.jcenterRepo

scalaSource in Compile := baseDirectory.value / "src/de/htwg/se/kakuro"

resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases"

libraryDependencies ++= {
  val scalaTestV       = "3.0.1"
  val scalaMockV       = "3.2.2"
  Seq(
    "org.scalatest" %% "scalatest"                   % scalaTestV       % "test",
    "org.scalamock" %% "scalamock-scalatest-support" % scalaMockV       % "test"
  )
}

libraryDependencies += "junit" % "junit" % "4.8" % "test"
libraryDependencies += "org.apache.logging.log4j" % "log4j-api" % "2.10.0"
libraryDependencies += "org.apache.logging.log4j" % "log4j-core" % "2.10.0"
libraryDependencies += "org.scala-lang" % "scala-swing" % "2.11+"
libraryDependencies += "com.google.inject" % "guice" % "3.0"
libraryDependencies += "net.codingwell" %% "scala-guice" % "4.1.0"
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.5.15"
libraryDependencies += "com.typesafe.akka" %% "akka-http"   % "10.1.8"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.5.19"
libraryDependencies += "com.ibm" %% "couchdb-scala" % "0.5.1"
libraryDependencies += "org.apache.spark" %% "spark-core" % "2.3.2"
libraryDependencies += "com.typesafe.akka" %% "akka-http-spray-json" % "10.1.8"

//coverageExcludedPackages := ".*aview.*"
//coverageHighlighting := true
