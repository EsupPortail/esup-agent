<%@include file="_include.jsp"%>

<e:page stringsVar="msgs" menuItem="gestion" locale="#{sessionController.locale}" authorized="#{gestionController.pageAuthorized}" >
	<%@include file="_navigation.jsp"%>
	<e:section value="#{msgs['GESTION.TITLE']}" />
	

	<e:messages />



	<h:panelGroup rendered="#{sessionController.currentUser != null}">
		<h:panelGroup rendered="#{sessionController.userLoginUnder == null}">
			<e:paragraph value="#{msgs['GESTION.TEXT.LOGINAS']}" />

			<h:form>
				<e:inputText id="loginAs" value="#{gestionController.loginAs}"
					required="true" validator="#{gestionController.validateInput}" />
				<e:commandButton value="#{msgs['GESTION.BUTTON.CONNECTAS']}"
					action="#{gestionController.seConnecterSous}" />
			</h:form>
		</h:panelGroup>
		<h:panelGroup rendered="#{sessionController.userLoginUnder != null}">
			<e:paragraph value="#{msgs['GESTION.TEXT.LOGINASOK']}">
				<f:param value="#{sessionController.userLoginUnder.id}" />
			</e:paragraph>
			<h:form>
				<e:commandButton value="#{msgs['GESTION.BUTTON.CONNECTBACK']}"
					action="#{gestionController.revenir}" />
			</h:form>
		</h:panelGroup>
	</h:panelGroup>

	<h:panelGroup rendered="#{sessionController.currentUser == null}">
		<e:paragraph value="#{msgs['GESTION.MSG.UNAUTHENTICATE']}" />
	</h:panelGroup>

	<%
		/* @include file="_debug.jsp" */
	%>
</e:page>