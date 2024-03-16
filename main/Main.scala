package example

import scala.meta._
import scala.meta.inputs.Input
import scala.meta.parsers.Parse
import scala.meta.prettyprinters._
import scala.meta.transversers._
import scala.jdk.StreamConverters._
import java.io.File

object Main {
  def main(args: Array[String]): Unit = {
    java.nio.file.Files.find(
      new File("scala", "src").toPath,
      100,
      (p, _) => p.toFile.getName.endsWith(".scala") && (p.toFile.getName != "Singleton.scala")
    ).toScala(List).map { f =>
      val tree = implicitly[Parse[Source]].apply(Input.File(f), scala.meta.dialects.Scala213Source3).get
      tree.traverse { a => () }
      tree
    }
  }
}
