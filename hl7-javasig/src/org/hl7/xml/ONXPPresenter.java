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
package org.hl7.xml;

import org.hl7.meta.Datatype;
import org.hl7.types.CS;
import org.hl7.types.DSET;
import org.hl7.types.ONXP;
import org.hl7.types.enums.EntityNamePartType;
import org.hl7.types.impl.ONXPimpl;
import org.hl7.types.impl.ONXPnull;
import org.hl7.xml.builder.DatatypeBuilder;
import org.hl7.xml.parser.DynamicContentHandler;
import org.hl7.xml.parser.TreeContentHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class ONXPPresenter extends ENXPPresenter {
	private static final ONXPPresenter INSTANCE = new ONXPPresenter();

	protected static class ONXPContentHandler extends ENXPContentHandler<ONXP> {
		public ONXPContentHandler(String namespaceURI, String localName, String qName, Attributes atts) {
			super(namespaceURI, localName, qName, atts);
		}

		protected void returnResult(Object intermediate) throws SAXException {
			TreeContentHandler.Element element = (TreeContentHandler.Element) intermediate;
			ONXP result = valueOf(element);
			super.returnResult(result);
		}
		
		protected ONXP valueOf(String text, EntityNamePartType type, DSET<CS> qualifiers) {
			return ONXPimpl.valueOf(text, type, qualifiers);
		}

		protected ONXP nullValueOf(String nullFlavorString) {
			return ONXPnull.valueOf(nullFlavorString);
		}
	}

	protected static class ONXPBuilder extends ENXPPresenter.ENXPBuilder<ONXP> { }

	private ONXPPresenter() {}

	public static ONXPPresenter instance() {
		return INSTANCE;
	}

	public DynamicContentHandler getContentHandler(String namespaceURI, String localName, String qName, Attributes atts,
			Datatype datatype) {
		// do nothing with the datatype
		return new ONXPContentHandler(namespaceURI, localName, qName, atts);
	}

	public DatatypeBuilder getBuilder() {
		return new ONXPBuilder();
	}
}
