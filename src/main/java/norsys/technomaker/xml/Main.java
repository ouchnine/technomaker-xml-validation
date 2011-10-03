package norsys.technomaker.xml;

import javax.servlet.http.HttpServlet;

import norsys.technomaker.xml.servlet.BienvenueServlet;
import norsys.technomaker.xml.servlet.ParseurServlet;
import norsys.technomaker.xml.servlet.XsltHtmlServlet;
import norsys.technomaker.xml.servlet.XsltTexteServlet;
import norsys.technomaker.xml.servlet.XsltXmlServlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Point d'entree de l'application.
 */
public final class Main {

	/**
	 * Demarre l'application en initialisant les servlets.
	 * 
	 * @throws Throwable
	 *             erreur technique.
	 */
	public static void main(String[] args) throws Throwable {
		Server server = new Server(8080);

		final int options = ServletContextHandler.SESSIONS;
		ServletContextHandler context = new ServletContextHandler(options);
		context.setContextPath("/");
		server.setHandler(context);

		addServlet(context, "/", BienvenueServlet.class);
		addServlet(context, "/parseur", ParseurServlet.class);
		addServlet(context, "/xslt-html", XsltHtmlServlet.class);
		addServlet(context, "/xslt-xml", XsltXmlServlet.class);
		addServlet(context, "/xslt-texte", XsltTexteServlet.class);

		server.start();
		server.join();
	}

	/**
	 * Ajoute une servlet qui sera accessible a l'adresse <tt>contextPath</tt>.
	 * 
	 * @param context
	 *            gestionnaire des contextes.
	 * @param contextPath
	 *            chemin vers la servlet.
	 * @param servletClass
	 *            classe de la servlet.
	 * @throws InstantiationException
	 *             declenchee si la servlet ne contient pas de constrcuteur sans
	 *             arguments.
	 * @throws IllegalAccessException
	 *             erreur technique.
	 */
	private static void addServlet(ServletContextHandler context,
			String contextPath, Class<? extends HttpServlet> servletClass)
			throws InstantiationException, IllegalAccessException {

		HttpServlet servletInstance = servletClass.newInstance();
		ServletHolder servletHolder = new ServletHolder(servletInstance);
		context.addServlet(servletHolder, contextPath);
	}
}
