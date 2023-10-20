package tn.enis.member.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.enis.member.entities.Member;
import tn.enis.member.entities.Member_Pub_Ids;
import tn.enis.member.entities.Member_Publication;

import java.util.List;


public interface MemberPubRepository extends
        JpaRepository<Member_Publication, Member_Pub_Ids> {
    List<Member_Publication> findByAuteur (Member auteur);
}

