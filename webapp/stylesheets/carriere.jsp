<%@include file="_include.jsp"%>
<e:page stringsVar="msgs" menuItem="about"
	locale="#{sessionController.locale}"
	authorized="#{aboutController.pageAuthorized}">
	<%@include file="_navigation.jsp"%>

	<e:section value="#{msgs['CARRIERE.TITLE']}">
		<f:param value="#{applicationService.name}" />
		<f:param value="#{applicationService.version}" />
	</e:section>

	<h:panelGroup rendered="#{sessionController.currentUser != null}">
		<t:div styleClass="esup-agent-portlet-display-block"
			rendered="#{carriereController.carriereTree == null}">
			<h:outputText styleClass="portlet-msg-alert"
				value="Il n'existe pas de séquence de carrière" />
		</t:div>


		<t:div styleClass="esup-agent-portlet-display-block"
			rendered="#{carriereController.carriereTree != null}">
			<t:div styleClass="esup-agent-portlet-display-list">
				<h:form>
					<h:panelGroup rendered="#{carriereController.carriereTree != null}">
						<t:tree2 id="tree" value="#{carriereController.carriereTree}"
							var="node" varNodeToggler="t" clientSideToggle="false"
							showRootNode="false">
							<f:facet name="root">
								<h:panelGroup>
									<t:graphicImage value="/media/images/16x16/openCateg.png" />
								</h:panelGroup>
							</f:facet>
							<f:facet name="carriereDto">
								<h:panelGroup>
									<t:graphicImage value="/media/images/16x16/closedCateg.png"
										rendered="#{!t.nodeExpanded}" />
									<t:graphicImage value="/media/images/16x16/openCateg.png"
										rendered="#{t.nodeExpanded}" />
									<e:text value="#{node.description}" />
								</h:panelGroup>
							</f:facet>
							<f:facet name="elementCarriereDto">
								<h:panelGroup>
									<t:graphicImage value="/media/images/16x16/course.png" />
									<e:text value="#{node.description}" />
									<t:commandLink
										action="#{carriereController.updateCurrentElementCarriereDto}">
										<t:graphicImage value="/media/images/16x16/info.png" />
										<t:updateActionListener value="#{node.elementCarriereDto}"
											property="#{carriereController.currentElementCarriereDto}" />
										<t:updateActionListener value="#{node.carriereDto}"
											property="#{carriereController.currentCarriereDto}" />
									</t:commandLink>
								</h:panelGroup>
							</f:facet>
						</t:tree2>
					</h:panelGroup>
				</h:form>

			</t:div>




			<t:div
				rendered="#{carriereController.currentElementCarriereDto!=null}"
				styleClass="esup-agent-portlet-display-detail">
				<h:panelGroup>
					<h:panelGrid border="0" columns="1" cellpadding="3" width="100%"
						styleClass="portlet-menu">
						<h:outputText value="Carrière" styleClass="portlet-section-header" />
					</h:panelGrid>

					<h:dataTable var="bap"
						value="#{carriereController.currentCarriereDto.bapReferensDto}"
						headerClass="esup-agent-portlet-datatable-header" width="100%">
						<h:column>
							<f:facet name="header">
								<h:outputText value="Libellé de la B.A.P." />
							</f:facet>
							<h:outputText
								value="#{bap.codeBAPReferens} - #{bap.libelleLongBAPReferens}"
								styleClass="portlet-section-text" />
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Date de début" />
							</f:facet>
							<h:outputText value="#{bap.dateDebut.time}"
								styleClass="portlet-section-text">
								<f:convertDateTime pattern="dd/MM/yyyy" timeZone="Europe/Paris"
									locale="Locale.FRANCE" />
							</h:outputText>
						</h:column>
						<h:column>
							<f:facet name="header">
								<h:outputText value="Date de fin" />
							</f:facet>
							<h:outputText value="#{bap.dateFin.time}"
								styleClass="portlet-section-text">
								<f:convertDateTime pattern="dd/MM/yyyy" timeZone="Europe/Paris"
									locale="Locale.FRANCE" />
							</h:outputText>
						</h:column>
					</h:dataTable>
				</h:panelGroup>

				<h:panelGrid border="0" columns="1" cellpadding="10" width="100%"
					styleClass="portlet-menu">
					<h:outputText value="Elément de carrière"
						styleClass="portlet-section-header" />
				</h:panelGrid>
				<h:panelGrid border="0" columns="2" cellspacing="10" cellpadding="2">
					<h:outputText styleClass="table-titre portlet-form-label"
						value="Catégorie" />
					<h:outputText
						value="#{carriereController.currentCarriereDto.categorieFonctionPubliqueDto.codeCategorieFonctionPublique}"
						styleClass="portlet-form-label" />
					<h:outputText styleClass="table-titre portlet-form-label"
						value="Type d'accès" />
					<h:outputText
						value="#{carriereController.currentElementCarriereDto.typeAccesDto.libelleTypeAcces}"
						styleClass="portlet-section-text" />
					<h:outputText styleClass="table-titre portlet-form-label"
						value="Date d'effet" />
					<h:outputText
						value="#{carriereController.currentElementCarriereDto.dateEffetElementsCarriere.time}"
						styleClass="portlet-section-text">
						<f:convertDateTime pattern="dd/MM/yyyy" timeZone="Europe/Paris"
							locale="Locale.FRANCE" />
					</h:outputText>
					<h:outputText styleClass="table-titre portlet-form-label"
						value="Echelon" />
					<h:outputText
						value="#{carriereController.currentElementCarriereDto.echelonDto.codeEchelon}"
						styleClass="portlet-section-text" />
					<h:outputText styleClass="table-titre portlet-form-label"
						value="Corps" />
					<h:outputText
						value="#{carriereController.currentElementCarriereDto.corpsDto.libelleCorps}"
						styleClass="portlet-section-text" />
					<h:outputText styleClass="table-titre portlet-form-label"
						value="Grade" />
					<h:outputText
						value="#{carriereController.currentElementCarriereDto.gradeDto.libelleGrade}"
						styleClass="portlet-section-text" />
				</h:panelGrid>

				<h:panelGroup
					rendered="#{carriereController.currentInformationsOccupationAffectationDto!= null}">
					<h:panelGrid border="0" columns="1" cellpadding="10" width="100%"
						styleClass="portlet-menu">
						<h:outputText value="Occupation"
							styleClass="portlet-section-header" />
					</h:panelGrid>
					<h:panelGroup>
						<h:dataTable var="informationsOccupationAffectationDto"
							value="#{carriereController.currentInformationsOccupationAffectationDto}"
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
								<h:panelGroup
									rendered="#{informationsOccupationAffectationDto.dateFin.time!=null}">
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
								<h:panelGroup
									rendered="#{informationsOccupationAffectationDto.dateFin.time==null}">
									<h:outputText value="A partir "
										styleClass="portlet-section-text" />
									<h:outputText
										value="#{informationsOccupationAffectationDto.dateDebut.time}"
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
							value="#{carriereController.currentInformationsOccupationAffectationDto}">
							<h:column>
								<h:dataTable var="AffectationDto"
									value="#{informationsOccupationAffectationDto.affectationDto}"
									headerClass="esup-agent-portlet-datatable-header" width="100%">
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
										<h:panelGroup
											rendered="#{AffectationDto.dateFinAffectation.time!=null}">
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
										<h:panelGroup
											rendered="#{AffectationDto.dateFinAffectation.time==null}">
											<h:outputText value="A partir du "
												styleClass="portlet-section-text" />
											<h:outputText
												value="#{AffectationDto.dateDebutAffectation.time}"
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
											value="#{AffectationDto.structureAffectationDto.quotite}"
											styleClass="portlet-section-text" />
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
		<e:paragraph value="#{msgs['CARRIERE.MSG.UNAUTHENTICATE']}" />
	</h:panelGroup>

	<%
		/* @include file="_debug.jsp" */
	%>
</e:page>
