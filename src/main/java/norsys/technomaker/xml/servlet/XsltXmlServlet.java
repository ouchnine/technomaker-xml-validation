package norsys.technomaker.xml.servlet;

import norsys.technomaker.xml.servlet.core.ConstanteServlet;
import norsys.technomaker.xml.servlet.core.AbstractXsltServlet;

/**
 * Servlet destinee a l'affichage d'un flux XML depuis une generation en XSLT.
 */
public class XsltXmlServlet extends AbstractXsltServlet {

	private static final long serialVersionUID = 5767700799045966615L;

	/**
	 * Construit un nouveau {@link XsltXmlServlet}.
	 */
	public XsltXmlServlet() {
		super("text/xml", ConstanteServlet.XSL_XML_FILE);
	}
}
