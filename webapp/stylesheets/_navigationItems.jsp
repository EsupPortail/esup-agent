<%@include file="_include.jsp"%>
<e:menuItem id="welcome" value="#{msgs['NAVIGATION.TEXT.WELCOME']}"
	action="#{welcomeController.enter}"
	accesskey="#{msgs['NAVIGATION.ACCESSKEY.WELCOME']}" />



<e:menuItem id="contrat" value="#{msgs['NAVIGATION.TEXT.CONTRAT']}"
	accesskey="#{msgs['NAVIGATION.ACCESSKEY.CONTRAT']}"
	action="#{contratController.enter}"
	rendered="#{contratController.pageAuthorized}" />

<e:menuItem id="carriere" value="#{msgs['NAVIGATION.TEXT.CARRIERE']}"
	accesskey="#{msgs['NAVIGATION.ACCESSKEY.CARRIERE']}"
	action="#{carriereController.enter}"
	rendered="#{carriereController.pageAuthorized}" />
<e:menuItem id="gestion" value="#{msgs['NAVIGATION.TEXT.GESTION']}"
	accesskey="#{msgs['NAVIGATION.ACCESSKEY.GESTION']}"
	action="#{gestionController.enter}"
	rendered="#{gestionController.pageAuthorized}" />
<e:menuItem id="login" action="casLogin"
	value="#{msgs['NAVIGATION.TEXT.LOGIN']}"
	accesskey="#{msgs['NAVIGATION.ACCESSKEY.LOGIN']}"
	rendered="#{sessionController.printLogin}" />
<e:menuItem id="logout" action="#{sessionController.logout}"
	value="#{msgs['NAVIGATION.TEXT.LOGOUT']}"
	accesskey="#{msgs['NAVIGATION.ACCESSKEY.LOGOUT']}"
	rendered="#{sessionController.printLogout}" />

