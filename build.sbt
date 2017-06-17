name := """try-ci"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

lazy val rebuild = taskKey[Unit]("A sample int task.")

rebuild := {
  compile.in(Compile).dependsOn(clean).value
  Unit
}

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
    "com.typesafe.play" %% "play-json" % "2.6.0-M3" ,
  "com.typesafe.play" %% "play-slick" % "2.0.0",
  "com.typesafe.slick" %% "slick-codegen" % "3.1.1",
  "mysql" % "mysql-connector-java" % "5.1.24",
//  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-xml" % "2.7.2" ,
//  "com.fasterxml.jackson.dataformat" % "jackson-dataformat-cbor" % "2.7.2",
//  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.7.2"
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.8.5"

)

//ERROR
//wartremoverErrors ++= Warts.unsafe

wartremoverWarnings ++= Warts.unsafe
//使い勝手の悪いものを除外
wartremoverWarnings --= Seq( Wart.NonUnitStatements , Wart.DefaultArguments )

wartremoverExcluded ++= Seq ( 
	baseDirectory.value / "app" / "model" / "HelloActiveAdm.scala"
	,baseDirectory.value / "app" / "slickx" / "GeneratorMain.scala"
	,baseDirectory.value / "target" / "scala-2.11" / "routes" / "main" / "controllers" / "ReverseRoutes.scala"
	,baseDirectory.value / "target" / "scala-2.11" / "routes" / "main" / "router" / "Routes.scala"
	,baseDirectory.value / "target" / "scala-2.11" / "routes" / "main" / "router" / "RoutesPrefix.scala"
)

//testタスクで実行するテストコードを限定させる（通常はすべてのテストコードが対象になる）
//絞り込み条件の設定
//testOptions in Test := Seq(Tests.Filter(s => s.endsWith("ControllerSpec")))
//絞り込みを有効にしたいときコメント解除
//fork in Test := true

