val common = Def.settings(
  scalaVersion := "2.13.13",
  run / fork := true,
  run / baseDirectory := (LocalRootProject / baseDirectory).value,
  Compile / unmanagedSourceDirectories += baseDirectory.value.getParentFile / "main",
)
lazy val p1 = project.settings(
  common,
  libraryDependencies += "org.scalameta" %% "parsers" % "4.9.0"
)

lazy val p2 = project.settings(
  common,
  libraryDependencies += "org.scalameta" %% "parsers" % "4.8.15"
)
