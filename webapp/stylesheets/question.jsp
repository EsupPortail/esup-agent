<%@include file="_include.jsp"%>
<e:page stringsVar="msgs" menuItem="about"
	locale="#{sessionController.locale}"
	authorized="#{questionController.pageAuthorized}">

<t:div styleClass="esupAgent">
	<%@include file="_navigation.jsp"%>

	<e:section value="#{msgs['QUESTION.TITLE']}">
		<f:param value="#{applicationService.name}" />
		<f:param value="#{applicationService.version}" />
	</e:section>
	
		<h:panelGroup rendered="#{sessionController.currentUser != null}">
			<h:form>
				<h:outputText value="Titre du message :" styleClass="portlet-form-label" /><t:htmlTag value="br" />
				<t:inputText value="#{questionController.titre}" /><t:htmlTag value="br" />
				<h:outputText value="Message : " styleClass="portlet-form-label" /><t:htmlTag value="br" />
				<t:inputTextarea value="#{questionController.message}" cols="40" rows="10"/><t:htmlTag value="br" />
				<h:commandButton value="#{msgs['QUESTION.TEXT.SENDMESSAGE']}"
					action="#{questionController.sendMessage}" />
			</h:form>

		</h:panelGroup>


		<h:panelGroup rendered="#{sessionController.currentUser == null}">
			<e:paragraph value="#{msgs['QUESTION.MSG.UNAUTHENTICATE']}" />
		</h:panelGroup>



	</t:div>

	<%
		/* @include file="_debug.jsp" */
	%>

</e:page>
