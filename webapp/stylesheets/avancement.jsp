<%@include file="_include.jsp"%>
<e:page stringsVar="msgs" menuItem="avancement"
	locale="#{sessionController.locale}"
	authorized="#{aboutController.pageAuthorized}" footer="">
	<t:div styleClass="esupAgent">
		<%@include file="_navigation.jsp"%>

		<e:section value="#{msgs['AVANCEMENT.TITLE']}">
			<f:param value="#{applicationService.name}" />
			<f:param value="#{applicationService.version}" />
		</e:section>

		<h:panelGroup rendered="#{sessionController.currentUser != null}">

			<t:div styleClass="esup-agent-portlet-display-block"
				rendered="#{avancementController.displayUser.agent.consulterDonneesAvancement == null}">
				<h:outputText styleClass="portlet-msg-alert"
					value="Il n'existe pas de donn�es sur votre avancement" />
			</t:div>

			<h:panelGroup
				rendered="#{avancementController.displayUser.agent.consulterDonneesActuelles!=null}">
				<h:outputText value="#{msgs['AVANCEMENT.TEXT.INM']} actuel #{avancementController.displayUser.agent.consulterDonneesActuelles}." />
			</h:panelGroup>
			<t:div/>
			<h:panelGroup rendered="#{avancementController.displayUser.agent.avancement != null}">

				<h:outputText value="Dernier passage le " rendered="#{!avancementController.displayUser.agent.avancement.dateDernierChangementEstFuture}" />
				<h:outputText value="Prochain passage le " rendered="#{avancementController.displayUser.agent.avancement.dateDernierChangementEstFuture}" />

				<h:outputText value="#{avancementController.displayUser.agent.avancement.dateDernierChangement}">
				  <f:convertDateTime pattern="dd/MM/yyyy" timeZone="Europe/Paris"
						     locale="Locale.FRANCE" />
				</h:outputText>

				<h:outputText value=" � l'�chelon #{avancementController.displayUser.agent.avancement.echelonDernierChangement}." />

				<t:div style="margin-top: 1em;"/>

				<h:outputText value="Prochain passage dans " rendered="#{!avancementController.displayUser.agent.avancement.dateDernierChangementEstFuture}" />
				<h:outputText value="Passage suivant dans " rendered="#{avancementController.displayUser.agent.avancement.dateDernierChangementEstFuture}" />

				<h:outputText value="#{avancementController.displayUser.agent.avancement.moisAvantProchainChangementPrevisionnelMin}" />
				<h:outputText value=" � #{avancementController.displayUser.agent.avancement.moisAvantProchainChangementPrevisionnelMax}" rendered="#{avancementController.displayUser.agent.avancement.moisAvantProchainChangementPrevisionnelMin != avancementController.displayUser.agent.avancement.moisAvantProchainChangementPrevisionnelMax}" />
				<h:outputText value=" mois. (*)"/>
 				<t:div/><h:outputText value="Pr�cision : vous avez une r�duction potentielle de passage d'�chelon. (*)" rendered="#{avancementController.displayUser.agent.avancement.bonificationEchelon}" />
				<t:div/><h:outputText value="Pr�cision : vous avez un reliquat d'anciennet�. (*)" rendered="#{avancementController.displayUser.agent.avancement.reliquatAnciennete}" />

				<t:div style="margin-top: 1em;"/>
 				<h:outputText value="(*) Les informations fournies relatives � votre avancement sont donn�es � titre informatif et ne sont pas garanties."/>

			</h:panelGroup>

		</h:panelGroup>


		<h:panelGroup rendered="#{sessionController.currentUser == null}">
			<e:paragraph value="#{msgs['AVANCEMENT.MSG.UNAUTHENTICATE']}" />
		</h:panelGroup>



	</t:div>

	<%
		/* @include file="_debug.jsp" */
	%>

</e:page>
