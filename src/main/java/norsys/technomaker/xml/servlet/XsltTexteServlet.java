package norsys.technomaker.xml.servlet;

import norsys.technomaker.xml.servlet.core.ConstanteServlet;
import norsys.technomaker.xml.servlet.core.AbstractXsltServlet;

/**
 * Servlet destinee a l'affichage d'une page texte depuis une generation en
 * XSLT.
 */
public class XsltTexteServlet extends AbstractXsltServlet {

	private static final long serialVersionUID = 5767700799045966615L;

	/**
	 * Construit un nouveau {@link XsltTexteServlet}.
	 */
	public XsltTexteServlet() {
		super("text/html", ConstanteServlet.XSL_TEXT_FILE);
	}
}
