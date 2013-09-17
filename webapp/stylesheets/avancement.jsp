<%@include file="_include.jsp"%>
<e:page stringsVar="msgs" menuItem="about"
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
					value="Il n'existe pas de données sur votre avancement" />
			</t:div>

			<h:panelGroup
				rendered="#{avancementController.displayUser.agent.consulterDonneesActuelles!=null}">
				<h:outputText value="#{msgs['AVANCEMENT.TEXT.INM']} actuel : "
					styleClass="portlet-form-label" />
				<h:outputText
					value="#{avancementController.displayUser.agent.consulterDonneesActuelles}"
					styleClass="portlet-font" />
			</h:panelGroup>
			<h:dataTable title="Avancement" id="avancement"
				value="#{avancementController.displayUser.agent.consulterDonneesAvancement}"
				var="avancement" columnClasses="list-column-center"
				headerClass="portlet-table-header" rowClasses="portlet-font"
				width="50%" cellspacing="5" cellpadding="2"
				rendered="#{avancementController.displayUser.agent.consulterDonneesAvancement!= null}">

				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msgs['AVANCEMENT.TEXT.INM']}" />
					</f:facet>
					<h:panelGroup>
						<h:outputText value="#{avancement.indiceMajoreFutur} "
							rendered="#{avancement.indiceMajoreFutur!=null}" />
						<h:outputText
							value="#{avancement.echelonFuturDto.libelleEchelonFutur}"
							rendered="#{avancement.echelonFuturDto.libelleEchelonFutur!=null}" />
					</h:panelGroup>
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputText value="#{msgs['AVANCEMENT.TEXT.DATEPREVISION']}" />
					</f:facet>
					<h:outputText value="#{avancement.datePrevisionnelle.time}"
						rendered="#{avancement.datePrevisionnelle!=null}">
						<f:convertDateTime pattern="dd/MM/yyyy" timeZone="Europe/Paris"
							locale="Locale.FRANCE" />
					</h:outputText>
				</h:column>
			</h:dataTable>





		</h:panelGroup>


		<h:panelGroup rendered="#{sessionController.currentUser == null}">
			<e:paragraph value="#{msgs['AVANCEMENT.MSG.UNAUTHENTICATE']}" />
		</h:panelGroup>



	</t:div>

	<%
		/* @include file="_debug.jsp" */
	%>

</e:page>
