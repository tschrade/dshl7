package net.gumbix.hl7dsl

import net.gumbix.hl7dsl.build.{SimpleLoadMessage, BuildMessage}
import junit.framework.TestCase
import org.hl7.util.MessageLoader
import org.hl7.rim.{RimObject, Document}
import org.hl7.util._
import org.hl7.types._
import org.hl7.types.impl._
import net.gumbix.hl7dsl.DSL.DocumentDSL
import net.gumbix.hl7dsl.helper.ImplicitDef._
import net.gumbix.hl7dsl.helper.Address
import scala.collection.JavaConversions._

/**
 * @author Ahmet Gül
 * Simple load CDA and read data
 */

class HL7LoadTest extends TestCase {
  def testLoadMessage() {
    val doc = StringFromFile.readFileAsString("Arztbrief-2aufLevel3.XML")

    //--------------- document -------------------
    val clinicalDocument = MessageLoader.LoadMessage("POCD_HD000040", doc).asInstanceOf[Document]

    val cda = new DocumentDSL(clinicalDocument)

    println("//------------- Anamnese Komponente ---------------")
    println(cda.outboundRelationship(0).target.outboundRelationship(0).target.title)
    println(cda.outboundRelationship(0).target.outboundRelationship(0).target.text)

    println(" //------------- Befund Komponente ---------------")
    println(cda.outboundRelationship(0).target.outboundRelationship(1).target.title)
    println(cda.outboundRelationship(0).target.outboundRelationship(1).target.text)

    println("")
    println("")
    println("// Alle Überschriften auslesen")
    val sections = cda.outboundRelationship(0).target.outboundRelationship
    sections.toList.foreach(a => println("-> " + a.target.title))

    println("")
    println("")
    println("// Alle Adressen auslesen")
    cda.participations.toList.foreach {
      a =>
        println("-> " + DatatypeTool.AddressTool.getAll(a.role.getAddr))
    }

    // -------------------------------------

    val ms = cda.outboundRelationship(0).target.outboundRelationship
    ms.toList.foreach(a => a.target.title = a.target.title + "!!!")

    val modified = BuildMessage.toXML(cda, "POCD_HD000040")
    println("=============")
    println(modified)
  }

  def testLoadMessage2() {
    var slm: SimpleLoadMessage = new SimpleLoadMessage
    var rim: RimObject = slm.LoadMessage("POCD_HD000040", "Arztbrief-2aufLevel3.XML").asInstanceOf[RimObject]
    println(BuildMessage.toXML(rim, "Arztbrief-2aufLevel3_0.XML"))
  }
}