package norsys.technomaker.xml.servlet.core;

import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Servlet utilisant le XSLT pour afficher des documents.
 */
public abstract class AbstractXsltServlet extends AbstractServlet {

	private static final long serialVersionUID = 2033774359823773089L;

	private String xslFileName;

	/**
	 * Construit un nouveau {@link AbstractXsltServlet}.
	 * 
	 * @param contentType
	 *            type du document genere (html, xml, ...).
	 * @param xslFileName
	 *            fichier XSL.
	 */
	public AbstractXsltServlet(String contentType, String xslFileName) {
		super(contentType);
		this.xslFileName = xslFileName;
	}

	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp)
			throws Throwable {

		ServletOutputStream outputStream = resp.getOutputStream();

		genererDocument(xslFileName, ConstanteServlet.XML_FILE, outputStream);
	}

	/**
	 * Genere le document dans le <tt>outputStream</tt> a partir d'un fichier
	 * XSL et XML.
	 * 
	 * @param xslFile
	 *            fichier modele (XSLT).
	 * @param xmlFile
	 *            fichier de donnees XML.
	 * @param outputStream
	 *            flux de sortie.
	 * @throws Exception
	 *             erreur technique.
	 */
	private static void genererDocument(String xslFile, String xmlFile,
			ServletOutputStream outputStream) throws Exception {

		ClassLoader loader = Thread.currentThread().getContextClassLoader();

		// Recuperation du fichier XSLT
		InputStream xslStream = loader.getResourceAsStream(xslFile);
		StreamSource xslStreamSource = new StreamSource(xslStream);

		// Recuperation du fichier XML
		InputStream xmlStream = loader.getResourceAsStream(xmlFile);
		StreamSource xmlStreamSource = new StreamSource(xmlStream);

		// Initialise le flux en sortie
		StreamResult outputStreamResult = new StreamResult(outputStream);

		// Initialisation a partir du XSLT
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer(xslStreamSource);

		// Lance la generation du document
		transformer.transform(xmlStreamSource, outputStreamResult);
	}
}
