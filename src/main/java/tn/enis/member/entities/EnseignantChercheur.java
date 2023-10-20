package tn.enis.member.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;
import tn.enis.member.beans.PublicationBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("ens")
public class EnseignantChercheur extends Member {
    @NonNull
    private String grade;
    @NonNull
    private String etablissement;
    @OneToMany(mappedBy = "encadrant")
    @JsonIgnore
    private List<Etudiant> etudiants = new ArrayList<>();

    @Builder

    public EnseignantChercheur (Collection<PublicationBean> pubs, Long id, @NonNull String cin, @NonNull String nom, @NonNull String prenom, @NonNull Date dateNaissance, Byte photo, String cv, @NonNull String email, @NonNull String password, @NonNull String grade, @NonNull String etablissement, List<Etudiant> etudiants) {
        super(pubs, id, cin, nom, prenom, dateNaissance, photo, cv, email, password);
        this.grade = grade;
        this.etablissement = etablissement;
        this.etudiants = etudiants;
    }
}
