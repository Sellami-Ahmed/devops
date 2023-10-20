package tn.enis.member.beans;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class EvenementBean {

    private Long id;
    private String titre;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String lieu;
}
