<%@include file="_include.jsp"%>
<e:page stringsVar="msgs" menuItem="about"
	locale="#{sessionController.locale}"
	authorized="#{aboutController.pageAuthorized}">
<t:div styleClass="esupAgent">
	<%@include file="_navigation.jsp"%>

	<e:section value="#{msgs['CONTRAT.TITLE']}">
		<f:param value="#{applicationService.name}" />
		<f:param value="#{applicationService.version}" />
	</e:section>

	
	<h:panelGroup rendered="#{sessionController.currentUser != null}">
		<t:div styleClass="esup-agent-portlet-display-block"
			rendered="#{contratController.contratTree == null}">
			<h:outputText styleClass="portlet-msg-alert"
				value="Il n'existe pas de contrat" />
		</t:div>
		<t:div styleClass="esup-agent-portlet-display-block"
			rendered="#{contratController.contratTree != null}">
			<t:div styleClass="esup-agent-portlet-display-list">
				<h:form>
					<h:panelGroup rendered="#{contratController.contratTree != null}">
						<t:tree2 id="tree" value="#{contratController.contratTree}"
							var="node" varNodeToggler="t" clientSideToggle="false"
							showRootNode="false">
							<f:facet name="root">
								<h:panelGroup>
									<t:graphicImage value="/media/images/16x16/openCateg.png" />
								</h:panelGroup>
							</f:facet>
							<f:facet name="informationsContratDto">
								<h:panelGroup>
									<t:graphicImage value="/media/images/16x16/closedCateg.png"
										rendered="#{!t.nodeExpanded}" />
									<t:graphicImage value="/media/images/16x16/openCateg.png"
										rendered="#{t.nodeExpanded}" />
									<e:text value="#{node.description}" />
								</h:panelGroup>
							</f:facet>
							<f:facet name="avenantContrat">
								<h:panelGroup>
									<t:graphicImage value="/media/images/16x16/course.png" />
									
									<t:commandLink
										action="#{contratController.updateCurrentAvenantContratDto}">
										<e:text value="#{node.description}" />
										<t:updateActionListener value="#{node.avenantContratDto}"
											property="#{contratController.currentAvenantContratDto}" />
										<t:updateActionListener
											value="#{node.informationsContratsDto}"
											property="#{contratController.currentContratDto}" />
									</t:commandLink>
								</h:panelGroup>
							</f:facet>
						</t:tree2>
					</h:panelGroup>
				</h:form>
			</t:div>
			<t:div
				rendered="#{contratController.currentAvenantContratDto != null}"
				styleClass="esup-agent-portlet-display-detail">
				<h:panelGrid border="0" columns="1" cellpadding="10" width="100%"
					styleClass="portlet-subsection-header">
					<h:outputText value="Contrat"  />
				</h:panelGrid>
				<h:panelGroup>
					<h:panelGrid border="0" columns="2" cellspacing="10"
						cellpadding="2">
						<h:outputText styleClass="portlet-form-label"
							value="Numéro du contrat" />
						<h:outputText
							value="#{contratController.currentContratDto.numeroContrat}"
							styleClass="portlet-font" />

						<h:outputText styleClass="portlet-form-label"
							value="Numéro Avenant" />
						<h:outputText
							value="#{contratController.currentAvenantContratDto.numeroAvenant}"
							styleClass="portlet-font" />
						<h:outputText styleClass="portlet-form-label"
							value="Type de contrat" />
						<h:outputText
							value="#{contratController.currentContratDto.typeContratDto.libelleLong}"
							styleClass="portlet-font" />
						<h:outputText styleClass="portlet-form-label"
							value="Référence de contrat" />
						<h:outputText
							value="#{contratController.currentAvenantContratDto.referenceContrat}"
							styleClass="portlet-font" />
						<h:outputText styleClass="portlet-form-label"
							value="Date de début du contrat" />
						<h:outputText
							value="#{contratController.currentAvenantContratDto.dateDebutContrat.time}"
							styleClass="portlet-font">
							<f:convertDateTime pattern="dd/MM/yyyy" timeZone="Europe/Paris"
								locale="Locale.FRANCE" />
						</h:outputText>
						<h:outputText styleClass="portlet-form-label"
							value="Date de fin du contrat" />
						<h:outputText
							value="#{contratController.currentAvenantContratDto.dateFinContrat.time}"
							styleClass="portlet-font">
							<f:convertDateTime pattern="dd/MM/yyyy" timeZone="Europe/Paris"
								locale="Locale.FRANCE" />
						</h:outputText>
						<h:outputText styleClass="portlet-form-label"
							value="Date de signature du contrat" />
						<h:outputText
							value="#{contratController.currentAvenantContratDto.dateReferenceContratAvenant.time}"
							styleClass="portlet-font">
							<f:convertDateTime pattern="dd/MM/yyyy" timeZone="Europe/Paris"
								locale="Locale.FRANCE" />
						</h:outputText>
						<h:outputText styleClass="portlet-subsection-header"
							value="Fonctions assurées" />
						<h:outputText
							value="#{contratController.currentAvenantContratDto.fonctionsAssurees}"
							styleClass="portlet-font" />
						<h:outputText styleClass="portlet-form-label"
							value="Equivalent grade" />
						<h:outputText
							value="#{contratController.currentAvenantContratDto.equivalentGradeDto.libelleEquivalentGrade}"
							styleClass="portlet-font" />
						<h:outputText styleClass="portlet-form-label"
							value="Equivalent catégorie" />
						<h:outputText
							value="#{contratController.currentAvenantContratDto.equivalentCategorieFPDto.codeEquivalentCategorieFP}"
							styleClass="portlet-font" />
					</h:panelGrid>
				</h:panelGroup>

				<h:panelGroup
					rendered="#{contratController.currentInformationsOccupationAffectationDto!= null}">
					<h:panelGrid border="0" columns="1" cellpadding="10" width="100%"
						styleClass="portlet-subsection-header" >
						<h:outputText value="Occupation"
							/>
					</h:panelGrid>
					<h:panelGroup>
						<h:dataTable var="informationsOccupationAffectationDto"
							value="#{contratController.currentInformationsOccupationAffectationDto}"
							columnClasses="list-column-center"
							headerClass="portlet-table-header" rowClasses="portlet-font" 
							width="100%">
							<h:column>
								<f:facet name="header">
									<h:outputText value="n° poste" />
								</f:facet>
								<h:outputText
									value="#{informationsOccupationAffectationDto.posteDto.numeroPoste}"
									styleClass="portlet-font" />
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="n° national" />
								</f:facet>
								<h:outputText
									value="#{informationsOccupationAffectationDto.posteDto.numeroNational}"
									styleClass="portlet-font" />
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="période" />
								</f:facet>
								<h:panelGroup>
									<h:outputText value="du " styleClass="portlet-section-text" />
									<h:outputText
										value="#{informationsOccupationAffectationDto.dateDebut.time}"
										styleClass="portlet-font">
										<f:convertDateTime pattern="dd/MM/yyyy"
											timeZone="Europe/Paris" locale="Locale.FRANCE" />
									</h:outputText>
									<h:outputText value=" au " styleClass="portlet-font" />
									<h:outputText
										value="#{informationsOccupationAffectationDto.dateFin.time}"
										styleClass="portlet-font">
										<f:convertDateTime pattern="dd/MM/yyyy"
											timeZone="Europe/Paris" locale="Locale.FRANCE" />
									</h:outputText>
								</h:panelGroup>
							</h:column>
						</h:dataTable>
					</h:panelGroup>




					<h:panelGrid border="0" columns="1" cellpadding="10" width="100%"
						styleClass="portlet-subsection-header">
						<h:outputText value="Affectation"
							 />
					</h:panelGrid>
					<h:panelGroup>
						<h:dataTable var="informationsOccupationAffectationDto"
							value="#{contratController.currentInformationsOccupationAffectationDto}" columnClasses="list-column-center"
							headerClass="portlet-table-header" rowClasses="portlet-font" 
							width="100%">
							<h:column>
								<h:dataTable var="AffectationDto"
									value="#{informationsOccupationAffectationDto.affectationDto}"
									columnClasses="list-column-center"
							headerClass="portlet-table-header" rowClasses="portlet-font">
									<h:column>
										<f:facet name="header">
											<h:outputText value="Structure" />
										</f:facet>
										<h:outputText
											value="#{AffectationDto.structureAffectationDto.libelleLongStructureAffectation}"
											styleClass="portlet-font" />
									</h:column>
									<h:column>
										<f:facet name="header">
											<h:outputText value="Période" />
										</f:facet>
										<h:panelGroup>
											<h:outputText value="du " styleClass="portlet-font" />
											<h:outputText
												value="#{AffectationDto.dateDebutAffectation.time}"
												styleClass="portlet-font">
												<f:convertDateTime pattern="dd/MM/yyyy"
													timeZone="Europe/Paris" locale="Locale.FRANCE" />
											</h:outputText>
											<h:outputText value=" au " styleClass="portlet-section-text" />
											<h:outputText
												value="#{AffectationDto.dateFinAffectation.time}"
												styleClass="portlet-font">
												<f:convertDateTime pattern="dd/MM/yyyy"
													timeZone="Europe/Paris" locale="Locale.FRANCE" />
											</h:outputText>
										</h:panelGroup>

									</h:column>
									<h:column>
										<f:facet name="header">
											<h:outputText value="n° du poste" />
										</f:facet>
										<h:outputText
											value="#{informationsOccupationAffectationDto.posteDto.numeroPoste}"
											styleClass="portlet-font" />
									</h:column>


									<h:column>
										<f:facet name="header">
											<h:outputText value="Quotité" />
										</f:facet>
										<h:outputText
											value="#{affectationDto.structureAffectationDto.quotite}"
											styleClass="portlet-font" />
									</h:column>



								</h:dataTable>
							</h:column>

						</h:dataTable>
					</h:panelGroup>

				</h:panelGroup>

			</t:div>
		</t:div>
	</h:panelGroup>

	<h:panelGroup rendered="#{sessionController.currentUser == null}">
		<e:paragraph value="#{msgs['CONTRAT.MSG.UNAUTHENTICATE']}" />
	</h:panelGroup>
	</t:div>
	<%
		/* @include file="_debug.jsp" */
	%>
</e:page>
