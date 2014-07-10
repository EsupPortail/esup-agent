<%@include file="_include.jsp"%>
<e:page stringsVar="msgs" menuItem="welcome"
	locale="#{sessionController.locale}">
	<%@include file="_navigation.jsp"%>
	<e:section value="#{msgs['WELCOME.TITLE']}" />


	<e:messages />




	<e:form id="welcomeForm"
		rendered="#{sessionController.currentUser == null}">
		<e:paragraph value="#{msgs['WELCOME.TEXT.UNAUTHENTICATED']}" />
		<e:panelGrid columns="2">
			<e:outputLabel for="locale"
				value="#{msgs['PREFERENCES.TEXT.LANGUAGE']}" />
			<h:panelGroup>
				<e:selectOneMenu id="locale" onchange="submit();"
					value="#{preferencesController.locale}"
					converter="#{localeConverter}">
					<f:selectItems value="#{preferencesController.localeItems}" />
				</e:selectOneMenu>
				<e:commandButton value="#{msgs['_.BUTTON.CHANGE']}"
					id="localeChangeButton" />
			</h:panelGroup>
		</e:panelGrid>
	</e:form>



	<h:panelGroup rendered="#{sessionController.currentUser!=null}">



		<h:panelGroup>
			<h:panelGrid border="0" columns="1" cellpadding="10" width="100%"
				styleClass="esup-agent-portlet-subsection-header">
				<h:outputText value="#{msgs['WELCOME.TITLE.INFOADMIN']}" />
			</h:panelGrid>
			<h:panelGrid border="0" columns="2" cellspacing="10" cellpadding="2">
				<h:outputText styleClass="table-titre portlet-form-label"
					value="Numéro Harpege" />
				<h:outputText
					value="#{welcomeController.displayUser.agent.supannEmpId}"
					styleClass="portlet-form-label" />
				<h:outputText styleClass="table-titre portlet-form-label"
					value="#{msgs['WELCOME.TEXT.NOM']}" />
				<h:outputText
					value="#{welcomeController.displayUser.agent.consulterEtatCivil.individuReponseEtatCivil.nomPatronymique}"
					styleClass="portlet-form-label" />
				<h:outputText styleClass="table-titre portlet-form-label"
					value="#{msgs['WELCOME.TEXT.PRENOM']}" />
				<h:outputText
					value="#{welcomeController.displayUser.agent.consulterEtatCivil.individuReponseEtatCivil.prenom}"
					styleClass="portlet-form-label" />
				<h:outputText styleClass="table-titre portlet-form-label"
					value="#{msgs['WELCOME.TEXT.DATENAISSANCE']}" />
				<h:outputText
					value="#{welcomeController.displayUser.agent.consulterEtatCivil.individuReponseEtatCivil.dateNaissance.time}"
					styleClass="portlet-form-label">
					<f:convertDateTime pattern="dd/MM/yyyy" timeZone="Europe/Paris"
						locale="Locale.FRANCE" />
				</h:outputText>
				<h:outputText styleClass="table-titre portlet-form-label"
					value="#{msgs['WELCOME.TEXT.LIEUNAISSANCE']}"
					styleClass="portlet-form-label" />
				<h:outputText
					value="#{welcomeController.displayUser.agent.consulterEtatCivil.individuReponseEtatCivil.villeDeNaissance}"
					styleClass="portlet-form-label" />
				<h:outputText styleClass="table-titre portlet-form-label"
					value="#{msgs['WELCOME.TEXT.PAYSNAISSANCE']}" />
				<h:outputText
					value="#{welcomeController.displayUser.agent.consulterEtatCivil.individuReponseEtatCivil.paysNaissanceDto.paysNaissance}"
					styleClass="portlet-form-label" />
			</h:panelGrid>
		</h:panelGroup>

		<h:panelGroup>
			<h:panelGrid border="0" columns="1" cellpadding="10" width="100%"
				styleClass="esup-agent-portlet-subsection-header">
				<h:outputText value="#{msgs['WELCOME.TITLE.COORDONNEES']}" />
			</h:panelGrid>
			<h:dataTable var="adresse"
				title="#{msgs['WELCOME.TITLE.COORDONNEES']}"
				value="#{welcomeController.displayUser.agent.consulterCoordonneesPersonnellesDto}"
				columnClasses="list-column-center"
				headerClass="portlet-table-header"
				rowClasses="table-titre portlet-form-label" width="50%"
				cellspacing="10" cellpadding="2">
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msgs['WELCOME.TEXT.ADRESSE']}" />
					</f:facet>
					<h:outputText
						value="#{adresse.adresseDto.numeroVoie} #{adresse.adresseDto.voie.libelleVoie} #{adresse.adresseDto.nomVoie}" />
					<f:verbatim>
						<br />
					</f:verbatim>
					<h:outputText
						value="#{adresse.adresseDto.codePostal} #{adresse.adresseDto.ville}" />
					<f:verbatim>
						<br />
					</f:verbatim>
					<h:outputText value="#{adresse.adresseDto.pays.libellePays}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msgs['WELCOME.TEXT.TELEPHONE']}" />
					</f:facet>
					<h:outputText value="#{adresse.adresseDto.telephoneDomicile}" />
				</h:column>

			</h:dataTable>
		</h:panelGroup>


		<h:panelGroup
			rendered="#{welcomeController.displayUser.agent.consulterSituationFamiliale.listeEnfants!=null}">
			<h:panelGrid border="0" columns="1" cellpadding="10" width="100%"
				styleClass="esup-agent-portlet-subsection-header">
				<h:outputText value="#{msgs['WELCOME.TITLE.ENFANTS']}" />
			</h:panelGrid>
			<h:dataTable title="Enfants" id="enfants"
				value="#{welcomeController.displayUser.agent.consulterSituationFamiliale.listeEnfants}"
				var="enfant" columnClasses="list-column-center"
				headerClass="portlet-table-header"
				rowClasses="table-titre portlet-form-label" width="50%"
				cellspacing="10" cellpadding="2">
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msgs['WELCOME.TEXT.NOM']}" />
					</f:facet>
					<h:outputText value="#{enfant.nom}" styleClass="portlet-form-label" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msgs['WELCOME.TEXT.PRENOM']}" />
					</f:facet>
					<h:outputText value="#{enfant.prenom}"
						styleClass="portlet-form-label" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msgs['WELCOME.TEXT.DATENAISSANCE']}" />
					</f:facet>
					<h:outputText value="#{enfant.dateNaissance.time}"
						styleClass="portlet-form-label">
						<f:convertDateTime pattern="dd/MM/yyyy" timeZone="Europe/Paris"
							locale="Locale.FRANCE" />
					</h:outputText>
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msgs['WELCOME.TEXT.HANDICAP']}" />
					</f:facet>
					<h:outputText value="#{enfant.pourcentHandicap}"
						styleClass="portlet-form-label" />
				</h:column>
			</h:dataTable>
		</h:panelGroup>

		<h:panelGroup
			rendered="#{welcomeController.displayUser.agent.consulterDiplomes.taille!=0}">
			<h:panelGrid border="0" columns="1" cellpadding="10" width="100%"
				styleClass="esup-agent-portlet-subsection-header">
				<h:outputText value="#{msgs['WELCOME.TITLE.DIPLOMES']}" />
			</h:panelGrid>

			<h:dataTable var="diplome"
				value="#{welcomeController.displayUser.agent.consulterDiplomes.consultationDiplomesDto}"
				columnClasses="list-column-center"
				headerClass="portlet-table-header"
				rowClasses="table-titre portlet-form-label" width="50%"
				cellspacing="10" cellpadding="2">

				<h:column>
					<f:facet name="header">
						<h:outputText value="Année" />
					</f:facet>

					<h:outputText value="#{diplome.anneeDiplome+1900}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Diplôme" />
					</f:facet>

					<h:outputText value="#{diplome.diplomeDto.libelleLong}" />
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="Lieu du diplôme" />
					</f:facet>

					<h:outputText value="#{diplome.lieuDiplome}" />
				</h:column>
			</h:dataTable>
		</h:panelGroup>

	</h:panelGroup>

	<script type="text/javascript">	
	hideButton("welcomeForm:localeChangeButton");		
</script>
	<%
		/* @include file="_debug.jsp" */
	%>
</e:page>
