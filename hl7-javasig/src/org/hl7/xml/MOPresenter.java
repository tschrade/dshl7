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
import org.hl7.types.MO;
import org.hl7.types.ValueFactory;
import org.hl7.types.impl.CSimpl;
import org.hl7.types.impl.MOimpl;
import org.hl7.types.impl.MOnull;
import org.hl7.xml.builder.BuilderException;
import org.hl7.xml.builder.DatatypeBuilder;
import org.hl7.xml.builder.RimGraphXMLSpeaker;
import org.hl7.xml.parser.SimpleTypeContentHandler;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/**
 * This little guy knows how to build MO values.
 * 
 * FIXME: CS code system not set
 */
public class MOPresenter extends DatatypePresenterBase {
	private static final String ATTR_NULL_FLAVOR = "nullFlavor";
	private static final String ATTR_VALUE = "value";
	private static final String ATTR_CURRENCY = "currency";

	private static final MOPresenter INSTANCE = new MOPresenter();

	private static class MOContentHandler extends SimpleTypeContentHandler {
		MO _result = null;

		protected void notifyActivation(Attributes atts) {
			String nullFlavorString = atts.getValue(ATTR_NULL_FLAVOR);
			if (nullFlavorString != null) {
				_result = MOnull.valueOf(nullFlavorString);
			} else {
				String valueString = atts.getValue(ATTR_VALUE);
				String currencyString = atts.getValue(ATTR_CURRENCY);
				_result = MOimpl.valueOf(ValueFactory.getInstance().REALvalueOfLiteral(valueString), CSimpl.valueOf(
						currencyString, "unknown"));
			}
		}

		protected Object getResult() {
			return (_result == null) ? MOnull.NI : _result;
		}
	} // MOContentHandler

	private static class MOBuilder implements DatatypeBuilder<MO> {
		public void build(RimGraphXMLSpeaker.ContentBuilder builder, MO value, String localName) throws BuilderException {
			try {
				MO mo = (MO) value;
				if (builder.nullValueHandled(value, localName))
					return;
				builder.addAttribute(ATTR_VALUE, mo.value());
				builder.addAttribute(ATTR_CURRENCY, mo.currency());
				builder.startElement(localName);
				builder.endElement(localName);
			} catch (SAXException ex) {
				throw new BuilderException(ex);
			}
		}

		// .......................................................................
		public void buildStructural(RimGraphXMLSpeaker.ContentBuilder builder, MO value, String localName)
				throws BuilderException {
			throw new BuilderException("MO cannot be a structural attribute");
		}
	} // MOBuilder

	private MOPresenter() {}

	public static MOPresenter instance() {
		return INSTANCE;
	}

	public ContentHandler getContentHandler(String namespaceURI, String localName, String qName, Attributes atts,
			Datatype datatype) {
		// do nothing with the datatype
		return new MOContentHandler();
	}

	public DatatypeBuilder getBuilder() {
		return new MOBuilder();
	}
}
