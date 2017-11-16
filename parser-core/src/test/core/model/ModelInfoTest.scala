// (C) Uri Wilensky. https://github.com/NetLogo/NetLogo

package org.nlogo.core.model

import cats.data.Validated.Valid

import org.nlogo.core.ModelInfo

import org.scalatest.FunSuite

object ModelInfoTest {
  import DummyXML._

  val title = namedText("title", "Model Title")
  val tags = namedText("subject", "biology,hubnet,unverified")

  val modelInfoXml =
    Elem("modelInfo",
      Seq(),
      Seq(title, tags))

  val modelInfo = ModelInfo("Model Title", Seq("biology", "hubnet", "unverified"))
}

class ModelInfoTest extends FunSuite {
  import ModelInfoTest._
  import DummyXML.Factory

  test("reads ModelInfo from xml") {
    assertResult(Valid(modelInfo))(ModelInfoXml.read(modelInfoXml))
  }

  test("writes ModelInfo to xml") {
    assertResult(modelInfoXml)(ModelInfoXml.write(modelInfo, Factory))
  }
}
