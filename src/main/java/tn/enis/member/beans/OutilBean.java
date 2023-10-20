package tn.enis.member.beans;


import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;

@Data
public class OutilBean {

    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;
    private String source;
}
