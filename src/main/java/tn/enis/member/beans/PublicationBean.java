package tn.enis.member.beans;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class PublicationBean {

    private Long id;
    private String type;
    private String titre;
    private String lien;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String sourcePdf;
}
