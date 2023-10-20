package tn.enis.member.services;

import tn.enis.member.beans.PublicationBean;
import tn.enis.member.entities.EnseignantChercheur;
import tn.enis.member.entities.Etudiant;
import tn.enis.member.entities.Member;

import java.util.List;
import java.util.Optional;

public interface IMemberService {
    //Crud sur les membres
    Member addMember(Member m);
    void deleteMember(Long id) ;
    Member updateMember(Member p) ;
    Optional<Member> findMember(Long id) ;
    List<Member> findAll();
    //Filtrage par propriété
    Member findByCin(String cin);
    Member findByEmail(String email);
    List<Member> findByNom(String nom);
    //recherche spécifique des étudiants
    List<Etudiant> findByDiplome(String diplome);
    //recherche spécifique des enseignants
    List<EnseignantChercheur> findByGrade(String grade);
    List<EnseignantChercheur> findByEtablissement(String etablissement);
    List<Member> findByNomStartingWith (String caractere);
    void affecterEtudiantEnseignant(Long idEtudiant,Long idEnseignant);
    List<Etudiant> findEtudiantByEncadrant(EnseignantChercheur enseignantChercheur);
    void affecterAuteurToPublication (Long idauteur, Long idpub);
    List<PublicationBean> findPublicationParAuteur (Long idauteur);
}
