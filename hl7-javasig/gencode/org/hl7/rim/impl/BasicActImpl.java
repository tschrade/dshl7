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
package org.hl7.rim.impl;

import org.hibernate.Criteria;
import org.hl7.hibernate.Persistence;

import org.hl7.rim.BasicAct;
import org.hl7.rim.impl.InfrastructureRootImpl;
import org.hl7.types.CS;
import org.hl7.types.SET;
import org.hl7.types.II;
import org.hl7.types.CD;
import org.hl7.types.BL;
import org.hl7.types.ST;
import org.hl7.types.ED;
import org.hl7.types.TS;
import org.hl7.types.CE;
import org.hl7.types.CE;
import org.hl7.types.IVL;
import org.hl7.types.INT;
import org.hl7.types.CE;

import org.hl7.rim.ActRelationship;
import org.hl7.rim.Participation;
import /*org.hl7.rim.AssociationSet*/java.util.List;

/** Implementation of org.hl7.rim.Act as a simple data holder bean.
    @see org.hl7.rim.Act
  */
public class BasicActImpl extends org.hl7.rim.impl.InfrastructureRootImpl implements BasicAct {

  private CS _classCode;
  /** Gets the property classCode.
      @see org.hl7.rim.Act#getClassCode
  */
  public CS getClassCode() { return _classCode; }
  /** Sets the property classCode.
      @see org.hl7.rim.Act#setClassCode
  */
  public void setClassCode(CS classCode) {
    if(classCode instanceof org.hl7.hibernate.ClonableCollection)
      classCode = ((org.hl7.hibernate.ClonableCollection<CS>) classCode).cloneHibernateCollectionIfNecessary();
    _classCode = classCode;
  }
  /** Sets the property classCode. To be used only by hibernate.
      @deprecated to be used only by hibernate
      @see org.hl7.rim.Act#setClassCode
  */
  public void setClassCodeForHibernate(CS classCode) {
    _classCode = classCode;
  }

  private CS _moodCode;
  /** Gets the property moodCode.
      @see org.hl7.rim.Act#getMoodCode
  */
  public CS getMoodCode() { return _moodCode; }
  /** Sets the property moodCode.
      @see org.hl7.rim.Act#setMoodCode
  */
  public void setMoodCode(CS moodCode) {
    if(moodCode instanceof org.hl7.hibernate.ClonableCollection)
      moodCode = ((org.hl7.hibernate.ClonableCollection<CS>) moodCode).cloneHibernateCollectionIfNecessary();
    _moodCode = moodCode;
  }
  /** Sets the property moodCode. To be used only by hibernate.
      @deprecated to be used only by hibernate
      @see org.hl7.rim.Act#setMoodCode
  */
  public void setMoodCodeForHibernate(CS moodCode) {
    _moodCode = moodCode;
  }
  public Object clone() throws CloneNotSupportedException {
    BasicActImpl that = (BasicActImpl) super.clone();

    // deep clone of persistent component collections
    return that;
  }
}
