package tn.enis.member.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member_Publication implements Serializable {
    @EmbeddedId
    private Member_Pub_Ids id;
    @ManyToOne
    @MapsId("auteur_id")
    private Member auteur;
}
