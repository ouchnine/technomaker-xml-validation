<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="text" indent="no" />
	<xsl:strip-space elements="*" />

	
	<xsl:template match="/">


		<xsl:apply-templates select="messages/message" />

		<xsl:apply-templates select="messages/informationsMessages" />


	</xsl:template>


	<xsl:template match="message">



		<xsl:value-of select="auteur" />
		<xsl:text>;
		</xsl:text>


		<xsl:value-of select="date" />
		<xsl:text>;</xsl:text>

		<xsl:value-of select="contenu" />

		<![CDATA[<br/>]]>
	</xsl:template>

	<xsl:template match="informationsMessages">



		<xsl:value-of select="nombreMessages" />


		<xsl:value-of select="datePremierMessage" />

	</xsl:template>

</xsl:stylesheet>
