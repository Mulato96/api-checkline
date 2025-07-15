package com.sico.api.checkinline.domain.models.general;

import com.sico.api.checkinline.domain.models.general.search.Company;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanySearch implements Serializable {

    private List<Company> companies;
}
