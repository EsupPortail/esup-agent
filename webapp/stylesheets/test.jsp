<%@include file="_include.jsp"%>
<e:page stringsVar="msgs" menuItem="welcome" locale="#{sessionController.locale}" >
	<%@include file="_navigation.jsp"%>
	<e:section value="TEST" />
	<e:paragraph value="PAGE DE TEST" />
	
	<e:messages/>

<h:form>
<e:inputText id="loginAs" value="#{testController.loginAs}" validator="#{testController.cherche}"/>
<e:commandButton value="Go" action="#{testController.affiche}"/>
</h:form>
<% /* @include file="_debug.jsp" */ %>
</e:page>
