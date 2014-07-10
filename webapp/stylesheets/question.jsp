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
				<e:messages />
				
				<t:htmlTag value="br" />
				<h:outputText value="#{msgs['QUESTION.TEXT.TITREMESSAGE']} :"
					styleClass="portlet-form-label" />
				<t:htmlTag value="br" />
				<t:inputText value="#{questionController.titre}"/>
				<t:htmlTag value="br" />
				<h:outputText value="#{msgs['QUESTION.TEXT.MESSAGE']} * :"
					styleClass="portlet-form-label" />
				<t:htmlTag value="br" />
				<t:inputTextarea id="message" value="#{questionController.message}"
					cols="40" rows="10" required="#{true}" validator="#{questionController.validateMessage}">
				</t:inputTextarea>
				<t:htmlTag value="br" />

				<h:selectOneRadio id="destinataires" styleClass="portlet-font"
					value="#{questionController.contactSelected}"
					rendered="#{not empty questionController.envoiMail.contactList}"
					required="#{true}">
					<f:selectItems value="#{questionController.choixContact}" />

				</h:selectOneRadio>
				<t:htmlTag value="br" />

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
