package norsys.technomaker.xml.servlet;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import norsys.technomaker.xml.servlet.core.AbstractServlet;

/**
 * Servlet d'accueil de l'application.
 */
public class BienvenueServlet extends AbstractServlet {

	private static final long serialVersionUID = -7086163939719870130L;

	/**
	 * Construit une nouvelle {@link BienvenueServlet}.
	 */
	public BienvenueServlet() {
		super("text/html");
	}

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp)
			throws Throwable {

		PrintWriter writer = resp.getWriter();
		writer.println("<h1>Formation XML - TP de validation</h1>");

		writer.println("<ul>");
		writer.println("<li><a href=\"/parseur\">Parseur</a></li>");
		writer.println("<li><a href=\"/xslt-html\">XSLT (HTML)</a></li>");
		writer.println("<li><a href=\"/xslt-xml\">XSLT (XML)</a></li>");
		writer.println("<li><a href=\"/xslt-texte\">XSLT (Texte)</a></li>");
		writer.println("</ul>");
	}
}
