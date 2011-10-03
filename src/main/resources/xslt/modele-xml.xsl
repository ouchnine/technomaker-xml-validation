<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml" indent="yes" />
	<xsl:key name="regrouper" match="auteur" use="." />
	<xsl:key name="grouper" match="message" use="." />

	<xsl:template match="/">
		<auteurs>

			<xsl:apply-templates
				select="messages/message/auteur[generate-id(.)=generate-id(key('regrouper',.)[1])]" />

		</auteurs>

	</xsl:template>

	<xsl:template match="auteur">
		<auteur>

			<messages>
				<xsl:apply-templates select="//contenu[../auteur=current()]" />
			</messages>
			<dates>
				<xsl:apply-templates select="//date[../auteur=current()]" />
			</dates>

		</auteur>
	</xsl:template>


	<xsl:template match="date">
		<xsl:copy-of select="." />
	</xsl:template>

	<xsl:template match="contenu">
		<xsl:copy-of select="." />
	</xsl:template>

	<xsl:template match="informationsMessages">
		<informationsMessages>
			<nombreMessages>
				<xsl:value-of select="nombreMessages" />
			</nombreMessages>
			<datePremierMessage>
				<xsl:value-of select="datePremierMessage" />
			</datePremierMessage>
		</informationsMessages>
	</xsl:template>

</xsl:stylesheet>