package norsys.technomaker.xml.servlet.core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Tronc commun des servlets de cette application.
 */
public abstract class AbstractServlet extends HttpServlet {

	private static final long serialVersionUID = -1500845971442679449L;

	private String contentType;

	/**
	 * Construit une nouvelle servlet.
	 * 
	 * @param contentType
	 *            type de la reponse (html, xml, ...).
	 */
	public AbstractServlet(String contentType) {
		super();
		this.contentType = contentType;
	}

	/**
	 * Traitement applique lors de la reception d'une requete.
	 * 
	 * @param req
	 *            requete du navigateur.
	 * @param resp
	 *            reponse qui sera envoyee au navigateur.
	 * @throws Throwable
	 *             erreur technique.
	 */
	public abstract void process(HttpServletRequest req,
			HttpServletResponse resp) throws Throwable;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {
			resp.setContentType(contentType);
			resp.setStatus(HttpServletResponse.SC_OK);

			process(req, resp);
			
		} catch (Throwable e) {
			resp.reset();
			resp.setContentType("text/html");
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			PrintWriter writer = resp.getWriter();
			writer.println("<pre>");
			e.printStackTrace(writer);
			writer.println("</pre>");
			
			throw new ServletException(e);
		}
	}
}
