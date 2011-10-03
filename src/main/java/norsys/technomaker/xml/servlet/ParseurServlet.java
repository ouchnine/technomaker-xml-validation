package norsys.technomaker.xml.servlet;

import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import norsys.technomaker.xml.parser.MonParseurXml;
import norsys.technomaker.xml.servlet.core.AbstractServlet;
import norsys.technomaker.xml.servlet.core.ConstanteServlet;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

/**
 * Servlet utilisant un parseur XML pour afficher les donnees.
 */
public class ParseurServlet extends AbstractServlet {

	private static final long serialVersionUID = 2033774359823773089L;

	/**
	 * Construit un nouveau {@link ParseurServlet}.
	 */
	public ParseurServlet() {
		super("text/html");
	}

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp)
			throws Throwable {

		PrintWriter writer = resp.getWriter();

		String xmlFile = ConstanteServlet.XML_FILE;
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream stream = loader.getResourceAsStream(xmlFile);

		SAXBuilder builder = new SAXBuilder();
		Document document = builder.build(stream);

		String htmlBody = MonParseurXml.creerCorpsPageHtml(document);
		writer.print(htmlBody);
	}
}
