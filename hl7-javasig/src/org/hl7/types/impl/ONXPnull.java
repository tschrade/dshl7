/* The contents of this file are subject to the Health Level-7 Public
 * License Version 1.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the
 * License at http://www.hl7.org/HPL/
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See
 * the License for the specific language governing rights and
 * limitations under the License.
 *
 * The Original Code is all this file.
 *
 * The Initial Developer of the Original Code is .
 * Portions created by Initial Developer are Copyright (C) 2002-2004 
 * Health Level Seven, Inc. All Rights Reserved.
 *
 * Contributor(s): 
 */
package org.hl7.types.impl;

import org.hl7.types.NullFlavor;
import org.hl7.types.ONXP;

public class ONXPnull extends ENXPnull implements ONXP {
	public static final ONXPnull NI = new ONXPnull(NullFlavorImpl.NI);
	public static final ONXPnull NA = new ONXPnull(NullFlavorImpl.NA);
	public static final ONXPnull UNK = new ONXPnull(NullFlavorImpl.UNK);
	public static final ONXPnull NASK = new ONXPnull(NullFlavorImpl.NASK);
	public static final ONXPnull ASKU = new ONXPnull(NullFlavorImpl.ASKU);
	public static final ONXPnull NAV = new ONXPnull(NullFlavorImpl.NAV);
	public static final ONXPnull OTH = new ONXPnull(NullFlavorImpl.OTH);
	public static final ONXPnull PINF = new ONXPnull(NullFlavorImpl.PINF);
	public static final ONXPnull NINF = new ONXPnull(NullFlavorImpl.NINF);

	private ONXPnull(final NullFlavor nf) {
		super(nf);
	}

	/**
	 * Get the a null value according to the null flavor code.
	 */
	public static ONXPnull valueOf(final String nullFlavor) {
	    return ANYimpl.nullValueOf(ONXPnull.class, nullFlavor);
	}
}
