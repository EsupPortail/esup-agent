<%@include file="_include.jsp"%>
<e:page stringsVar="msgs" menuItem="about"
	locale="#{sessionController.locale}"
	authorized="#{aboutController.pageAuthorized}">
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
									<e:text value="#{node.description}" />
									<t:commandLink
										action="#{contratController.updateCurrentAvenantContratDto}">
										<t:graphicImage value="/media/images/16x16/info.png" />
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
					styleClass="portlet-menu">
					<h:outputText value="Contrat" styleClass="portlet-section-header" />
				</h:panelGrid>
				<h:panelGroup>
					<h:panelGrid border="0" columns="2" cellspacing="10"
						cellpadding="2">
						<h:outputText styleClass="table-titre portlet-form-label"
							value="Numéro du contrat" />
						<h:outputText
							value="#{contratController.currentContratDto.numeroContrat}"
							styleClass="portlet-section-text" />

						<h:outputText styleClass="table-titre portlet-form-label"
							value="Numéro Avenant" />
						<h:outputText
							value="#{contratController.currentAvenantContratDto.numeroAvenant}"
							styleClass="portlet-section-text" />
						<h:outputText styleClass="table-titre portlet-form-label"
							value="Type de contrat" />
						<h:outputText
							value="#{contratController.currentContratDto.typeContratDto.libelleLong}"
							styleClass="portlet-section-text" />
						<h:outputText styleClass="table-titre portlet-form-label"
							value="Référence de contrat" />
						<h:outputText
							value="#{contratController.currentAvenantContratDto.referenceContrat}"
							styleClass="portlet-section-text" />
						<h:outputText styleClass="table-titre portlet-form-label"
							value="Date de début du contrat" />
						<h:outputText
							value="#{contratController.currentAvenantContratDto.dateDebutContrat.time}"
							styleClass="portlet-section-text">
							<f:convertDateTime pattern="dd/MM/yyyy" timeZone="Europe/Paris"
								locale="Locale.FRANCE" />
						</h:outputText>
						<h:outputText styleClass="table-titre portlet-form-label"
							value="Date de fin du contrat" />
						<h:outputText
							value="#{contratController.currentAvenantContratDto.dateFinContrat.time}"
							styleClass="portlet-section-text">
							<f:convertDateTime pattern="dd/MM/yyyy" timeZone="Europe/Paris"
								locale="Locale.FRANCE" />
						</h:outputText>
						<h:outputText styleClass="table-titre portlet-form-label"
							value="Date de signature du contrat" />
						<h:outputText
							value="#{contratController.currentAvenantContratDto.dateReferenceContratAvenant.time}"
							styleClass="portlet-section-text">
							<f:convertDateTime pattern="dd/MM/yyyy" timeZone="Europe/Paris"
								locale="Locale.FRANCE" />
						</h:outputText>
						<h:outputText styleClass="table-titre portlet-form-label"
							value="Fonctions assurées" />
						<h:outputText
							value="#{contratController.currentAvenantContratDto.fonctionsAssurees}"
							styleClass="portlet-section-text" />
						<h:outputText styleClass="table-titre portlet-form-label"
							value="Equivalent grade" />
						<h:outputText
							value="#{contratController.currentAvenantContratDto.equivalentGradeDto.libelleEquivalentGrade}"
							styleClass="portlet-section-text" />
						<h:outputText styleClass="table-titre portlet-form-label"
							value="Equivalent catégorie" />
						<h:outputText
							value="#{contratController.currentAvenantContratDto.equivalentCategorieFPDto.codeEquivalentCategorieFP}"
							styleClass="portlet-section-text" />
					</h:panelGrid>
				</h:panelGroup>

				<h:panelGroup
					rendered="#{contratController.currentInformationsOccupationAffectationDto!= null}">
					<h:panelGrid border="0" columns="1" cellpadding="10" width="100%"
						styleClass="portlet-menu">
						<h:outputText value="Occupation"
							styleClass="portlet-section-header" />
					</h:panelGrid>
					<h:panelGroup>
						<h:dataTable var="informationsOccupationAffectationDto"
							value="#{contratController.currentInformationsOccupationAffectationDto}"
							headerClass="esup-agent-portlet-datatable-header" width="100%">
							<h:column>
								<f:facet name="header">
									<h:outputText value="n° poste" />
								</f:facet>
								<h:outputText
									value="#{informationsOccupationAffectationDto.posteDto.numeroPoste}"
									styleClass="portlet-section-text" />
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="n° national" />
								</f:facet>
								<h:outputText
									value="#{informationsOccupationAffectationDto.posteDto.numeroNational}"
									styleClass="portlet-section-text" />
							</h:column>
							<h:column>
								<f:facet name="header">
									<h:outputText value="période" />
								</f:facet>
								<h:panelGroup>
									<h:outputText value="du " styleClass="portlet-section-text" />
									<h:outputText
										value="#{informationsOccupationAffectationDto.dateDebut.time}"
										styleClass="portlet-section-text">
										<f:convertDateTime pattern="dd/MM/yyyy"
											timeZone="Europe/Paris" locale="Locale.FRANCE" />
									</h:outputText>
									<h:outputText value=" au " styleClass="portlet-section-text" />
									<h:outputText
										value="#{informationsOccupationAffectationDto.dateFin.time}"
										styleClass="portlet-section-text">
										<f:convertDateTime pattern="dd/MM/yyyy"
											timeZone="Europe/Paris" locale="Locale.FRANCE" />
									</h:outputText>
								</h:panelGroup>
							</h:column>
						</h:dataTable>
					</h:panelGroup>




					<h:panelGrid border="0" columns="1" cellpadding="10" width="100%"
						styleClass="portlet-menu">
						<h:outputText value="Affectation"
							styleClass="portlet-section-header" />
					</h:panelGrid>
					<h:panelGroup>
						<h:dataTable var="informationsOccupationAffectationDto"
							value="#{contratController.currentInformationsOccupationAffectationDto}" width="100%">
							<h:column>
								<h:dataTable var="AffectationDto"
									value="#{informationsOccupationAffectationDto.affectationDto}"
									headerClass="esup-agent-portlet-datatable-header">
									<h:column>
										<f:facet name="header">
											<h:outputText value="Structure" />
										</f:facet>
										<h:outputText
											value="#{AffectationDto.structureAffectationDto.libelleLongStructureAffectation}"
											styleClass="portlet-section-text" />
									</h:column>
									<h:column>
										<f:facet name="header">
											<h:outputText value="Période" />
										</f:facet>
										<h:panelGroup>
											<h:outputText value="du " styleClass="portlet-section-text" />
											<h:outputText
												value="#{AffectationDto.dateDebutAffectation.time}"
												styleClass="portlet-section-text">
												<f:convertDateTime pattern="dd/MM/yyyy"
													timeZone="Europe/Paris" locale="Locale.FRANCE" />
											</h:outputText>
											<h:outputText value=" au " styleClass="portlet-section-text" />
											<h:outputText
												value="#{AffectationDto.dateFinAffectation.time}"
												styleClass="portlet-section-text">
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
											styleClass="portlet-section-text" />
									</h:column>


									<h:column>
										<f:facet name="header">
											<h:outputText value="Quotité" />
										</f:facet>
										<h:outputText
											value="#{affectationDto.structureAffectationDto.quotite}"
											styleClass="pportlet-section-text" />
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

	<%
		/* @include file="_debug.jsp" */
	%>
</e:page>
