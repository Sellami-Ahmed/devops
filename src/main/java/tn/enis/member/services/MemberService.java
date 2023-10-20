package tn.enis.member.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.enis.member.beans.PublicationBean;
import tn.enis.member.entities.*;
import tn.enis.member.proxies.PublicationProxyService;
import tn.enis.member.repositories.EnseignantChercheurRepository;
import tn.enis.member.repositories.EtudiantRepository;
import tn.enis.member.repositories.MemberPubRepository;
import tn.enis.member.repositories.MemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService implements IMemberService {
    private final MemberRepository memberRepository;
    private final MemberPubRepository memberPubRepository;
    private final EnseignantChercheurRepository enseignantChercheurRepository;
    private final EtudiantRepository etudiantRepository;
    private final PublicationProxyService proxyService;


    @Autowired
    public MemberService (MemberRepository memberRepository, MemberPubRepository memberPubRepository, EnseignantChercheurRepository enseignantChercheurRepository, EtudiantRepository etudiantRepository, PublicationProxyService proxyService) {
        this.memberRepository = memberRepository;
        this.memberPubRepository = memberPubRepository;
        this.enseignantChercheurRepository = enseignantChercheurRepository;
        this.etudiantRepository = etudiantRepository;
        this.proxyService = proxyService;
    }

    @Override
    public Member addMember (Member member) {
        return memberRepository.save(member);
    }

    @Override
    @Transactional
    public void deleteMember (Long id) {
        memberRepository.deleteMemberById(id);
    }

    public List<Member> findByNomStartingWith (String caractere) {
        return memberRepository.findByNomStartingWith(caractere);
    }

    @Override
    public Member findByCin (String cin) {
        return memberRepository.findByCin(cin);
    }

    @Override
    public Member findByEmail (String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    public List<Member> findByNom (String nom) {
        return memberRepository.findByNom(nom);
    }

    @Override
    public List<Etudiant> findByDiplome (String diplome) {
        return etudiantRepository.findByDiplome(diplome);
    }

    @Override
    public List<EnseignantChercheur> findByGrade (String grade) {
        return enseignantChercheurRepository.findByGrade(grade);
    }

    @Override
    public List<EnseignantChercheur> findByEtablissement (String etablissement) {
        return enseignantChercheurRepository.findByEtablissement(etablissement);
    }

    @Override
    public Member updateMember (Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Optional<Member> findMember (Long id) {
        return memberRepository.findById(id);
    }

    @Override
    public List<Member> findAll () {
        return memberRepository.findAll();
    }

    @Override
    public void affecterEtudiantEnseignant (Long idEtudiant, Long idEnseignant) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(idEtudiant);
        Optional<EnseignantChercheur> enseignantChercheur = enseignantChercheurRepository.findById(idEnseignant);
        if (etudiant.isPresent() && enseignantChercheur.isPresent()) {
            etudiant.get().setEncadrant(enseignantChercheur.get());
            etudiantRepository.save(etudiant.get());
        }
    }

    @Override
    public List<Etudiant> findEtudiantByEncadrant (EnseignantChercheur enseignantChercheur) {
        return etudiantRepository.findByEncadrant(enseignantChercheur);
    }

    @Override
    public void affecterAuteurToPublication (Long idauteur, Long idpub) {
        Optional<Member> mbr = memberRepository.findById(idauteur);
        Member_Publication mbs = new Member_Publication();
        if (mbr.isPresent()) {
            mbs.setAuteur(mbr.get());
            mbs.setId(new Member_Pub_Ids(idpub, idauteur));
            memberPubRepository.save(mbs);
        }


    }


    @Override
    public List<PublicationBean> findPublicationParAuteur (Long idauteur) {
        List<PublicationBean> pubs = new ArrayList<>();
        Optional<Member> auteur = memberRepository.findById(idauteur);
        if (auteur.isPresent()) {
            List<Member_Publication> idpubs = memberPubRepository.findByAuteur(auteur.get());
            idpubs.forEach(s -> {
                        System.out.println(s);
                        pubs.add(proxyService.getPublicationById(s.getId().getPublication_id()));
                    }
            );
        }
        return pubs;

    }

}
