package com.sico.api.checkinline.domain.models.ImporterExporter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImportExport {

    private String name;
    private String origin;
    private String destination;
    private String tariff;
    private String weight;
    private String numArticles;
    private String value;
    private Date date;

}
