package com.sico.api.checkinline.domain.models.general;

import com.sico.api.checkinline.domain.models.general.report.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InformationReport implements Serializable {

  private GeneralInformation generalInformation;

  private boolean hasProposer;

  private boolean hasFiscalAuditor;

  private boolean hasImporterExporterData;

  private List<Renewal> renewals;

  private List<Employee> employees;

  private List<LegalRepresentative> legalRepresentatives;

  private List<Linked> linkeds;

  private List<Executive> executives;

  private List<AssociatedEstablishment> associatedEstablishments;

  private List<NetSalesPerYear> netSalesPerYears;

  private List<AssetPerYear> assetPerYears;

  private List<CompanySize> companySizes;
}
