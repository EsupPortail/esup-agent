<%@include file="_include.jsp"%>
<e:form id="navigationForm">
	<e:menu>
		<%@include file="_navigationItems.jsp"%>
	</e:menu>
</e:form>


<t:div rendered="#{sessionController.userLoginUnder != null}" styleClass="esup-agent-warning">
			<e:paragraph value="#{msgs['NAVIGATION.MESSAGE.LOGINASOK']}">
				<f:param value="#{sessionController.userLoginUnder.id}" />
			</e:paragraph>
</t:div>

