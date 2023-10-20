package tn.enis.member.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.enis.member.entities.EnseignantChercheur;
import tn.enis.member.entities.Etudiant;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    List<Etudiant> findByDiplome(String diplome);
    List<Etudiant> findByDiplomeOrderByDateInscriptionDesc(String diplome);
    List<Etudiant> findByEncadrant(EnseignantChercheur enseignantChercheur);

}
