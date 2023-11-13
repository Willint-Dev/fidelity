package com.fidelity.movil.citations_service.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CitationRequest {
    private long id;
    private Date date_citation;
    private String reason_citation;
    private String status_citation;
    private long id_client;
    private long id_manager;
}
