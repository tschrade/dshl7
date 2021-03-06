/*
Copyright 2010 the original author or authors.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/
package net.gumbix.hl7dsl.DSL

import org.hl7.rim.{RimObjectFactory, Place}
import org.hl7.types._
import impl.BAGjuListAdapter
import java.util.ArrayList
import net.gumbix.hl7dsl.helper.ImplicitDef._
import net.gumbix.hl7dsl.helper.Address

/**
 * Wrapper Class for RIM Class "Place"
 * @author Ahmet Gül (guel.ahmet@hotmail.de)
 */

class PlaceDSL(place: Place) extends EntityDSL(place) {
  def this() = {
    this (RimObjectFactory.getInstance.createRimObject("Place").asInstanceOf[Place])
  }

  /**
   * @return BL
   */
  def mobileInd: BL = place.getMobileInd

  def mobileInd_=(v: BL) {
    place.setMobileInd(v)
  }

  /**
   * @return BAG[AD]
   */
  def addr: Address = {
    def addressChanged(a: Address) {
      place.setAddr(a.toRS)
    }
    // TODO change constructor in Address
    val rsList = new ArrayList[AD]()
    rsList.add(place.getAddr)
    val a = new Address(BAGjuListAdapter.valueOf(rsList), addressChanged)
    a
  }

  def addr_=(a: Address) {
    // TODO Somehow remember that here was an assignment:
    place.setAddr(a.toRS)
  }

  /**
   * @return ED
   */
  def directionsText: ED = place.getDirectionsText

  def directionsText_=(v: ED) {
    place.setDirectionsText(v)
  }

  /**
   * @return ED
   */
  def positionText: ED = place.getPositionText

  def positionText_=(v: String) {
    place.setPositionText(v)
  }

  /**
   * @return ST
   */
  def gpsText: ST = place.getGpsText

  def gpsText_=(v: ST) {
    place.setGpsText(v)
  }
}