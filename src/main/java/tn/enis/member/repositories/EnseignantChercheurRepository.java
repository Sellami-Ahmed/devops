package tn.enis.member.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enis.member.entities.EnseignantChercheur;
import tn.enis.member.entities.Etudiant;

import java.util.List;

@Repository
public interface EnseignantChercheurRepository extends JpaRepository<EnseignantChercheur,Long> {
    List<EnseignantChercheur> findByGrade(String grade);
    List<EnseignantChercheur>findByEtablissement(String etablissement);
}
