/*
THIS FILE IS GENERATED AUTOMATICALLY - DO NOT MODIFY.

The contents of this file are subject to the Health Level-7 Public
License Version 1.0 (the "License"); you may not use this file except
in compliance with the License. You may obtain a copy of the License
at http://www.hl7.org/HPL/

Software distributed under the License is distributed on an "AS IS"
basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See
the License for the specific language governing rights and limitations
under the License.

The Original Code is all this file.

The Initial Developer of the Original Code is automatically generated
from HL7 copyrighted standards specification which may be subject to
different license. Portions created by Initial Developer are Copyright
(C) 2002-2004 Health Level Seven, Inc. All Rights Reserved.

THIS FILE IS GENERATED AUTOMATICALLY - DO NOT MODIFY.
*/
package org.hl7.rim;

import org.hl7.rim.QueryEvent;
import org.hl7.types.INT;

import /*org.hl7.rim.AssociationSet*/java.util.List;

/**<p>This class maintains the state information required at the application level to control the logical continuation of a query
   response.
</p>
*/
public interface QueryContinuation extends org.hl7.rim.QueryEvent {

  /**<p>Specifies the instance number in the original query result set to start return in next query response message.</p>
  */
  INT getStartResultNumber();
  /** Sets the property startResultNumber.
      @see #getStartResultNumber
  */
  void setStartResultNumber(INT startResultNumber);

  /**<p>Specifies the number of instance matches to return in the next query response message.</p>
  */
  INT getContinuationQuantity();
  /** Sets the property continuationQuantity.
      @see #getContinuationQuantity
  */
  void setContinuationQuantity(INT continuationQuantity);
}
