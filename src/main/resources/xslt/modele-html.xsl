<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="html" indent="yes" />

	<xsl:template match="/">
		<html>
			<body>
				<h1>TP de validation XML</h1>
				<table border="1" cellspacing="0" cellpadding="3">
					<h3>Liste des message </h3>
					<tr bgcolor="#FFFF00">
						<td>Auteur</td>
						<td>Date</td>
						<td>Contenu</td>
					</tr>

					<xsl:apply-templates select="messages/message" />

				</table>
				<xsl:apply-templates select="messages/informationsMessages" />

			</body>
		</html>
	</xsl:template>


	<xsl:template match="message">


		<tr>

			<td>
				<xsl:value-of select="auteur" />
			</td>

			<td>
				<xsl:value-of select="date" />
			</td>

			<td>
				<xsl:value-of select="contenu" />
			</td>

		</tr>


	</xsl:template>

	<xsl:template match="informationsMessages">

		<table border="1" cellspacing="0" cellpadding="3">
			<h2>Les informations sur les messages  </h2>
			<tr bgcolor="#FFFF00">
				<td>Nombre des Messages </td>
				<td>Date de Premier Message </td>

			</tr>
			<tr>
				<td>
					<xsl:value-of select="nombreMessages" />
				</td>
				<td>
					<xsl:value-of select="datePremierMessage" />
				</td>

			</tr>
		</table>
	</xsl:template>
</xsl:stylesheet>