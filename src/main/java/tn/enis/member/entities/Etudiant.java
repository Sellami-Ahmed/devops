package tn.enis.member.entities;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;
import tn.enis.member.beans.PublicationBean;

import java.util.Collection;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("etd")
public class Etudiant extends Member {
    @NonNull
    private Date dateInscription;
    @NonNull
    private String diplome;
    @ManyToOne
    private EnseignantChercheur encadrant;

    @Builder

    public Etudiant (Collection<PublicationBean> pubs, Long id, @NonNull String cin, @NonNull String nom, @NonNull String prenom, @NonNull Date dateNaissance, Byte photo, String cv, @NonNull String email, @NonNull String password, @NonNull Date dateInscription, @NonNull String diplome, EnseignantChercheur encadrant) {
        super(pubs, id, cin, nom, prenom, dateNaissance, photo, cv, email, password);
        this.dateInscription = dateInscription;
        this.diplome = diplome;
        this.encadrant = encadrant;
    }
}
