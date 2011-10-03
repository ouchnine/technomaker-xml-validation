package norsys.technomaker.xml.parser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * Classe de parcours du fichier XML pour construire l'affichage HTML.
 */
public final class MonParseurXml {

	/**
	 * Constructeur.
	 */
	private MonParseurXml() {
	}

	/**
	 * Cree le corps de la page HTML de la page a partir du fichier XML qui
	 * 
	 * @param document
	 *            fichier XML a parser.
	 * @return String contenant le code HTML de la page avec les donnees du
	 *         fichier XML.
	 * @throws IOException
	 * @throws JDOMException
	 */
	public static String creerCorpsPageHtml(Document document)
			throws JDOMException, IOException {

		StringBuilder builder = new StringBuilder();
		File xmlFile = new File(
				"/TechnoMaker/workspace/technomaker-xml-validation/src/main/resources/xml/donnees-messages.xml");

		SAXBuilder build = new SAXBuilder();
		document = build.build(xmlFile);

		List liste = document.getRootElement().getChildren();

		builder.append("<html>");
		builder.append("<body>");

		builder.append("<h1>Parseur XML</h1>");
		builder.append("<h3>Listes des messages  </h3>");
		builder.append("<table border='1' cellspacing='0' cellpadding='3'>");
		builder.append("<tr bgcolor='#FFFF00'>");
		builder.append("<td>Auteur</td>");
		builder.append("<td>Date</td>");
		builder.append("<td>Contenu</td>");
		for (int j = 0; j < liste.size() - 1; j++) {
			Element message = (Element) liste.get(j);

			Attribute attr = message.getAttribute("reference");
			message.getValue();
			List contenu = message.getChildren();
			builder.append(" <tr>");
			for (int i = 0; i < contenu.size(); i++) {
				Element elment = (Element) contenu.get(i);
				builder.append(" <td>");
				builder.append("" + elment.getValue());

				builder.append(" </td>");
			}
			// builder.append("<b>A faire...</b>"+ message.getValue() );
			builder.append(" </tr>");

		}

		builder.append("</table>");
		builder.append("<h3>Information Sur les messages </h3>");
		builder.append("<table border='1' cellspacing='0' cellpadding='3'>");
		builder.append("<tr bgcolor='#FFFF00'>");
		builder.append("<td>Nombre  des Messages </td>");
		builder.append("<td>Date de Premier Message </td>");
		Element informationMessage = (Element) liste.get(liste.size()-1);
		
		List infomessage = informationMessage.getChildren();
		builder.append(" <tr>");
		for (int i = 0; i < infomessage.size(); i++) {
			Element dernier= (Element) infomessage.get(i);
			builder.append(" <td>");
			builder.append("" + dernier.getValue());

			builder.append(" </td>");
		}
		
		builder.append(" </tr>");
		builder.append("</table>");
		
		builder.append("</body>");
		builder.append("</html>");

		return builder.toString();
	}
}
