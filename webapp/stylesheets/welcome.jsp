

<%@include file="_include.jsp"%>
<e:page stringsVar="msgs" menuItem="welcome"
	locale="#{sessionController.locale}">

	<t:div styleClass="esupAgent">
		<%@include file="_navigation.jsp"%>
		<e:section value="#{msgs['WELCOME.TITLE']}" />


		<e:messages />

		<h:panelGrid border="0" columns="2" cellpadding="10" width="100%"
			styleClass="esup-agent-entete"
			rendered="#{sessionController.currentUser != null}">
			<h:outputText
				value="#{welcomeController.displayUser.agent.consultationEtatCivil.individuReponseEtatCivil_V2.prenom}  #{welcomeController.displayUser.agent.consultationEtatCivil.individuReponseEtatCivil_V2.nomPatronymique}"
				styleClass="portlet-section-header" />
			<h:outputText
				rendered="#{welcomeController.displayUser.agent.consultationEtatCivil.individuReponseEtatCivil_V2!=null || welcomeController.displayUser.agent.consultationEtatCivil.individuReponseEtatCivil_V2.numen != null}"
				value="Numen : #{welcomeController.displayUser.agent.consultationEtatCivil.individuReponseEtatCivil_V2.numen}"
				styleClass="portlet-section-header" />
		</h:panelGrid>


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
				<h:panelGrid border="0" columns="1" cellpadding="2" width="100%"
					styleClass="portlet-subsection-header">
					<h:outputText value="#{msgs['WELCOME.TITLE.INFOADMIN']}" />
				</h:panelGrid>
				<h:panelGrid border="0" columns="2" cellspacing="10" cellpadding="2">
					<h:outputText styleClass="portlet-form-label"
						value="Numéro Harpege" />
					<h:outputText
						value="#{welcomeController.displayUser.agent.supannEmpId}"
						styleClass="portlet-font" />
					<h:outputText styleClass="portlet-form-label"
						value="#{msgs['WELCOME.TEXT.NOMFAMILLE']}" />
					
					<h:outputText
						value="#{welcomeController.displayUser.agent.consultationEtatCivil.individuReponseEtatCivil_V2.nomPatronymique}"
						styleClass="portlet-font"
						 />
					
					<h:outputText styleClass="portlet-form-label"
						value="#{msgs['WELCOME.TEXT.NOMUSUEL']}" />
					<h:outputText
						value="#{welcomeController.displayUser.agent.consulterEtatCivil.individuReponseEtatCivil_V2.nomUsuel}"
						styleClass="portlet-font" />
					
					
					<h:outputText styleClass="portlet-form-label"
						value="#{msgs['WELCOME.TEXT.PRENOM']}" />
					<h:outputText
						value="#{welcomeController.displayUser.agent.consulterEtatCivil.individuReponseEtatCivil_V2.prenom}"
						styleClass="portlet-font" />
					<h:outputText styleClass="portlet-form-label"
						value="#{msgs['WELCOME.TEXT.DATENAISSANCE']}" />
					<h:outputText
						value="#{welcomeController.displayUser.agent.consulterEtatCivil.individuReponseEtatCivil_V2.dateNaissance.time}"
						styleClass="portlet-font">
						<f:convertDateTime pattern="dd/MM/yyyy" timeZone="Europe/Paris"
							locale="Locale.FRANCE" />
					</h:outputText>
					<h:outputText styleClass="portlet-form-label"
						value="#{msgs['WELCOME.TEXT.LIEUNAISSANCE']}" />
					<h:outputText 
						value="#{welcomeController.displayUser.agent.consulterEtatCivil.individuReponseEtatCivil_V2.communeNaissanceDto.communeNaissance}"
						styleClass="portlet-font" rendered="#{welcomeController.displayUser.agent.consulterEtatCivil.individuReponseEtatCivil_V2.communeNaissanceDto.communeNaissance!=null}"/>	
					<h:outputText 
						value="#{welcomeController.displayUser.agent.consulterEtatCivil.individuReponseEtatCivil_V2.villeDeNaissance}"
						rendered="#{welcomeController.displayUser.agent.consulterEtatCivil.individuReponseEtatCivil_V2.communeNaissanceDto.communeNaissance==null}"
						styleClass="portlet-font" />
						
					<h:outputText styleClass="portlet-form-label"
						value="#{msgs['WELCOME.TEXT.PAYSNAISSANCE']}" />
					<h:outputText
						value="#{welcomeController.displayUser.agent.consulterEtatCivil.individuReponseEtatCivil_V2.paysNaissanceDto.paysNaissance}"
						styleClass="portlet-font" />
					<h:outputText styleClass="portlet-form-label"
						value="#{msgs['WELCOME.TEXT.SITUATIONFAMILLIALE']}" />
					<h:outputText
						value="#{welcomeController.displayUser.agent.consulterSituationFamiliale.situationfamilialeDto.libelleSituationFamiliale}"
						styleClass="portlet-font" />						
				</h:panelGrid>
			</h:panelGroup>
			<h:panelGroup
				rendered="#{welcomeController.displayUser.agent.visualisationCompte!=false}">
				<h:panelGrid border="0" columns="1" cellpadding="5" width="100%"
					styleClass="portlet-subsection-header">
					<h:outputText value="#{msgs['WELCOME.TITLE.COORDONNEESBANCAIRES']}" />
				</h:panelGrid>
				<h:dataTable var="compteBancaire" title="#{msgs['WELCOME.TEXT.COMPTEBANCAIRE']}"
					value="#{welcomeController.displayUser.agent.consultationCoordonneesBancaires}"
					headerClass="portlet-table-header" rowClasses="portlet-font">
					<h:column>
						<f:facet name="header">
							<h:outputText value="#{msgs['WELCOME.TEXT.IBAN']}" />
						</f:facet>
						<h:outputText
							value="#{compteBancaire.codeIban1} #{compteBancaire.codeIban2}
					#{compteBancaire.codeIban3} #{compteBancaire.codeIban4}
					#{compteBancaire.codeIban5} #{compteBancaire.codeIban6}
					#{compteBancaire.codeIban7} #{compteBancaire.codeIban8}"
							styleClass="portlet-font" />
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="#{msgs['WELCOME.TEXT.BIC']}" />
						</f:facet>
						<h:outputText
							value="#{compteBancaire.codeBanqueBic} #{compteBancaire.codePaysIso}
					#{compteBancaire.codeEmplacement} #{compteBancaire.codeBranche}"
							styleClass="portlet-font" />
					</h:column>
				</h:dataTable>
			</h:panelGroup>

			<h:panelGroup>
				<h:panelGrid border="0" columns="1" cellpadding="5" width="100%"
					styleClass="portlet-subsection-header">
					<h:outputText value="#{msgs['WELCOME.TITLE.COORDONNEES']}" />
				</h:panelGrid>
				<h:dataTable var="adresse"
					title="#{msgs['WELCOME.TITLE.COORDONNEES']}"
					value="#{welcomeController.displayUser.agent.consulterCoordonneesPersonnellesDto}"
					columnClasses="list-column-center"
					headerClass="portlet-table-header" rowClasses="portlet-font"
					width="50%" cellspacing="2" cellpadding="2">
					<h:column>
						<f:facet name="header">
							<h:outputText value="#{msgs['WELCOME.TEXT.ADRESSE']}" />
						</f:facet>
						<h:panelGroup rendered="#{adresse.adresseDto.habitantChez!=null}">
							<f:verbatim>
								<br />
							</f:verbatim>
							<h:outputText value="#{adresse.adresseDto.habitantChez}" />
						</h:panelGroup>
						<h:outputText value="#{adresse.adresseDto.numeroVoie}" />
						<h:outputText
							rendered="#{adresse.adresseDto.bisTer=='T' || adresse.adresseDto.bisTer=='B' || adresse.adresseDto.bisTer=='Q' || adresse.adresseDto.bisTer=='C'}"
							value=" #{adresse.adresseDto.bisTer}" />
						<h:outputText
							value=" #{adresse.adresseDto.voie.libelleVoie} #{adresse.adresseDto.nomVoie}" />
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
						<h:panelGroup
							rendered="#{welcomeController.displayUser.agent.adresseModifiable}">
							<h:form>
								<h:commandButton id="editAdresse"
									value="#{msgs['WELCOME.TEXT.EDITADRESSE']}"
									action="#{welcomeController.afficheModAdresse}" rendered="#{sessionController.userLoginUnder == null}">
								</h:commandButton>
							</h:form>
							<h:form
								rendered="#{welcomeController.displayUser.agent.adresseModifiable && welcomeController.isAfficheFormAdresse}">
								<h:panelGrid id="panel" columns="2" border="0" styleClass="portlet-font">
									
										<h:outputText value="Voie : " />
										<t:inputText
											value="#{welcomeController.numeroVoie}" />
										<h:outputText value="bisTer : " />
										<t:selectOneMenu
											value="#{welcomeController.bisTer}">
											<f:selectItems value="#{welcomeController.choixBisTer}" />
										</t:selectOneMenu>
										<h:outputText value="Code voie : " />
										<t:selectOneMenu
											value="#{welcomeController.codeVoie}">
											<f:selectItems value="#{welcomeController.choixVoirie}" />
										</t:selectOneMenu>
										<h:outputText value="Nom voie : " />
										<t:inputText
											value="#{welcomeController.nomVoie}" />
									<h:outputText value="Habitant chez : " />
										<t:inputText
											value="#{welcomeController.adresseDto.habitantChez}" />
									<h:outputText value="Code postal : " />
									<t:inputText
											value="#{welcomeController.codePostal}" />
									<h:outputText value="Ville : " />
									<t:inputText
											value="#{welcomeController.ville}" />
									<h:outputText value="Telephone : " />
									<t:inputText
											value="#{welcomeController.telephoneDomicile}" />
									<h:outputText value="Fax : " />
									<t:inputText
											value="#{welcomeController.numeroFax}" />
									
								</h:panelGrid>
								<h:commandButton value="#{msgs['WELCOME.TEXT.MODIFIER']}"
									action="#{welcomeController.modAdresse}" />
							</h:form>
						</h:panelGroup>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="#{msgs['WELCOME.TEXT.TELEPHONEPORTABLE']}" />
						</f:facet>
						<h:outputText value="#{adresse.telephonePortable}" />
						<h:panelGroup
							rendered="#{welcomeController.displayUser.agent.telephonePortableModifiable}">
							<h:form>
								<h:commandButton id="editTelephonePortable"
									value="#{msgs['WELCOME.TEXT.EDITTELEPHONEPORTABLE']}"
									action="#{welcomeController.afficheModTelephonePortable}" rendered="#{sessionController.userLoginUnder == null}">
								</h:commandButton>
							</h:form>
							<h:form
								rendered="#{welcomeController.displayUser.agent.telephonePortableModifiable && welcomeController.isAfficheFormTelephonePortable}">
								<t:inputText value="#{welcomeController.telephonePortable}" />
								<h:commandButton value="#{msgs['WELCOME.TEXT.MODIFIER']}"
									action="#{welcomeController.modPortable}" />
							</h:form>
						</h:panelGroup>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="#{msgs['WELCOME.TEXT.EMAILPERSONNEL']}" />
						</f:facet>
						<h:outputText value="#{adresse.email}" />
						<h:panelGroup
							rendered="#{welcomeController.displayUser.agent.emailModifiable}">
							<h:form>
								<h:commandButton id="editEmail"
									value="#{msgs['WELCOME.TEXT.EDITEMAIL']}"
									action="#{welcomeController.afficheModEmail}" rendered="#{sessionController.userLoginUnder == null}">
								</h:commandButton>
							</h:form>
							<h:form
								rendered="#{welcomeController.displayUser.agent.emailModifiable && welcomeController.isAfficheFormEmail}">
								<t:inputText value="#{welcomeController.email}" />
								<h:commandButton value="#{msgs['WELCOME.TEXT.MODIFIER']}"
									action="#{welcomeController.modEmail}" />
							</h:form>
						</h:panelGroup>
					</h:column>
				</h:dataTable>
			</h:panelGroup>


			<h:panelGroup
				rendered="#{welcomeController.displayUser.agent.consulterSituationFamiliale.listeEnfants!=null}">
				<h:panelGrid border="0" columns="1" cellpadding="10" width="100%"
					styleClass="portlet-subsection-header">
					<h:outputText value="#{msgs['WELCOME.TITLE.ENFANTS']}" />
				</h:panelGrid>
				<h:dataTable title="Enfants" id="enfants"
					value="#{welcomeController.displayUser.agent.listeEnfants}"
					var="enfant" columnClasses="list-column-center"
					headerClass="portlet-table-header" rowClasses="portlet-font"
					width="50%" cellspacing="2" cellpadding="2">
					<h:column>
						<f:facet name="header">
							<h:outputText value="#{msgs['WELCOME.TEXT.NOMFAMILLE']}" />
						</f:facet>
						<h:outputText value="#{enfant.nom}" styleClass="portlet-font" />
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="#{msgs['WELCOME.TEXT.PRENOM']}" />
						</f:facet>
						<h:outputText value="#{enfant.prenom}" styleClass="portlet-font" />
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="#{msgs['WELCOME.TEXT.DATENAISSANCE']}" />
						</f:facet>
						<h:outputText value="#{enfant.dateNaissance.time}"
							styleClass="portlet-font">
							<f:convertDateTime pattern="dd/MM/yyyy" timeZone="Europe/Paris"
								locale="Locale.FRANCE" />
						</h:outputText>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="#{msgs['WELCOME.TEXT.HANDICAP']}" />
						</f:facet>
						<h:outputText value="#{enfant.pourcentHandicap}"
							styleClass="portlet-font" />
					</h:column>
				</h:dataTable>
			</h:panelGroup>

			<h:panelGroup
				rendered="#{welcomeController.displayUser.agent.consulterDiplomes.taille!=0}">
				<h:panelGrid border="0" columns="1" cellpadding="10" width="100%"
					styleClass="portlet-subsection-header">
					<h:outputText value="#{msgs['WELCOME.TITLE.DIPLOMES']}" />
				</h:panelGrid>

				<h:dataTable var="diplome"
					value="#{welcomeController.displayUser.agent.consulterDiplomes.consultationDiplomesDto}"
					columnClasses="list-column-center"
					headerClass="portlet-table-header" rowClasses="portlet-font"
					width="50%" cellspacing="2" cellpadding="2">

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


			<h:panelGroup rendered="#{welcomeController.displayUser.agent.consulterDonneesPosition !=null}">
				<h:panelGrid border="0" columns="1" cellpadding="10" width="100%"
					styleClass="portlet-subsection-header">
					<h:outputText value="#{msgs['WELCOME.TITLE.POSITION']}" />
				</h:panelGrid>
				<h:dataTable var="position"
					value="#{welcomeController.displayUser.agent.consulterDonneesPosition}"
					columnClasses="list-column-center"
					headerClass="portlet-table-header" rowClasses="portlet-font"
					width="50%" cellspacing="2" cellpadding="2" >

					<h:column>
						<f:facet name="header">
							<h:outputText value="Date de début" />
						</f:facet>

						<h:outputText value="#{position.dateDebut.time}">
							<f:convertDateTime pattern="dd/MM/yyyy" timeZone="Europe/Paris"
								locale="Locale.FRANCE" />
						</h:outputText>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Libelle position" />
						</f:facet>

						<h:outputText value="#{position.positionDto.libellePosition}" />
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Motif position" />
						</f:facet>

						<h:outputText value="#{position.motifPosition}"
							rendered="#{position.motifPosition!=null}" />
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Date de fin" />
						</f:facet>

						<h:outputText value="#{position.dateFin.time}"
							rendered="#{position.dateFin!=null}">
							<f:convertDateTime pattern="dd/MM/yyyy" timeZone="Europe/Paris"
								locale="Locale.FRANCE" />
						</h:outputText>
					</h:column>
				</h:dataTable>
			</h:panelGroup>

		</h:panelGroup>

		<script type="text/javascript">	
	hideButton("welcomeForm:localeChangeButton");		
</script>

	</t:div>

	<%
		/* @include file="_debug.jsp" */
	%>
</e:page>

