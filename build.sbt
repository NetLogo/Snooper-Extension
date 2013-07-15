scalaVersion := "2.9.3"

scalaSource in Compile <<= baseDirectory(_ / "src")

scalacOptions ++= Seq("-deprecation", "-unchecked", "-Xlint", "-Xfatal-warnings", "-encoding", "us-ascii")

libraryDependencies ++= Seq(
  "org.nlogo" % "NetLogo" % "5.0.4" from
    "http://ccl.northwestern.edu/netlogo/5.0.4/NetLogo.jar"
)

name := "snooper"

NetLogoExtension.settings

NetLogoExtension.classManager := "org.nlogo.extensions.snooper.SnooperExtension"
