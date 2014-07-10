<%@include file="_include.jsp"%>
<e:form id="navigationForm">
	<e:menu>
		<%@include file="_navigationItems.jsp"%>
	</e:menu>
</e:form>


<h:panelGrid border="0" columns="3" cellpadding="10" width="100%"
	styleClass="esup-agent-entete" rendered="#{sessionController.currentUser != null}">
	<h:outputText
		value="Numen : #{sessionController.currentUser.agent.consultationEtatCivil.individuReponseEtatCivil.numen}"
		styleClass="portlet-section-header" />
	<h:outputText
		value="Dossier : #{sessionController.currentUser.agent.supannEmpId}"
		styleClass="portlet-section-header" />
	<h:outputText
		value="Agent : #{sessionController.currentUser.agent.consultationEtatCivil.individuReponseEtatCivil.prenom}  #{sessionController.currentUser.agent.consultationEtatCivil.individuReponseEtatCivil.nomPatronymique}"
		styleClass="portlet-section-header" />
</h:panelGrid>

<t:div rendered="#{sessionController.userLoginUnder != null}" styleClass="esup-agent-warning">
			<e:paragraph value="#{msgs['NAVIGATION.MESSAGE.LOGINASOK']}">
				<f:param value="#{sessionController.userLoginUnder.id}" />
			</e:paragraph>
</t:div>

